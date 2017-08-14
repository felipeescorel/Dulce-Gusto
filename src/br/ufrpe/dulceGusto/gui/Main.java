package br.ufrpe.dulceGusto.gui;
	
import java.io.IOException;

import br.ufrpe.dulceGusto.negócio.Fachada;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application {
	
	private static Main instancia;
	private Fachada fachada = Fachada.getInstancia();
	
	public static Main getInstancia(){
		if(instancia == null){
			instancia = new Main();
		}
		return instancia;
	}
	
	private Stage palcoPrincipal;
	private Pane rootScene;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		instancia = this;
		this.palcoPrincipal = primaryStage;
		this.palcoPrincipal.setResizable(false);
		this.palcoPrincipal.setTitle("DulceGusto - BetaVersion");
		this.rootScene = new Pane();
		Scene scene = new Scene(this.rootScene,550,380);
		this.palcoPrincipal.setScene(scene);
		this.palcoPrincipal.show();
		this.openLoginScreen();
	}
	private void openLoginScreen(){
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/br/ufrpe/dulceGusto/gui/TelaLogin.fxml"));
			Pane pane = (Pane) loader.load();
			
			this.rootScene.getChildren().add(pane);
			TelaLoginController telaControl = loader.getController();
			telaControl.setApp(this);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public void changeStage(Stage stage){
		this.palcoPrincipal = stage;
	}
	public Stage getPalcoPrincipal(){
		return this.palcoPrincipal;
	}
	public Pane getRootScene(){
		return this.rootScene;
	}
	
	public static void main(String[] args) {		
		launch(args);
	}
}
