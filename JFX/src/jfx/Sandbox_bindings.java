package jfx;

import javax.management.remote.SubjectDelegationPermission;

import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableIntegerValue;

public class Sandbox_bindings {

	public static void main(String[] args) {
		
		StringProperty lastnameprop = new SimpleStringProperty();
		StringProperty surnameprop = new SimpleStringProperty();
		
//		surnameprop.bind(lastnameprop);
		surnameprop.bindBidirectional(lastnameprop);
		lastnameprop.set("Patrick");
		System.out.println(surnameprop.get());
		surnameprop.set("Ster");
		System.out.println(lastnameprop.get());
		
		StringProperty fullname = new SimpleStringProperty();
		StringProperty firstname = new SimpleStringProperty("Niels");
		StringProperty lastname = new SimpleStringProperty("De Groot");
//voornaam en achternaam binden in naam		
		fullname.bind(Bindings.concat(firstname," ",lastname));
		System.out.println(fullname.get());
		firstname.set("Nielske");
		lastname.set(" De Zot");
		System.out.println(fullname.get());
//area berekenen lengte*breedte
		IntegerProperty length = new SimpleIntegerProperty(18);
		IntegerProperty width = new SimpleIntegerProperty(13);
		IntegerProperty area = new SimpleIntegerProperty();
		//high level binding
		area.bind(length.multiply(width));
		System.out.println(area.get());
		
		NumberBinding perimeter = length.add(width).multiply(2);
		System.out.println(((ObservableIntegerValue) perimeter).get());
		//lowlevel binding
		DoubleProperty radius=new SimpleDoubleProperty(1.5);
		DoubleBinding volumeBinding= new DoubleBinding() {
			{
				super.bind(radius);
			}
			
			@Override
			protected double computeValue() {
				
				return 4/3*Math.PI*Math.pow(radius.get(), 3);
			}
		};//anonieme classe sluiten met;
		System.out.println(volumeBinding.get());
		radius.set(2.5);
		System.out.println(volumeBinding.get());
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
