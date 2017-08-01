package br.ufrpe.dulceGusto.classesbasicas;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.dulceGusto.exceptions.DadosException;

public class Cliente extends Usuario {

	private ArrayList<String> restricaoAlimentar = new ArrayList<String>();
	private long telefone;
	private Endereco endereco = new Endereco();
	// pedido aqui

	public Cliente() {

	}

	public Cliente(String nome, String cpf, String email, String telefone, Endereco endereco, String senha) {
		super(nome, cpf, email, senha);
		// TODO this.restricaoAlimentar = restricaoAlimentar;
	}

	public void cadastrarNovaRestricao(String alimento) {
		restricaoAlimentar.add(alimento);
	}

	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(long telefone) throws DadosException {
		if (telefone >= 10000000) {
			this.telefone = telefone;
		} else
			throw new DadosException("Telefone inválido");
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) throws DadosException {
		if (endereco != null) {
			this.endereco = endereco;
		} else
			throw new DadosException();
	}

	public List getRestricaoAlimentar() {
		return restricaoAlimentar;
	}

}
