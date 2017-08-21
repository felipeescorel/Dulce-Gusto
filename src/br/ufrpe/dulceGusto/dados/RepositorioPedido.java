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

import br.ufrpe.dulceGusto.classesbasicas.Cliente;
import br.ufrpe.dulceGusto.classesbasicas.Pedido;
import br.ufrpe.dulceGusto.classesbasicas.Produto;
import br.ufrpe.dulceGusto.exceptions.DadosException;
import br.ufrpe.dulceGusto.exceptions.ItemException;

public class RepositorioPedido implements IRepositorioPedido, Serializable {

	private static RepositorioPedido instancia;
	private ArrayList<Pedido> pedido = new ArrayList<Pedido>();

	public static RepositorioPedido getInstancia() {
		if (instancia == null) {
			instancia = lerDoArquivo();
		}
		return instancia;
	}

	private static RepositorioPedido lerDoArquivo() {
		RepositorioPedido instanciaLocal = null;

		File in = new File("Pedidos.db");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioPedido) o;
		} catch (Exception e) {
			instanciaLocal = new RepositorioPedido();
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

	private RepositorioPedido() {

	}

	@Override
	public void cadastrarPedido(Pedido ped) {
		this.pedido.add(ped);
		RepositorioPedido.gravarArquivo();

	}

	@Override
	public Pedido buscarPedido(String numeroPedido) throws ItemException {
		Pedido retorno = null;
		int indice = this.obterIndice(numeroPedido);
		if (indice != -1) {
			retorno = this.pedido.get(indice);
		} else {
			ItemException produtoExc = new ItemException(numeroPedido);
			throw produtoExc;
		}
		return retorno;
	}

	@Override
	public void novoProduto(Produto produto, Pedido pedido) throws ItemException {
		pedido.novoProduto(produto);

	}

	private int obterIndice(String numeroPedido) {
		int indice = -1;
		for (int i = 0; i < pedido.size(); i++) {
			if (numeroPedido.equals(this.pedido.get(i).getNumeroPedido())) {
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
	public void removerPedido(String numeroPedido) throws ItemException {
		int indice = this.obterIndice(numeroPedido);
		if (indice != -1) {
			this.pedido.remove(numeroPedido);
			RepositorioPedido.gravarArquivo();
		} else {
			ItemException itemExc = new ItemException(numeroPedido);
			throw itemExc;
		}
	}

	@Override
	public void alterarPedido(Pedido pedido) throws ItemException {
		int indice = this.obterIndice(pedido.getNumeroPedido());
		if (indice != -1) {
			this.pedido.set(indice, pedido);
			RepositorioPedido.gravarArquivo();
		} else {
			ItemException itemExc = new ItemException(pedido.getNumeroPedido());
			throw itemExc;
		}
	}

	@Override
	public List<Pedido> listarPedido() {
		return this.pedido;
	}

	@Override
	public List<Pedido> buscarPedido(Cliente cliente) throws DadosException {
		if (cliente == null || cliente.getPedidos() == null) {
			DadosException dadosExc = new DadosException();
			throw dadosExc;
		}
		return cliente.getPedidos();
	}
}
