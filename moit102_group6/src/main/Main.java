package main;

public class Main {

	public static void main(String[] args) {
		/*
		 loop 100 times (i)
		 if i div by 3 & 5: print "FIZZBUZZ"
		 if i div by 3: print "FIZZ"
		 if i div by 5: print "BUZZ"
		 if i div by 7: print "BAZZ"
		 else: print i
		 */
		
	
		for(int i = 1; i <= 100; i++) {
			
			String result = "";
			
			if(i % 3 == 0) result += "Fizz";
			if(i % 5 == 0) result += "Buzz";
			if(i % 7 == 0) result += "Bazz";

			System.out.println(result.isEmpty() ? i : result);
			// "?" short for if
			// ":" short for else
		}
		
		System.out.println("This is a test.");
		
	}
	
}
