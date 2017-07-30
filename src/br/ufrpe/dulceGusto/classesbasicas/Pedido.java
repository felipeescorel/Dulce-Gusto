package br.ufrpe.dulceGusto.classesbasicas;

import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.time.LocalTime;


public class Pedido {

	private Cliente cliente;
	private double valorTotal;	
	private Date dataPedido;
	private int quantidade;
	private LocalTime data; 	//??
	private List<Produto> produto = new ArrayList<Produto>();
	private String numeroPedido;// TODO pedir ajuda ao professor

	public Pedido(Cliente cliente, Date dataPedido) {
		this.setCliente(cliente);	
		this.setDataPedido(dataPedido);
//		this.numeroPedido = numeroPedido;
		this.gerarNumeroPedido();
		//gerar o numero aqui dentro
		
	}

	public Pedido() {

	}

	public int getQuantidade() {
		return quantidade;
	}
	public String gerarNumeroPedido(){		
		
		return Integer.toString(this.getDataPedido().getYear()+
				this.getDataPedido().getMonth()+this.getDataPedido().getDay());
	}
	public LocalTime getData(){
		return data;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Cliente getCliente() {
		return cliente;
	}
	public String getNumeroPedido(){
		return numeroPedido;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getValorTotal() {
		return valorTotal;
	}	

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		
		this.dataPedido = dataPedido;
		// TODO CHECAR SE TÁ FUNCIONANDO.
	}

	public double getValorDaCompra(){
		for(int i=0;i<this.produto.size();i++){
			valorTotal += this.produto.get(i).getPreco()*this.getQuantidade();			
		}
		return valorTotal;
	}
	public boolean validarProduto(Cliente cliente){
		boolean retorno = false;
		for(int i=0;i<this.produto.size();i++){
			if (this.produto.get(i).getIngredientes().equals(cliente.getRestricaoAlimentar())){
				retorno = true;
				//Verifica se o cliente é alérgico ao produto. Retorna verdadeiro se for alérgico.
			}			
		}
		return retorno;
	}

	public void novoProduto(Produto produto) {
		boolean verifica = false;
		if (produto != null) {
			for (int i = 0; i < this.produto.size(); i++) {
				verifica = this.produto.get(i).getNome().equals(produto.getNome());	
				if(verifica != false){
					break;
				}
			}
			if(verifica != true){				
					this.produto.add(produto);				
			}
		}

	}
	public void removerProduto(Produto produto){
		if(produto!=null){
			for(int i=0;i<this.produto.size();i++){
				if (this.produto.get(i).getNome().equals(produto.getNome())) {
					this.produto.remove(i);
				}
			}
		}
	}

	public List<Produto> mostrarProdutos() {
		return this.produto;
	}

}
