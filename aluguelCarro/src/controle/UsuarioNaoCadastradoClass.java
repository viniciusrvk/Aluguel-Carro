package controle;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class UsuarioNaoCadastradoClass {	
	
    @FXML
    private JFXButton okButton;    

   
	public void open() throws IOException {
		
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/UsuarioNaoCadastrado.fxml"));
		
		Scene scene = new Scene (root);
		
		Stage primaryStage = new Stage();
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@FXML
    void okButtonAction(ActionEvent event) {
		close();
    }
	
	public void close() {
		
		Stage stage = (Stage) okButton.getScene().getWindow(); //Obtendo a janela atual
	    stage.close();
		
//		Stage stage = (Stage) OkButton.getScene().getWindow(); //Obtendo a janela atual
//	    stage.close();
	}
}
