package br.ufrpe.dulceGusto.classesbasicas;

public class Administrador extends Usuario {
	private String redeSocial;

	public Administrador() {
		// falta adicionar as senhas nos usuários.
		this.setAdm(true);
	}

	public Administrador(String nome, String cpf, String email, String telefone, String endereco, String senha,
			String redeSocial) {
		super(nome, cpf, email, telefone, endereco, senha);
		this.setRedeSocial(redeSocial);
		this.setAdm(true);
	}

	public String getRedeSocial() {
		return redeSocial;
	}

	public void setRedeSocial(String redeSocial) {
		this.redeSocial = redeSocial;
	}

	@Override
	public String toString() {
		return "Nome: " + this.getNome() + "\nCpf: " + this.getCpf() + "\nEmail: " + this.getEmail() + "\nTelefone: "
				+ this.getTelefone() + "\n\nEndereço: " + this.getEndereco() + "\nRede Social: " + this.getRedeSocial();
	}

}
