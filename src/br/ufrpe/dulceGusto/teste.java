package br.ufrpe.dulceGusto;

import br.ufrpe.dulceGusto.classesbasicas.Administrador;
import br.ufrpe.dulceGusto.classesbasicas.Cliente;
import br.ufrpe.dulceGusto.dados.RepositorioAdministrador;
import br.ufrpe.dulceGusto.dados.RepositorioCliente;
import br.ufrpe.dulceGusto.neg�cio.CadastroAdministrador;
import br.ufrpe.dulceGusto.neg�cio.CadastroClientes;
//import br.ufrpe.dulceGusto.neg�cio.CadastroAdministrador;
//import br.ufrpe.dulceGusto.neg�cio.CadastroClientes;
import br.ufrpe.dulceGusto.neg�cio.ControleDeLogin;
import br.ufrpe.dulceGusto.neg�cio.Fachada;
//import br.ufrpe.dulceGusto.neg�cio.ICadastroAdministrador;
//import br.ufrpe.dulceGusto.neg�cio.ICadastroClientes;
import br.ufrpe.dulceGusto.neg�cio.IControleDeLogin;
import br.ufrpe.dulceGusto.neg�cio.IFachada;

import java.util.Scanner;



public class teste {

	public static void main(String [] args){
		
		IControleDeLogin login = ControleDeLogin.getInstancia();
//		CadastroClientes cadastroC = CadastroClientes.getInstancia();
//		CadastroAdministrador cadastroA = CadastroAdministrador.getInstancia();
		IFachada fachada = Fachada.getInstancia();
		boolean retorno,retorno2,loop;
		Scanner scan = new Scanner(System.in);
		RepositorioAdministrador repo = RepositorioAdministrador.getInstancia();
		CadastroAdministrador control = CadastroAdministrador.getInstancia();
		RepositorioCliente rep = RepositorioCliente.getInstancia();
		CadastroClientes control2 = CadastroClientes.getInstancia();
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
		fachada.cadastrarAdm(adm);
		fachada.adicionarCliente(cliente);
		loop = true;
		boolean aux = adm.getSenha().equals(cliente.getSenha());
		if(aux!=false){
			System.out.println("sim");
		}
		else{
			System.out.println("nao");
		}
		while(loop!=false){
			System.out.println("Tela de Login\nInforme seu cpf:");
			cpf = scan.nextLine();
			
			System.out.println("Informe sua senha:");
			senha = scan.nextLine();			
			retorno = login.autenticarLoginAdm(senha, cpf);
			if(retorno!=true){
				retorno2 = login.autenticarLoginCliente(senha, cpf);
				if(retorno2 == false){
					System.out.println("Login falhou.Tente Novamente.");
				}
				else{
					System.out.println("Cliente "+fachada.buscarCliente(cpf).getNome()+" logado com sucesso.");
					loop = false;
				}
			}
			else{
				System.out.println("Administrador "+fachada.buscarAdministrador(cpf).getNome()+" logado com sucesso.");
				loop = false;
			}
				
		}
	}
}
