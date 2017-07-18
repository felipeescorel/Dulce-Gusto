package br.ufrpe.dulceGusto.dados;

import java.util.List;

import br.ufrpe.dulceGusto.classesbasicas.*;

public interface IRepositorioUsuario {
	
	void cadastrarUsuario(Usuario user);
	Usuario buscarUsuario(String cpf);
	void alterarUsuario(Usuario usuario);
	List<Usuario> mostrarUsuarios();
	boolean autenticarLogin(String senha, String cpf);
	void removerUsuario(String cpf);
	boolean existe(String cpf);
}
