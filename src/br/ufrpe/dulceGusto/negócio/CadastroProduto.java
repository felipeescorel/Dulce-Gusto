package br.ufrpe.dulceGusto.neg�cio;

import br.ufrpe.dulceGusto.dados.*;

import java.util.List;

import br.ufrpe.dulceGusto.classesbasicas.Produto;

public class CadastroProduto implements ICadastroProduto{
	
	private IRepositorioProduto repositorio;
	
	public CadastroProduto(){
		repositorio.getInstancia();
	}
	
	@Override	
	public void adicionarProduto(Produto produt){
		this.repositorio.adicionarProduto(produt);		
		if (produt == null) {
			System.out.println("Produto invalido " + produt);
			return;
		}
	}
	@Override
	public Produto buscarProduto (String nome){
		return this.repositorio.buscarProduto(nome);		
	}
	@Override
	public void removerProduto (Produto produt){
		this.repositorio.removerProduto(produt.getNome());
	}
	@Override
	public void alterarProduto(Produto produt){
		
		if (produt == null) {
			System.out.println("Produto invalido!");
			return;
		}		
		this.repositorio.alterarProduto(produt);
	}
	@Override
	public List<Produto> listarProdutos(){
		return this.repositorio.listarProdutos();
	}
	

}
