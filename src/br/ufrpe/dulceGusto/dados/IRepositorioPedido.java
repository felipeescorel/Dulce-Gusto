package br.ufrpe.dulceGusto.dados;

import java.util.List;

import br.ufrpe.dulceGusto.classesbasicas.Cliente;
import br.ufrpe.dulceGusto.classesbasicas.Pedido;
import br.ufrpe.dulceGusto.classesbasicas.Produto;
import br.ufrpe.dulceGusto.exceptions.DadosException;
import br.ufrpe.dulceGusto.exceptions.ItemException;

public interface IRepositorioPedido {

	void cadastrarPedido(Pedido ped);

	Pedido buscarPedido(String numeroPedido) throws ItemException;

	boolean existe(String numeroPedido);

	void removerPedido(String numeroPedido) throws ItemException;

	List<Pedido> listarPedido();

	void alterarPedido(Pedido pedido) throws ItemException;

	void novoProduto(Produto produto, Pedido pedido) throws ItemException;

	List<Pedido> buscarPedido(Cliente cliente) throws DadosException;
}
