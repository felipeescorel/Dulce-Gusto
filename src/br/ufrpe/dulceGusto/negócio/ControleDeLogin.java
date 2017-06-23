package br.ufrpe.dulceGusto.negócio;

import br.ufrpe.dulceGusto.classesbasicas.Administrador;
import br.ufrpe.dulceGusto.classesbasicas.Cliente;

public class ControleDeLogin {

	private CadastroClientes cadastroCliente;
	private CadastroAdministrador cadastroAdm;
	private static ControleDeLogin instancia;

	public static ControleDeLogin getInstancia() {
		if (instancia == null) {
			instancia = new ControleDeLogin();
		}
		return instancia;
	}

	private ControleDeLogin() {
		this.cadastroCliente = CadastroClientes.getInstancia();
		this.cadastroAdm = CadastroAdministrador.getInstancia();

	}

	// Cliente

	public void atribuirCliente(CadastroClientes cadastroCliente) {
		this.cadastroCliente = cadastroCliente;
	}

	public boolean autenticarLoginCliente(String senha, String cpf) {
		return this.cadastroCliente.autenticarLogin(senha, cpf);
	}

	// ADM

	public void atribuirAdm(CadastroAdministrador cadastroAdm) {
		this.cadastroAdm = cadastroAdm;
	}

	public boolean autenticarLoginAdm(String senha, String cpf) {
		return this.cadastroAdm.autenticarLogin(senha, cpf);
	}

}
