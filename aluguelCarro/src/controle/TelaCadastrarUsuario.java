package controle;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import modelo.Usuario;
import modelo.UsuarioConc;
import servico.UsuarioControle;


public class TelaCadastrarUsuario  implements Initializable {
	
	@FXML
    private AnchorPane rootPane;
	
	@FXML
    private Label exitLabel;
	
	@FXML
    private JFXComboBox<Label> tipoComboBox;
    @FXML
    private JFXTextField matriculaTxt;
    @FXML
    private JFXTextField cpfTxt;  
    @FXML
    private JFXTextField nomeTxt;   
    @FXML
    private JFXTextField emailTxt;       
    
    @FXML
    private JFXButton saveBtn;
    @FXML
    private JFXButton cancelBtn;
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		initComboBoxTipo(); 
	}
	
	@FXML
    public void saveUsuario(ActionEvent event) { 
		
		String userTipo = tipoComboBox.getSelectionModel().getSelectedItem().getText();	
		String userMatricula = matriculaTxt.getText();
		String userCPF = cpfTxt.getText();
		String userNome = nomeTxt.getText();
		String userEmail = emailTxt.getText();
		
		Usuario usuario;
		

		
		usuario = new UsuarioConc(userMatricula, userCPF, userNome, userEmail);
		usuario.set_tipo(userTipo);
		
		UsuarioControle usuarioControle = UsuarioControle.getInstance();
		try {
			usuarioControle.cadastrar(usuario);
		} catch (Exception e) {
			TelaAlertaErro telaErro = new TelaAlertaErro(e.getMessage());
		}
		this.closeWindow();
    }
	


    @FXML
    void cancel(ActionEvent event) {    	
    	closeWindow();
    }
    
    private void initComboBoxTipo() {
    	
    	ObservableList<Label> tipos = FXCollections.observableArrayList();
    	ITiposUsuario tiposUsuarios = new TiposUsuarios();
    	ArrayList<String> tiposUser = tiposUsuarios.getTipos();
    	for (int i = 0; i < tiposUser.size(); i++) {
    		tipos.add(new Label(tiposUser.get(i)));
    	}
		this.tipoComboBox.setItems(tipos);
	}
    
    @FXML
    void exitAction(MouseEvent event) {
    	closeWindow();
    }

    
    public void closeWindow() {
    	
    	Stage stage = (Stage) rootPane.getScene().getWindow();
    	stage.close();
    }
    
}
