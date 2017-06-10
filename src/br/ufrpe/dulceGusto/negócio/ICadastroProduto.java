package br.ufrpe.dulceGusto.negócio;

import br.ufrpe.dulceGusto.classesbasicas.Produto;

public interface ICadastroProduto {
	
	void adicionarProduto(Produto produt);
	Produto buscarProduto(String nome);
	void removerProduto(Produto produt);
	void alterarProduto(Produto produt);
	public void listarProdutos();
	
}
