package jfx;



import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application{

	@Override
	public void start(Stage stage)throws Exception{
		stage.setTitle("Hello JavaFX");
		stage.setAlwaysOnTop(true); 
		stage.setResizable(true);
		Label lbl = new Label("Hello World!!");
//		Button btn = new Button("Click to Exit");
//		btn.setMinSize(100, 67);
//		btn.setStyle("-fx-background-color: #047872");
//		btn.setStyle("-fx-text-fill: #097804");
//		btn.setOnAction((ActionEvent event)->{
//			Platform.exit();
//		});
            
//		Integer width = Integer.parseInt(getParameters().getNamed().get("width"));
//		Integer heigth = Integer.parseInt(getParameters().getNamed().get("heigth"));
		
		Button btn1 = new Button("First button");
		Button btn2 = new Button("Second Button extra lang");
		Button btn3 = new Button("Third button");
		Button btn4 = new Button("Fourth Button");
		
		
		
//		btn1.setLayoutX(250);
//		btn2.setLayoutY(250);
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("Hello World");
				
			}
		});
		
		//Group group = new Group();
		GridPane grid = new GridPane();
		//group.getChildren().addAll(btn1,btn2);
		//grid.setGridLinesVisible(true);
		grid.setHgap(20);
		grid.setVgap(5);
		
		grid.setMinHeight(400);
		grid.setMinWidth(600);
		
		GridPane.setConstraints(btn1, 0, 1);
		GridPane.setConstraints(btn2, 1, 2);
		GridPane.setConstraints(btn3, 2, 1);
		GridPane.setConstraints(btn4, 2, 0);
		
//		BorderPane borderPane = new BorderPane();
//		borderPane.setTop(new Button("Top"));
//		borderPane.setBottom(new Button("Bottom"));
//		borderPane.setCenter(new Button("Center"));
//		borderPane.setRight(new Button("Right"));
//		borderPane.setLeft(new Button("Left"));
//		GridPane.setConstraints(borderPane, 2, 2, 2, 3);
//		GridPane.
		
//		grid.getChildren().addAll(btn1, btn2, btn3, btn4, borderPane);
		
		TableView labelArea = new TableView();
		labelArea.setMinWidth(550);
		labelArea.setMinHeight(300);
		GridPane.setConstraints(labelArea, 1, 1, 3, 1);
		TableColumn column1 = new TableColumn("Priority");
		TableColumn column2 = new TableColumn("Description");
		TableColumn column3 = new TableColumn("Progress");
		labelArea.getColumns().addAll(column1,column2,column3);
		
		TextField taskName = new TextField();
		taskName.setPromptText("Enter task name");
		taskName.setText("Default");
		taskName.setMinWidth(300);
		GridPane.setConstraints(taskName, 2, 2);
		
		ComboBox<String> priority = new ComboBox<>();
		priority.getItems().addAll("Low","Medium","High");
		priority.setPromptText("Set priority");
		GridPane.setConstraints(priority, 1, 2);
		
		Button addButton = new Button("ADD");
		addButton.setMinWidth(100);
		GridPane.setConstraints(addButton, 3, 2);
		Button cancelButton = new Button("Cancel");
		cancelButton.setMinWidth(100);
		GridPane.setConstraints(cancelButton, 3, 3);
		
		HBox progressArea= new HBox();
		progressArea.getChildren().addAll(new Label("Progress"), new Spinner<Integer>(0,100,0), new CheckBox("Completed"));
		progressArea.setAlignment(Pos.CENTER_RIGHT);
		progressArea.setSpacing(10);
		GridPane.setConstraints(progressArea, 1, 3,2,1);
		
		grid.getChildren().addAll(labelArea, taskName, priority, addButton,cancelButton,progressArea);
		
		Scene scene = new Scene(grid,600,500);
		stage.setScene(scene);
        stage.show();
		
		
	}
	


public static void main(String[] args) {
	Application.launch(args);
}
}