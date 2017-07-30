package br.ufrpe.dulceGusto.classesbasicas;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
	
	
	private ArrayList<String> restricaoAlimentar = new ArrayList<String>();
	private String telefone;
	private Endereco endereco = new Endereco();
	//pedido aqui
	
	public Cliente() {
	
	}
	public Cliente(String nome, String cpf, String email, String telefone, Endereco endereco, String senha) {
		super(nome, cpf, email,senha);
//		TODO this.restricaoAlimentar = restricaoAlimentar;
	}
	public void cadastrarNovaRestricao(String alimento){
		restricaoAlimentar.add(alimento);
	}
	public String getTelefone(){
		return telefone;
	}
	public void setTelefone(String telefone){
		this.telefone = telefone;
	}
	public Endereco getEndereco(){
		return endereco;
	}
	public void setEndereco(Endereco endereco){
		this.endereco = endereco;
	}
	public List getRestricaoAlimentar(){
		return restricaoAlimentar;
	}
	
	

}
