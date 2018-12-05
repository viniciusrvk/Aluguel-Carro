package controle;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TelaBuscarUsuario implements Initializable{
	
	
	@FXML
    private AnchorPane rootPane;

    @FXML
    private Label exitLabel;

    @FXML
    private GridPane gridPane;

    private ToggleGroup toggle = new ToggleGroup();
    
    @FXML
    private JFXRadioButton nomeRadioBtn;
    @FXML
    private JFXRadioButton matriculaRadioBtn;
    @FXML
    private JFXRadioButton cpfRadioBtn;   

    @FXML
    private JFXButton buscarButton;
    @FXML
    private JFXButton cancelBtn;
    

    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		this.nomeRadioBtn.setToggleGroup(toggle);
		this.matriculaRadioBtn.setToggleGroup(toggle);
		this.cpfRadioBtn.setToggleGroup(toggle);
	}
	
	@FXML
    void buscarUsuario(ActionEvent event) {
		
		System.out.println("Buscar Usuario");
    }
	
	private void emptyFieldAlert() {
		
		// T� dando algum tipo de CRASH no JVM quando a janela � fechada.
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setHeaderText(null);
		alert.setContentText("Todos os campos devem ser preenchidos!");
		alert.showAndWait();
		return;
	}

    @FXML
    void cancel(ActionEvent event) {
    	close();
    }

    @FXML
    void exitAction(MouseEvent event) {
    	close();
    }
    
    public void close() {
    	
    	Stage stage = (Stage) rootPane.getScene().getWindow();
    	stage.close();
    }

}
