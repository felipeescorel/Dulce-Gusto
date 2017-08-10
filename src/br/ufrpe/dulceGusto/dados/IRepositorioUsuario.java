package br.ufrpe.dulceGusto.dados;

import java.util.List;

import br.ufrpe.dulceGusto.classesbasicas.*;
import br.ufrpe.dulceGusto.exceptions.DadosException;
import br.ufrpe.dulceGusto.exceptions.ItemException;

public interface IRepositorioUsuario {
	
	void cadastrarUsuario(Usuario user);
	Usuario buscarUsuario(String cpf) throws ItemException;
	void alterarUsuario(Usuario usuario) throws DadosException;
	List<Usuario> mostrarUsuarios();
	boolean autenticarLogin(String senha, String cpf) throws ItemException;
	void removerUsuario(String cpf) throws ItemException;
	boolean existe(String cpf);
}
