package br.ufrpe.dulceGusto.negócio;

import java.util.List;

import br.ufrpe.dulceGusto.classesbasicas.Administrador;
import br.ufrpe.dulceGusto.classesbasicas.Cliente;
import br.ufrpe.dulceGusto.classesbasicas.Produto;
import br.ufrpe.dulceGusto.classesbasicas.Pedido;
import br.ufrpe.dulceGusto.dados.*;

public class Fachada implements IFachada {
	
	private ICadastroAdministrador cadastroAdministrador;
	private ICadastroProduto cadastroProduto;
	private ICadastroPedido cadastroPedido;
	private ICadastroClientes cadastroCliente;	
	private static Fachada instancia;
	
	private Fachada(){
		this.cadastroAdministrador.getInstancia();
		this.cadastroProduto.getInstancia();
		this.cadastroCliente.getInstancia();
		this.cadastroPedido.getInstancia();		
	}
	
	public static Fachada getInstancia(){
		if(instancia == null){
			instancia = new Fachada();
		}
		return instancia;		
	}	
	
	//ADMINISTRADOR
	//TODO APENAS ADM DEVE PODER EXECUTAR
	public void cadastrarCliente(Administrador adm){
		this.cadastroAdministrador.cadastrarAdministrador(adm);
	}
	//TODO APENAS ADM
	public Administrador buscarAdministrador(String cpf){
		return this.cadastroAdministrador.buscarAdministrador(cpf);
	}
	//TODO APENAS ADM
	public void removerAdministrador(Administrador adm){
		this.removerAdministrador(adm);
	}
	//TODO APENAS ADM
	public void alterarAdministrador(Administrador adm){
		this.cadastroAdministrador.alterarAdministrador(adm);
	}
	//TODO implementar método que possa seR chamado por cliente mas apenas informe as informações básicas
	public List<Administrador> exibirAdministradores(){
		return this.cadastroAdministrador.mostrarAdms();
	}
	
	
	
	//PRODUTO
	//TODO APENAS ADM
	public void adicionarProduto(Produto produt){
		this.cadastroProduto.adicionarProduto(produt);
	}
	public Produto buscarProduto(String nome){
		return this.cadastroProduto.buscarProduto(nome);
	}
	//TODO APENAS ADM
	public void removerProduto(Produto produt){
		this.cadastroProduto.removerProduto(produt);
	}
	//TODO APENAS ADM
	public void alterarProduto(Produto produt){
		this.cadastroProduto.alterarProduto(produt);
	}
	public List<Produto> listarProdutos(){
		return this.cadastroProduto.listarProdutos();
	}
	
	
	
	//CLIENTE
	//Apenas ADM
	public void adicionarCliente(Cliente cliente){
		this.cadastroCliente.cadastrarCliente(cliente);
	}
	//APENAS ADM
	public Cliente buscarCliente(String nome){
		return this.cadastroCliente.buscarCliente(nome);
	}
	//APENAS ADM
	public void removerCliente(Cliente cliente){
		this.cadastroCliente.removerCliente(cliente);
	}
	//APENAS ADM ALTERA OUTROS, O PROPRIO PODE SE ALTERAR
	public void alterarCliente(Cliente cliente){
		this.cadastroCliente.alterarCliente(cliente);
	}
	//APENAS ADM
	public List<Cliente> listarClientes(){
		return this.cadastroCliente.listarClientes();
	}
	
	
	//PEDIDO
	public void cadastrarPedido(Pedido pedido){
		this.cadastroPedido.cadastrarPedido(pedido);
	}
	public Pedido buscarPedido(int numeroPedido){
		return this.cadastroPedido.buscarPedido(numeroPedido);
	}
	public void removerPedido(Pedido pedido){
		this.cadastroPedido.removerPedido(pedido);
	}
	public void alterarPedido(Pedido pedido){
		this.cadastroPedido.cadastrarPedido(pedido);
	}
	public List<Pedido> mostrarPedido(){
		return this.cadastroPedido.mostrarPedido();
	}
}
