package br.ufrpe.dulceGusto;

import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;

//import br.ufrpe.dulceGusto.classesbasicas.Administrador;
import br.ufrpe.dulceGusto.classesbasicas.Cliente;
import br.ufrpe.dulceGusto.classesbasicas.Pedido;
import br.ufrpe.dulceGusto.classesbasicas.Produto;
import br.ufrpe.dulceGusto.classesbasicas.Usuario;
import br.ufrpe.dulceGusto.dados.RepositorioUsuario;
import br.ufrpe.dulceGusto.exceptions.DadosException;
import br.ufrpe.dulceGusto.exceptions.ItemException;
import br.ufrpe.dulceGusto.negócio.Fachada;

public class ClasseDeTestes {

	public static void main(String[] args) throws DadosException, ItemException{

		RepositorioUsuario repo = RepositorioUsuario.getInstancia();
		Fachada fachada = Fachada.getInstancia();
		Usuario felipe = new Cliente();
		felipe.setCpf("06854395429");
		felipe.setSenha("senha");
		fachada.cadastrarUsuario(felipe);
//		repo.cadastrarUsuario(felipe);
		System.out.println(fachada.buscarUsuario("06854395429").getSenha());
		fachada.removerUsuario(felipe);
		System.out.println(fachada.buscarUsuario(felipe.getCpf()));
		
	}
}
