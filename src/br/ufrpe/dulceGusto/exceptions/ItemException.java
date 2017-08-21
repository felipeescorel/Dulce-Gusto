package br.ufrpe.dulceGusto.exceptions;

import java.util.ArrayList;

public class ItemException extends Exception {

	private ArrayList<String> ingredientes;

	public ItemException(ArrayList<String> numeroPedido) {
		super("O ingrdiente " + numeroPedido + "ja existe");
		this.ingredientes = numeroPedido;
	}

	public ArrayList<String> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(ArrayList<String> ingredientes) {
		this.ingredientes = ingredientes;
	}
}
