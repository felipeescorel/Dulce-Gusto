package br.ufrpe.dulceGusto.negócio;

import java.util.List;

import br.ufrpe.dulceGusto.classesbasicas.Produto;
import br.ufrpe.dulceGusto.dados.IRepositorioProduto;
import br.ufrpe.dulceGusto.dados.RepositorioProduto;

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
		return this.repositorio.buscarProduto(nome);
	}

	public void removerProduto(Produto produt) {
		this.repositorio.removerProduto(produt.getNome());
	}

	public void alterarProduto(Produto produt) {

		if (produt == null) {
			System.out.println("Produto invalido!");
			return;
		}
		this.repositorio.alterarProduto(produt);
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
