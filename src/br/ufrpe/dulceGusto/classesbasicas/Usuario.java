package br.ufrpe.dulceGusto.classesbasicas;


public class Usuario {
	public String nome;
	public String email;
	public String telefone;
	public String endereco;
	public String user;
	
	public Usuario(){
		
	}
	
	public Usuario(String nome, String email, String telefone, String endereco, String user) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
		this.user = user;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
		
	}
	
	//EXCEÇOES
	/*
	
	
	public void setTelefone(String telefone) throws DadosException {
		if(telefone>=10000000){
			this.telefone = telefone;
		}
		else
			throw new DadosException("Telefone inválido");
	}
	
	
	public void setNome(String nome) throws DadosException{
		if(nome!= ""){
			this.nome = nome;
		}
		else
			throw new DadosException();
	}
	
	public void setEmail(String email) throws DadosException {
		if(email != ""){
			this.email = email;
		}
		else
			throw new DadosException();
	}
	
	public void setEndereco(String endereco) throws DadosException {
		if(endereco != ""){
			this.endereco = endereco;
		}
		else
			throw new DadosException();
	}
	
	 */
	
	
	

}
