
package controle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TelaBuscarMaterial {

    @FXML
    private AnchorPane TelaPrincipal;

    @FXML
    private Button btnCancelar;

    @FXML
    private ChoiceBox<?> cbTipoBusca;

    @FXML
    private TextField tfBusca;

    @FXML
    private Button btnRemover;

    @FXML
    private Label lblTombamento;

    @FXML
    private Label lblNome;

    @FXML
    private Label lblSerie;

    @FXML
    private Label lblDescricao;

    @FXML
    void buscarMaterial(ActionEvent event) {
    	String chave = tfBusca.getText();
   // 	Material m = new CadastrarMaterialControle().busca(chave);
    	
    	btnRemover.setOpacity(1.0);
    }

    @FXML
    void cancelar(ActionEvent event) {
    	this.close();
    }

    @FXML
    void remover(ActionEvent event) {
//    	new CadastrarMaterialControle().remover(tfBusca.getText());
    	this.close();
    }
    private void close() {
    	Stage stage = (Stage) btnCancelar.getScene().getWindow();
    	stage.close();
    }

	public void open() {
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("/view/TelaBuscarMaterial.fxml"));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Buscar Material");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
