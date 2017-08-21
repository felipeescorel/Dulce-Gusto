package br.ufrpe.dulceGusto.gui;

import java.awt.TextField;

import br.ufrpe.dulceGusto.negócio.Fachada;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;

public class TelaCadastroController {
	
	private Main main;
	@FXML private TextField tfNome;
	@FXML private TextField tfCPF;
	@FXML private TextField tfTelefone;
	@FXML private TextField tfCEP;
	@FXML private TextField tfLogradouro;
	@FXML private TextField tfNumero;
	@FXML private TextField tfComplemento;
	@FXML private TextField tfCidade;
	@FXML private TextField tfBairro;
	@FXML private TextField tfUF;
	@FXML private TextField tfEmail;
	@FXML private PasswordField pfSenha;
	@FXML private Button btCadastrar;

	private Fachada fachada = Fachada.getInstancia();
	
	public void initialize (){
//		boolean cadastrarOk = fachada.cadastrarUsuario(tfNome.getText(), tfCPF.getText(), tfTelefone.getText(), tfCEP.getText(), tfLogradouro.getText(), tfNumero.getText(), tfComplemento.getText(), tfCidade.getText(), tfBairro.getText(), tfUF.getText(),tfEmail.getText(), pfSenha.getText());
		
		
		
		this.main = Main.getInstancia();
		this.btCadastrar.setOnAction(e ->{
			Stage stage = null;
			Parent root = null;
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Cadastrado!");
			alert.setHeaderText("Cadastrado com sucesso!");
			alert.setContentText("");
			alert.showAndWait();
		}
		);
	}
	
	
}                        