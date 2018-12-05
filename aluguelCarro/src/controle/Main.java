package controle;

import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start (Stage primaryStage) {
		new TelaLogin().open();
	}
	public static void main (String[] args) {
		
		launch(args);

	}
}
