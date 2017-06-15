package br.ufrpe.dulceGusto.classesbasicas;

public class Cliente extends Usuario{
	public String cpf;
	
	
	public Cliente() {
		this.setAdm(false);
	}

	public Cliente(String nome, String email, String telefone, String endereco,String cpf,String senha) {
		super(nome, email, telefone, endereco, senha);
		this.cpf = cpf;
		this.setAdm(false);
		
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
	
	
}
