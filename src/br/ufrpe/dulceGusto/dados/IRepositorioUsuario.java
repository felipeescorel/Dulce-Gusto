package br.ufrpe.dulceGusto.dados;

import java.util.List;

import br.ufrpe.dulceGusto.classesbasicas.*;
import br.ufrpe.dulceGusto.exceptions.DadosException;

public interface IRepositorioUsuario {

	void cadastrarUsuario(Usuario user);

	Usuario buscaPorCpf(String cpf);

	void alterarUsuario(Usuario usuario) throws DadosException;

	List<Usuario> mostrarUsuarios();

	boolean autenticarLogin(String senha, String cpf);

	void remover(String cpf);

	boolean existe(String cpf);

}
