package br.ufrpe.dulceGusto.negócio;



public class ControleDeLogin {

	private CadastroUsuario cadastroUser;
	private static ControleDeLogin instancia;

	public static ControleDeLogin getInstancia() {
		if (instancia == null) {
			instancia = new ControleDeLogin();
		}
		return instancia;
	}

	private ControleDeLogin() {
		
		this.cadastroUser = CadastroUsuario.getInstancia();

	}
	public boolean autenticarLogin(String senha, String cpf) {
		return this.cadastroUser.autenticarLogin(senha, cpf);
	}

}
