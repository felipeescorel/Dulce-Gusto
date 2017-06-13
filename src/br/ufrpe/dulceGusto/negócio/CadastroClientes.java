package br.ufrpe.dulceGusto.negócio;

import br.ufrpe.dulceGusto.dados.*;

import br.ufrpe.dulceGusto.classesbasicas.Cliente;

import java.util.List;

	
	public class CadastroClientes implements ICadastroClientes{
		
		private IRepositorioCliente repositorio;	
		public CadastroClientes(){
			repositorio.getInstancia();
		}
		
		@Override	
		public void cadastrarCliente(Cliente client){
			this.repositorio.cadastrarCliente(client);		
			if (client == null) {
				System.out.println("Cliente invalido " + client);
				return;
			}
		}
		@Override
		public Cliente buscarCliente (String nome){
			return this.repositorio.buscarCliente(nome);		
		}
		@Override
		public void removerCliente (Cliente client){
			this.repositorio.removerCliente(client.getNome());
		}
		@Override
		public void alterarCliente(Cliente client){
			
			if (client == null) {
				System.out.println("Cliente invalido!");
				return;
			}		
			this.repositorio.alterarCliente(client);
		}

		@Override
		public List<Cliente> listarClientes() {
			// TODO Auto-generated method stub
			return null;
		}
	
		

	}
	
	


