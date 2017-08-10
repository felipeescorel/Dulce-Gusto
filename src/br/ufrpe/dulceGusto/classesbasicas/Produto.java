package br.ufrpe.dulceGusto.classesbasicas;

import java.util.ArrayList;

import br.ufrpe.dulceGusto.exceptions.ItemException;

public class Produto  {

	private String nome;
	private double preco;
	private String descricao;
	private ArrayList<String> ingredientes = new ArrayList<String>();

	public Produto(String nome, double preco, String descricao) {
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;

	}

	public Produto() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void cadastrarIngrediente(String ingrediente) throws ItemException{
		if(ingrediente==null || this.ingredientes.contains(ingrediente)){
			ItemException itemInvalido = new ItemException(ingrediente);
			throw itemInvalido;
		}
		else{
			this.ingredientes.add(ingrediente);
		}

	}

	public void removerIngrediente(String ingrediente) throws ItemException {
//		
		if(ingrediente != null || this.ingredientes.contains(ingrediente)){
			this.ingredientes.remove(ingrediente);
		}
		else{
			ItemException itemInvalido = new ItemException(ingrediente);
			throw itemInvalido;
			
		}
	}

	public ArrayList<String> getIngredientes() {
		return this.ingredientes;

	}

}
