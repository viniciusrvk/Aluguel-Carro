
package controle;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lixo.TelaBuscarAluno;
import modelo.Emprestimo;
import modelo.Material;
import modelo.Usuario;
import servico.UsuarioControle;


public class TelaPrincipalClass implements Initializable {
	
	
	// Bot�es Laterais...
	@FXML
    private JFXButton registrarEmprestimoBtn;
	@FXML
    private JFXButton buscarUsuarioBtn;
	@FXML
    private JFXButton encerrarEmprestimoBtn;
	@FXML
    private JFXButton addUsuarioBtn;
    @FXML
    private JFXButton addFerramentaBtn;
    
    
    // ---- TAB 'Usuarios' START ----
    @FXML
    private Tab tabUsuarios;
    
    @FXML
    private HBox headerUsuarios;
    @FXML
    private JFXComboBox<Label> comboBoxUsuarios; 
    @FXML
    private JFXButton buscarUsuariosBtn;

    @FXML
    private TableView<Usuario> tableViewUsuarios;
    @FXML
    private TableColumn<Usuario, String> usuarioColumnMatricula; 
    @FXML
    private TableColumn<Usuario, String> usuarioColumnNome;
    @FXML
    private TableColumn<Usuario, String> usuarioColumnEmail; 
    
    private ObservableList<Usuario> observableListUsuario;
    

    @FXML
    private HBox bottomUsuarios;
    @FXML
    private JFXButton viewUsuarioBtn;
    // ---- TAB 'Usuarios' END ---- 
    
    // ---- TAB 'Emprestimos' START ----
    @FXML
    private Tab tabEmprestimos;
    
    @FXML
    private HBox headerEmprestimos;
    @FXML
    private JFXComboBox<Label> comboBoxEmprestimos; 
    @FXML
    private JFXButton buscarEmprestimosBtn;

    @FXML
    private TableView<Emprestimo> tableViewEmprestimos;
    @FXML
    private TableColumn<Emprestimo, String> emprestimoColumnID;
    @FXML
    private TableColumn<Emprestimo, String> emprestimoColumnDataInicio;  //Ver se � melhor deixar o tipo String mesmo.
    @FXML
    private TableColumn<Emprestimo, String> emprestimoColumnStatus;     

    @FXML
    private HBox bottomEmprestimo;
    @FXML
    private JFXButton viewEmprestimoBtn;
    // ---- TAB 'Emprestimos' END ---- 
    
    // ---- TAB 'Ferramentas' START ----
    @FXML
    private Tab tabFerramentas;
    
    @FXML
    private HBox headerFerramentas;
    @FXML
    private JFXComboBox<Label> comboBoxFerramentas;  
    @FXML
    private JFXButton buscarFerramentasBtn;

    @FXML
    private TableView<Material> tableViewFerramentas;
    @FXML
    private TableColumn<Material, String> ferramentaColumnID;
    @FXML
    private TableColumn<Material, String> ferramentaColumnTipo;
    @FXML
    private TableColumn<Material, String> ferramentaColumnStatus;     

