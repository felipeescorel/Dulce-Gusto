package br.ufrpe.dulceGusto.classesbasicas;
import java.util.Calendar;

public class Pedido  {
	
	
	private Cliente cliente;
	private double valorTotal;
	private Calendar dataPedido;
	private int quantidade;
	private Produto[] produto;
	private int numeroPedido;
	
	public Pedido(Cliente cliente, double valor, Calendar dataPedido,int quantidade, int numeroPedido){
		this.cliente = cliente;
		this.valorTotal = valor;
		this.dataPedido = dataPedido;
		this.numeroPedido = numeroPedido;
		setQuantidade(quantidade);
	}
	
	
	public int getQuantidade(){
		return quantidade;
	}
	public void setQuantidade(int quantidade){
		this.quantidade = quantidade;
	}
	public Cliente getCliente(){
		return cliente;
	}
	public void setCliente(Cliente cliente){
		this.cliente = cliente;
				
	}
	public double getValorTotal(){
		return valorTotal;
	}
	public void setValorTotal(double valor){
		this.valorTotal = valor*this.getQuantidade();
	}
	public Calendar getDataPedido(){
		return dataPedido;
	}
	public void setDataPedido(Calendar dataPedido){
		dataPedido = Calendar.getInstance();
		this.dataPedido = dataPedido;
		// TODO CHECAR SE TÁ FUNCIONANDO.
	}
	public int getNumeroPedido() {
		return numeroPedido;
	}
	public void setNumeroPedido(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}


	public void cadastrarProduto(){
		//TODO
	}
	public void listarProdutos(){
		for(Produto produto : produto){
			System.out.println(produto);
		}
	}
}

