package br.ufrpe.dulceGusto.exceptions;

public class PedidoNaoExisteException extends Exception {

	private String numeroPedido;

	public PedidoNaoExisteException(String numeroPedido) {
		super("O pedido " + numeroPedido + "ja existe");
		this.numeroPedido = numeroPedido;
	}

	public String getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(String numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

}
