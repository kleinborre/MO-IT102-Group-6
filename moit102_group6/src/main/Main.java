package main;

public class Main {
	
	public static void insertionSort(String[] array) {
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

	public static void main(String[] args) {
		
		//List of Engine Numbers
		String engineNumber[] = {"142QVTSIUR","PZCT1S00XE","4VBTV8YNM7","95AN3AWVF4","483QHIM661","SPHA17SSEE","0AV7SWGX93","QMUB6UYLKL"};

        //Before Sorting
        System.out.println("Before Sorting:");
        for (String engine : engineNumber) {
            System.out.print(engine + " ");
        }       
        //Called Method
        Sorting s = new Sorting();
        insertionSort(engineNumber);
        
        //After Sorting 
        System.out.println("\n\nAfter Sorting:");
        for (String engine : engineNumber) {
            System.out.print(engine + " ");
        }
		
	}	
}
