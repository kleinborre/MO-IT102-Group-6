package main;

public class Sort{
	
	public static void main(String[] args) {
        // Sample data in a multi-dimensional array (from the provided data)
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

        // Print inventory before sorting
        System.out.println("Before Sorting:");
        for (String[] row : inventory) {
            System.out.println(String.join(", ", row));
        }

        // Call the insertion sort method to sort the inventory by brand
        insertionSort(inventory);

        // Print the sorted inventory
        System.out.println("\nAfter Sorting by Brand:");
        for (String[] row : inventory) {
            System.out.println(String.join(", ", row));
        }
    }

    // Method to sort the array using insertion sort by the brand column (Column 3)
    public static void insertionSort(String[][] data) {
        int n = data.length;
        for (int i = 1; i < n; i++) {
            String[] key = data[i];
            int j = i - 1;

            // Compare the brand name (data[j][2]) to the key's brand (key[2])
            while (j >= 0 && data[j][2].compareTo(key[2]) > 0) {
                data[j + 1] = data[j];
                j = j - 1;
            }
            data[j + 1] = key;
        }
    }
}