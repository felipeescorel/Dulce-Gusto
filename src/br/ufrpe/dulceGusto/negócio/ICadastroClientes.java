package br.ufrpe.dulceGusto.negócio;

import java.util.List;

import br.ufrpe.dulceGusto.classesbasicas.Cliente;


public interface ICadastroClientes {
	
		void cadastrarCliente(Cliente client);
		Cliente buscarCliente(String cpf);
		void removerCliente(Cliente client);
		void alterarCliente(Cliente client);
		List<Cliente> listarClientes();
		CadastroClientes getInstancia();
	}



