package br.ufrpe.dulceGusto.negócio;

import br.ufrpe.dulceGusto.dados.IRepositorioProduto;
import br.ufrpe.dulceGusto.dados.RepositorioProduto;

import java.util.List;
import br.ufrpe.dulceGusto.classesbasicas.Produto;

public class CadastroProduto implements ICadastroProduto{
	
	private IRepositorioProduto repositorio = RepositorioProduto.getInstancia();
	private static CadastroProduto instancia;
	private CadastroProduto(){
		RepositorioProduto.getInstancia();
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
	
	public static CadastroProduto getInstancia(){
		if(instancia == null){
			instancia = new CadastroProduto();
		}
		return instancia;
	}

}
