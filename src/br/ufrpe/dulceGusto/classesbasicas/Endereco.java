package br.ufrpe.dulceGusto.classesbasicas;

import java.io.Serializable;

public class Endereco implements Serializable {
	private String logradouro;
	private String numero;
	private String cidade;
	private String bairro;
	private String cep;
	private String complemento;
	private String estado;

	public Endereco() {

	}

	public Endereco(String logradouro, String numero, String cidade, String estado, String bairro, String cep,
			String complemento) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.cidade = cidade;
		this.bairro = bairro;
		this.cep = cep;
		this.complemento = complemento;
		this.estado = estado;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Logradouro: " + this.getLogradouro() + "		Número: " + this.getNumero() + "\nComplemento: "
				+ this.getComplemento() + "\nCep: " + this.getCep() + "\nCidade: " + this.getCidade()
				+ "		Estado: " + this.getEstado();
	}

}
