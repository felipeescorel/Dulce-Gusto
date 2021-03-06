package br.ufrpe.dulceGusto.classesbasicas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.dulceGusto.exceptions.DadosException;

public class Cliente extends Usuario implements Serializable {

	private ArrayList<String> restricaoAlimentar = new ArrayList<String>();
	private String telefone;
	private Endereco endereco = new Endereco();
	private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

	public Cliente() {

	}

	public Cliente(String nome, String cpf, String email, String telefone, Endereco endereco, String senha) {
		super(nome, cpf, email, senha);
	}

	public void cadastrarNovaRestricao(String alimento) {
		restricaoAlimentar.add(alimento);
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) throws DadosException {
		if (Long.parseLong(telefone) >= 10000000) {
			this.telefone = telefone;
		} else
			throw new DadosException("Telefone inv�lido");
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

	public ArrayList<String> getRestricaoAlimentar() {
		return restricaoAlimentar;
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Pedido pedidos) {
		this.pedidos.add(pedidos);
	}

}
