package br.ufrpe.dulceGusto.classesbasicas;

public class Cliente extends Usuario{
	public String cpf;

	
	public Cliente() {
				
	}

	public Cliente(String nome, String email, String telefone, String endereco, String user,String cpf) {
		super(nome, email, telefone, endereco, user);
		this.cpf = cpf;
		
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	
	
	
}
