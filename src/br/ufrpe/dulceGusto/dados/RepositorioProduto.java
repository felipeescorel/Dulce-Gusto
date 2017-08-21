package br.ufrpe.dulceGusto.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.dulceGusto.classesbasicas.Produto;
import br.ufrpe.dulceGusto.exceptions.ItemException;

public class RepositorioProduto implements IRepositorioProduto, Serializable {

	private RepositorioProduto() {

	}

	private static RepositorioProduto instancia;

	private ArrayList<Produto> produt = new ArrayList<Produto>();

	public static RepositorioProduto getInstancia() {
		if (instancia == null) {
			instancia = lerDoArquivo();
		}
		return instancia;
	}

	private static RepositorioProduto lerDoArquivo() {
		RepositorioProduto instanciaLocal = null;

		File in = new File("Produtos.db");
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioProduto) o;
		} catch (Exception e) {
			instanciaLocal = new RepositorioProduto();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
				}
			}
		}
		return instanciaLocal;
	}

	private static void gravarArquivo() {
		if (instancia == null) {
			return;
		}
		File out = new File("Pedidos.db");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream(out);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(instancia);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
				}
			}
		}
	}

	@Override
	public void adicionarProduto(Produto produt) {
		this.produt.add(produt);
		RepositorioProduto.gravarArquivo();
	}

	public Produto buscarProduto(String nome) throws ItemException {
		Produto retorno = null;
		int indice = this.obterIndice(nome);
		if (indice != -1) {
			retorno = this.produt.get(indice);
		} else {
			ItemException produtoExc = new ItemException(nome);
			throw produtoExc;
		}
		return retorno;
	}

	private int obterIndice(String nome) {
		int indice = -1;
		for (int i = 0; i < produt.size(); i++) {
			if (nome.equals(this.produt.get(i).getNome())) {
				indice = i;
			}
		}
		return indice;
	}

	@Override
	public boolean existe(String nome) {
		boolean existe = false;
		int indice = this.obterIndice(nome);
		if (indice != -1) {
			existe = true;
		}
		return existe;
	}

	@Override
	public void removerProduto(String nome) throws ItemException {
		int indice = this.obterIndice(nome);
		if (indice != -1) {
			this.produt.remove(nome);
			RepositorioProduto.gravarArquivo();
		} else {
			ItemException itemExc = new ItemException(nome);
			throw itemExc;
		}
	}

	@Override
	public void alterarProduto(Produto produt) throws ItemException {
		int indice = this.obterIndice(produt.getNome());
		if (indice != -1) {
			this.produt.set(indice, produt);
			RepositorioProduto.gravarArquivo();
		} else {
			ItemException itemExc = new ItemException(produt.getNome());
			throw itemExc;
		}
	}

	@Override
	public List<Produto> listarProdutos() {
		return this.produt;
	}

}
