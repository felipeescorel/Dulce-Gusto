
package br.ufrpe.dulceGusto.exceptions;

public class ClienteNaoExisteException extends Exception {

	public ClienteNaoExisteException(String cpf) {
		super("O cpf " + cpf + " n�o � referente a nenhum cliente cadastrado.");
	}
}
