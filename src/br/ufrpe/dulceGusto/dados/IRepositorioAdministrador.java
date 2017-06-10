package br.ufrpe.dulceGusto.dados;

import br.ufrpe.dulceGusto.classesbasicas.Administrador;

public interface IRepositorioAdministrador {

	void cadastrarAdministrador(Administrador adm);
	Administrador buscarAdministrador(String cpf);
	void removerAdministrador(String cpf);
	void alterarAdministrador(Administrador adm);
	boolean existe(String cpf);
	void mostrarAdms();
	RepositorioAdministrador getInstancia();
}
