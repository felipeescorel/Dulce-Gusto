package br.ufrpe.dulceGusto.negócio;

import java.util.List;

import br.ufrpe.dulceGusto.classesbasicas.Pedido;

public interface ICadastroPedido {

	void cadastrarPedido(Pedido pedido);
	Pedido buscarPedido(int numeroPedido);
	void removerPedido(Pedido pedido);
	void alterarPedido(Pedido pedido);
	List<Pedido> mostrarPedido();
	CadastroPedido getInstancia();
}