    @FXML
    private HBox bottomFerramentas;
    @FXML
    private JFXButton viewFerramentaBtn;
    // ---- TAB 'Ferramentas' END ---- 
    
    
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		initComboBoxUsuarios();
		carregarTableViewUsuario();
		
//		initComboBoxEmprestimos();
//		initColumnsEmprestimos();	//Tab Emprestimos
//		
//		initComboBoxFerramentas();
//		initColumnsFerramentas();	//Tab Ferramentas
	}
	
	
	@FXML
    void loadRegistrarEmprestimo(ActionEvent event) {
		System.out.println("testes");
		loadWindow("aluguelCarro/src/view/TelaRealizarEmprestimo.fxml"); 
    }
	
	@FXML
    void loadEncerrarEmprestimo(ActionEvent event) {
		
		loadWindow("aluguelCarro/src/view/TelaEncerrarEmprestimo.fxml"); 
    }    
	
	@FXML
    void loadBuscarUsuario(ActionEvent event) {
		
//		loadWindow("src/lixo/TelaBuscarUsuario.fxml");
		new TelaBuscarAluno().open();
    }
	
	
	@FXML
    void loadCadastrarUsuario(ActionEvent event) {
		
		loadWindow("aluguelCarro/src/view/TelaCadastrarUsuario.fxml");
    }
    
    @FXML
    void loadCadastrarMaterial(ActionEvent event) {		

	    loadWindow("aluguelCarro/src/view/TelaCadastrarMaterial.fxml");
    }    
    
    void loadWindow(String location) {
    	
    	try {
			// Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource(location));
			
    		// S� est� carregando assim do contr�rio lan�aa exce��o;
			URL url = new File(location).toURI().toURL();
			Parent parent = FXMLLoader.load(url);
			
			Stage stage = new Stage(StageStyle.UNDECORATED);
			stage.setScene( new Scene(parent) );
			stage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
   //  ---- ACTIONS FROM TAB 'Usuarios'  ----
   private void initComboBoxUsuarios() {
   	
		this.comboBoxUsuarios.getItems().add(new Label("Usu�rios Ativos") );
		this.comboBoxUsuarios.getItems().add(new Label("Usu�rios com Empr�stimo Ativo") );
		this.comboBoxUsuarios.getItems().add(new Label("Usu�rios com Empr�stimo Em Atraso") );
	}


   private void carregarTableViewUsuario() {

		System.out.println("entrou no initColumsUsuario");
		usuarioColumnMatricula.setCellValueFactory(new PropertyValueFactory<>("matricula"));	
		usuarioColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));	
		usuarioColumnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
	   
		UsuarioControle usuarioControle = UsuarioControle.getInstance();
		List <Usuario> list = usuarioControle.buscar();
	   
//	   List<Usuario> listTeste = new ArrayList<>();
//	   listTeste.add(new Usuario("2015", "373", "vinicius", "viniciusrvk@gmail.com")); // 
	   
	   observableListUsuario = FXCollections.observableArrayList(list);
	   tableViewUsuarios.setItems(observableListUsuario);
   }

   @FXML
   void buscarUsuariosAction(ActionEvent event) {
   	
   }

   @FXML
   void openVisualizarUsuario(ActionEvent event) {
	   System.out.println(tableViewUsuarios.getItems().get(0).get_matricula());
   }   

    
   //  ---- ACTIONS FROM TAB 'Emprestimos'  ----
   private void initComboBoxEmprestimos() {
   	
		this.comboBoxEmprestimos.getItems().add(new Label("Empr�stimos Ativos") );
		this.comboBoxEmprestimos.getItems().add(new Label("Empr�stimos Encerrados") );
		this.comboBoxEmprestimos.getItems().add(new Label("Empr�stimos Em Atraso") );
	}

   private void initColumnsEmprestimos() {
		
		ferramentaColumnID.setCellValueFactory(new PropertyValueFactory<>("id"));	
		ferramentaColumnTipo.setCellValueFactory(new PropertyValueFactory<>("inicio"));	
		ferramentaColumnStatus.setCellValueFactory(new PropertyValueFactory<>("isAtivo"));	// PODE DAR ERRADO !!!
	}
   
   @FXML
   void buscarEmprestimosAction(ActionEvent event) {
   	
   }

   @FXML
   void openVisualizarEmprestimo(ActionEvent event) {

   }   
   
	//   ---- ACTIONS FROM TAB 'Ferramentas'  ----
	private void initComboBoxFerramentas() {
    	
		this.comboBoxFerramentas.getItems().add(new Label("Ferramentas Dispon�veis") );
		this.comboBoxFerramentas.getItems().add(new Label("Ferramentas em Empr�stimo") );
		this.comboBoxFerramentas.getItems().add(new Label("Ferramentas Avariadas") );
	}

    private void initColumnsFerramentas() {
		
		ferramentaColumnID.setCellValueFactory(new PropertyValueFactory<>("id"));	
		ferramentaColumnTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));	
		ferramentaColumnStatus.setCellValueFactory(new PropertyValueFactory<>("isDisponivel"));		
	}
    
    @FXML
    void buscarFerramentasAction(ActionEvent event) {
    	
    }

    @FXML
    void openVisualizarFerramenta(ActionEvent event) {

    }

    @FXML
    void verifyComboAction(ActionEvent event) {
    	
    	Object source = event.getSource();
    	
    	if(source == comboBoxUsuarios) {
    		this.comboBoxUsuarios.setStyle(  
	    			  "-fx-font: 13px \"Serif\";"
					+ "-fx-background-color: #ffffff;"
					+ "-fx-text-fill: #c6d5df;"
					+ "-fx-font-weight: bold;"  	);
    	} else if(source == comboBoxEmprestimos) {
    		this.comboBoxEmprestimos.setStyle(  
	    			  "-fx-font: 13px \"Serif\";"
					+ "-fx-background-color: #669b92;"
					+ "-fx-font-weight: bold;"  	);
    	} else {    		
    		this.comboBoxFerramentas.setStyle(  
	    			  "-fx-font: 13px \"Serif\";"
					+ "-fx-background-color: #669b92;"
					+ "-fx-font-weight: bold;"  	);
    	}
    	
    }
	
	// LOGOUT
	public void sair(ActionEvent event){
		
		Stage stage = (Stage) addFerramentaBtn.getScene().getWindow(); //Obtendo a janela atual
    	System.out.println("Voltou pra tela de login");
	    stage.close();
	    Main login = new Main();
	    Stage primaryStage = new Stage();
		login.start(primaryStage );
	}


	public void open() {
		try {
			System.out.println("ooi\n");
			Parent root = FXMLLoader.load(getClass().getResource("aluguelCarro/src/view/TelaPrincipal.fxml"));	
			
			Scene scene = new Scene(root);
//			scene.getStylesheets().add(getClass().getResource("/view_novo/main.css").toExternalForm()); 
			
			Stage primaryStage = new Stage();
			primaryStage.setScene(scene);
			primaryStage.setMaximized(false);  	// Inicializa a tela Principal maximizada.
			primaryStage.setResizable(false);   // Desabilita o bot�o maximizar.
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}