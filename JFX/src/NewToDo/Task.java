package NewToDo;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Task {

	private StringProperty priority = new SimpleStringProperty();
	private StringProperty description = new SimpleStringProperty();
	private ObjectProperty<Integer> progress = new SimpleObjectProperty<>(0);
	private final ObjectProperty<Integer> id = new SimpleObjectProperty<>();
	
	

	public Task() {}
	
	public Task(Integer id,String description, String priority, Integer progress) {
		this.id.set(id);
		this.description.set(description);
		this.priority.set(priority);
		this.progress.set(progress);
	}
	
	public StringProperty priorityProperty() {
		return priority;
	}
	
	public String getPriority() {
		return priority.get();
	}
	public void setPriority(String priority) {
		this.priority.set(priority);
	}
	public String getDescription() {
		return description.get();
	}
	public void setDescription(String description) {
		this.description.set(description); 
	}
	public StringProperty descriptionProperty() {
		return description;
	}
	public ObjectProperty<Integer> progressProperty() {
		return progress;
	}
	public void setProgress(Integer progress) {
		this.progress.set(progress); 
	}
	public Integer getProgress() {
		return progress.get();
	}
	public Integer getId() {
		return id.get();
	}	
	public void setId(Integer id) {
		this.id.set(id);
	}
	public ObjectProperty<Integer> idProperty(){
		return id;
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
}
