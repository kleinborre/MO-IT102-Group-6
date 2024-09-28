package main;

public class Main {

	public static void main(String[] args) {
		
		// The array below is not the actual MS1 array but for Demonstration purposes only.
		// This is just to test if the code for algorithms is working properly.
		// Feel free to change the array after cloning. Enjoy!
		
		int arr[] = { 12, 11, 13, 5, 6 };
		
		//Compile all the calling methods below;
		
		//For Sorting Method
		Sorting s = new Sorting();
		s.sort(arr);
		s.printArray(arr);
		
		
	}
}
