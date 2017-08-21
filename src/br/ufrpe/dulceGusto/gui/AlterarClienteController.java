package br.ufrpe.dulceGusto.gui;

import br.ufrpe.dulceGusto.classesbasicas.Cliente;
import br.ufrpe.dulceGusto.classesbasicas.Usuario;
import br.ufrpe.dulceGusto.exceptions.ClienteNaoExisteException;
import br.ufrpe.dulceGusto.neg�cio.ServidorDulceGusto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class AlterarClienteController {
	
	@FXML private TextField tfCpfCliente;
	@FXML private TextField tfNome;
	@FXML private TextField tfCPF;
	@FXML private TextField tfEndere�o;
	@FXML private TextField tfTelefone;
	@FXML private TextField tfEmail;
	@FXML private TextField tfRestri��oAlimentar;
	@FXML private Label txtCadastrado;
	
	@FXML private Button btBuscar;
	@FXML private Button btSalvar;
	@FXML private Button btVoltar;
	
	ServidorDulceGusto svr = ServidorDulceGusto.getInstance();
	Cliente cliente = null;
	String cpf = null;
	
	@FXML
	public void buscar(ActionEvent event) {
		try{
			cpf = Long.parseLong(tfCPF.getText());
		}catch(NumberFormatException e) {
			Alert err = new Alert(AlertType.ERROR);
			err.setContentText("Preencha o campo CPF corretamente.");
			err.showAndWait();
			return;
		}
		
		try {
			cliente = (Cliente) svr.buscarUsuario((tfCpfCliente.getText()));
			tfNome.setText(cliente.getNome());
			tfCPF.setText(cliente.getCpf());
			tfEndere�o.setPromptText(cliente.getEndereco());
			tfTelefone.setText(cliente.getTelefone());
			tfEmail.setText(cliente.getEmail());
			tfRestri��oAlimentar.setPromptText(cliente.getRestricaoAlimentar());
			
		} catch (ClienteNaoExisteException e) {
			Alert err = new Alert(AlertType.ERROR);
			err.setContentText(e.getMessage());
			err.showAndWait();
		}
	}
			
	@FXML public void atualizar(ActionEvent event) {
		cliente.setNome(tfNome.getText());
		cliente.setCpf(tfCPF.getText());
		cliente.setEndereco(tfEndere�o.getText());
		cliente.setTelefone(tfTelefone.getText());
		cliente.setEmail(tfEmail.getText());
		cliente.setRestricaoAlimentar(tfRestri��oAlimentar.getText());
		svr.atualizar(cliente);
		txtCadastrado.setText("Cliente editado com sucesso!");
	}

}
