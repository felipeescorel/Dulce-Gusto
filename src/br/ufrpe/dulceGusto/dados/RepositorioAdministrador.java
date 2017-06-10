package br.ufrpe.dulceGusto.dados;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.dulceGusto.classesbasicas.Administrador;
import br.ufrpe.dulceGusto.classesbasicas.Cliente;


public class RepositorioAdministrador {

	private List<Administrador> administrador = new ArrayList<Administrador>();
	private List<Cliente> cliente = new ArrayList<Cliente>();
//	cliente.getInstacia();
	
	private static RepositorioAdministrador instancia;
	
	public static RepositorioAdministrador getInstancia(){
		if(instancia == null){
			instancia = new RepositorioAdministrador();
		}
		return instancia;
	}
	private RepositorioAdministrador(){
		
	}
	public void cadastrarAdministrador(Administrador adm){
		this.administrador.add(adm);
	}
	
	public Administrador buscarAdministrador(String cpf){
		Administrador retorno = null;
		int indice = this.obterIndice(cpf);
		if(indice!=-1){
			retorno = this.administrador.get(indice);
		}
		return retorno;
	}
	public void cadastrarCliente(Cliente cliente){
//		this.
	}
	
	private int obterIndice(String cpf){
		int indice = -1;
		for(int i=0;i<administrador.size();i++){
			if(this.administrador.get(i).equals(cpf)){
				indice = i;
			}
		}
		return indice;
			
		
	}
	public boolean existe(String cpf){
		boolean existe = false;
		int indice=this.obterIndice(cpf);
		if(indice!=-1){
			existe = true;
		}
		return existe;
	}
	//Remove Usuário, tanto adm quanto cliente.
	public void removerUsuario(String cpf){
		int indice = this.obterIndice(cpf);
		if(indice!=-1){
			this.administrador.remove(cpf);
		}
	}
	
	
}
