package br.ufrpe.dulceGusto.negócio;

import java.util.List;

import br.ufrpe.dulceGusto.classesbasicas.*;

public class Fachada {


	private ControladorProduto cadastroProduto;
	private ControladorPedido cadastroPedido;
	private static Fachada instancia;
	private ControleDeLogin controleLogin;
	private ControladorUsuario cadastroUsuario;

	private Fachada() {
		this.cadastroProduto = ControladorProduto.getInstancia();
		this.cadastroPedido = ControladorPedido.getInstancia();
		this.controleLogin = ControleDeLogin.getInstancia();
		this.cadastroUsuario = ControladorUsuario.getInstancia();
	}
	public static Fachada getInstancia() {
		if (instancia == null) {
			instancia = new Fachada();
		}
		return instancia;
	}
	//USUARIO
	public void cadastrarUsuario(Usuario user){
		this.cadastroUsuario.cadastrarAdministrador(user);
	}
	public Usuario buscarUsuario(String cpf){
		return this.cadastroUsuario.buscarUsuario(cpf);
	}
	public void removerUsuario(Usuario user){
		this.removerUsuario(user);
	}
	public void alterarUSuario(Usuario user){
		this.cadastroUsuario.alterarUsuario(user);
	}
	public List<Usuario> exibirUsuarios(){
		return this.cadastroUsuario.mostrarUsuarios();
	}
	
	



	// PRODUTO
	// TODO APENAS ADM

	public void adicionarProduto(Produto produt) {
		this.cadastroProduto.adicionarProduto(produt);
	}

	public Produto buscarProduto(String nome) {
		return this.cadastroProduto.buscarProduto(nome);
	}

	// TODO APENAS ADM
	public void removerProduto(Produto produt) {
		this.cadastroProduto.removerProduto(produt);
	}

	// TODO APENAS ADM
	public void alterarProduto(Produto produt) {
		this.cadastroProduto.alterarProduto(produt);
	}

	public List<Produto> listarProdutos() {
		return this.cadastroProduto.listarProdutos();
	}


	// PEDIDO

	public void cadastrarPedido(Pedido pedido) {
		this.cadastroPedido.cadastrarPedido(pedido);
	}

	public void novoProduto(Produto produto, Pedido pedido) {
		this.cadastroPedido.novoProduto(produto, pedido);
	}

	public Pedido buscarPedido(String numeroPedido) {
		return this.cadastroPedido.buscarPedido(numeroPedido);
	}

	public void removerPedido(Pedido pedido) {
		this.cadastroPedido.removerPedido(pedido);
	}

	public void alterarPedido(Pedido pedido) {
		this.cadastroPedido.cadastrarPedido(pedido);
	}

	public List<Pedido> mostrarPedido() {
		return this.cadastroPedido.mostrarPedido();
	}

	// LOGIN

	public boolean autenticarLogin(String senha, String cpf) {
		return this.controleLogin.autenticarLogin(senha, cpf);
	}
}
