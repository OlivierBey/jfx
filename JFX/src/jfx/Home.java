package jfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Home extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/simpleui.fxml"));
		HBox box = loader.load();

		Scene scene = new Scene(box);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		Application.launch();
	}

}
