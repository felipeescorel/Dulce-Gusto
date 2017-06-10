package br.ufrpe.dulceGusto.negócio;

import br.ufrpe.dulceGusto.dados.*;
import br.ufrpe.dulceGusto.classesbasicas.Produto;

public class CadastroProduto implements ICadastroProduto{
	
	private IRepositorioProduto repositorio;
	
	public void adicionarProduto(Produto produt){
		this.repositorio.adicionarProduto(produt);
		
		if (produt == null) {
			System.out.println("Produto invalido " + produt);
			return;
		}
	}
	public Produto buscarProduto (String nome){
		return this.repositorio.buscarProduto(nome);
		
		
	}
	public void removerProduto (Produto produt){
		this.repositorio.removerProduto(produt.getNome());
	}
	public void alterarProduto(Produto produt){
		
		if (produt == null) {
			System.out.println("Produto invalido!");
			return;
		}
		
		
		this.repositorio.alterarProduto(produt);
	}
	public void listarProdutos(){
		this.repositorio.listarProdutos();
	}
	

}
