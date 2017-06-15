package br.ufrpe.dulceGusto.dados;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.dulceGusto.classesbasicas.Pedido;

public class RepositorioPedido implements IRepositorioPedido {
	
	private static RepositorioPedido instancia;
	private ArrayList<Pedido> pedido = new ArrayList<Pedido>();
	
	
	
	public static RepositorioPedido getInstancia(){
		if(instancia == null){
			instancia = new RepositorioPedido();
		}
		return instancia;
	}
	private RepositorioPedido(){
		
	}	
	@Override
	public void cadastrarPedido(Pedido ped){
		this.pedido.add(ped);
	}
	@Override
	public Pedido buscarPedido(int numeroPedido){
		Pedido retorno = null;
		int indice = this.obterIndice(numeroPedido);
		if(indice!=-1){
			retorno = this.pedido.get(indice);
		}
		return retorno;
	}
	private int obterIndice(int numeroPedido) {
		int indice = -1;
		for(int i=0;i<pedido.size();i++){
			if(this.pedido.get(i).getNumeroPedido() == numeroPedido){
				indice = i;
			}
		}
		return indice;	
	}
	@Override
	public boolean existe(int numeroPedido){
		boolean existe = false;
		int indice = this.obterIndice(numeroPedido);
		if(indice!=-1){
			existe = true;
		}
		return existe;
	}
	@Override
	public void removerPedido(int numeroPedido){		
		int indice = this.obterIndice(numeroPedido);
		if(indice!=-1){
			this.pedido.remove(numeroPedido);
		}
	}
	@Override
	public void alterarPedido(Pedido pedido){		
		int indice = this.obterIndice(pedido.getNumeroPedido());		
		if(indice!=-1){
			this.pedido.set(indice, pedido);
		}
	}
	@Override
	public List<Pedido> listarPedido(){
		return this.pedido;
	}
}
