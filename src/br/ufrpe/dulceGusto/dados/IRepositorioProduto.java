package br.ufrpe.dulceGusto.dados;

import java.util.List;

import br.ufrpe.dulceGusto.classesbasicas.Produto;
import br.ufrpe.dulceGusto.exceptions.ItemException;

public interface IRepositorioProduto {

	void adicionarProduto(Produto produt);

	Produto buscarProduto(String nome) throws ItemException;

	void removerProduto(String nome) throws ItemException;

	void alterarProduto(Produto produt) throws ItemException;

	boolean existe(String nome);

	List<Produto> listarProdutos();

}
