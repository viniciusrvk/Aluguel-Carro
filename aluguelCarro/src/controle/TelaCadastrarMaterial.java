package controle;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import modelo.Material;
import modelo.MaterialConc;
import servico.MaterialControle;

public class TelaCadastrarMaterial implements Initializable {

	@FXML
    private AnchorPane rootPane;
	
	@FXML
    private Label exitLabel;
	
    @FXML
    private JFXTextField idTxt;
    @FXML
    private ComboBox<Label> tiposComboBox;
    @FXML
    private JFXTextArea descricaoTxtArea;
    
    @FXML
    private JFXButton saveBtn;
    @FXML
    private JFXButton cancelBtn;
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		initComboBoxTipos(); 
	}
	
	@FXML
    public void saveFerramenta(ActionEvent event) {
		
		String toolId = idTxt.getText();
		String toolTipo = tiposComboBox.getSelectionModel().getSelectedItem().getText();
		String toolDescricao = descricaoTxtArea.getText();
		
		if (toolId.isEmpty() || toolTipo.isEmpty() || toolDescricao.isEmpty()) {		
			
			emptyFieldAlert();
			return ;
		}
		
		Material material = new MaterialConc(Integer.parseInt(toolId));
		/*((MaterialConc) material).set_aleatorio(toolTipo);*/
		material.set_descricao(toolDescricao);
		material.set_nome(toolTipo);
		MaterialControle materialControle = MaterialControle.getInstance();
		materialControle.cadastrar(material);
		this.close();
    }	

    private void initComboBoxTipos() {
    	
    	ObservableList<Label> tipos = FXCollections.observableArrayList();
    	ITiposMaterial tiposUsuarios = new TiposMateriais();
    	ArrayList<String> tiposUser = tiposUsuarios.getTipos();
    	for (int i = 0; i < tiposUser.size(); i++) {
    		tipos.add(new Label(tiposUser.get(i)));
    	}
		this.tiposComboBox.setItems(tipos);
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

	private void close() {
		Stage stage = (Stage) exitLabel.getScene().getWindow();
    	stage.close();
	}

}
