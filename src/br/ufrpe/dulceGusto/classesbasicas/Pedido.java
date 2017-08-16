package br.ufrpe.dulceGusto.classesbasicas;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
//import java.sql.Date;
import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.time.ZoneOffset;
//import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Pedido implements Serializable {

	private Cliente cliente;
	private double valorTotal;
	private int quantidadeProduto;
	private List<Produto> produto = new ArrayList<Produto>();
	private String numeroPedido;
	private int contador = 0;
	

	private LocalDateTime data = LocalDateTime.now();


	public Pedido(Cliente cliente, LocalDateTime dataPedido) {
		this.setCliente(cliente);	
		this.gerarNumeroPedido(dataPedido);
	}

	public Pedido() {
		this.gerarNumeroPedido(LocalDateTime.now());
	}

	public int getQuantidade() {
		return quantidadeProduto;
	}

	public void gerarNumeroPedido(LocalDateTime data) {	
		DateTimeFormatter formatar = DateTimeFormatter.ofPattern("yyyyMMdd");
		String numero = data.format(formatar);
		setNumeroPedido(numero+"0"+Integer.toString(contador));	
		contador++;
	}
	
	public void setNumeroPedido(String numeroPedido){
		this.numeroPedido = numeroPedido;
		
	}
	
	public LocalDateTime getData() {
		return data;
	}

	public void setQuantidade(int quantidade) {
		this.quantidadeProduto = quantidade;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public String getNumeroPedido() {
		return numeroPedido;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getValorTotal() {
		return valorTotal;
	}
	public double getValorDaCompra() {
		for (int i = 0; i < this.produto.size(); i++) {
			valorTotal += this.produto.get(i).getPreco() * this.getQuantidade();
		}
		return valorTotal;
	}

	public boolean validarProduto(Cliente cliente) {
		boolean retorno = false;
		for (int i = 0; i < this.produto.size(); i++) {
			if (this.produto.get(i).getIngredientes().equals(cliente.getRestricaoAlimentar())) {
				retorno = true;
				// Verifica se o cliente é alérgico ao produto. 
				// Retorna verdadeiro se for alérgico.
			}
		}
		return retorno;
	}

	public void novoProduto(Produto produto) {
		boolean verifica = false;
		if (produto != null) {
			for (int i = 0; i < this.produto.size(); i++) {
				verifica = this.produto.get(i).getNome().equals(produto.getNome());
				if (verifica != false) {
					break;
				}
			}
			if (verifica != true) {
				this.produto.add(produto);
			}
		}

	}

	public void removerProduto(Produto produto) {
		if (produto != null) {
			for (int i = 0; i < this.produto.size(); i++) {
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
