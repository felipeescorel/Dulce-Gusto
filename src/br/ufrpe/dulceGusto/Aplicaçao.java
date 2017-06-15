package br.ufrpe.dulceGusto;

import java.sql.Date;
import java.util.Calendar;
import java.util.Scanner;

import br.ufrpe.dulceGusto.classesbasicas.Administrador;
import br.ufrpe.dulceGusto.classesbasicas.Cliente;
import br.ufrpe.dulceGusto.classesbasicas.Produto;
import br.ufrpe.dulceGusto.negócio.Fachada;
import br.ufrpe.dulceGusto.negócio.IFachada;
import br.ufrpe.dulceGusto.classesbasicas.Pedido;

public class Aplicaçao {

//	static IFachada fachada = Fachada.getInstancia();
//	static Scanner scan = new Scanner(System.in);
//	static int opcao, quantidade, numeroPedido;
//	static String nome;
//	static String cpf;
//	static String endereco;
//	static String telefone;
//	static String email;
//	static String user;
//	static String descricao;
//	static String ingredientes;
//	static double preco, valor;
//	static Calendar dataPedido = Calendar.getInstance();
//
//	static int opcao2, op3, op4, op5, op6, op7;
//	static Cliente cliente = new Cliente();
//	static Administrador administrador = new Administrador();
//	static Produto produto = new Produto();
//	static Pedido pedido = new Pedido();
//
//	static boolean condicao = true;
//	static boolean condicao2 = true;
//	
//	public static String menuInicial(){
//		return "CADASTRAR(1)	BUSCAR(2)	REMOVER(3)	ALTERAR(4)	SAIR(5)";
//	}
//	public static void novoCliente(){
//		System.out.println("Informar nome do cliente");
//		nome = scan.nextLine();
//		scan.next();
//		cliente.setNome(nome);
//		System.out.println("Informar cpf");
//		cpf = scan.nextLine();
//		scan.next();
//		cliente.setCpf(cpf);
//		System.out.println("Informar endereço");
//		endereco = scan.nextLine();
//		scan.next();
//		cliente.setEndereco(endereco);
//		System.out.println("Informar telefone");
//		telefone = scan.nextLine();
//		scan.next();
//		cliente.setTelefone(telefone);
//		System.out.println("Informar email");
//		email = scan.nextLine();
//		scan.next();
//		cliente.setEmail(email);
//		System.out.println("Informar user");
//		user = scan.nextLine();
//		scan.next();
//		cliente.setUser(user);
//	}
//	public static void novoAdm(){
//		System.out.println("Informar nome do Administrador");
//		nome = scan.nextLine();
//		scan.next();
//		administrador.setNome(nome);
//		System.out.println("Informar cpf");
//		cpf = scan.nextLine();
//		scan.next();
//		administrador.setCpf(cpf);
//		System.out.println("Informar endereço");
//		endereco = scan.nextLine();
//		scan.next();
//		administrador.setEndereco(endereco);
//		System.out.println("Informar telefone");
//		telefone = scan.nextLine();
//		scan.next();
//		administrador.setTelefone(telefone);
//		System.out.println("Informar email");
//		email = scan.nextLine();
//		scan.next();
//		administrador.setEmail(email);
//		System.out.println("Informar user");
//		user = scan.nextLine();
//		scan.next();
//		administrador.setUser(user);
//	}
//	public static void novoProduto(){
//		System.out.println("Informar nome do Produto");
//		nome = scan.nextLine();
//		scan.next();
//		produto.setNome(nome);
//		System.out.println("Informar preço");
//		preco = scan.nextDouble();
//		scan.next();
//		produto.setPreco(preco);
//		System.out.println("Informar a descriçao");
//		descricao = scan.nextLine();
//		scan.next();
//		produto.setDescricao(descricao);
//		System.out.println("Informar os ingredientes");
//		ingredientes = scan.nextLine();
//		scan.next();
//		produto.cadastrarIngrediente(ingredientes);
//		while (condicao2 != false) {
//			System.out.println("Deseja informar outro ingrediente? SIM(1) Não(2)");
//			op3 = scan.nextInt();
//			scan.next();
//			switch (op3) {
//			case 1: {
//				System.out.println("Informar ingrediente");
//				ingredientes = scan.nextLine();
//				scan.next();
//				break;
//			}
//			case 2: {
//				System.out.println("Todos ingredientes foram cadastrados.");
//				condicao2 = false;
//				break;
//			}
//			default: {
//				System.out.println("Opção inválida.Tente novamente.");
//				break;
//			}
//
//			}
//		}
//	}
//	public static void novoPedido(){
//		
//	}
	
