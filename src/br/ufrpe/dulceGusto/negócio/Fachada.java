package br.ufrpe.dulceGusto.neg�cio;

public class Fachada implements IFachada {
	
	private ICadastroAdministrador cadastroAdministrador;
	//TODO Resto das interfaces
	private static Fachada instancia;
	
	private Fachada(){
		this.cadastroAdministrador = new CadastroAdministrador();
		//TODO inicializar o resto das coisas
	}
	public static Fachada getInstancia(){
		if(instancia == null){
			instancia = new Fachada();
		}
		return instancia;
		
	}
	//TODO Terminar As Atribui��es 

}
