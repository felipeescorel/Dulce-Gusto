package br.ufrpe.dulceGusto.gui;

import java.io.IOException;

import br.ufrpe.dulceGusto.negócio.Fachada;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class MenuClienteController {
	@FXML
	private MenuItem mnNovoPedido;
	@FXML
	private MenuItem mnitAlterarCadastro;
	@FXML
	private MenuItem mnitALterarPedido;
	@FXML
	private Menu mnSair;

	Fachada fachada = Fachada.getInstancia();
	Main main;

	@FXML
	private void novoPedido() {
		main = Main.getInstancia();
		Stage stage;
		Parent root;
		try {

			root = (Parent) FXMLLoader.load(getClass().getResource("/br/ufrpe/dulceGusto/gui/TelaNovoPedido.fxml"));
			Scene scene = new Scene(root);
			stage = main.getPalcoPrincipal();
			stage.setScene(scene);
			main.changeStage(stage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void alterarCadastro() {
		main = Main.getInstancia();
		Stage stage;
		Parent root;
		try {
			root = (Parent) FXMLLoader.load(getClass().getResource("/br/ufrpe/dulceGusto/gui/AlterarCliente.fxml"));
			Scene scene = new Scene(root);
			stage = main.getPalcoPrincipal();
			stage.setScene(scene);
			main.changeStage(stage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	 * @FXML private void alterarPedido(){ main = Main.getInstancia(); Stage
	 * stage; Parent root; try{ root = (Parent)
	 * FXMLLoader.load(getClass().getResource(
	 * "/br/ufrpe/dulceGusto/gui/AlterarCliente.fxml")); Scene scene = new
	 * Scene(root); stage = main.getPalcoPrincipal(); stage.setScene(scene);
	 * main.changeStage(stage); }catch(IOException e){ e.printStackTrace(); }
	 * 
	 * }
	 */

	@FXML
	private void deslogar() {
		main = Main.getInstancia();
		Stage stage;
		Parent root;
		try {
			root = (Parent) FXMLLoader.load(getClass().getResource("/br/ufrpe/dulceGusto/gui/TelaLogin.fxml"));
			Scene scene = new Scene(root);
			stage = main.getPalcoPrincipal();
			stage.setScene(scene);
			main.changeStage(stage);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}