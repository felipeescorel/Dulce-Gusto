package br.ufrpe.dulceGusto.dados;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.dulceGusto.classesbasicas.Pedido;
import br.ufrpe.dulceGusto.classesbasicas.Produto;

public class RepositorioPedido implements IRepositorioPedido {

	private static RepositorioPedido instancia;
	private ArrayList<Pedido> pedido = new ArrayList<Pedido>();
	private ArrayList<Produto> produto = new ArrayList<Produto>();

	public static RepositorioPedido getInstancia() {
		if (instancia == null) {
			instancia = new RepositorioPedido();
		}
		return instancia;
	}

	private RepositorioPedido() {

	}

	@Override
	public void cadastrarPedido(Pedido ped) {
		this.pedido.add(ped);
	}

	@Override
	public Pedido buscarPedido(String numeroPedido) {
		Pedido retorno = null;
		int indice = this.obterIndice(numeroPedido);
		if (indice != -1) {
			retorno = this.pedido.get(indice);
		}
		return retorno;
	}

	@Override
	public void novoProduto(Produto produto) {
		for (int i = 0; i < pedido.size(); i++) {
			boolean verf = this.pedido.get(i).equals(produto);
			if (verf = !false) {
				this.pedido.get(i).novoProduto(produto);
				return;
			}
		}
	}

	private int obterIndice(String numeroPedido) {
		int indice = -1;
		for (int i = 0; i < pedido.size(); i++) {
			if (this.pedido.get(i).getNumeroPedido().equals(numeroPedido)) {
				indice = i;
			}
		}
		return indice;
	}

	@Override
	public boolean existe(String numeroPedido) {
		boolean existe = false;
		int indice = this.obterIndice(numeroPedido);
		if (indice != -1) {
			existe = true;
		}
		return existe;
	}

	@Override
	public void removerPedido(String numeroPedido) {
		int indice = this.obterIndice(numeroPedido);
		if (indice != -1) {
			this.pedido.remove(numeroPedido);
		}
	}

	@Override
	public void alterarPedido(Pedido pedido) {
		int indice = this.obterIndice(pedido.getNumeroPedido());
		if (indice != -1) {
			this.pedido.set(indice, pedido);
		}
	}

	@Override
	public List<Pedido> listarPedido() {
		return this.pedido;
	}
}
