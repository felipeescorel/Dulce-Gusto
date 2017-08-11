package br.ufrpe.dulceGusto.gui;

import br.ufrpe.dulceGusto.classesbasicas.Cliente;
import br.ufrpe.dulceGusto.classesbasicas.Usuario;
import br.ufrpe.dulceGusto.negócio.Fachada;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.text.Font;

public class TelaLoginController {
	
	private Main main;
	@FXML private TextField tfLogin;
	@FXML private PasswordField pfSenha;
	@FXML private Button btEntrar;
	private String user;
	private String pass;
	private Fachada fachada = Fachada.getInstancia();
	
	public void initialize(){
		this.main = Main.getInstancia();
//		this.user = "felipe";
//		this.pass = "senha";		
				this.btEntrar.setOnAction(e -> {
			Stage stage = null;
			Parent root = null;
			Cliente cliente = new Cliente();
			cliente.setCpf("felipe");
			cliente.setSenha("senha");
			fachada.cadastrarUsuario(cliente);
			
			boolean loginOk = fachada.autenticarLogin(tfLogin.getText(), pfSenha.getText());
			if(loginOk){
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.setTitle("Bem vindo "+user);
				stage.setResizable(true);
				main.changeStage(stage);
			}
			else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Falha de Login");
				alert.setHeaderText("Erro");
				alert.setContentText("As informações fornecidas são inválidas");
				alert.showAndWait();
			}
		});
		
	}
	
	public void setApp(Main main){
		this.main = main;
	}
	
}
