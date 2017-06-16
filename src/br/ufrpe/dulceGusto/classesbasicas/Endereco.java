package br.ufrpe.dulceGusto.classesbasicas;

public class Endereco {
	private String logradouro;
	private String numero;
	private String cidade;
	private String bairro;
	private String cep;
	public String complemento;

	public Endereco(String logradouro, String numero, String cidade, String bairro, String cep, String complemento) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.cidade = cidade;
		this.bairro = bairro;
		this.cep = cep;
		this.complemento = complemento;
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

}
