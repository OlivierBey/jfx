package jfx;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableIntegerValue;
import javafx.beans.value.ObservableValue;

public class Listeners {
	public static void main(String[] args) {
		//javafx properties
				SimpleIntegerProperty intprop = new SimpleIntegerProperty();
				intprop.set(10);
				System.out.println(intprop.get());
				
				SimpleStringProperty stringProp = new SimpleStringProperty("Initial value");
				System.out.println(stringProp.get());
				
				ReadOnlyBooleanWrapper readonlybooleanwrapper = new ReadOnlyBooleanWrapper(true);
				ReadOnlyBooleanProperty readOnlyBooleanProperty = readonlybooleanwrapper.getReadOnlyProperty();
				System.out.println(readOnlyBooleanProperty);
				
		//listener		
				
				intprop.addListener(new ChangeListener<Number>() {
		//methode changed wordt uitgevoerd bij veranderen van intprop door 'luisteren'
					@Override
					public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
					System.out.println("listener 1:integer property is changed in "+newValue);
					System.out.println("oldvalue was "+oldValue);
					}
					
				});
				
//				intprop.set(25);
//				intprop.set(100);
				
				intprop.addListener(new ChangeListener<Number>() {
					
					@Override
					public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
					System.out.println("listener 2:integer property is changed in "+newValue);
					System.out.println("oldvalue was "+oldValue);
								}
								
							});
				
				
				
		//invalidationlistener wordt altijd als eerste uitgevoerd
			//anonieme classe van invalidationlistener gebruiken omdat maar 1 keer gebruikt	
				
				intprop.addListener(new InvalidationListener() {
					
					@Override
					public void invalidated(Observable arg0) {
						System.out.println("-------    intprop changed     ------------");
						
					}
				});
				
				intprop.set(25);
				intprop.set(100);
}}
