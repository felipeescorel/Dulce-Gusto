package br.ufrpe.dulceGusto;

import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;

//import br.ufrpe.dulceGusto.classesbasicas.Administrador;
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
		LocalDateTime data = LocalDateTime.now();
		Produto agua = new Produto();
		String hidrogenio = "hidrogenio", oxigenio = "oxigenio";
		felipe.setCpf("06854395429");
		felipe.setNome("Felipe");
		felipe.setSenha("pocoto");
		Produto produto = new Produto();
		fachada.adicionarProduto(produto);
		fachada.cadastrarUsuario(felipe);
		System.out.println(fachada.buscarUsuario(felipe.getCpf()).getNome());
		fachada.removerUsuario(felipe);
		System.out.println(fachada.buscarUsuario(felipe.getCpf()).getNome());
		
		try {
			agua.cadastrarIngrediente(hidrogenio);
			agua.cadastrarIngrediente(oxigenio);
		} catch (ItemException e) {		
			e.printStackTrace();
		}
		pedido.novoProduto(agua);		
		felipe.setPedidos(pedido);
		pedido.setData(data);
		pedido.gerarNumeroPedido(data);
		
		System.out.println(pedido.getData());
		System.out.println(pedido.getNumeroPedido());
		for(Produto e : pedido.getProduto()){
			System.out.println(e.getIngredientes());
		}
		System.out.println(pedido.getProduto().toString());
		felipe.cadastrarNovaRestricao(oxigenio);
		System.out.println(pedido.validarProduto(felipe));
		
		pedido.novoProduto(produto);
		
		
		System.out.println(fachada.buscarUsuario("06854395429").getSenha());
	}
}
