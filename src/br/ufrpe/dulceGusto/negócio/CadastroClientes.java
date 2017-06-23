package br.ufrpe.dulceGusto.negócio;

import java.util.List;

import br.ufrpe.dulceGusto.classesbasicas.Cliente;
import br.ufrpe.dulceGusto.dados.IRepositorioCliente;
import br.ufrpe.dulceGusto.dados.RepositorioCliente;

public class CadastroClientes {

	private static CadastroClientes instancia;
	private IRepositorioCliente repositorio;

	private CadastroClientes() {
		this.repositorio = RepositorioCliente.getInstancia();
	}

	public void cadastrarCliente(Cliente client) {
		if (client != null) {
			boolean existe = this.repositorio.existe(client.getCpf());
			if (existe != true)
				this.repositorio.cadastrarCliente(client);
		} else {
			System.out.println("Cliente invalido " + client);
			return;
			// Não precisa botar isso, a gente vai resolver com excessão depois.
		}
	}

	public Cliente buscarCliente(String cpf) {
		Cliente retorno = null;
		if (cpf != null) {
			retorno = this.repositorio.buscarCliente(cpf);
		}
		return retorno;
	}

	public void removerCliente(Cliente client) {
		if (client != null) {
			if (this.repositorio.existe(client.getCpf()) != false) {
				this.repositorio.removerCliente(client.getNome());
			}
		}
	}

	public void alterarCliente(Cliente client) {
		if (client == null) {
			System.out.println("Cliente invalido!");
			return;
			// Não precisa blablabla exceção
		}
		if (client != null) {
			if (this.repositorio.existe(client.getCpf())) {
				this.repositorio.alterarCliente(client);
			}
		}

	}

	public List<Cliente> listarClientes() {
		return this.repositorio.listarClientes();
	}

	public static CadastroClientes getInstancia() {
		if (instancia == null) {
			instancia = new CadastroClientes();

		}
		return instancia;
	}

	public boolean autenticarLogin(String senha, String cpf) {
		boolean retorno = false;
		if (cpf != null && senha != null) {
			if (this.repositorio.existe(cpf)) {
				retorno = this.repositorio.autenticarLogin(senha, cpf);
			}
		}
		return retorno;

	}
}
