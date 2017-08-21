package br.ufrpe.dulceGusto.gui;

import java.io.IOException;

import br.ufrpe.dulceGusto.classesbasicas.Cliente;
import br.ufrpe.dulceGusto.classesbasicas.Produto;
import br.ufrpe.dulceGusto.exceptions.ClienteNaoExisteException;
import br.ufrpe.dulceGusto.exceptions.ProdutoNaoExisteException;
import br.ufrpe.dulceGusto.negócio.ServidorDulceGusto;
import javafx.event.ActionEvent;
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

public class AlterarProdutoController {
	private Main main;
	@FXML private TextField tfProduto;
	@FXML private TextField tfNome;
	@FXML private TextField tfPreço;
	@FXML private TextField tfDescrição;
	
	@FXML private Button btPesquisar;
	@FXML private Button btSalvar;
	@FXML private Button btVoltar;
	
	ServidorDulceGusto svr = ServidorDulceGusto.getInstance();
	Produto produto = null;
	String nome = null;
	
	@FXML
	public void buscar(ActionEvent event){
		try{
			nome = (tfNome.getText());
		}catch(ProdutoNaoExisteException e) {
			Alert err = new Alert(AlertType.ERROR);
			err.setContentText("Preencha o campo nome corretamente.");
			err.showAndWait();
			return;
		}
		try {
			produto = svr.buscarProduto((tfProduto.getText()));
			tfNome.setText(produto.getNome());
			tfPreço.setPromptText(produto.getPreco());
			tfDescrição.setText(produto.getDescricao());
			
		} catch (ProdutoNaoExisteException e) {
			Alert err = new Alert(AlertType.ERROR);
			err.setContentText(e.getMessage());
			err.showAndWait();
		}
		this.main = Main.getInstancia();
		this.btVoltar.setOnAction(e2 -> {
			main = Main.getInstancia();
			 Stage stage;
			 Parent root;	
			 try{

				 root = (Parent) FXMLLoader.load(getClass().getResource("/br/ufrpe/dulceGusto/gui/MenuAdministrador.fxml"));
				 Scene scene = new Scene(root);
				 stage = main.getPalcoPrincipal();
				 stage.setScene(scene);
				 main.changeStage(stage);
			 }catch(IOException e3){
				 e3.printStackTrace(); 
			 };
		});
	}
			
	@FXML public void atualizar(ActionEvent event) {
		produto.setNome(tfNome.getText());
		produto.setPreco(tfPreço.getText());
		produto.setDescricao(tfDescrição.getText());
		svr.alterarProduto(produto);
	}
	
}
