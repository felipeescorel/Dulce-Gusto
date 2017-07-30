package br.ufrpe.dulceGusto.classesbasicas;

import java.util.ArrayList;

public class Produto {

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

	public void cadastrarIngrediente(String ingrediente) {
		if (ingrediente == null || ingredientes.contains(ingrediente)) {
			System.out.println("Esse ingrediente já foi adicionado anteriormente ou está vazio.");
		} else {
			ingredientes.add(ingrediente);
			System.out.println("Ingrediente adicionado.");
		}

	}

	public void removerIngrediente(String ingrediente) {
		for (int i = 0; i < ingredientes.size(); i++) {
			if (ingrediente == null) {
				System.out.println("Esse ingrediente não existe");
			} else {
				ingredientes.remove(ingrediente);
				System.out.println("Ingrediente removido");
			}
		}
	}

	public ArrayList<String> getIngredientes() {
		return this.ingredientes;

	}

}
