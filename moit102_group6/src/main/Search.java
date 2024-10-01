package main;

public class Search{
	
	public static void main(String[] args) {
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

        // Search for engine number "4VBTV8YNM7"
        String target = "4VBTV8YNM7";
        int result = linearSearch(inventory, target);

        // Display result
        if (result != -1) {
            System.out.println("Engine number found at row " + result);
            System.out.println("Date Entered: " + inventory[result][0] + ", Brand: " + inventory[result][2]);
        } else {
            System.out.println("Engine number not found.");
        }
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