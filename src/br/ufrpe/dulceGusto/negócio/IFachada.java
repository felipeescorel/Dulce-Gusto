package br.ufrpe.dulceGusto.negócio;
import br.ufrpe.dulceGusto.classesbasicas.Administrador;
import br.ufrpe.dulceGusto.classesbasicas.Produto;


public interface IFachada {

		//ADMINISTRADOR
		void cadastrarCliente(Administrador adm);
		Administrador buscarAdministrador(String cpf);
		void removerAdministrador(Administrador adm);
		void alterarAdministrador(Administrador adm);
		void exibirAdministradores();
		
		
		//PRODUTO
		void adicionarProduto(Produto produt);
		Produto buscarProduto(String nome);
		void removerProduto(Produto produt);
		void alterarProduto(Produto produt);
		void listarProdutos();
		
		
		//TODO Cliente
		//TODO Pedido
}
