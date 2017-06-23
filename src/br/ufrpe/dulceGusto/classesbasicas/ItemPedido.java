package br.ufrpe.dulceGusto.classesbasicas;

public class ItemPedido {
	private String produto;
	private int quantProduto;

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public int getQuantProduto() {
		return quantProduto;
	}

	public void setQuantProduto(int quantProduto) {
		this.quantProduto = quantProduto;
	}

	public ItemPedido() {

	}

	public ItemPedido(String produto, int quantProduto) {
		this.produto = produto;
		this.quantProduto = quantProduto;
	}

}
