package br.ufrpe.dulceGusto.exceptions;

public class ProdutoJaExisteException extends Exception {

	private String nome;

	public ProdutoJaExisteException(String nome) {
		super("O produto " + nome + "ja existe");
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
