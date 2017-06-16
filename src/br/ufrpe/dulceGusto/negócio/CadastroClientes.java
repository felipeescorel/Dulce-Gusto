package br.ufrpe.dulceGusto.negócio;

import br.ufrpe.dulceGusto.classesbasicas.Cliente;
import br.ufrpe.dulceGusto.dados.IRepositorioCliente;
import br.ufrpe.dulceGusto.dados.RepositorioCliente;

import java.util.List;
	
	public class CadastroClientes implements ICadastroClientes{
		
		private static CadastroClientes instancia;
		private IRepositorioCliente repositorio = RepositorioCliente.getInstancia();
		private CadastroClientes(){
			RepositorioCliente.getInstancia();
		}		
		@Override	
		public void cadastrarCliente(Cliente client){
			if(client!=null){
				boolean existe = this.repositorio.existe(client.getCpf());
				if(existe!=true)
					this.repositorio.cadastrarCliente(client);		
			}			
			else {
				System.out.println("Cliente invalido " + client);
				return;
				//Não precisa botar isso, a gente vai resolver com excessão depois.
			}
		}
		@Override
		public Cliente buscarCliente (String cpf){
			Cliente retorno = null;
			if(cpf!=null){
				retorno = this.repositorio.buscarCliente(cpf);
			}
			return retorno;	
		}
		@Override
		public void removerCliente (Cliente client){
			if(client != null){				
				if(this.repositorio.existe(client.getCpf()) != false){
					this.repositorio.removerCliente(client.getNome());
				}
			}			
		}
		@Override
		public void alterarCliente(Cliente client){			
			if (client == null) {
				System.out.println("Cliente invalido!");
				return;
				//Não precisa blablabla exceção
			}
			if(client != null){
				if(this.repositorio.existe(client.getCpf())){
					this.repositorio.alterarCliente(client);
				}
			}
		}
		@Override
		public List<Cliente> listarClientes() {			
			return this.repositorio.listarClientes();
		}
		
		public static CadastroClientes getInstancia(){
			if(instancia == null){
				instancia = new CadastroClientes();
			}
			return instancia;
		}
		@Override
		public boolean autenticarLogin(String senha, String cpf){
			boolean retorno = false;
			if(cpf!=null &&senha!=null){
				if(this.repositorio.existe(cpf)){					
					retorno = this.repositorio.autenticarLogin(senha, cpf);
				}
			}
			return retorno;
	
		}
	}
	
	


