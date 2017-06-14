package br.ufrpe.dulceGusto;
import java.util.Calendar;
import java.util.Scanner;

import br.ufrpe.dulceGusto.classesbasicas.Administrador;
import br.ufrpe.dulceGusto.classesbasicas.Cliente;
import br.ufrpe.dulceGusto.classesbasicas.Produto;
import br.ufrpe.dulceGusto.classesbasicas.Pedido;

import br.ufrpe.dulceGusto.negócio.Fachada;
import br.ufrpe.dulceGusto.negócio.IFachada;

public class Aplicaçao {

	public static void main(String[] args) {
		
		
		IFachada fachada =Fachada.getInstancia();
		Scanner scan = new Scanner(System.in);
		int opcao,quantidade,numeroPedido;
		String nome,cpf,endereco,telefone,email,user,descricao,ingredientes;
		double preco,valor;
		Calendar datapedido;
		
		
		int opcao2, op3, op4;
		Cliente cliente = new Cliente();
		Administrador administrador = new Administrador();
		Produto produto = new Produto();
		Pedido pedido = new Pedido();
		
		boolean condicao = true;
		boolean condicao2 = true;
		while (condicao!=false){
			//LOGIN AINDA N IMPLEMENTADO
			
			//FUNCIONALIDADES DO ADM
			
			System.out.println("CADASTRAR(1)	BUSCAR(2)	REMOVER(3)	ALTERAR(4)	SAIR(5)");			
			opcao = scan.nextInt();
			scan.next();
			switch(opcao){
			case 1:{
				System.out.println("NOVO CLIENTE(1)	NOVO ADMINISTRADOR(2)	NOVO PRODUTO(3)	NOVO PEDIDO(4)	SAIR(5)	");
				opcao2 = scan.nextInt();
				scan.nextLine();
					switch(opcao2){
						case 1 :{
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
						
						case 2:{
							System.out.println("Informar nome do Administrador");
							nome = scan.nextLine();
							scan.next();
							administrador.setNome(nome);
							System.out.println("Informar cpf");
							cpf = scan.nextLine();
							scan.next();
							administrador.setCpf(cpf);
							System.out.println("Informar endereço");
							endereco = scan.nextLine();
							scan.next();
							administrador.setEndereco(endereco);
							System.out.println("Informar telefone");
							telefone = scan.nextLine();
							scan.next();
							administrador.setTelefone(telefone);
							System.out.println("Informar email");
							email = scan.nextLine();
							scan.next();
							administrador.setEmail(email);
							System.out.println("Informar user");
							user = scan.nextLine();
							scan.next();
							administrador.setUser(user);	
						}
						
						case 3:{
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
							while(condicao2!=false){
								System.out.println("Deseja informar outro ingrediente? SIM(1) Não(2)");	
									op3 = scan.nextInt();
									scan.next();
									switch(op3){
											case 1:{
												System.out.println("Informar ingrediente");
												ingredientes = scan.nextLine();
												scan.next();
												break;					
											}
											case 2:{
												System.out.println("Todos ingredientes foram cadastrados.");
												condicao2 = false;
												break;
												}
											default:
											{
												System.out.println("Opção inválida.Tente novamente.");
												break;
											}
									
										}
								}
					
						}
						
				/*		case 4:{
							System.out.println("Lista de Produtos disponíveis: ");
							fachada.listarProdutos();
							
							while(condicao2!=false){
								
								System.out.println("Deseja ordenar algum produto? SIM(1) Não(2)");	
									op3 = scan.nextInt();
									scan.next();
									switch(op3){
											case 1:{
												System.out.println("Informar produto: ");
												nome = scan.nextLine();
												scan.next();
												produto = fachada.buscarProduto(nome);
												fachada.
												
												System.out.println("Informar Quantidade: ");
												quantidade = scan.nextInt();
												scan.next();
												fachada.
												break;					
											}
											
											
											case 2:{
												System.out.println("Todos ingredientes foram cadastrados.");
												condicao2 = false;
												break;
												}
											default:
											{
												System.out.println("Opção inválida.Tente novamente.");
												break;
											}
											
											
									
									}
								}
							
							
							
						} */
						
						case 5:{
							condicao = false;
							break;
						}
						
						default:{
							System.out.println("Opção inválida.Tente Novamente");
							break;
							}
						}	
				}
			}
		}
	}
	
}