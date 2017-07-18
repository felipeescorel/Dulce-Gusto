package br.ufrpe.dulceGusto.negócio;

import java.util.List;

import br.ufrpe.dulceGusto.classesbasicas.*;

public class Fachada {

//	private CadastroAdministrador cadastroAdministrador;
	private CadastroProduto cadastroProduto;
	private CadastroPedido cadastroPedido;
//	private CadastroClientes cadastroCliente;
	private static Fachada instancia;
	private ControleDeLogin controleLogin;
	private CadastroUsuario cadastroUsuario;

	private Fachada() {
//		this.cadastroAdministrador = CadastroAdministrador.getInstancia();
		this.cadastroProduto = new CadastroProduto();
		this.cadastroPedido = new CadastroPedido();
//		this.cadastroCliente = CadastroClientes.getInstancia();
		this.controleLogin = new ControleLogin();
		this.cadastroUsuario = new CadastroUsuario();
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
	
	

//	// ADMINISTRADOR
//	// TODO APENAS ADM DEVE PODER EXECUTAR
//
//	public void cadastrarAdm(Administrador adm) {
//		this.cadastroAdministrador.cadastrarAdministrador(adm);
//	}
//
//	// TODO APENAS ADM
//
//	public Administrador buscarAdministrador(String cpf) {
//		return this.cadastroAdministrador.buscarAdministrador(cpf);
//	}
//
//	// TODO APENAS ADM
//	public void removerAdministrador(Administrador adm) {
//		this.removerAdministrador(adm);
//	}
//
//	// TODO APENAS ADM
//
//	public void alterarAdministrador(Administrador adm) {
//		this.cadastroAdministrador.alterarAdministrador(adm);
//	}
//
//	// TODO implementar método que possa seR chamado por cliente mas apenas
//	// informe as informações básicas
//
//	public List<Administrador> exibirAdministradores() {
//		return this.cadastroAdministrador.mostrarAdms();
//	}

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

//	// CLIENTE
//	// Apenas ADM
//	public void adicionarCliente(Cliente cliente) {
//		this.cadastroCliente.cadastrarCliente(cliente);
//	}
//
//	// APENAS ADM
//	public Cliente buscarCliente(String cpf) {
//		return this.cadastroCliente.buscarCliente(cpf);
//	}
//
//	// APENAS ADM
//	public void removerCliente(Cliente cliente) {
//		this.cadastroCliente.removerCliente(cliente);
//	}
//
//	// APENAS ADM ALTERA OUTROS, O PROPRIO PODE SE ALTERAR
//	public void alterarCliente(Cliente cliente) {
//		this.cadastroCliente.alterarCliente(cliente);
//	}
//
//	// APENAS ADM
//	public List<Cliente> listarClientes() {
//		return this.cadastroCliente.listarClientes();
//	}

	// PEDIDO

	public void cadastrarPedido(Pedido pedido) {
		this.cadastroPedido.cadastrarPedido(pedido);
	}

	public void novoProduto(Produto produto) {
		this.cadastroPedido.novoProduto(produto);
	}

	public Pedido buscarPedido(int numeroPedido) {
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

	public boolean autenticarLoginUsuario(String senha, String cpf) {
		return this.controleLogin.autenticarLoginCliente(senha, cpf);
	}

//	public boolean autenticarLoginAdm(String senha, String cpf) {
//		return this.controleLogin.autenticarLoginAdm(senha, cpf);
//	}
//
//	public void atribuirAdm(CadastroAdministrador cadastroA) {
//		this.controleLogin.atribuirAdm(cadastroA);
//	}
//
//	public void atribuirCliente(CadastroClientes cadastroC) {
//		this.controleLogin.atribuirCliente(cadastroC);
//	}
}
