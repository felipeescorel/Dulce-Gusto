package br.ufrpe.dulceGusto.dados;

import java.util.List;

import br.ufrpe.dulceGusto.classesbasicas.Pedido;
import br.ufrpe.dulceGusto.classesbasicas.Produto;

public interface IRepositorioPedido {

	void cadastrarPedido(Pedido ped);

	Pedido buscarPedido(String numeroPedido);

	boolean existe(String numeroPedido);

	void removerPedido(String numeroPedido);

	List<Pedido> listarPedido();

	void alterarPedido(Pedido pedido);

	void novoProduto(Produto produto);
}
