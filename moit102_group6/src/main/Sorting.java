package main;

public class Sorting {
	
	public void insertionSort(String[] array) {
        int n = array.length;
        
        // Start from the second element (index 1)
        for (int i = 1; i < n; i++) {
            String key = array[i];
            int j = i - 1;
            
            // Compare the key with the previous elements in sorted order
            while (j >= 0 && array[j].compareTo(key) > 0) {
                array[j + 1] = array[j];  // Shift the element to the right
                j--;
            }
            
            // Place the key at the correct position
            array[j + 1] = key;
        }
    }
}