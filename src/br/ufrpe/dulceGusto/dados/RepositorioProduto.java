package br.ufrpe.dulceGusto.dados;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.dulceGusto.classesbasicas.Produto;

public class RepositorioProduto implements IRepositorioProduto {
	
	
	private RepositorioProduto(){
		
	}
	
	private List<Produto> produt = new ArrayList<Produto>();
	
	public void adicionarProduto(Produto produt){
		
		this.produt.add(produt);
	}
	
	public Produto buscarProduto(String nome){
		Produto retorno = null;
		int indice = this.obterIndice(nome);
		if(indice!=-1){
			retorno = this.produt.get(indice);
		}
		return retorno;
	}

	private int obterIndice(String nome) {
		int indice = -1;
		for(int i=0;i<produt.size();i++){
			if(this.produt.get(i).equals(nome)){
				indice = i;
			}
		}
		return indice;
	
	}
	
	public boolean existe(String nome){
		boolean existe = false;
		int indice=this.obterIndice(nome);
		if(indice!=-1){
			existe = true;
		}
		return existe;
	}
	
	public void removerProduto(String nome){
		
		int indice = this.obterIndice(nome);
		if(indice!=-1){
			this.produt.remove(nome);
		}
	}
	
	public void alterarProduto(Produto produt){
		
		
		int indice = this.obterIndice(produt.getNome());
		
		if(indice!=-1){
			this.produt.set(indice, produt);
		}
	}
	
	public void listarProdutos(){
		for(Produto produt : produt){
			System.out.println(produt);
		}
	}

	

}
