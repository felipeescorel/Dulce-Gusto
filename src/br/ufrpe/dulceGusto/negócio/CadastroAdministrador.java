package br.ufrpe.dulceGusto.negócio;

import br.ufrpe.dulceGusto.dados.*;
import br.ufrpe.dulceGusto.classesbasicas.Administrador;
import java.util.List;
import br.ufrpe.dulceGusto.dados.RepositorioAdministrador;

public class CadastroAdministrador implements ICadastroAdministrador {
	
	private static CadastroAdministrador instancia;
	private IRepositorioAdministrador repositorio = RepositorioAdministrador.getInstancia();
	
	private CadastroAdministrador(){
		RepositorioAdministrador.getInstancia();
	}
	@Override
	public void cadastrarAdministrador(Administrador adm){
		if(adm!=null){
			boolean existe = this.repositorio.existe(adm.getCpf());
			if(existe!=true){
				this.repositorio.cadastrarAdministrador(adm);
			}
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
	
	public static CadastroAdministrador getInstancia(){
		if(instancia == null){
			instancia = new CadastroAdministrador();
		}
		return instancia;
		
	}
	@Override
	public boolean autenticarLogin(String senha, String cpf){
		boolean retorno = false;
		if(cpf!=null&&senha!=null){
			if(this.repositorio.existe(cpf)){
				this.repositorio.autenticarLogin(senha, cpf);
				retorno = true;
			}
		}
		return retorno;
	}
}
