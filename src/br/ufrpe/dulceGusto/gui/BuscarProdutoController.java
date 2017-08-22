package br.ufrpe.dulceGusto.gui;

import java.io.IOException;

import javax.xml.ws.Action;

import br.ufrpe.dulceGusto.classesbasicas.Produto;
import br.ufrpe.dulceGusto.dados.RepositorioProduto;
import br.ufrpe.dulceGusto.exceptions.ItemException;
import br.ufrpe.dulceGusto.exceptions.ProdutoNaoExisteException;
import br.ufrpe.dulceGusto.negócio.Fachada;
import br.ufrpe.dulceGusto.negócio.ServidorDulceGusto;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class BuscarProdutoController {
	
	@FXML private TextField tfProduto;
	@FXML private Label lbNome;
	@FXML private Label lbPreço;
	@FXML private Label lbDescrição;
	@FXML private Button btPesquisar;
	@FXML private Button btVoltar;
	
	ServidorDulceGusto svr = ServidorDulceGusto.getInstance();
	
	String nome = null;
	
	@FXML
	public void buscar(Action event){
		try {
			Produto produt = svr.buscarProduto(nome);
			lbNome.setText(produt.getNome().toString());
			lbPreço.setText(Double.toString(produt.getPreco()));
			lbDescrição.setText(produt.getDescricao());
		} catch (ProdutoNaoExisteException e) {
			Alert err = new Alert(AlertType.ERROR);
			err.setContentText(e.getMessage());
			err.showAndWait();
		}
		
		
	}
		
	

}