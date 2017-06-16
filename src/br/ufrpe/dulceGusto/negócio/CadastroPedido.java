package br.ufrpe.dulceGusto.negócio;

import java.util.List;
import br.ufrpe.dulceGusto.classesbasicas.Pedido;
import br.ufrpe.dulceGusto.classesbasicas.Produto;
import br.ufrpe.dulceGusto.dados.IRepositorioPedido;
import br.ufrpe.dulceGusto.dados.RepositorioPedido;

public class CadastroPedido implements ICadastroPedido {

	private static CadastroPedido instancia;
	private IRepositorioPedido repositorio = RepositorioPedido.getInstancia();

	private CadastroPedido() {
		RepositorioPedido.getInstancia();
	}

	@Override
	public void cadastrarPedido(Pedido pedido) {
		if (pedido != null) {
			boolean existe = this.repositorio.existe(pedido.getNumeroPedido());
			if (existe != true)
				this.repositorio.cadastrarPedido(pedido);
		}
	}
	@Override
	public void novoProduto(Produto produto){
		if(produto!=null){
			this.repositorio.novoProduto(produto);
		}
	}
	@Override
	public Pedido buscarPedido(int numeroPedido) {
		Pedido retorno = null;
		if (numeroPedido != 0) {
			retorno = this.repositorio.buscarPedido(numeroPedido);
		}
		return retorno;
	}

	@Override
	public void removerPedido(Pedido pedido) {
		if (pedido != null) {
			if (this.repositorio.existe(pedido.getNumeroPedido()))
				this.repositorio.removerPedido(pedido.getNumeroPedido());
		}

	}

	@Override
	public void alterarPedido(Pedido pedido) {
		if (pedido != null) {
			if (this.repositorio.existe(pedido.getNumeroPedido()))
				this.repositorio.alterarPedido(pedido);
		}
	}

	@Override
	public List<Pedido> mostrarPedido() {
		return this.repositorio.listarPedido();
	}

	public static CadastroPedido getInstancia() {
		if (instancia == null) {
			instancia = new CadastroPedido();
		}
		return instancia;
	}
}
