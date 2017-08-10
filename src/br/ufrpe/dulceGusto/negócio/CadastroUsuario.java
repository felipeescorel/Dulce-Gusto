package br.ufrpe.dulceGusto.negócio;
import java.util.List;
import br.ufrpe.dulceGusto.classesbasicas.*;
import br.ufrpe.dulceGusto.dados.*;
import br.ufrpe.dulceGusto.exceptions.DadosException;
import br.ufrpe.dulceGusto.exceptions.ItemException;

public class CadastroUsuario {
	private static CadastroUsuario instancia;
	private IRepositorioUsuario repositorio;
	
	private CadastroUsuario(){
		this.repositorio = RepositorioUsuario.getInstancia();
	}
	public static CadastroUsuario getInstancia(){
		if(instancia == null){
			instancia = new CadastroUsuario();
		}
		return instancia;
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
			try {
				retorno = this.repositorio.buscarUsuario(cpf);
			} catch (ItemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return retorno;
	}

	public void removerUsuario(Usuario user) {
		if (user != null) {
			if (this.repositorio.existe(user.getCpf()) != false)
				try {
					this.repositorio.removerUsuario(user.getCpf());
				} catch (ItemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
				try {
					retorno = this.repositorio.autenticarLogin(senha, cpf);
				} catch (ItemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return retorno;
	}
}
