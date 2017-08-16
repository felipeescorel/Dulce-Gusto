package br.ufrpe.dulceGusto.gui;

import java.io.IOException;

import br.ufrpe.dulceGusto.classesbasicas.Administrador;
import br.ufrpe.dulceGusto.classesbasicas.Cliente;
import br.ufrpe.dulceGusto.classesbasicas.Usuario;
import br.ufrpe.dulceGusto.exceptions.ItemException;
import br.ufrpe.dulceGusto.negócio.Fachada;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;


public class TelaLoginController {
	
	private Main main;
	@FXML private TextField tfLogin;
	@FXML private PasswordField pfSenha;
	@FXML private Button btEntrar;
	@FXML private Hyperlink hypCadastrar;
	private Usuario user;
	
	private Fachada fachada = Fachada.getInstancia();
	
	
	public void initialize(){
		this.main = Main.getInstancia();	
			this.hypCadastrar.setOnAction(e2 -> {
				main = Main.getInstancia();
				 Stage stage;
				 Parent root;	
				 try{

					 root = (Parent) FXMLLoader.load(getClass().getResource("/br/ufrpe/dulceGusto/gui/TelaCadastro.fxml"));
					 Scene scene = new Scene(root);
					 stage = main.getPalcoPrincipal();
					 stage.setScene(scene);
					 main.changeStage(stage);
				 }catch(IOException e3){
					 e3.printStackTrace(); 
				 }
				
			});
			this.btEntrar.setOnAction(e -> {
			Stage stage = null;
			Parent root = null;			
					
			boolean loginOk = fachada.autenticarLogin(pfSenha.getText(), tfLogin.getText());
			if(loginOk){
				try {
					user = fachada.buscarUsuario(tfLogin.getText());
				} catch (ItemException e1) {				
					e1.printStackTrace();
				}
				stage=(Stage) btEntrar.getScene().getWindow();
				if(user instanceof Cliente){
					try {
						root = (Parent) FXMLLoader.load(getClass().getResource("/br/ufrpe/dulceGusto/gui/MenuCliente.fxml"));
					} catch (IOException e1) {						
						e1.printStackTrace();
					}
				}
				else if(user instanceof Administrador){
					try {
						root = (Parent) FXMLLoader.load(getClass().getResource("/br/ufrpe/dulceGusto/gui/MenuAdministrador.fxml"));
					} catch (IOException e1) {						
						e1.printStackTrace();
					}
				}
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.setTitle("Bem vindo "+ user.getNome());
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
