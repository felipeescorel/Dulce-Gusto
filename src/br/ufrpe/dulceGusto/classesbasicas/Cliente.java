package br.ufrpe.dulceGusto.classesbasicas;

public class Cliente extends Usuario {
	private String restricaoAlimentar;

	public Cliente() {
		this.setAdm(false);
	}

	public Cliente(String nome, String cpf, String email, String telefone, String endereco, String senha,
			String restricaoAlimentar) {
		super(nome, cpf, email, telefone, endereco, senha);
		this.restricaoAlimentar = restricaoAlimentar;
		this.setAdm(false);

	}

	public String getRestricaoAlimentar() {
		return restricaoAlimentar;
	}

	public void setRestricaoAlimentar(String restricaoAlimentar) {
		this.restricaoAlimentar = restricaoAlimentar;
	}

}
