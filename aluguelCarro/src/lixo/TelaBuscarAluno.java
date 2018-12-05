package lixo;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.Usuario;
import servico.UsuarioControle;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class TelaBuscarAluno implements Initializable{

    @FXML
    private AnchorPane TelaPrincipal;
    @FXML
    private Label lblCPF;
    @FXML
    private Label lblNome;
    @FXML
    private Label lblEmail;
    @FXML
    private Label lblMatricula;
    @FXML
    private Label lblUsuario;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnRemover;
    @FXML
    private Label lblAlertaModoBusca;
    @FXML
    private ComboBox<String> cbTipoBusca; // TIPO DE BUSCA // 
    private ObservableList<String> list = FXCollections.observableArrayList("Matrícula", "CPF", "Nome");
    @FXML
    private TextField tfBusca;
    
    @FXML
    void remover(ActionEvent event){
    	
    	String id = tfBusca.getText(); // ID DA BUSCA
    	String chave = cbTipoBusca.getValue();
    	
    	if(chave.equals("Matrícula")) {
    		UsuarioControle usuarioControle = UsuarioControle.getInstance();
    		List<Usuario> list = usuarioControle.buscar_matricula(id);
    		Usuario first = list.get(0);
    		usuarioControle.remover_matricula(first.get_matricula());

    	} else if(chave.equals("CPF")) {
    		UsuarioControle usuarioControle = UsuarioControle.getInstance();
    		List<Usuario> list = usuarioControle.buscar_CPF(id);
    		Usuario first = list.get(0);
    		usuarioControle.remover_matricula(first.get_matricula());
    	}
		

    	this.close();
    }

    @FXML
    void cancelar(ActionEvent event) {
    	this.close();
    }

	private void close() {
		Stage stage = (Stage) btnCancelar.getScene().getWindow(); //Obtendo a janela atual
	    stage.close();
	}
	public void open() {
		try {
		Stage buscarAluno = new Stage();
		Parent tela = FXMLLoader.load(getClass().getResource("/lixo/TelaBuscarAluno.fxml"));
		Scene scene = new Scene(tela);
		buscarAluno.setScene(scene);
		buscarAluno.setTitle("BUSCA");
		buscarAluno.show();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cbTipoBusca.setItems(list);
		cbTipoBusca.setValue("Matrícula");
		tfBusca.setPromptText(cbTipoBusca.getValue());
	}
	public void tipoBuscaMudou(ActionEvent event) {
		tfBusca.setPromptText(cbTipoBusca.getValue());
	}
	
	//TODO Buscar por todas as coisas (cpf/nome/etc)	
	public void buscarAlunoPor(ActionEvent event) {
    	String id = tfBusca.getText(); // ID DA BUSCA
    	String chave = cbTipoBusca.getValue();
    	
    	if(chave.equals("Matrícula")) {
    		UsuarioControle usuarioControle = UsuarioControle.getInstance();
    		List<Usuario> list = usuarioControle.buscar_matricula(id);
    		if(list.isEmpty()) {
    			System.out.println("Lista vazia");
    			//TODO LANÇAR exception
    		} else {
    			Usuario first = list.get(0);
    			lblCPF.setText(first.get_cpf());
    	    	lblEmail.setText(first.get_email());
    	    	lblMatricula.setText(first.get_matricula());
    	    	lblNome.setText(first.get_nome());
    	    	btnRemover.setOpacity(1.0); // botao remover aparece apenas quando clicado em remover
    		}
    	} else if(chave.equals("CPF")) {
    		UsuarioControle usuarioControle = UsuarioControle.getInstance();
    		List<Usuario> list = usuarioControle.buscar_CPF(id);
    		if(list.isEmpty()) {
    			System.out.println("Lista vazia");
    			//TODO LANÇAR exception
    		} else {
    			Usuario first = list.get(0);
    			lblCPF.setText(first.get_cpf());
    	    	lblEmail.setText(first.get_email());
    	    	lblMatricula.setText(first.get_matricula());
    	    	lblNome.setText(first.get_nome());
    	    	btnRemover.setOpacity(1.0); // botao remover aparece apenas quando clicado em remover
    		}
    	}
    }

}
