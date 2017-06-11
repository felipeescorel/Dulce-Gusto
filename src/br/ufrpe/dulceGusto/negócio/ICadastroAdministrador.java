package br.ufrpe.dulceGusto.negócio;

import java.util.List;

import br.ufrpe.dulceGusto.classesbasicas.Administrador;

public interface ICadastroAdministrador {

	void cadastrarAdministrador(Administrador adm);
	Administrador buscarAdministrador(String cpf);
	void removerAdministrador(Administrador adm);
	void alterarAdministrador(Administrador adm);
	public List<Administrador> mostrarAdms();
}
