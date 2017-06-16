package br.ufrpe.dulceGusto;

import java.sql.Date;
import java.util.Calendar;
import java.util.Scanner;

import br.ufrpe.dulceGusto.classesbasicas.Administrador;
import br.ufrpe.dulceGusto.classesbasicas.Cliente;
import br.ufrpe.dulceGusto.classesbasicas.Produto;
import br.ufrpe.dulceGusto.negócio.ControleDeLogin;
import br.ufrpe.dulceGusto.negócio.Fachada;
import br.ufrpe.dulceGusto.negócio.IControleDeLogin;
import br.ufrpe.dulceGusto.negócio.IFachada;
import br.ufrpe.dulceGusto.classesbasicas.Pedido;

public class Aplicacao {

	public static void main(String[] args) {
		IFachada fachada = Fachada.getInstancia();
		Administrador teste = new Administrador();
		teste.setCpf("cpfteste");
		teste.setSenha("senhateste");
		teste.setNome("Adm");
		fachada.cadastrarAdm(teste);
		Aplicacao.Login();

	}
	public static void MenuCompras(){
		Produto produto,produto2;
		
		IFachada fachada = Fachada.getInstancia();
		Scanner scan = new Scanner(System.in);
		int opcao;
		String nome = null;
		double soma = 0;
		Pedido pedido = null;
		boolean loop =true,loop2 = true;
		while(loop!=false){
			produto= (Produto) fachada.listarProdutos();
			System.out.println("Produtos disponiveis: " + produto);
			
			while(loop2!=false){
				System.out.println("Deseja acrescentar algo ao pedido? (1) SIM  (2) NÃO");
				opcao = scan.nextInt();
				switch (opcao) {
				case 1: {
					System.out.println("Digite o nome do produto : ");
					nome = scan.nextLine();
					
					produto2 =fachada.buscarProduto(nome);
					pedido.novoProduto(produto2);
					soma+=	produto2.getPreco();
					break;
				}
				case 2: {
					if(nome!=null){
						System.out.println("Valor total da compra :"+soma);
					}
					else{
						System.out.println("Encerrando aplicação.");
						loop2=false;
					}
					break;
				}
				default: {
					System.out.println("Opção inválida, tente novamente.");
		
					break;
				}
		
				}
			}
			fachada.cadastrarPedido(pedido);
		}
	}
	public static void Login(){
		boolean loop,retorno,retorno2;
		Scanner scan = new Scanner(System.in);
		String cpf, senha;
		IFachada fachada = Fachada.getInstancia();
		IControleDeLogin login = ControleDeLogin.getInstancia();
		loop = true;
		while (loop != false) {
			System.out.println("Tela de Login\nInforme seu cpf:");
			cpf = scan.nextLine();

			System.out.println("Informe sua senha:");
			senha = scan.nextLine();
			retorno = login.autenticarLoginAdm(senha, cpf);
			if (retorno != true) {
				retorno2 = login.autenticarLoginCliente(senha, cpf);
				if (retorno2 == false) {
					System.out.println("Login falhou.Tente Novamente.");
				} else {
					System.out.println("Cliente " + fachada.buscarCliente(cpf).getNome() + " logado com sucesso.");
					loop = false;
					Aplicacao.MenuCompras();
				}
			} else {
				System.out.println(
						"Administrador " + fachada.buscarAdministrador(cpf).getNome() + " logado com sucesso.");
					Aplicacao.MenuAdm();
				loop = false;
			}

		}
	}
	public static void MenuAdm(){
		
		Scanner scan = new Scanner(System.in);
		int opcao,opcao2;
		boolean loop = true,loop2=true,loop3=true,loop4 = true;
		while(loop!=false){		
			System.out.println("Menu Administrador\n(1) Cadastrar  (2)Remover (3)Alterar (4)Buscar (5)Sair");
			opcao = scan.nextInt();
			switch(opcao){
				case 1:{
					while(loop2!=false){
						System.out.println("Menu de Cadastro\nNOVO CLIENTE(1)	NOVO ADMINISTRADOR(2)	NOVO PRODUTO(3)	SAIR(4)	");
						opcao2 = scan.nextInt();
						switch(opcao2){
							case 1:{
								Aplicacao.novoCliente();
								System.out.println();
								break;
							}
							case 2:{
								Aplicacao.novoAdministrador();
								break;
							}
							case 3:{
								Aplicacao.novoProduto();
								break;
							}
							case 4:{
								System.out.println("Voltando ao menu principal.");
								loop2 = false;
								break;
							}
						}
					}
					break;
				}
				case 2:{
					Aplicacao.Remover();		
					break;
				}
				case 3:{
					Aplicacao.Alterar();
					break;
				}
				case 4:{
					Aplicacao.Buscar();
					break;
				}
				case 5:{
					loop = false;
					System.out.println("Encerrando a aplicação.");
					break;
				}
				default:{
					System.out.println("Opção inválida.Tente tovamente");
					break;
				}
			
			}
		}
	}
	public static void novoCliente() {
		String nome,cpf,telefone,endereco,email,senha;
		Scanner scan = new Scanner(System.in);
		Cliente cliente = new Cliente();
		IFachada fachada = Fachada.getInstancia();
		System.out.println("Informar nome do cliente");
		nome = scan.nextLine();
		
		cliente.setNome(nome);
		System.out.println("Informar cpf");
		cpf = scan.nextLine();
		
		cliente.setCpf(cpf);
		System.out.println("Informar senha");
		senha = scan.nextLine();
		
		cliente.setSenha(senha);
		System.out.println("Informar endereço");
		endereco = scan.nextLine();
		
		cliente.setEndereco(endereco);
		System.out.println("Informar telefone");
		telefone = scan.nextLine();
		
		cliente.setTelefone(telefone);
		System.out.println("Informar email");
		email = scan.nextLine();
		
		cliente.setEmail(email);
		
		fachada.adicionarCliente(cliente);
	}
	public static void novoAdministrador() {
		String nome,cpf,telefone,endereco,email,senha;
		Scanner scan = new Scanner(System.in);
		IFachada fachada = Fachada.getInstancia();
		Administrador administrador = new Administrador();
		System.out.println("Informar nome do Administrador");
		nome = scan.nextLine();
		
		administrador.setNome(nome);
		System.out.println("Informar cpf");
		cpf = scan.nextLine();
		
		administrador.setCpf(cpf);
		System.out.println("Informar endereço");
		endereco = scan.nextLine();
		
		administrador.setEndereco(endereco);
		System.out.println("Informar senha");
		senha = scan.nextLine();
		
		administrador.setSenha(senha);
		System.out.println("Informar telefone");
		telefone = scan.nextLine();
		
		administrador.setTelefone(telefone);
		System.out.println("Informar email");
		email = scan.nextLine();
		
		administrador.setEmail(email);
		fachada.cadastrarAdm(administrador);
	}
	public static void novoProduto() {
		Scanner scan = new Scanner(System.in);
		String nome,descricao,ingredientes;
		Produto produto = new Produto();
		IFachada fachada = Fachada.getInstancia();
		double preco;
		boolean loop = true;
		int opcao;
		System.out.println("Informar nome do Produto");
		nome = scan.nextLine();
		
		produto.setNome(nome);
		System.out.println("Informar preço");
		preco = scan.nextDouble();
		
		produto.setPreco(preco);
		System.out.println("Informar a descriçao");
		descricao = scan.nextLine();
		
		produto.setDescricao(descricao);
		System.out.println("Informar os ingredientes");
		ingredientes = scan.nextLine();
		
		produto.cadastrarIngrediente(ingredientes);
		while (loop != false) {
			System.out.println("Deseja informar outro ingrediente? SIM(1) Não(2)");
			opcao = scan.nextInt();
			scan.next();
			switch (opcao) {
			case 1: {
				System.out.println("Informar ingrediente");
				ingredientes = scan.nextLine();
				
				produto.cadastrarIngrediente(ingredientes);
				break;
			}
			case 2: {
				System.out.println("Todos ingredientes foram cadastrados.");
				loop = false;
				break;
			}
			default: {
				System.out.println("Opção inválida.Tente novamente.");
				break;
			}

			}
		}
		fachada.adicionarProduto(produto);

	}
	public static void Remover() {
		IFachada fachada = Fachada.getInstancia();
		Scanner scan = new Scanner(System.in);
		int opcao;
		String cpf,nome;
		int numeroPedido;
		boolean loop = true;
		
		while(loop!=false){
			System.out.println("REMOVER CLIENTE(1)	REMOVER ADMINISTRADOR(2)   REMOVER PRODUTO(3)	REMOVER PEDIDO(4)	SAIR(5)	");
			opcao = scan.nextInt();
			switch (opcao) {
				case 1: {
					System.out.println("Informe o cpf do cliente que deseja remover: ");
					cpf = scan.nextLine();
					
					fachada.removerCliente(fachada.buscarCliente(cpf));	
					break;
				}
				case 2: {
					System.out.println("Informe o cpf do administrador que deseja remover: ");
					cpf = scan.nextLine();
					
					fachada.removerAdministrador(fachada.buscarAdministrador(cpf));		
					break;
				}
				case 3: {
					System.out.println("Informe o nome do produto que deseja remover: ");
					nome = scan.nextLine();
					
					fachada.removerProduto(fachada.buscarProduto(nome));	
					break;
				}
				case 4: {
					System.out.println("Informe o numero do pedido que deseja remover: ");
					numeroPedido = scan.nextInt();
					fachada.removerPedido(fachada.buscarPedido(numeroPedido));
		
					break;	
				}
				case 5: {
					System.out.println("Voltando ao menu principal.");
					loop = false;		
					break;
				}
				default: {
					System.out.println("Opção inválida, tente novamente.");
		
					break;
		
				}
			}
		}
	}
	public static void Buscar() {
		IFachada fachada = Fachada.getInstancia();
		int opcao;
		String cpf,nome;
		int numeroPedido;
		Scanner scan = new Scanner(System.in);
		boolean loop = true;
		
		while(loop!=false){
			System.out.println("BUSCAR CLIENTE(1)	BUSCAR ADMINISTRADOR(2)   BUSCAR PRODUTO(3)	BUSCAR PEDIDO(4)	SAIR(5)	");
			opcao = scan.nextInt();
	
			switch (opcao) {
				case 1: {
					System.out.println("Informe o CPF do cliente que deseja encontrar: ");
					cpf = scan.nextLine();
					
					fachada.buscarCliente(cpf);
					//TODO implementar toStrings pra exibir na tela
					break;
				}
				case 2: {
					System.out.println("Informe o CPF do administrador que deseja encontrar: ");
					cpf = scan.nextLine();
					
					fachada.buscarAdministrador(cpf);
					//TODO implementar toStrings pra exibir na tela
					break;
				}
				case 3: {
					System.out.println("Informe o nome do produto que deseja encontrar: ");
					nome = scan.nextLine();
					
					fachada.buscarProduto(nome);
					//TODO implementar toStrings pra exibir na tela
					break;
				}
				case 4: {
					System.out.println("Informe o número do pedido que deseja encontrar: ");
					numeroPedido = scan.nextInt();
					fachada.buscarPedido(numeroPedido);
					//TODO implementar toStrings pra exibir na tela
					break;
				}
				case 5: {
					loop = false;
					System.out.println("Retornando ao menu principal.");
					break;
				}
				default:{
					System.out.println("Opção Inválida.Tente novamente.");
					break;
				}
	
			}
		}
		
	}
	public static void Alterar() {
		IFachada fachada = Fachada.getInstancia();
		int opcao,opcao2,opcao3,opcao4;
		Scanner scan = new Scanner(System.in);
		String cpf,email,telefone,endereco,nome,senha,descricao,ingredientes;
		Cliente cliente = new Cliente();
		Administrador administrador = new Administrador();
		Produto produto = new Produto();
		boolean loop = true,loop2 = true,loop3 = true,loop4=true;
		double preco;
		while(loop!=false){
			System.out.println("ALTERAR CLIENTE(1)	ALTERAR ADMINISTRADOR(2)   ALTERAR PRODUTO(3)	ALTERAR PEDIDO(4)	SAIR(5)	");
			opcao = scan.nextInt();
	
			switch (opcao) {
			case 1: {
				System.out.println("Informe o CPF do cliente que deseja alterar: ");
				cpf = scan.nextLine();
				
				cliente = fachada.buscarCliente(cpf);
				
				while(loop2!=false){
					System.out.println("O que você deseja alterar? NOME(1), EMAIL(2), TELEFONE(3), ENDEREÇO(4), CPF(5), SENHA(6) SAIR(7)");
					opcao2 = scan.nextInt();	
				
					switch (opcao2) {
						case 1: {
							System.out.println("Informe o novo nome: ");
							nome = scan.nextLine();
							
							cliente.setNome(nome);
							break;
						}
						case 2: {
							System.out.println("Informe o novo email: ");
							email = scan.nextLine();
							
							cliente.setEmail(email);
			
							break;
						}
						case 3: {
							System.out.println("Informe o novo telefone: ");
							telefone = scan.nextLine();
							
							cliente.setTelefone(telefone);
			
							break;
						}
						case 4: {
							System.out.println("Informe o novo endereço: ");
							endereco = scan.nextLine();
							
							cliente.setEndereco(endereco);
			
							break;
						}
						case 5: {
							System.out.println("Informe o novo CPF: ");
							cpf = scan.nextLine();
							
							cliente.setCpf(cpf);
							break;
						}
						case 6: {
							System.out.println("Informe a nova senha");
							senha = scan.nextLine();
							
							cliente.setSenha(senha);
							break;
						}
						case 7:{
							System.out.println("Voltando ao menu principal.");
							loop2=false;
							break;
						}
						default: {
							System.out.println("Opção inválida, tente novamente.");
							break;
						}
			
					}
		
					}
				}
			case 2: {
				System.out.println("Informe o CPF do administrador que deseja alterar");
				cpf = scan.nextLine();
				
				administrador = fachada.buscarAdministrador(cpf);
				while(loop3!=false){
					System.out.println("O que você deseja alterar? NOME(1), EMAIL(2), TELEFONE(3), ENDEREÇO(4), SENHA(5), CPF(6), SAIR(7) ");
					opcao3 = scan.nextInt();
		
					switch (opcao3) {
						case 1: {
							System.out.println("Informe o novo nome: ");
							nome = scan.nextLine();
							
							administrador.setNome(nome);
			
							break;
						}
						case 2: {
							System.out.println("Informe o novo email: ");
							email = scan.nextLine();
							
							administrador.setEmail(email);			
							break;
						}
						case 3: {
							System.out.println("Informe o novo telefone: ");
							telefone = scan.nextLine();
							
							administrador.setTelefone(telefone);
			
							break;
						}
						case 4: {
							System.out.println("Informe o novo endereço: ");
							endereco = scan.nextLine();
							
							administrador.setEndereco(endereco);
			
							break;
						}
			
						case 6: {
							System.out.println("Informe o novo CPF: ");
							cpf = scan.nextLine();
							
							administrador.setCpf(cpf);			
							break;
						}
						case 7: {
							loop3 = false;
							System.out.println("Voltando ao menu principal");
							break;
						}
						default: {
							System.out.println("Opção inválida, tente novamente: ");
			
							break;
						}
					}
				}
			}
			case 3: {
				System.out.println("Informe o nome do produto que deseja alterar: ");
				nome = scan.nextLine();
				
				produto = fachada.buscarProduto(nome);
				while(loop4!=false){
					System.out.println("O que você deseja alterar? NOME(1), PREÇO(2), DESCRIÇÃO(3), INGREDIENTES(4), SAIR(5) ");
					opcao4 = scan.nextInt();
					
					switch (opcao4) {
						case 1: {
							System.out.println("Informe o novo nome: ");
							nome = scan.nextLine();
							
							produto.setNome(nome);
			
							break;
						}
						case 2: {
							System.out.println("Informe o novo preço: ");
							preco = scan.nextDouble();
							produto.setPreco(preco);
			
							break;
						}
						case 3: {
							System.out.println("Informe a nova descrição: ");
							descricao = scan.nextLine();
							
							produto.setDescricao(descricao);
			
							break;
						}
						case 4: {
							System.out.println("Informe qual o produto que deseja alterar o ingrediente: ");
							nome = scan.nextLine();
							
							produto = fachada.buscarProduto(nome);
							System.out.println("Informe o novo ingredientes: ");
							ingredientes = scan.nextLine();
							
							produto.cadastrarIngrediente(ingredientes);
							System.out.println("Informe o ingrediente que deseja remover: ");
//							String ingredientes2 = scan.nextLine();
							System.out.println("Metodo ainda n implementado");
							
							// produto.remove(ingredientes2); //TODO criar metodo q remove
							// um ingrediente
			
							break;
			
						
						}
					}
				}
			}
			
		}
	}
	
	}
}
