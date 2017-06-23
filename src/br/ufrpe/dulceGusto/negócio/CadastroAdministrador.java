package br.ufrpe.dulceGusto.negócio;

import java.util.List;

import br.ufrpe.dulceGusto.classesbasicas.Administrador;
import br.ufrpe.dulceGusto.dados.*;

public class CadastroAdministrador {

	private static CadastroAdministrador instancia;
	private IRepositorioAdministrador repositorio;

	private CadastroAdministrador() {
		this.repositorio = RepositorioAdministrador.getInstancia();
	}

	public void cadastrarAdministrador(Administrador adm) {
		if (adm != null) {
			boolean existe = this.repositorio.existe(adm.getCpf());
			if (existe != true) {
				this.repositorio.cadastrarAdministrador(adm);
			}
		}
	}

	public Administrador buscarAdministrador(String cpf) {
		Administrador retorno = null;
		if (cpf != null) {
			retorno = this.repositorio.buscarAdministrador(cpf);
		}
		return retorno;
	}

	public void removerAdministrador(Administrador adm) {
		if (adm != null) {
			if (this.repositorio.existe(adm.getCpf()) != false)
				this.repositorio.removerAdministrador(adm.getCpf());
		}
	}

	public void alterarAdministrador(Administrador adm) {
		if (adm != null) {
			if (this.repositorio.existe(adm.getCpf()) != false)
				this.repositorio.alterarAdministrador(adm);
		}
	}

	public List<Administrador> mostrarAdms() {
		return this.repositorio.mostrarAdms();
	}

	public static CadastroAdministrador getInstancia() {
		if (instancia == null) {
			instancia = new CadastroAdministrador();
		}
		return instancia;

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
