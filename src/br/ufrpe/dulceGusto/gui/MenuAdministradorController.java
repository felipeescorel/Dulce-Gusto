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


public class MenuAdministradorController {
@FXML private MenuItem mnitCadastrarCliente;
@FXML private MenuItem mnitCadastrarProduto;
@FXML private MenuItem mnitALterarCliente;
@FXML private MenuItem mnitAlterarProduto;
@FXML private MenuItem mnitRemoverCliente;
@FXML private MenuItem mnitRemoverProduto;
@FXML private MenuItem mnitBuscarCliente;
@FXML private MenuItem mnitBuscarProduto;
@FXML private Menu mnSair;

 Fachada fachada = Fachada.getInstancia();
 Main main ;
 
 @FXML private void cadastrarCliente(){
	 main = Main.getInstancia();
	 Stage stage;
	 Parent root;	
	 try{

		 root = (Parent) FXMLLoader.load(getClass().getResource("/br/ufrpe/dulceGusto/gui/TelaCadastro.fxml"));
		 Scene scene = new Scene(root);
		 stage = main.getPalcoPrincipal();
		 stage.setScene(scene);
		 main.changeStage(stage);
	 }catch(IOException e){
		 e.printStackTrace(); 
	 }
 }
 @FXML private void cadastrarProduto(){
	 main = Main.getInstancia();
	 Stage stage;
	 Parent root;
	 try{
		 root = (Parent) FXMLLoader.load(getClass().getResource("/br/ufrpe/dulceGusto/gui/TelaCadastrarProduto.fxml"));
		 Scene scene = new Scene(root);
		 stage = main.getPalcoPrincipal();
		 stage.setScene(scene);
		 main.changeStage(stage);
	 }catch(IOException e){
		 e.printStackTrace();
	 }
 }
 @FXML private void alterarCliente(){ 
	 main = Main.getInstancia();
	 Stage stage;
	 Parent root;
	 try{
		 root = (Parent) FXMLLoader.load(getClass().getResource("/br/ufrpe/dulceGusto/gui/AlterarCliente.fxml"));
		 Scene scene = new Scene(root);
		 stage = main.getPalcoPrincipal();
		 stage.setScene(scene);
		 main.changeStage(stage);
	 }catch(IOException e){
		 e.printStackTrace();
	 }
	 
 }
 @FXML private void alterarProduto(){ 
	 main = Main.getInstancia();
	 Stage stage;
	 Parent root;
	 try{
		 root = (Parent) FXMLLoader.load(getClass().getResource("/br/ufrpe/dulceGusto/gui/AlterarProduto.fxml"));
		 Scene scene = new Scene(root);
		 stage = main.getPalcoPrincipal();
		 stage.setScene(scene);
		 main.changeStage(stage);
	 }catch(IOException e){
		 e.printStackTrace();
	 }
	 
 }
 @FXML private void removerCliente(){ 
	 main = Main.getInstancia();
	 Stage stage;
	 Parent root;
	 try{
		 root = (Parent) FXMLLoader.load(getClass().getResource("/br/ufrpe/dulceGusto/gui/RemoverCliente.fxml"));
		 Scene scene = new Scene(root);
		 stage = main.getPalcoPrincipal();
		 stage.setScene(scene);
		 main.changeStage(stage);
	 }catch(IOException e){
		 e.printStackTrace();
	 }
	 
 }
 @FXML private void removerProduto(){
	 main = Main.getInstancia();
	 Stage stage;
	 Parent root;
	 try{
		 root = (Parent) FXMLLoader.load(getClass().getResource("/br/ufrpe/dulceGusto/gui/RemoverProduto.fxml"));
		 Scene scene = new Scene(root);
		 stage = main.getPalcoPrincipal();
		 stage.setScene(scene);
		 main.changeStage(stage);
 }catch(IOException e){
	 e.printStackTrace();
 }
	 
 }
 @FXML private void buscarCliente(){ 
	 main = Main.getInstancia();
	 Stage stage;
	 Parent root;
	 try{
		 root = (Parent) FXMLLoader.load(getClass().getResource("/br/ufrpe/dulceGusto/gui/BuscarCliente.fxml"));
		 Scene scene = new Scene(root);
		 stage = main.getPalcoPrincipal();
		 stage.setScene(scene);
		 main.changeStage(stage);
	 }catch(IOException e){
		 e.printStackTrace();
	 }
		 
 }
 @FXML private void buscarProduto(){ 
	 main = Main.getInstancia();
	 Stage stage;
	 Parent root;
	 try{
		 root = (Parent) FXMLLoader.load(getClass().getResource("/br/ufrpe/dulceGusto/gui/BuscarProduto.fxml"));
		 Scene scene = new Scene(root);
		 stage = main.getPalcoPrincipal();
		 stage.setScene(scene);
		 main.changeStage(stage);
	 }catch(IOException e){
		 e.printStackTrace();
	 }
		 
 }
 @FXML private void deslogar(){
	 main = Main.getInstancia();
	 Stage stage;
	 Parent root;
	 try{
		 root = (Parent) FXMLLoader.load(getClass().getResource("/br/ufrpe/dulceGusto/gui/TelaLogin.fxml"));
		 Scene scene = new Scene(root);
		 stage = main.getPalcoPrincipal();
		 stage.setScene(scene);
		 main.changeStage(stage);
	 }catch(IOException e){
		 e.printStackTrace();
	 }
	 
 }

}
