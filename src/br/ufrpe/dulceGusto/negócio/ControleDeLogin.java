package br.ufrpe.dulceGusto.neg�cio;

public class ControleDeLogin {

	private ControladorUsuario cadastroUser;
	private static ControleDeLogin instancia;

	public static ControleDeLogin getInstancia() {
		if (instancia == null) {
			instancia = new ControleDeLogin();
		}
		return instancia;
	}

	private ControleDeLogin() {

		this.cadastroUser = ControladorUsuario.getInstancia();

	}

	public boolean autenticarLogin(String senha, String cpf) {
		return this.cadastroUser.autenticarLogin(senha, cpf);
	}

}
