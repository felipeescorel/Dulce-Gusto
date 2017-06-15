package br.ufrpe.dulceGusto.classesbasicas;

public class Administrador extends Usuario{

	public String cpf;
	public Administrador(){
//	falta adicionar as senhas nos usuários.
		
	}
	public Administrador(String nome, String email, String telefone,String endereco,String cpf,String senha){
		super(nome,email,telefone,endereco,senha);
		setCpf(cpf);
		this.setAdm(true);
	}
	
	public String getCpf(){
		return cpf;
	}
	
	public void setCpf(String cpf){
		this.cpf = cpf;
	}
	
	@Override
	public String toString(){
		return "Nome: "+this.getNome()+"\nEmail: "+this.getEmail()+"\nTelefone: "+this.getTelefone()+"\nCpf: "+this.getCpf()+"\n\nEndereço: "+this.getEndereco();
	}
}
