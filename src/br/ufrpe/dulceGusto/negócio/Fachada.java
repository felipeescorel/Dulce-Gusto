package br.ufrpe.dulceGusto.negócio;

import br.ufrpe.dulceGusto.classesbasicas.Administrador;
import br.ufrpe.dulceGusto.classesbasicas.Produto;

public class Fachada implements IFachada {
	
	private ICadastroAdministrador cadastroAdministrador;
	private ICadastroProduto cadastroProduto;
	//TODO Resto das interfaces
	private static Fachada instancia;
	
	private Fachada(){
		this.cadastroAdministrador = new CadastroAdministrador();
		this.cadastroProduto = new CadastroProduto();
		
		//TODO inicializar o resto das coisas
	}
	public static Fachada getInstancia(){
		if(instancia == null){
			instancia = new Fachada();
		}
		return instancia;
		
	}
	
	
	//TODO Apenas administrador deve poder executar
	public void cadastrarCliente(Administrador adm){
		this.cadastroAdministrador.cadastrarAdministrador(adm);
	}
	//TODO Apenas administrador deve poder executar
	public Administrador buscarAdministrador(String cpf){
		return this.cadastroAdministrador.buscarAdministrador(cpf);
	}
	//TODO Apenas administrador deve poder executar
	public void removerAdministrador(Administrador adm){
		this.removerAdministrador(adm);
	}
	//TODO Apenas administrador deve poder executar
	public void alterarAdministrador(Administrador adm){
		this.cadastroAdministrador.alterarAdministrador(adm);
	}
	//TODO implementar método que possa se chamado por cliente mas apenas informe as informações básicas
	public void exibirAdministradores(){
		this.cadastroAdministrador.mostrarAdms();
	}
	//TODO Apenas administrador deve poder executar
	public void adicionarProduto(Produto produt){
		this.cadastroProduto.adicionarProduto(produt);
	}
	public Produto buscarProduto(String nome){
		return this.cadastroProduto.buscarProduto(nome);
	}
	//TODO Apenas administrador deve poder executar
	public void removerProduto(Produto produt){
		this.cadastroProduto.removerProduto(produt);
	}
	//TODO Apenas administrador deve poder executar
	public void alterarProduto(Produto produt){
		this.cadastroProduto.alterarProduto(produt);
	}
	public void listarProdutos(){
		this.cadastroProduto.listarProdutos();
	}
	
	//TODO Terminar As Atribuições 
	
}
