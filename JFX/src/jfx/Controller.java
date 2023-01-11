package jfx;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {

	@FXML
	public TextField textfield;

	public void initialize() {
		System.out.println("This is initialised.");
		textfield.setText("Tyolo");
	}
}
