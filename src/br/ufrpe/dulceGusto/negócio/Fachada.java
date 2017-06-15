package br.ufrpe.dulceGusto.negócio;

import java.util.List;

import br.ufrpe.dulceGusto.classesbasicas.Administrador;
import br.ufrpe.dulceGusto.classesbasicas.Cliente;
import br.ufrpe.dulceGusto.classesbasicas.Produto;
import br.ufrpe.dulceGusto.classesbasicas.Pedido;


public class Fachada implements IFachada {
	
	private ICadastroAdministrador cadastroAdministrador;
	private ICadastroProduto cadastroProduto;
	private ICadastroPedido cadastroPedido;
	private ICadastroClientes cadastroCliente;
	private static Fachada instancia;
	
	private Fachada(){
		CadastroAdministrador.getInstancia();
		CadastroProduto.getInstancia();
		CadastroClientes.getInstancia();
		CadastroPedido.getInstancia();		
	}
	
	public static Fachada getInstancia(){
		if(instancia == null){
			instancia = new Fachada();
		}
		return instancia;		
	}	
	
	//ADMINISTRADOR
	//TODO APENAS ADM DEVE PODER EXECUTAR
	@Override
	public void cadastrarCliente(Administrador adm){
		this.cadastroAdministrador.cadastrarAdministrador(adm);
	}
	//TODO APENAS ADM
	@Override
	public Administrador buscarAdministrador(String cpf){
		return this.cadastroAdministrador.buscarAdministrador(cpf);
	}
	//TODO APENAS ADM
	@Override
	public void removerAdministrador(Administrador adm){
		this.removerAdministrador(adm);
	}
	//TODO APENAS ADM
	@Override
	public void alterarAdministrador(Administrador adm){
		this.cadastroAdministrador.alterarAdministrador(adm);
	}
	//TODO implementar método que possa seR chamado por cliente mas apenas informe as informações básicas
	@Override
	public List<Administrador> exibirAdministradores(){
		return this.cadastroAdministrador.mostrarAdms();
	}
	
	
	
	//PRODUTO
	//TODO APENAS ADM
	@Override
	public void adicionarProduto(Produto produt){
		this.cadastroProduto.adicionarProduto(produt);
	}
	@Override
	public Produto buscarProduto(String nome){
		return this.cadastroProduto.buscarProduto(nome);
	}
	@Override
	//TODO APENAS ADM
	public void removerProduto(Produto produt){
		this.cadastroProduto.removerProduto(produt);
	}
	@Override
	//TODO APENAS ADM
	public void alterarProduto(Produto produt){
		this.cadastroProduto.alterarProduto(produt);
	}@Override
	public List<Produto> listarProdutos(){
		return this.cadastroProduto.listarProdutos();
	}
	
	
	@Override
	//CLIENTE
	//Apenas ADM
	public void adicionarCliente(Cliente cliente){
		this.cadastroCliente.cadastrarCliente(cliente);
	}
	@Override
	//APENAS ADM
	public Cliente buscarCliente(String cpf){
		return this.cadastroCliente.buscarCliente(cpf);
	}
	@Override
	//APENAS ADM
	public void removerCliente(Cliente cliente){
		this.cadastroCliente.removerCliente(cliente);
	}
	@Override
	//APENAS ADM ALTERA OUTROS, O PROPRIO PODE SE ALTERAR
	public void alterarCliente(Cliente cliente){
		this.cadastroCliente.alterarCliente(cliente);
	}
	@Override
	//APENAS ADM
	public List<Cliente> listarClientes(){
		return this.cadastroCliente.listarClientes();
	}
	
	
	
	
	//PEDIDO
	@Override
	public void cadastrarPedido(Pedido pedido){
		this.cadastroPedido.cadastrarPedido(pedido);
	}
	@Override
	public Pedido buscarPedido(int numeroPedido){
		return this.cadastroPedido.buscarPedido(numeroPedido);
	}
	@Override
	public void removerPedido(Pedido pedido){
		this.cadastroPedido.removerPedido(pedido);
	}
	@Override
	public void alterarPedido(Pedido pedido){
		this.cadastroPedido.cadastrarPedido(pedido);
	}
	@Override
	public List<Pedido> mostrarPedido(){
		return this.cadastroPedido.mostrarPedido();
	}
}
