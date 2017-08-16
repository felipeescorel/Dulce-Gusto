package br.ufrpe.dulceGusto.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.dulceGusto.classesbasicas.*;
import br.ufrpe.dulceGusto.exceptions.DadosException;
import br.ufrpe.dulceGusto.exceptions.ItemException;

public class RepositorioUsuario implements IRepositorioUsuario, Serializable{
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private Usuario user;

	private static RepositorioUsuario instancia;

	public static RepositorioUsuario getInstancia() {
		if (instancia == null) {
			instancia = lerDoArquivo();
		}
		return instancia;
	}

	private RepositorioUsuario() {
		
	}

	@Override
	public void cadastrarUsuario(Usuario user) {
		this.usuarios.add(user);
		RepositorioUsuario.gravarArquivo();
	}

	@Override
	public Usuario buscarUsuario(String cpf) throws ItemException{
		Usuario retorno = null;
		int indice = this.obterIndice(cpf);
		if (indice != -1) {
			retorno = this.usuarios.get(indice);
		}
		else{
			ItemException cpfExc = new ItemException(cpf);
			throw cpfExc;
		}
		return retorno;
	}

	private int obterIndice(String cpf) {
		int indice = -1;
		for (int i = 0; i < this.usuarios.size(); i++) {			
//			if(this.usuarios.get(i)!=null){
				if (cpf.equals(this.usuarios.get(i).getCpf())) {
					indice = i;
				}
//			}
		}
		
		return indice;
	}

	 private static RepositorioUsuario lerDoArquivo(){
	        RepositorioUsuario instanciaLocal = null;

	        File in = new File("Usuarios.db");
	        FileInputStream fis = null;
	        ObjectInputStream ois = null;

	        try{
	            fis = new FileInputStream(in);
	            ois = new ObjectInputStream(fis);
	            Object o = ois.readObject();
	            instanciaLocal = (RepositorioUsuario) o;
	        }catch (Exception e){
	            instanciaLocal = new RepositorioUsuario();
	        } finally {
	            if (ois != null){
	                try{
	                    ois.close();
	                }catch (IOException e){
	                }
	            }
	        }
	        return instanciaLocal;
	    }

	    private static void gravarArquivo(){
	        if (instancia==null){
	            return;
	        }
	        File out = new File("Usuarios.db");
	        FileOutputStream fos = null;
	        ObjectOutputStream oos = null;

	        try{
	            fos = new FileOutputStream(out);
	            oos = new ObjectOutputStream(fos);
	            oos.writeObject(instancia);
	        }catch (Exception e){
	            e.printStackTrace();
	        } finally{
	            if(oos != null){
	                try {
	                    oos.close();
	                }catch (IOException e){
	                }
	            }
	        }
	    }
	@Override
	public boolean existe(String cpf) {
		boolean existe = false;
		int indice = this.obterIndice(cpf);
		if (indice != -1) {
			existe = true;
		}
		return existe;
	}

	@Override
	public void removerUsuario(String cpf) throws ItemException{
		int indice = this.obterIndice(cpf);
		if (indice != -1) {
			this.usuarios.remove(indice);
			RepositorioUsuario.gravarArquivo();
		}
		else{
			ItemException userExc = new ItemException (cpf);
			throw userExc;
		}
	}

	@Override
	public void alterarUsuario(Usuario user) throws DadosException{
		int indice = this.obterIndice(user.getCpf());
		if (indice != -1) {
			this.usuarios.set(indice, user);
			RepositorioUsuario.gravarArquivo();
		}
		else{
			DadosException userExc = new DadosException();
			throw userExc;
		}
	}

	@Override
	public List<Usuario> mostrarUsuarios() {
		return this.usuarios;
	}

	@Override
	public boolean autenticarLogin(String senha, String cpf) throws ItemException {
		boolean retorno = false;
		boolean equivale;
		user = this.buscarUsuario(cpf);
		equivale = user.getSenha().equals(senha);			
			if (equivale != false) {
				retorno = true;
			}		
		return retorno;
	}

}