	public static void main(String[] args) {
		
		IFachada fachada = Fachada.getInstancia();
		Scanner scan = new Scanner(System.in);
		int opcao, quantidade, numeroPedido;
		String nome, cpf, endereco, telefone, email, user, descricao, ingredientes;
		double preco, valor;
		Calendar dataPedido = Calendar.getInstance();

		int opcao2, op3, op4, op5, op6, op7;
		Cliente cliente = new Cliente();
		Administrador administrador = new Administrador();
		Produto produto = new Produto();
		Pedido pedido = new Pedido();
		String lixo;
		boolean condicao = true;
		boolean condicao2 = true;
		while (condicao != false) {
			// LOGIN AINDA N IMPLEMENTADO

			// FUNCIONALIDADES DO ADM
			
			

//			Aplicaçao.menuInicial();
			System.out.println("CADASTRAR(1)	BUSCAR(2)	REMOVER(3)	ALTERAR(4)	SAIR(5)");
			opcao = scan.nextInt();			
			switch (opcao) {
			case 1: {
				System.out.println("NOVO CLIENTE(1)	NOVO ADMINISTRADOR(2)	NOVO PRODUTO(3)	NOVO PEDIDO(4)	SAIR(5)	");
				opcao2 = scan.nextInt();
				scan.nextLine();
				switch (opcao2) {
				case 1: {
//					Aplicaçao.novoCliente();
					System.out.println("Informar nome do cliente");
					nome = scan.nextLine();
					scan.next();
					cliente.setNome(nome);
					System.out.println("Informar cpf");
					cpf = scan.nextLine();
					scan.next();
					cliente.setCpf(cpf);
					System.out.println("Informar endereço");
					endereco = scan.nextLine();
					scan.next();
					cliente.setEndereco(endereco);
					System.out.println("Informar telefone");
					telefone = scan.nextLine();
					scan.next();
					cliente.setTelefone(telefone);
					System.out.println("Informar email");
					email = scan.nextLine();
					scan.next();
					cliente.setEmail(email);
					System.out.println("Informar user");
					user = scan.nextLine();
					scan.next();
					cliente.setUser(user);
				}

				case 2: {
//					Aplicaçao.novoAdm();
					System.out.println("Informar nome do Administrador");
					nome = scan.nextLine();
					scan.nextLine();
					administrador.setNome(nome);
					System.out.println("Informar cpf");
					cpf = scan.nextLine();
					scan.next();
					administrador.setCpf(cpf);
					System.out.println("Informar endereço");
					endereco = scan.nextLine();
					scan.nextLine();
					administrador.setEndereco(endereco);
					System.out.println("Informar telefone");
					telefone = scan.nextLine();
					scan.nextLine();
					administrador.setTelefone(telefone);
					System.out.println("Informar email");
					email = scan.nextLine();
					scan.nextLine();
					administrador.setEmail(email);
					System.out.println("Informar user");
					user = scan.nextLine();
					scan.nextLine();
					administrador.setUser(user);
				}

				case 3: {
//					Aplicaçao.novoProduto();
					System.out.println("Informar nome do Produto");
					nome = scan.nextLine();
					scan.next();
					produto.setNome(nome);
					System.out.println("Informar preço");
					preco = scan.nextDouble();
					scan.next();
					produto.setPreco(preco);
					System.out.println("Informar a descriçao");
					descricao = scan.nextLine();
					scan.next();
					produto.setDescricao(descricao);
					System.out.println("Informar os ingredientes");
					ingredientes = scan.nextLine();
					scan.next();
					produto.cadastrarIngrediente(ingredientes);
					while (condicao2 != false) {
						System.out.println("Deseja informar outro ingrediente? SIM(1) Não(2)");
						op3 = scan.nextInt();
						scan.next();
						switch (op3) {
						case 1: {
							System.out.println("Informar ingrediente");
							ingredientes = scan.nextLine();
							scan.next();
							break;
						}
						case 2: {
							System.out.println("Todos ingredientes foram cadastrados.");
							condicao2 = false;
							break;
						}
						default: {
							System.out.println("Opção inválida.Tente novamente.");
							break;
						}

						}
					}

				}

				
				  case 4:{ System.out.println("Lista de Produtos disponíveis: "); 
					  fachada.listarProdutos();				  
					  while(condicao2!=false){				  
						  System.out.println(
						  "\nDeseja selecionar algum produto? SIM(1) Não(2)"); 
						  op3 =scan.nextInt(); 						 
						  switch(op3){ 
							  case 1:{
								  System.out.println("Informar produto: "); 
								  nome = scan.nextLine(); 
								  scan.next(); 
								  produto = fachada.buscarProduto(nome); 							  
								  
								  System.out.println("Informar Quantidade: "); 
								  quantidade =scan.nextInt(); 								  
								  pedido = new Pedido();
								  pedido.setQuantidade(quantidade);
								  pedido.setValorTotal(produto.getPreco());								 
//								  dataPedido.getTime();
								  dataPedido.set(Calendar.YEAR,dataPedido.get(Calendar.YEAR));
								  dataPedido.set(Calendar.MONTH,dataPedido.get(Calendar.MONTH));
								  dataPedido.set(Calendar.DAY_OF_MONTH,dataPedido.get(Calendar.DAY_OF_MONTH));
//								  Date date = new Date();
//								  dataPedido.setTime(date);
								  //TODO perguntar ao professor como colocar a hora
								  pedido.setDataPedido(dataPedido);
								  //TODO ARRUMAR NUMERO PEDIDO
								  fachada.cadastrarPedido(pedido);
								  break; 
							  }
							  case 2:{ 
								  System.out.println("Todos ingredientes foram cadastrados."); 
								  condicao2 = false;
								  break; 
								  } 
							  default: { 
								  System.out.println("Opção inválida.Tente novamente."); 
								  break; 
							  }					  
						  } 
					  }					  
				  }
				 

				case 5: {
					condicao = false;
					break;
				}

				default: {
					System.out.println("Opção inválida, tente Novamente.");
					break;
				}
				}
			}
			case 2: {
				//TODO LOOP
				System.out.println("BUSCAR CLIENTE(1)	BUSCAR ADMINISTRADOR(2)   BUSCAR PRODUTO(3)	BUSCAR PEDIDO(4)	SAIR(5)	");
				opcao2 = scan.nextInt();
				
				
				switch(opcao2){
				case 1: {
					System.out.println("Informe o CPF do cliente que deseja encontrar: ");
					cpf = scan.nextLine();
					scan.next();
					fachada.buscarCliente(cpf);
					break;
				}
				case 2: {
					System.out.println("Informe o CPF do administrador que deseja encontrar: ");
					cpf = scan.nextLine();
					scan.next();
					fachada.buscarAdministrador(cpf);
					break;
				}
				case 3:{
					System.out.println("Informe o nome do produto que deseja encontrar: ");
					nome = scan.nextLine();
					scan.next();
					fachada.buscarProduto(nome);
					break;
				}
				case 4:{
					System.out.println("Informe o número do pedido que deseja encontrar: ");
					numeroPedido = scan.nextInt();					
					fachada.buscarPedido(numeroPedido);
					break;
				}
				case 5:{
					//TODO boolean recebe false e sai do loop
					break;
				}
					
				}
			}
			case 3: {
				System.out.println(
						"REMOVER CLIENTE(1)	REMOVER ADMINISTRADOR(2)   REMOVER PRODUTO(3)	REMOVER PEDIDO(4)	SAIR(5)	");
				opcao2 = scan.nextInt();				
				switch (opcao2) {
				case 1: {
					System.out.println("Informe o cpf do cliente que deseja remover: ");
					cpf = scan.nextLine();
					scan.next();
					fachada.removerCliente(fachada.buscarCliente(cpf));

					break;
				}
				case 2: {
					System.out.println("Informe o cpf do administrador que deseja remover: ");
					cpf = scan.nextLine();
					scan.next();
					fachada.removerAdministrador(fachada.buscarAdministrador(cpf));

					break;
				}
				case 3: {
					System.out.println("Informe o nome do produto que deseja remover: ");
					nome = scan.nextLine();
					scan.next();
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
					condicao = false;

					break;
				}
				default: {
					System.out.println("Opção inválida, tente novamente.");

					break;

				}
				}
			}
			case 4: {
				System.out.println(
						"ALTERAR CLIENTE(1)	ALTERAR ADMINISTRADOR(2)   ALTERAR PRODUTO(3)	ALTERAR PEDIDO(4)	SAIR(5)	");
				opcao2 = scan.nextInt();
				
				switch (opcao2) {
				case 1: {
					System.out.println("Informe o CPF do cliente que deseja alterar: ");
					cpf = scan.nextLine();
					scan.next();
					cliente = fachada.buscarCliente(cpf);
					System.out.println(
							"O que você deseja alterar? NOME(1), EMAIL(2), TELEFONE(3), ENDEREÇO(4), CPF(5), SAIR(6)");
					op3 = scan.nextInt();
					
					// TODO tem que implementar um while
					switch (op3) {
					case 1: {
						System.out.println("Informe o novo nome: ");
						nome = scan.nextLine();
						scan.next();
						cliente.setNome(nome);
						break;
					}
					case 2: {
						System.out.println("Informe o novo email: ");
						email = scan.nextLine();
						scan.next();
						cliente.setEmail(email);

						break;
					}
					case 3: {
						System.out.println("Informe o novo telefone: ");
						telefone = scan.nextLine();
						scan.next();
						cliente.setTelefone(telefone);

						break;
					}
					case 4: {
						System.out.println("Informe o novo endereço: ");
						endereco = scan.nextLine();
						scan.next();
						cliente.setEndereco(endereco);

						break;
					}
					case 5: {
						System.out.println("Informe o novo CPF: ");
						cpf = scan.nextLine();
						scan.next();
						cliente.setCpf(cpf);
						break;
					}
					case 6: {
						// TODO boolean do loop recebe falso e sai do loop
						break;
					}
					default: {
						System.out.println("Opção inválida, tente novamente.");
						break;
					}

					}

				}
				case 2: {
					System.out.println("Informe o CPF do administrador que deseja alterar");
					cpf = scan.nextLine();
					scan.next();
					administrador = fachada.buscarAdministrador(cpf);
					// TODO implementar loop
					System.out.println(
							"O que você deseja alterar? NOME(1), EMAIL(2), TELEFONE(3), ENDEREÇO(4), USER(5), CPF(6), SAIR(7) ");
					op4 = scan.nextInt();
					
					switch (op4) {
					case 1: {
						System.out.println("Informe o novo nome: ");
						nome = scan.nextLine();
						scan.next();
						administrador.setNome(nome);

						break;
					}
					case 2: {
						System.out.println("Informe o novo email: ");
						email = scan.nextLine();
						scan.next();
						administrador.setEmail(email);

						break;
					}
					case 3: {
						System.out.println("Informe o novo telefone: ");
						telefone = scan.nextLine();
						scan.next();
						administrador.setTelefone(telefone);

						break;
					}
					case 4: {
						System.out.println("Informe o novo endereço: ");
						endereco = scan.nextLine();
						scan.next();
						administrador.setEndereco(endereco);

						break;
					}
					case 5: {
						System.out.println("Informe o novo nome de usuario: ");
						user = scan.nextLine();
						scan.next();
						administrador.setUser(user);

						break;
					}
					case 6: {
						System.out.println("Informe o novo CPF: ");
						cpf = scan.nextLine();
						scan.next();
						administrador.setCpf(cpf);

						break;
					}
					case 7: {
						// TODO boolean recebe falso e sai do loop;
						break;
					}
					default: {
						System.out.println("Opção inválida, tente novamente: ");

						break;
					}
					}
				}
				case 3: {
					System.out.println("Informe o nome do produto que deseja alterar: ");
					nome = scan.nextLine();
					scan.next();
					produto = fachada.buscarProduto(nome);
					// TODO loop blablabla
					System.out.println("O que você deseja alterar? NOME(1), PREÇO(2), DESCRIÇÃO(3), INGREDIENTES(4), SAIR(5) ");
					op5 = scan.nextInt();
					scan.next();
					switch (op5) {
					case 1: {
						System.out.println("Informe o novo nome: ");
						nome = scan.nextLine();
						scan.next();
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
						scan.next();
						produto.setDescricao(descricao);

						break;
					}
					case 4: {
						System.out.println("Informe qual o produto que deseja alterar o ingrediente: ");
						nome = scan.nextLine();
						scan.next();
						produto = fachada.buscarProduto(nome);
						System.out.println("Informe o novo ingredientes: ");
						ingredientes = scan.nextLine();
						scan.next();
						produto.cadastrarIngrediente(ingredientes);
						System.out.println("Informe o ingrediente que deseja remover: ");
						String ingredientes2 = scan.nextLine();
						scan.next();
						// produto.remove(ingredientes2); //TODO criar metodo q remove um ingrediente

						break;

					}
					case 5: {
						// TODO boolean vai receber false
						break;
					}
					default:{
						System.out.println("Opção invalida, tente novamente.");
						
						break;
					}

					}

				}case 4:{
					

			}
			case 5: {

			}
			default: {

						}
					}
				}
			}
		}
	}
}