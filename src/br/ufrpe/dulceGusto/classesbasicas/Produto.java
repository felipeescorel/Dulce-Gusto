package br.ufrpe.dulceGusto.classesbasicas;

public class Produto {
	
	private String nome;
	private double preco;
	private String descricao;
	private String[] ingredientes;
	private int tamanho;
	private int proxima;
	//TODO variável que informa se é doce ou salgado
	
	public Produto(String nome, double preco, String descricao){
		this.nome=nome;
		this.preco=preco;
		this.descricao=descricao;
		tamanho = 50;
		ingredientes = new String[tamanho];
	}
	
	public String getNome(){
		return nome;
	}
	public void setNome(String nome){
		this.nome = nome;
	}
	public double getPreco(){
		return preco;
	}
	public void setPreco(double preco){
		this.preco = preco;
	}
	public String getDescricao(){
		return descricao;
	}
	public void setDescricao(String descricao){
		this.descricao = descricao;
	}
	
	public void cadastrarIngrediente(String ingrediente){
		for (int i = 0;i<proxima;i++){
			if(ingrediente!= null && proxima<tamanho){
				ingredientes[proxima] = ingrediente;
				proxima++;
				if(proxima>tamanho){
					tamanho = tamanho*2;
				}
			}
		}
	}
	public void mostrarIngredientes(){
		for(String ingrediente : ingredientes){
			System.out.println(ingrediente);
		}
	}

}
