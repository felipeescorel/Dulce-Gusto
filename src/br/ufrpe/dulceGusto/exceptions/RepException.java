package br.ufrpe.dulceGusto.exceptions;

import br.ufrpe.dulceGusto.classesbasicas.*;

public class RepException extends Exception {

	public RepException(String nome) {
		super("N�o foi encontrado nenhum usu�rio chamado: " + nome);

	}

	public RepException(String cpf, String senha) {
		super("N�o foi encontrado nenhuma conta cadastrada com esses dados");

	}

	public RepException() {
		super("Nenhum item cadastrado");
	}

}
