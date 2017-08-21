package br.ufrpe.dulceGusto.exceptions;

public class ProdutoNaoExisteException extends Exception {

	private String nome;

	public ProdutoNaoExisteException(String nome) {
		super("O produto " + nome + "nao existe");
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
