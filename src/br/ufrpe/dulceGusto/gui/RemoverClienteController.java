package br.ufrpe.dulceGusto.gui;

import br.ufrpe.dulceGusto.exceptions.ClienteNaoExisteException;
import br.ufrpe.dulceGusto.exceptions.DadosException;
import br.ufrpe.dulceGusto.negócio.Fachada;
import br.ufrpe.dulceGusto.classesbasicas.Cliente;
import br.ufrpe.dulceGusto.classesbasicas.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class RemoverClienteController {
	@FXML private Button btPesquisar;
	@FXML private Button btRemover;
	@FXML private Button btVoltar;
	@FXML private TextField tfCpfCliente;
	
	
	@FXML private Label lbCPF;
	@FXML private Label lbNome;
	@FXML private Label lbEmail;
	@FXML private Label lbTelefone;
	@FXML private Label lbEndereço;
	@FXML private Label lbRestriçãoAlimentar;
	Fachada fachada = Fachada.getInstancia();
		
		String cpf = null;
		
		@FXML
		public boolean validarCpf(ActionEvent event) {
			try{
				cpf = (tfCpfCliente.getText());
				return true;
			}catch(NumberFormatException e) {
				Alert err = new Alert(AlertType.ERROR);
				err.setContentText("Preencha o campo CPF corretamente.");
				err.showAndWait();
			}
			
			return false;
		}
		
		
		
		@FXML
		public void buscar(ActionEvent event) throws DadosException {
			
			if(this.validarCpf(event)) {
			
				try {
					Usuario cliente = fachada.buscaPorCpf(cpf);
					lbNome.setText(cliente.getNome());
					lbEmail.setText(cliente.getEmail());					
					if(cliente instanceof Cliente){
						lbTelefone.setText((((Cliente) cliente).getTelefone()));
						lbEndereço.setText(((Cliente)cliente).getEndereco().getLogradouro());
					}
				} catch (ClienteNaoExisteException e) {
					Alert err = new Alert(AlertType.ERROR);
					err.setContentText(e.getMessage());
					err.showAndWait();
				}
			
			}
		}
		
		@FXML
		public void remover(ActionEvent event) throws ClienteNaoExisteException, DadosException {
			
			if(this.validarCpf(event)) {
			
				Alert err = new Alert(AlertType.CONFIRMATION);
				err.setContentText("Tem certeza de que deseja remover este cliente?");
				err.showAndWait();

				fachada.remover(cpf);
				
			}	
		}
	}

