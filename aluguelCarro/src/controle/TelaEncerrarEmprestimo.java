package controle;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import servico.EmprestimoControle;

public class TelaEncerrarEmprestimo implements Initializable {

	
	@FXML
    private AnchorPane rootPane;
	
    @FXML
    private Label exitLabel;

    @FXML
    private JFXTextField idMaterialTxt;
    @FXML
    private JFXTextField matriculaTxt;

    @FXML
    private JFXButton devolverBtn;
    @FXML
    private JFXButton cancelBtn;

    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}    
   
    @FXML
    void devolverMaterialAction(ActionEvent event) {
    	//TODO
    	EmprestimoControle emprestimoControle = new EmprestimoControle();
    	emprestimoControle.remover(matriculaTxt.getText(), idMaterialTxt.getText());
    	this.close();
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
