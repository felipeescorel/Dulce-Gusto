package br.ufrpe.dulceGusto.dados;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.dulceGusto.classesbasicas.Cliente;

public class RepositorioCliente implements IRepositorioCliente {

	private ArrayList<Cliente> cliente = new ArrayList<Cliente>();
	private Cliente clt;

	private static RepositorioCliente instancia;

	public static RepositorioCliente getInstancia() {
		if (instancia == null) {
			instancia = new RepositorioCliente();
		}
		return instancia;
	}

	private RepositorioCliente() {

	}

	@Override
	public void cadastrarCliente(Cliente cliente) {
		this.cliente.add(cliente);
	}

	private int obterIndice(String cpf) {
		int indice = -1;
		for (int i = 0; i < this.cliente.size(); i++) {
			if (this.cliente.get(i).getCpf().equals(cpf)) {
				indice = i;
			}
		}
		return indice;
	}

	@Override
	public Cliente buscarCliente(String cpf) {
		Cliente retorno = null;
		int indice = this.obterIndice(cpf);
		if (indice != -1) {
			retorno = this.cliente.get(indice);
		}
		return retorno;
	}

	@Override
	public void removerCliente(String cpf) {
		int indice = this.obterIndice(cpf);
		if (indice != -1) {
			this.cliente.remove(indice);
		}
	}

	@Override
	public void alterarCliente(Cliente cliente) {
		int indice = this.obterIndice(cliente.getCpf());
		if (indice != -1) {
			this.cliente.set(indice, cliente);
		}
	}

	@Override
	public boolean existe(String cpf) {
		boolean existe = false;
		int indice = this.obterIndice(cpf);
		if (indice != -1) {
			existe = true;
		}
		return existe;
	}

	@Override
	public List<Cliente> listarClientes() {
		return this.cliente;
	}

	@Override
	public boolean autenticarLogin(String senha, String cpf) {
		boolean retorno = false;
		this.clt = this.buscarCliente(cpf);
		boolean tipo = this.clt.getAdm();
		if (this.clt.getSenha().equals(senha) && tipo != true) {
			retorno = true;
		}
		return retorno;
	}
}
