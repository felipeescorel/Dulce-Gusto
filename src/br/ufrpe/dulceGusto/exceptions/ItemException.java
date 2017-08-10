package br.ufrpe.dulceGusto.exceptions;

public class ItemException extends Exception {

	private String str;
	public ItemException(String str) {
		super("str");
		this.str = str;
	}

}
