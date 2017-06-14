package br.ufrpe.dulceGusto;
import java.util.Scanner;

import br.ufrpe.dulceGusto.classesbasicas.Cliente;


public class Aplicaçao {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int opcao;
		String nome;
		String cpf;
		int opcao2, op3, op4;
		Cliente cliente = new Cliente();
		boolean condicao = true;
		while (condicao!=false){
			//LOGIN AINDA N IMPLEMENTADO
			
			//FUNCIONALIDADES DO ADM
			
			System.out.println("CADASTRAR(1)	BUSCAR(2)	REMOVER(3)	ALTERAR(4)	SAIR(5)");			
			opcao = scan.nextInt();
			scan.next();
			switch(opcao){
			case 1:{
				System.out.println("CADASTRO CLIENTE(1)	CADASTRO ADMINISTRADOR(2)	CADASTRO PRODUTO(3)	CADASTRO PEDIDO(4)	SAIR(5)	");
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
						}
					}
				break;
			}
			case 2:{
				
				break;
			}
			case 3:{
				break;
			}
			case 4:{
				break;
			}
			case 5:{
				condicao = false;
				break;
			}
			default:{
				break;
			}
			}
			

			
		}
		
		
	}
	
	{
		//	
	//		System.out.println("");
		//	System.out.println("");
		//	System.out.println("");
		}
	{
		//		System.out.println("ALTERAR CLIENTE");
		//		System.out.println("ALTERAR ADMINISTRADOR");
		//		System.out.println("ALTERAR PRODUTO");
		//		System.out.println("ALTERAR PEDIDO");
			}
	{
		//		System.out.println("REMOVER CLIENTE");
		//		System.out.println("REMOVER ADM");
		//		System.out.println("REMOVER PRODUTO");
		//		System.out.println("REMOVER PEDIDO");
				
			}
	{
		//			System.out.println("BUSCAR CLIENTE");
			//		System.out.println("BUSCAR ADM");
				//	System.out.println("BUSCAR PRODUTO");
					//System.out.println("BUSCAR PEDIDO");
					
				}
			

}
