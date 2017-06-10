package br.ufrpe.dulceGusto.negócio;

import br.ufrpe.dulceGusto.dados.*;
import br.ufrpe.dulceGusto.classesbasicas.Administrador;

public class CadastroAdministrador implements ICadastroAdministrador {
	
	private IRepositorioAdministrador repositorio;
	public CadastroAdministrador(){
		repositorio.getInstancia();
	}

	public void cadastrarAdministrador(Administrador adm){
		this.repositorio.cadastrarAdministrador(adm);
	}
	public Administrador buscarAdministrador(String cpf){
		return this.repositorio.buscarAdministrador(cpf);
	}
	public void removerAdministrador(Administrador adm){
		this.repositorio.removerAdministrador(adm.getCpf());
	}
	public void alterarAdministrador(Administrador adm){
		this.repositorio.alterarAdministrador(adm);
	}
	public void mostrarAdms(){
		this.repositorio.mostrarAdms();
	}
	//TODO atualizar as restrições
}
