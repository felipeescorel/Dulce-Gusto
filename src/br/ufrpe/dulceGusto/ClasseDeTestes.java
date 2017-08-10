package br.ufrpe.dulceGusto;

import br.ufrpe.dulceGusto.classesbasicas.Administrador;
import br.ufrpe.dulceGusto.classesbasicas.Cliente;
import br.ufrpe.dulceGusto.classesbasicas.Pedido;
import br.ufrpe.dulceGusto.classesbasicas.Produto;
import br.ufrpe.dulceGusto.exceptions.DadosException;
import br.ufrpe.dulceGusto.exceptions.ItemException;
import br.ufrpe.dulceGusto.negócio.Fachada;

public class ClasseDeTestes {

	public static void main(String[] args) throws DadosException, ItemException{
		Fachada fachada = Fachada.getInstancia();
		Cliente felipe = new Cliente();
		Pedido pedido = new Pedido();
		Produto agua = new Produto();
		String hidrogenio = "hidrogenio", oxigenio = "oxigenio";
		felipe.setCpf("06854395429");
		felipe.setNome("Felipe");
		felipe.setSenha("pocoto");
		fachada.cadastrarUsuario(felipe);
//		pedido.gerarNumeroPedido();
		agua.cadastrarIngrediente(hidrogenio);
		pedido.novoProduto(agua);		
		felipe.setPedidos(pedido);
		System.out.println(pedido.getData());
		
		
		
		
		System.out.println(fachada.buscarUsuario("06854395429").getSenha());
	}
}
