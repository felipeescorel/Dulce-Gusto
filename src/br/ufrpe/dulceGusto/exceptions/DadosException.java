package br.ufrpe.dulceGusto.exceptions;

public class DadosException extends Exception {

	public DadosException() {
		super("Dados inválidos");
	}

	public DadosException(String msg) {
		super(msg);
	}
}
