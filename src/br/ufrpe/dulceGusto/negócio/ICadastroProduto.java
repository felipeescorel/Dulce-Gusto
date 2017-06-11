package br.ufrpe.dulceGusto.negócio;

import java.util.List;

import br.ufrpe.dulceGusto.classesbasicas.Produto;

public interface ICadastroProduto {
	
	void adicionarProduto(Produto produt);
	Produto buscarProduto(String nome);
	void removerProduto(Produto produt);
	void alterarProduto(Produto produt);
	List<Produto> listarProdutos();
	
}
