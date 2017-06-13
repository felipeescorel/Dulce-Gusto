package br.ufrpe.dulceGusto.negócio;
import java.util.List;

import br.ufrpe.dulceGusto.classesbasicas.Administrador;
import br.ufrpe.dulceGusto.classesbasicas.Cliente;
import br.ufrpe.dulceGusto.classesbasicas.Pedido;
import br.ufrpe.dulceGusto.classesbasicas.Produto;


public interface IFachada {

		//ADMINISTRADOR
		void cadastrarCliente(Administrador adm);
		Administrador buscarAdministrador(String cpf);
		void removerAdministrador(Administrador adm);
		void alterarAdministrador(Administrador adm);
		List<Administrador> exibirAdministradores();
		
		
		//PRODUTO
		void adicionarProduto(Produto produt);
		Produto buscarProduto(String nome);
		void removerProduto(Produto produt);
		void alterarProduto(Produto produt);
		List<Produto> listarProdutos();
		
		
		//TODO Cliente
		void adicionarCliente(Cliente cliente);
		Cliente buscarCliente(String nome);
		void removerCliente(Cliente cliente);
		void alterarCliente(Cliente cliente);
		List<Cliente> listarClientes();
		
		
		//TODO Pedido
		void cadastrarPedido(Pedido pedido);
		Pedido buscarPedido(int numeroPedido);
		void removerPedido(Pedido pedido);
		void alterarPedido(Pedido pedido);
		List<Pedido> mostrarPedido();
		
}
