package br.ufrpe.dulceGusto.negócio;
import java.util.List;
import br.ufrpe.dulceGusto.classesbasicas.*;
import br.ufrpe.dulceGusto.dados.*;

public class CadastroUsuario {
	private static CadastroUsuario instancia;
	private IRepositorioUsuario repositorio;
	
	public CadastroUsuario(){
		this.repositorio = RepositorioUsuario.getInstancia();
	}
	public void cadastrarAdministrador(Usuario user) {
		if (user != null) {
			boolean existe = this.repositorio.existe(user.getCpf());
			if (existe != true) {
				this.repositorio.cadastrarUsuario(user);
			}
		}
	}

	public Usuario buscarUsuario(String cpf) {
		Usuario retorno = null;
		if (cpf != null) {
			retorno = this.repositorio.buscarUsuario(cpf);
		}
		return retorno;
	}

	public void removerUsuario(Usuario user) {
		if (user != null) {
			if (this.repositorio.existe(user.getCpf()) != false)
				this.repositorio.removerUsuario(user.getCpf());
		}
	}

	public void alterarUsuario(Usuario user) {
		if (user != null) {
			if (this.repositorio.existe(user.getCpf()) != false)
				this.repositorio.alterarUsuario(user);
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
