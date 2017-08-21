package br.ufrpe.dulceGusto.negócio;
/*Fachada: serve para as classes de GUI do sistema terem acesso a todas as funcionalidades do mesmo.*/

import java.util.List;

import br.ufrpe.dulceGusto.classesbasicas.Cliente;
import br.ufrpe.dulceGusto.classesbasicas.Pedido;
import br.ufrpe.dulceGusto.classesbasicas.Produto;
import br.ufrpe.dulceGusto.classesbasicas.Usuario;
import br.ufrpe.dulceGusto.exceptions.ClienteJaCadastradoException;
import br.ufrpe.dulceGusto.exceptions.ClienteNaoExisteException;
import br.ufrpe.dulceGusto.exceptions.DadosException;
import br.ufrpe.dulceGusto.exceptions.PedidoNaoExisteException;
import br.ufrpe.dulceGusto.exceptions.ProdutoJaExisteException;
import br.ufrpe.dulceGusto.exceptions.ProdutoNaoExisteException;

public class ServidorDulceGusto {
	private ControladorUsuario user;
	private ControladorPedido pedidos;
	private ControladorProduto produtos;

	private static ServidorDulceGusto instance;

	private ServidorDulceGusto() {
		this.user = new ControladorUsuario();
		this.pedidos = new ControladorPedido();
		this.produtos = new ControladorProduto();
	}

	/**
	 * Implementando padrão Singleton
	 * 
	 * @return A instância da desta fachada
	 */
	public static ServidorDulceGusto getInstance() {
		if (instance == null) {
			instance = new ServidorDulceGusto();
		}

		return instance;
	}

	public void cadastrarUsuario(Usuario user) throws ClienteJaCadastradoException {
		this.user.cadastrarUsuario(user);
	}

	public Usuario buscarUsuario(String cpf) throws ClienteNaoExisteException, DadosException {
		return this.user.buscarUsuario(cpf);
	}

	public void removerUsuario(String cpf) throws DadosException {
		this.user.removerUsuario(cpf);
	}

	public void atualizar(Usuario user) {
		this.user.alterarUsuario(user);
	}

	public List<Usuario> mostrarUsuarios() {
		return this.user.mostrarUsuarios();
	}

	public void adicionarProduto(Produto produt) throws ProdutoJaExisteException {
		this.produtos.adicionarProduto(produt);
	}

	public Produto buscarProduto(String nome) throws ProdutoNaoExisteException {
		return produtos.buscarProduto(nome);
	}

	public void removerProduto(Produto produto) throws ProdutoNaoExisteException {
		this.produtos.removerProduto(produto);
	}

	public void alterarProduto(Produto produto) throws ProdutoNaoExisteException {
		this.produtos.alterarProduto(produto);
	}

	public void listarProdutos() {
		produtos.listarProdutos();
	}

	public void cadastrarPedido(Pedido pedido) {
		pedidos.cadastrarPedido(pedido);
	}

	public void removerPedido(Pedido pedido) throws PedidoNaoExisteException {
		pedidos.removerPedido(pedido);
	}

	public void listarPedido() {
		pedidos.listarPedido();
	}

	public Pedido buscarPedido(String numeroPedido) throws PedidoNaoExisteException {
		return pedidos.buscarPedido(numeroPedido);
	}

	public void alterarPedido(Pedido pedido) throws PedidoNaoExisteException {
		pedidos.alterarPedido(pedido);
	}

}
