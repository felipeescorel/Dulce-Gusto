package br.ufrpe.dulceGusto.neg�cio;

public interface IControleDeLogin {

	boolean autenticarLoginCliente(String senha, String cpf);

	boolean autenticarLoginAdm(String senha, String cpf);

	void atribuirAdm(CadastroAdministrador cadastroAdm);

	void atribuirCliente(CadastroClientes cadastroCliente);

}
