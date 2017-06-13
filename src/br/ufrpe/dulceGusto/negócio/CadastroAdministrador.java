package br.ufrpe.dulceGusto.negócio;

import br.ufrpe.dulceGusto.dados.*;
import br.ufrpe.dulceGusto.classesbasicas.Administrador;
import java.util.List;

public class CadastroAdministrador implements ICadastroAdministrador {
	
	private static CadastroAdministrador instancia;
	private IRepositorioAdministrador repositorio;
	private CadastroAdministrador(){
		repositorio.getInstancia();
	}
	@Override
	public void cadastrarAdministrador(Administrador adm){
		if(adm!=null){
			boolean existe = this.repositorio.existe(adm.getCpf());
			if(existe!=true)
				this.repositorio.cadastrarAdministrador(adm);
		}	
	}
	@Override
	public Administrador buscarAdministrador(String cpf){
		Administrador retorno = null;
		if(cpf!= null){		
			retorno = this.repositorio.buscarAdministrador(cpf);
		}
		return retorno;
	}
	@Override
	public void removerAdministrador(Administrador adm){
		if(adm!=null){			
			if(this.repositorio.existe(adm.getCpf())!=false)
				this.repositorio.removerAdministrador(adm.getCpf());
		}		
	}
	@Override
	public void alterarAdministrador(Administrador adm){
		if(adm!=null){
			if(this.repositorio.existe(adm.getCpf())!= false)
				this.repositorio.alterarAdministrador(adm);	
		}
	}
	@Override
	public List<Administrador> mostrarAdms(){
		return this.repositorio.mostrarAdms();
	}
	@Override
	public CadastroAdministrador getInstancia(){
		if(instancia == null){
			instancia = new CadastroAdministrador();
		}
		return instancia;
		
	}
	
}
