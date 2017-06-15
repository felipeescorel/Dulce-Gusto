package br.ufrpe.dulceGusto.dados;

import java.util.List;

import br.ufrpe.dulceGusto.classesbasicas.Pedido;

public interface IRepositorioPedido {

	void cadastrarPedido(Pedido ped);
	Pedido buscarPedido(int numeroPedido);
	boolean existe(int numeroPedido);
	void removerPedido(int numeroPedido);
	List<Pedido> listarPedido();
	void alterarPedido(Pedido pedido);
	



}
