
package br.ufrpe.dulceGusto.exceptions;

public class ClienteNaoExisteException extends Exception {

	public ClienteNaoExisteException(String cpf) {
		super("O cpf " + cpf + " não é referente a nenhum cliente cadastrado.");
	}
}
