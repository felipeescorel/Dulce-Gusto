package br.ufrpe.dulceGusto.dados;

import java.util.List;
import br.ufrpe.dulceGusto.classesbasicas.Cliente;


public interface IRepositorioCliente {

	void cadastrarCliente(Cliente client);
	Cliente buscarCliente(String cpf);
	void removerCliente(String cpf);
	void alterarCliente(Cliente client);
	boolean existe(String cpf);
	List<Cliente> listarClientes();
	boolean autenticarLogin(String senha, String cpf);


}
