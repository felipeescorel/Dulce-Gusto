package br.ufrpe.dulceGusto.negócio;

import java.util.List;

import br.ufrpe.dulceGusto.classesbasicas.Pedido;
import br.ufrpe.dulceGusto.classesbasicas.Produto;
import br.ufrpe.dulceGusto.dados.IRepositorioPedido;
import br.ufrpe.dulceGusto.dados.RepositorioPedido;
import br.ufrpe.dulceGusto.exceptions.ItemException;

public class ControladorPedido {

	private static ControladorPedido instancia;
	private IRepositorioPedido repositorio;

	private ControladorPedido() {
		this.repositorio = RepositorioPedido.getInstancia();
	}

	public void cadastrarPedido(Pedido pedido) {
		if (pedido != null) {
			boolean existe = this.repositorio.existe(pedido.getNumeroPedido());
			if (existe != true)
				this.repositorio.cadastrarPedido(pedido);
		}
	}

	public void novoProduto(Produto produto, Pedido pedido) {
		try{
			if (produto != null && 
				pedido!=null&& 
				repositorio.existe(pedido.getNumeroPedido()) && 
					!pedido.getProduto().contains(produto)){
			
				this.repositorio.novoProduto(produto,pedido);
			
				
			}
		}catch (ItemException e) {
			// TODO Tratar
			e.printStackTrace();
		}				
		
	}

	public Pedido buscarPedido(String numeroPedido) {
		Pedido retorno = null;
		if (numeroPedido != null) {
			try {
				retorno = this.repositorio.buscarPedido(numeroPedido);
			} catch (ItemException e) {
				//TODO TRATAR
				e.printStackTrace();
			}
		}
		return retorno;
	}

	public void removerPedido(Pedido pedido) {
		if (pedido != null) {
			if (this.repositorio.existe(pedido.getNumeroPedido()))
				try {
					this.repositorio.removerPedido(pedido.getNumeroPedido());
				} catch (ItemException e) {
					// TODO TRATAR
					e.printStackTrace();
				}
		}

	}

	public void alterarPedido(Pedido pedido) {
		if (pedido != null) {
			if (this.repositorio.existe(pedido.getNumeroPedido()))
				try {
					this.repositorio.alterarPedido(pedido);
				} catch (ItemException e) {
					// TODO TRATAR
					e.printStackTrace();
				}
		}
	}

	public List<Pedido> mostrarPedido() {
		return this.repositorio.listarPedido();
	}

	public static ControladorPedido getInstancia() {
		if (instancia == null) {
			instancia = new ControladorPedido();
		}
		return instancia;
	}
}
