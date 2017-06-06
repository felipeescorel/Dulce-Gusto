package br.ufrpe.dulceGusto.classesbasicas;
import java.util.Calendar;

public class Pedido  {
	
	
	private Cliente cliente;
	private double valor;
	private Calendar dataPedido;
//	Tipo salgado, tipo doce.
//	Armazenar os produtos entre os dois tipos.
//  Enum??
//	
//	public enum Tipo{
//		Doce, Salgado;
//	}
//	
	
	public Pedido(Cliente cliente, double valor, Calendar dataPedido){
		this.cliente = cliente;
		this.valor = valor;
		this.dataPedido = dataPedido;
	}
	
	public Cliente getCliente(){
		return cliente;
	}
	public void setCliente(Cliente cliente){
		this.cliente = cliente;
				
	}
	public double getValor(){
		return valor;
	}
	public void setValor(double valor){
		this.valor = valor;
	}
	public Calendar getDataPedido(){
		return dataPedido;
	}
	public void setDataPedido(Calendar dataPedido){
		dataPedido = Calendar.getInstance();
		this.dataPedido = dataPedido;
		// TODO CHECAR SE TÁ FUNCIONANDO.
	}
}

