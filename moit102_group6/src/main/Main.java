package main;

public class Main {

	public static void main(String[] args) {
		
		// create an array
		int[] age = {1,2,3,4,5};
		
		// accessing each element inside the array
		
		System.out.println("The element is: " + age[0]);
		System.out.println("The element is: " + age[1]);
		System.out.println("The element is: " + age[2]);
		System.out.println("The element is: " + age[3]);
		System.out.println("The element is: " + age[4]);
		System.out.println();
		
		// or we can do this using for loop
		
		for(int num : age) {
			System.out.println("The element is: " +  num );
		}
		
		// For Array Exercises
		ArrayExercises ae = new ArrayExercises();
		// Exercise No.1
		ae.exercise1();
		
		// Exercise No. 2
		ae.exercise2();
		
		//
		ae.exercise3();
	}
}
