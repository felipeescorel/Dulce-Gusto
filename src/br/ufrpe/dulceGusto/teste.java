package br.ufrpe.dulceGusto;

import br.ufrpe.dulceGusto.classesbasicas.Administrador;
import br.ufrpe.dulceGusto.classesbasicas.Cliente;
import br.ufrpe.dulceGusto.negócio.CadastroAdministrador;
import br.ufrpe.dulceGusto.negócio.CadastroClientes;
import br.ufrpe.dulceGusto.negócio.ControleDeLogin;
import br.ufrpe.dulceGusto.negócio.Fachada;
import br.ufrpe.dulceGusto.negócio.ICadastroAdministrador;
import br.ufrpe.dulceGusto.negócio.ICadastroClientes;
import br.ufrpe.dulceGusto.negócio.IControleDeLogin;
import br.ufrpe.dulceGusto.negócio.IFachada;

import java.util.Scanner;



public class teste {

	public static void main(String [] args){
		
		IControleDeLogin login = ControleDeLogin.getInstancia();
//		CadastroClientes cadastroC = CadastroClientes.getInstancia();
//		CadastroAdministrador cadastroA = CadastroAdministrador.getInstancia();
		IFachada fachada = Fachada.getInstancia();
		boolean retorno,retorno2,loop;
		Scanner scan = new Scanner(System.in);
		String cpf,senha;
//		login.atribuirAdm(cadastroA);
//		login.atribuirCliente(cadastroC);
		Administrador adm = new Administrador();
		adm.setCpf("testecpf");
		adm.setSenha("testesenha");
		adm.setNome("Felipe");
		Cliente cliente = new Cliente();
		cliente.setCpf("testecpf2");
		cliente.setSenha("testesenha2");
		cliente.setNome("Voinha");
		fachada.cadastrarCliente(adm);
		fachada.adicionarCliente(cliente);
		loop = true;
		while(loop!=false){
			System.out.println("Tela de Login\nInforme seu cpf:");
			cpf = scan.nextLine();
			scan.next();
			System.out.println("Informe sua senha:");
			senha = scan.nextLine();
			scan.next();
			retorno = login.autenticarLoginAdm(senha, cpf);
			if(retorno!=true){
				retorno2 = login.autenticarLoginCliente(senha, cpf);
				if(retorno2 == false){
					System.out.println("Login falhou.Tente Novamente.");
				}
				else{
					System.out.println("Cliente "+fachada.buscarCliente(cpf).getNome()+" logado com sucesso.");
					loop = true;
				}
			}
			else{
				System.out.println("Administrador "+fachada.buscarAdministrador(cpf).getNome()+" logado com sucesso.");
				loop = true;
			}
				
		}
	}
}
