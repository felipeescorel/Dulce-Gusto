package br.ufrpe.dulceGusto.exceptions;

public class ClienteJaCadastradoException extends Exception {

	private String cpf;

	public ClienteJaCadastradoException(String cpf) {
		super("O cpf" + cpf + "ja esta cadastrado");
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
