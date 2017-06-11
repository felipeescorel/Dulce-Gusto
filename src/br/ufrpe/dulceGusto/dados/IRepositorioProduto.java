package br.ufrpe.dulceGusto.dados;
import java.util.List;

import br.ufrpe.dulceGusto.classesbasicas.Produto;

public interface IRepositorioProduto {
	
	void adicionarProduto (Produto produt);
	Produto buscarProduto (String nome);
	void removerProduto(String nome);
	void alterarProduto(Produto produt);
	boolean existe(String nome);
	List<Produto> listarProdutos();
	RepositorioProduto getInstancia();

}
