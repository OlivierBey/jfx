package NewToDo;

import javax.management.remote.SubjectDelegationPermission;
import javax.sql.RowSetMetaData;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

public class Controller {

	private Task currentTask = new Task();
	private final ObservableList<Task> tasks= FXCollections.observableArrayList();
	
    @FXML
    private Button add;

    @FXML
    private Button cancel;

    @FXML
    private CheckBox completedCheckBox;

    @FXML
    private ComboBox<String> priorities;
    
    @FXML
    private TableColumn<Task, String> descriptionColumn;

    @FXML
    private TableColumn<Task, String> progressColumn;

    @FXML
    private TableColumn<Task, String> priorityColumn;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Spinner<Integer> progressSpinner;

    @FXML
    private TextField taskDescription;

    @FXML
    private TableView<Task> tasksTable;

    public void initialize() {
    	System.out.println("yes");
    	priorities.getItems().addAll("High","Medium","Low");
    	progressSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100,0) );
    	
    	progressSpinner.valueProperty().addListener(new ChangeListener<Integer>() {
    		@Override
			public void changed(ObservableValue<? extends Integer> observable, Integer oldvalue, Integer newvalue) {
				if (newvalue==100) {
					completedCheckBox.setSelected(true);
				}else {
					completedCheckBox.setSelected(false);
				}
				//progressBar.setProgress(1.0*newvalue/100);
				
				
				tasks.add(new Task(newvalue+4,"Nieuwe taak", "Medium",45));
			}
		});
    	ReadOnlyIntegerProperty intProgress= ReadOnlyIntegerProperty.readOnlyIntegerProperty(progressSpinner.valueProperty());
    	progressBar.progressProperty().bind(intProgress.divide(100.0));
    	
    	priorities.valueProperty().bindBidirectional(currentTask.priorityProperty());
    	taskDescription.textProperty().bindBidirectional(currentTask.descriptionProperty());
    	progressSpinner.getValueFactory().valueProperty().bindBidirectional(currentTask.progressProperty());
    	
    	tasksTable.setItems(tasks);
    	
    	priorityColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("priority"));
    	//descriptionColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("description"));
    	descriptionColumn.setCellValueFactory(rowData -> rowData.getValue().descriptionProperty());
    	
    	
    	//progressColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("progress"));
    	
//    	progressColumn.setCellValueFactory(new Callback<CellDataFeatures<Task,String>, ObservableValue<String>>() {
//			@Override
//			public ObservableValue<String> call(CellDataFeatures<Task, String> arg0) {
//				
//				return Bindings.concat(arg0.getValue().progressProperty(),"%");
//			}
//		});
    	//hetzelfde als hierboven maar met
    	//lambda expression ->
    	progressColumn.setCellValueFactory(rowdata -> Bindings.concat(rowdata.getValue().progressProperty(),"%"));
    	
    	tasks.addAll(new Task(1,"learn javafx","high",75),(new Task(2,"learn more","medium",50)));
// bij selectie komt de taak vanonder in currenttask om te bewerken dmv methode setcurrenttask   	
    	tasksTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Task>() {
    		@Override
			public void changed(ObservableValue<? extends Task> observable, Task oldValue, Task newValue) {
				setCurrentTask(newValue);
				
			}
			});
  //bij selectie in table verandert tekst op de knop naar update
    	
    	StringBinding addButtonTextBinding= new StringBinding() {
    		{
    		super.bind(currentTask.idProperty());
    		}
			@Override
			protected String computeValue() {
				return currentTask.getId()==null ? "Add" : "Update";
			}
		};
		add.textProperty().bind(addButtonTextBinding);
		
		add.disableProperty().bind(Bindings.greaterThan(3, currentTask.descriptionProperty().length()));
		
    	add.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				System.out.println("filter1= "+arg0.getEventType().getName());
			//door consume eindigt het event van mouseclick
				arg0.consume();
			}
		});
    	
    	add.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				System.out.println("eventhandler1: "+arg0.getEventType().getName());
				
			}
		});
    	
    }
   //methode gebruikt voor selectie weer te geven
    	private void setCurrentTask(Task newValue) {
			currentTask.setDescription(newValue.getDescription());
			currentTask.setPriority(newValue.getPriority());
			currentTask.setProgress(newValue.getProgress());
			currentTask.setId(newValue.getId());
		}
    	
    	
    	
    
    }

