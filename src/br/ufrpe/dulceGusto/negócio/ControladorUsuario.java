package br.ufrpe.dulceGusto.negócio;

import java.util.List;
import br.ufrpe.dulceGusto.classesbasicas.*;
import br.ufrpe.dulceGusto.dados.*;
import br.ufrpe.dulceGusto.exceptions.DadosException;
import br.ufrpe.dulceGusto.exceptions.ItemException;

public class ControladorUsuario {
	private static ControladorUsuario instancia;
	private IRepositorioUsuario repositorio;

	ControladorUsuario() {
		this.repositorio = RepositorioUsuario.getInstancia();
	}

	public static ControladorUsuario getInstancia() {
		if (instancia == null) {
			instancia = new ControladorUsuario();
		}
		return instancia;
	}

	public void cadastrarUsuario(Usuario user) {
		if (user != null) {
			boolean existe = this.repositorio.existe(user.getCpf());
			if (existe != true) {
				this.repositorio.cadastrarUsuario(user);
			}
		}
	}

	public Usuario buscarUsuario(String cpf) throws DadosException {
		Usuario retorno = null;
		if (cpf != null) {
			retorno = this.repositorio.buscaPorCpf(cpf);
		}
		return retorno;
	}

	public void removerUsuario(String cpf) throws DadosException {
		if (cpf != null) {
			if (this.repositorio.existe(cpf) != false)
				this.repositorio.remover(cpf);
		}
	}

	public void alterarUsuario(Usuario user) {
		if (user != null) {
			if (this.repositorio.existe(user.getCpf()) != false)
				try {
					this.repositorio.alterarUsuario(user);
				} catch (DadosException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	public List<Usuario> mostrarUsuarios() {
		return this.repositorio.mostrarUsuarios();
	}

	public boolean autenticarLogin(String senha, String cpf) {
		boolean retorno = false;
		if (cpf != null && senha != null) {
			boolean existe = this.repositorio.existe(cpf);
			if (existe != false) {
				retorno = this.repositorio.autenticarLogin(senha, cpf);
			}
		}
		return retorno;
	}

}
