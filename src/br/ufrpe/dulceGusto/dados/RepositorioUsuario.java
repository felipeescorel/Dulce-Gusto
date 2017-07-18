package br.ufrpe.dulceGusto.dados;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.dulceGusto.classesbasicas.Administrador;
import br.ufrpe.dulceGusto.classesbasicas.*;

public class RepositorioUsuario implements IRepositorioUsuario{
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private Usuario user;

	private static RepositorioUsuario instancia;

	public static RepositorioUsuario getInstancia() {
		if (instancia == null) {
			instancia = new RepositorioUsuario();
		}
		return instancia;
	}

	private RepositorioUsuario() {
		
	}

	@Override
	public void cadastrarUsuario(Usuario user) {
		this.usuarios.add(user);
	}

	@Override
	public Usuario buscarUsuario(String cpf) {
		Usuario retorno = null;
		int indice = this.obterIndice(cpf);
		if (indice != -1) {
			retorno = this.usuarios.get(indice);
		}
		return retorno;
	}

	private int obterIndice(String cpf) {
		int indice = -1;
		for (int i = 0; i < this.usuarios.size(); i++) {
			if (this.usuarios.get(i).getCpf().equals(cpf)) {
				indice = i;
			}
		}
		return indice;
	}

	@Override
	public boolean existe(String cpf) {
		boolean existe = false;
		int indice = this.obterIndice(cpf);
		if (indice != -1) {
			existe = true;
		}
		return existe;
	}

	@Override
	public void removerUsuario(String cpf) {
		int indice = this.obterIndice(cpf);
		if (indice != -1) {
			this.usuarios.remove(indice);
		}
	}

	@Override
	public void alterarUsuario(Usuario user) {
		int indice = this.obterIndice(user.getCpf());
		if (indice != -1) {
			this.usuarios.set(indice, user);
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
		user = this.buscarUsuario(cpf);
		equivale = user.getSenha().equals(senha);			
			if (equivale != false) {
				retorno = true;
			}		
		return retorno;
	}

}



