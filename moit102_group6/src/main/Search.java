package main;

import java.util.Scanner;

public class Search{
	
	public static void main(String[] args) {
        
		// Call the scanner
		Scanner scan = new Scanner(System.in);
		
		// Store scanner result
		String target;
		
		// Inventory data
        String[][] inventory = {
            {"2/1/2023", "Old", "Honda", "142QVTSIUR", "On-hand"},
            {"2/1/2023", "Old", "Honda", "PZCT1S00XE", "Sold"},
            {"2/1/2023", "Old", "Honda", "4VBTV8YNM7", "Sold"},
            {"2/1/2023", "Old", "Honda", "95AN3AWVF4", "On-hand"},
            {"2/3/2023", "Old", "Kawasaki", "483QHIM661", "On-hand"},
            {"2/3/2023", "Old", "Kymco", "SPHA17SSEE", "On-hand"},
            {"2/3/2023", "Old", "Kymco", "0AV7SWGX93", "Sold"},
            {"2/4/2023", "Old", "Kymco", "QMUB6UYLKL", "Sold"},
            {"2/4/2023", "Old", "Honda", "V96GMTFFEI", "Sold"},
            {"2/5/2023", "Old", "Kawasaki", "4J8UA0FMVY", "Sold"},
            {"2/5/2023", "Old", "Kawasaki", "A8BDL926FA", "Sold"},
            {"2/5/2023", "Old", "Kawasaki", "X8G5ZZ7A69", "Sold"}
        };

        // Search for engine number
        System.out.print("Search Engine number: ");
        target = scan.nextLine();
        
        int result = linearSearch(inventory, target);

        // Display result
        if (result != -1) {
        	System.out.println();
            System.out.println("Engine number found at row " + result);
            System.out.println();
            System.out.println("ENGINE NUMBER " + target + " COMPLETE DETAILS");
            System.out.println("Date Entered :    " + inventory[result][0]);
            System.out.println("Stock Label  :    " + inventory[result][1]);
            System.out.println("Brand        :    " + inventory[result][2]);
            System.out.println("Status       :    " + inventory[result][4]);
            
        } else {
            System.out.println("Engine number not found.");
        }
        scan.close();
    }

    // Linear Search Function
    public static int linearSearch(String[][] inventory, String target) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i][3].equals(target)) { // Checking engine_number
                return i; // Return the index of the row where it matches
            }
        }
        return -1; // If not found, return -1
    }
}