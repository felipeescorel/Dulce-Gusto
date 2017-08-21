package br.ufrpe.dulceGusto.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.dulceGusto.classesbasicas.*;
import br.ufrpe.dulceGusto.exceptions.DadosException;

public class RepositorioUsuario implements IRepositorioUsuario, Serializable {
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private List<Usuario> listaUsuarios = null;
	private Usuario user;

	private static RepositorioUsuario instancia;

	public static RepositorioUsuario getInstancia() {
		if (instancia == null) {
			instancia = lerDoArquivo();
		}
		return instancia;
	}

	private RepositorioUsuario() {

	}

	@Override
	public void cadastrarUsuario(Usuario user) {
		this.usuarios.add(user);
		RepositorioUsuario.gravarArquivo();
	}

	@Override
	public Usuario buscaPorCpf(String cpf) {
		Usuario user = null;

		for (Usuario usuario : getInstancia().listaUsuarios) {
			if (usuario.getCpf().equals(cpf)) {
				usuario = user;
				break;
			}
		}

		return user;
	}

	private static RepositorioUsuario lerDoArquivo() {
		RepositorioUsuario instanciaLocal = null;

		File in = new File("Usuarios.db");
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioUsuario) o;
		} catch (Exception e) {
			instanciaLocal = new RepositorioUsuario();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
				}
			}
		}
		return instanciaLocal;
	}

	private static void gravarArquivo() {
		if (instancia == null) {
			return;
		}
		File out = new File("Usuarios.db");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream(out);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(instancia);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
				}
			}
		}
	}

	@Override
	public boolean existe(Usuario user) {
		for (Usuario usuario : getInstancia().listaUsuarios) {
			if (user.equals(usuario)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public void remover(String cpf) {
		for (Usuario usuario : getInstancia().listaUsuarios) {
			if (usuario.getCpf().equals(cpf)) {
				getInstancia().listaUsuarios.remove(user);
				this.gravarArquivo();
				break;
			}
		}

	}

	@Override
	public void alterarUsuario(Usuario usuario) throws DadosException {
		List<Usuario> listaUsuarios = getInstancia().listaUsuarios;

		if (getInstancia().existe(usuario)) {
			listaUsuarios.set(listaUsuarios.indexOf(usuario), usuario);
			this.gravarArquivo();
		}

	}

	@Override
	public List<Usuario> mostrarUsuarios() {
		return this.usuarios;
	}

	@Override
	public boolean autenticarLogin(String senha, String cpf) {
		boolean retorno = false;
		boolean equivale;
		user = this.buscaPorCpf(cpf);
		equivale = user.getSenha().equals(senha);
		if (equivale != false) {
			retorno = true;
		}
		return retorno;
	}

}
