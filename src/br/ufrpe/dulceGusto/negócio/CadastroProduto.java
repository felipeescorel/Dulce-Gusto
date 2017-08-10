package br.ufrpe.dulceGusto.negócio;

import java.util.List;

import br.ufrpe.dulceGusto.classesbasicas.Produto;
import br.ufrpe.dulceGusto.dados.IRepositorioProduto;
import br.ufrpe.dulceGusto.dados.RepositorioProduto;
import br.ufrpe.dulceGusto.exceptions.ItemException;

public class CadastroProduto {

	private IRepositorioProduto repositorio;
	private static CadastroProduto instancia;

	private CadastroProduto() {
		this.repositorio = RepositorioProduto.getInstancia();
	}

	public void adicionarProduto(Produto produt) {
		this.repositorio.adicionarProduto(produt);
		if (produt == null) {
			System.out.println("Produto invalido " + produt);
			return;
		}
	}

	public Produto buscarProduto(String nome) {
		Produto produto = null;
		try {
			produto =  this.repositorio.buscarProduto(nome);
		} catch (ItemException e) {
			// TODO tratar
			e.printStackTrace();
		}
		
		return produto;
	}

	public void removerProduto(Produto produt) {
		try {
			this.repositorio.removerProduto(produt.getNome());
		} catch (ItemException e) {
			// TODO tratar
			e.printStackTrace();
		}
	}

	public void alterarProduto(Produto produt) {

		if (produt == null) {
			System.out.println("Produto invalido!");
			return;
		}
		try {
			this.repositorio.alterarProduto(produt);
		} catch (ItemException e) {
			// TODO tratar
			e.printStackTrace();
		}
	}

	public List<Produto> listarProdutos() {
		return this.repositorio.listarProdutos();
	}

	public static CadastroProduto getInstancia() {
		if (instancia == null) {
			instancia = new CadastroProduto();
		}
		return instancia;
	}

}
