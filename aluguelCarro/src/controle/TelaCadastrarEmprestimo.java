package controle;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import servico.EmprestimoControle;


public class TelaCadastrarEmprestimo implements Initializable{

	@FXML
    private AnchorPane rootPane;

    @FXML
    private Label exitLabel;
    @FXML
    private JFXTextField matriculaTxt;
    @FXML
    private JFXTextField idTxt;
    @FXML
    private JFXTextField diasAlugadoTxt;
    @FXML
    private JFXComboBox<String> seguroComboBox;
    
    @FXML
    private JFXTextArea descricaoTxtArea;

    @FXML
    private JFXButton confirmarBtn;
    @FXML
    private JFXButton cancelBtn;

   
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	
	}

    @FXML
    void confirmarEmprestimo(ActionEvent event) {
    	
    	EmprestimoControle emprestimoControle = new EmprestimoControle();
    	emprestimoControle.cadastrar(matriculaTxt.getText(), idTxt.getText(), Integer.parseInt(diasAlugadoTxt.getText()),
    								seguroComboBox.getValue());
    	
    	this.close();
    }
    
    private void initComboBox() {
    	
    	ObservableList<String> tipos = FXCollections.observableArrayList();
    	ArrayList<String> options = new ArrayList<>();
    	options.add("SIM");
    	options.add("NÃO");
    	tipos.setAll(options);
		this.seguroComboBox.setItems(tipos);
	}

    @FXML
    void cancelar(ActionEvent event) {
    	close();
    }
    
    
    @FXML
    void exitAction(MouseEvent event) {
    	close();
    }
    
    private void close() {
		Stage stage = (Stage) cancelBtn.getScene().getWindow();
		stage.close();
    }
	
}