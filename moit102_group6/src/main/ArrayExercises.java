package main;

import java.util.Scanner;

public class ArrayExercises{
	
	Scanner s = new Scanner(System.in);
	
	public void exercise1() {
		
		//Write a Java program that sums the array's values with the following elements: 25, 4, 16, 9, 10.
		
		int[] addition = new int[5];
		
		addition[0] = 25;
		addition[1] = 4;
		addition[2] = 16;
		addition[3] = 9;
		addition[4] = 10;
		
		//int sum = addition[0] + addition[1] + addition[2] + addition[3] + addition[4];
		
		int sum = 0;
		
		for(int i = 0; i < addition.length; i++) {
			sum += addition[i];
		}
		
		System.out.println();
		System.out.println("Exercise # 1");
		System.out.println("The sum of the array's addition is: " + sum + "\n");
	}
	
	public void exercise2() {
		
		//Exercise 2: Write a Java program to test if an array contains a specific value. Create an array with five elements.
		System.out.println("Exercise # 2");
		
		int[] value = {1,2,3,4,5};
		
		System.out.print("Enter a number: ");
		int guess = s.nextInt();
		
		boolean found = false;
		
		for(int i = 0; i < value.length; i++) {
			if(guess == value[i]) {
				found = true;
				break;
			}
		}
		
		if(found) {
			System.out.println("Yes, the number " + guess + ", is in the array of value.");
		}else {
			System.out.println("Sorry, the number " + guess + ", unfortunately, is not included in the array of value.");
		}
	}
	
	public void exercise3() {
		
		//Exercise 3: Write a Java program that creates an array of 5 integers and prompts the user to enter 5 integer values to fill the array.
		//The program should then find the sum of all the elements in the array and print the result.
		
		System.out.println();
		System.out.println("Exercise # 3");
		
		int[] numbers = new int[5];
		
		System.out.println("Enter the five integers for the array");
		
		for(int i = 0; i < numbers.length; i++) {
			System.out.print("Enter Value #" + (i+1) + " : ");
			numbers[i] = s.nextInt();		
		}
		
		int sum = 0;
		
		for(int i = 0; i < numbers.length; i++) {			
			sum += numbers[i];
		}
		
		System.out.print("The total for sum for numbers array is: " + sum);
		s.close();
	}
	
}