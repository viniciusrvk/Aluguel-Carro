package controle;
import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import servico.LoginControle;


public class TelaLogin {

	LoginControle login = new LoginControle(); 
	
	@FXML
	private Label exitLabel;
	
    @FXML
    private JFXTextField usernameTxt;
    @FXML
    private JFXPasswordField passwordField;
    
    @FXML
    private JFXButton entrarBtn;
    @FXML
    private JFXButton cancelarBtn;
    
    @FXML
    private Hyperlink esqueceuLink;    
   
    @FXML
    void open() {
    	
    	try {
			Parent root =  FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
			
			Scene scene = new Scene (root);
			
			Stage primaryStage = new Stage();
			primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void entrar(ActionEvent event) {
    	
    	try {
			if(login.PodeEntrar(usernameTxt.getText(), passwordField.getText())) {
				new TelaPrincipalClass().open();
				this.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void esqueceuAction(ActionEvent event) {
    	System.out.println("Feature ainda n�o adicionada!");
    }
	
    @FXML
    void exitLabelAction(MouseEvent event) {
		close();
    }
    
    @FXML
    void cancelarAction(ActionEvent event) {
    	close();
    }
    
    void close () {
    	
    	Stage stage = (Stage) entrarBtn.getScene().getWindow(); //Obtendo a janela atual
    	System.out.println("fechando Login ...");
	    stage.close();
    }
    
}
