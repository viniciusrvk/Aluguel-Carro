package lixo;
/*
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaCadastrarServidor {
	
	@FXML
	private TextField CPFCadastrar;
	@FXML
	private TextField NomeCadastrar;
	@FXML
	private TextField EmailCadastrar;
	@FXML
	private TextField MatriculaCadastrar;
	@FXML
	private Button Cadastrar;
	@FXML
	private CheckBox Administrador;
	
	public void open() throws IOException {
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/TelaPrincipalCadastrar.fxml"));
		Scene scene = new Scene (root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void cadastrar (ActionEvent event) {
		CadastrarAlunoControle cad = new CadastrarAlunoControle();
		boolean x = cad.cadastrar(CPFCadastrar.getText(), NomeCadastrar.getText(), EmailCadastrar.getText(), MatriculaCadastrar.getText());
		if(x) {
			Stage stage = (Stage) Cadastrar.getScene().getWindow(); //Obtendo a janela atual
		    stage.close();
		} else {
			
		}
	}
}
*/