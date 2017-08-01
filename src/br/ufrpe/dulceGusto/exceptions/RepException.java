package br.ufrpe.dulceGusto.exceptions;

import br.ufrpe.dulceGusto.classesbasicas.*;

public class RepException extends Exception {

	public RepException(String nome) {
		super("Não foi encontrado nenhum usuário chamado: " + nome);

	}

	public RepException(String cpf, String senha) {
		super("Não foi encontrado nenhuma conta cadastrada com esses dados");

	}

	public RepException() {
		super("Nenhum item cadastrado");
	}

}
