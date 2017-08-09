package br.ufrpe.dulceGusto.classesbasicas;

import java.util.ArrayList;

import br.ufrpe.dulceGusto.exceptions.*;

public abstract class Usuario {

	private String nome;
	private String cpf;
	private String email;
	private String senha;
		public Usuario() {

	}



	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Usuario(String nome, String cpf, String email, String senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws DadosException {
		if (nome != "") {
			this.nome = nome;
		} else
			throw new DadosException();
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws DadosException {
		if (email != "") {
			this.email = email;
		} else
			throw new DadosException();
	}

}
