package NewToDo;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Home extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("ui.fxml"));
		GridPane gridpane = loader.load();

		Scene scene = new Scene(gridpane);
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
		
//bij klikken in de scene(overal) komt print in de console		
		scene.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				System.out.println("scene filter: "+event.getEventType().getName());
			}
		});
		
		

	}//einde start

	public static void main(String[] args) {
		Application.launch();
	}//einde main

}//einde class
