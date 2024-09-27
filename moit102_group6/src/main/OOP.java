package main;

// This is a Class

public class OOP extends OOP1{
	
	// A Class is like a blueprint for making an object
	// An object/method is like objects in real life. It makes the class functional.
	
	// This is a variable
	//String name;
	
	
	// This is an object or a method
	//public void sayName() {
		//System.out.println("My Name");
	//}
	
	//Polymorphism is using the same name of a method but with different functions
	//public void sayName(String a) {
		//System.out.println("My name is" + name);
	//}
	
	//public void sayHi() {
		
	//}
	
	//This is an example of encapsulation
	private String flavor;
	
	//This method is created so that we can use and set the private String flavor
	public void setFlavor(String newFlavor) {
		flavor = newFlavor;
	}
	
	//This method is created so that we can use and display the set private String flavor
	public String getFlavor() {
		return flavor;
	}
	
}