package br.ufrpe.dulceGusto.gui;

import br.ufrpe.dulceGusto.exceptions.ProdutoNaoExisteException;
import br.ufrpe.dulceGusto.exceptions.ClienteNaoExisteException;
import br.ufrpe.dulceGusto.exceptions.DadosException;
import br.ufrpe.dulceGusto.negócio.Fachada;
import br.ufrpe.dulceGusto.classesbasicas.Cliente;
import br.ufrpe.dulceGusto.classesbasicas.Produto;
import br.ufrpe.dulceGusto.classesbasicas.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class RemoverProdutoController {
	@FXML private Button btPesquisar;
	@FXML private Button btRemover;
	@FXML private Button btVoltar;
	@FXML private TextField tfProduto;
	
	@FXML private Label lbNome;
	@FXML private Label lbPreço;
	@FXML private Label lbDescrição;

	Fachada fachada = Fachada.getInstancia();
		
		String nome = null;
		
		private boolean validarProduto(ActionEvent event) {
			try{
				nome = (lbNome.getText());
				return true;
			}catch(NumberFormatException e) {
				Alert err = new Alert(AlertType.ERROR);
				err.setContentText("Preencha o campo corretamente.");
				err.showAndWait();
			}
			return false;
		}
		
		
		@FXML
		public void buscarProduto(ActionEvent event) throws DadosException, ProdutoNaoExisteException {
			
			if(this.validarProduto(event)) {
			
				Produto produt = fachada.buscarProduto(nome);
				lbNome.setText(produt.getNome());
				lbPreço.setText(Double.toString(produt.getPreco()));	
				lbDescrição.setText(produt.getDescricao());
			
			}
		}
		
		
		@FXML
		public void remover(ActionEvent event) throws ProdutoNaoExisteException, DadosException {
		
			//	fachada.removerProduto(nome);
				
			}	
		}

