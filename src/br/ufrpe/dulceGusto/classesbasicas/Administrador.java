package br.ufrpe.dulceGusto.classesbasicas;

public class Administrador extends Usuario{

	public String cpf;
	public Administrador(){
	this.setAdm(true);
		
	}
	public Administrador(String nome, String email, String telefone,String endereco, String user, String cpf){
	super(nome,email,telefone,endereco,user);
	setCpf(cpf);
	this.setAdm(true);
	}
	public String getCpf(){
		return cpf;
	}
	public void setCpf(String cpf){
		this.cpf = cpf;
	}
}
