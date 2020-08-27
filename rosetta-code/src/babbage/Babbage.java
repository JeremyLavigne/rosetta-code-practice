package babbage;

import java.util.ArrayList;

/*
 * 
	 Charles Babbage, looking ahead to the sorts of problems his Analytical Engine would be able to solve, gave this example:
	
	What is the smallest positive integer whose square ends in the digits 269,696?
	— Babbage, letter to Lord Bowden, 1837; see Hollingdale and Tootill, Electronic Computers, second edition, 1970, p. 125.
	He thought the answer might be 99,736, whose square is 9,947,269,696; but he couldn't be certain.
	
	
	
	Task[edit]
	The task is to find out if Babbage had the right answer — and to do so, as far as your language allows it, in code that Babbage himself would have been able to read and understand. As Babbage evidently solved the task with pencil and paper, a similar efficient solution is preferred.
	
	For these purposes, Charles Babbage may be taken to be an intelligent person, familiar with mathematics and with the idea of a computer; he has written the first drafts of simple computer programmes in tabular form. [Babbage Archive Series L].
	
	
	
	Motivation
	The aim of the task is to write a program that is sufficiently clear and well-documented for such a person to be able to read it and be confident that it does indeed solve the specified problem.  
 
 */


public class Babbage {

	public static void solveProblem() {
		
 	  // Only numbers ending with 4 & 6 have a square ending by 6 - Don't consider others
		
		ArrayList<Integer> squareEndingBy6 = new ArrayList<>();
		squareEndingBy6.add(4);
		squareEndingBy6.add(6);
		
		ArrayList<Integer> squareEndingBy96 = WhichNumbersHaveSquareEndingBy96(squareEndingBy6);
		System.out.println("Ending by 96 : " + squareEndingBy96);
	
	  // Only numbers ending with 14, 36, 64, 86 have a square ending by 96 - Don't consider others
		
		ArrayList<Integer> squareEndingBy696 = WhichNumbersHaveSquareEndingBy696(squareEndingBy96);
		System.out.println("Ending by 696 : " + squareEndingBy696);
		
	  // Only numbers ending by 264, 764, 236, 736 have a square ending by 696 - Don't consider others

		ArrayList<Integer> squareEndingBy9696 = WhichNumbersHaveSquareEndingBy9696(squareEndingBy696);
		System.out.println("Ending by 9696 : " + squareEndingBy9696);
		
	  // Only numbers ending by 264, 5264, 2764, 7764, 2236, 7236, 4736, 9736 have a square ending by 9696 - Don't consider others

		ArrayList<Integer> squareEndingBy69696 = WhichNumbersHaveSquareEndingBy69696(squareEndingBy9696);
		System.out.println("Ending by 69696 : " + squareEndingBy69696);
		
		System.out.println("\n\nBabbage were unfortunately wrong, the smallest positive integer whose square ends \nin the digits 269,696 was 25264");
		
	}

	private static ArrayList<Integer> WhichNumbersHaveSquareEndingBy96(ArrayList<Integer> squareEndingBy6) {
		
		ArrayList<Integer> squareEndingBy96 = new ArrayList<>();
		
		// for each number to test,
		for (int i=0 ; i < squareEndingBy6.size() ; i ++ ) {
			
			// test every dizaines (14, 24, 34, ..),
			for (int j=squareEndingBy6.get(i); j < 100 ; j += 10) {
				
				String result = Integer.toString(j*j);
				
				// and watch for the last numbers, if it ends by 96, save it
				if (result.substring(result.length() - 2).equals("96")) {
					squareEndingBy96.add(j);
				}
			}
		}
			
		return squareEndingBy96;
	}
	
	private static ArrayList<Integer> WhichNumbersHaveSquareEndingBy696(ArrayList<Integer> squareEndingBy96) {
		
		ArrayList<Integer> squareEndingBy696 = new ArrayList<>();
		
		// for each number to test,
		for (int i=0 ; i < squareEndingBy96.size() ; i ++ ) {
			
			// test every centaines (114, 214, 314, ..),
			for (int j=squareEndingBy96.get(i); j < 1000 ; j += 100) {
				
				String result = Integer.toString(j*j);
				
				// and watch for the last numbers, if it ends by 696, save it
				if (result.substring(result.length() - 3).equals("696")) {
					squareEndingBy696.add(j);
					
					// check if the numbers ends by 269,696, if yes, print it
					if (result.length() >= 6 && result.substring(result.length() - 6).equals("269696")) {
						System.out.println("This is it, we find it ! number is : " + j);
					}
				}
			}
		}
			
		return squareEndingBy696;
	}

	private static ArrayList<Integer> WhichNumbersHaveSquareEndingBy9696(ArrayList<Integer> squareEndingBy696) {
		
		ArrayList<Integer> squareEndingBy9696 = new ArrayList<>();
		
		// for each number to test,
		for (int i=0 ; i < squareEndingBy696.size() ; i ++ ) {
			
			// test every thousand (264, 1264, 2264, ..),
			for (int j=squareEndingBy696.get(i); j < 10000 ; j += 1000) {
				
				String result = Integer.toString(j*j);
				
				// and watch for the last numbers, if it ends by 9696, save it
				if (result.substring(result.length() - 4).equals("9696")) {
					squareEndingBy9696.add(j);
					
					// check if the numbers ends by 269,696, if yes, print it
					if (result.length() >= 6 && result.substring(result.length() - 6).equals("269696")) {
						System.out.println("This is it, we find it ! number is : " + j);
					}
				}
			}
		}
			
		return squareEndingBy9696;
	}
	
	private static ArrayList<Integer> WhichNumbersHaveSquareEndingBy69696(ArrayList<Integer> squareEndingBy9696) {
		
		ArrayList<Integer> squareEndingBy69696 = new ArrayList<>();
		
		// for each number to test,
		for (int i=0 ; i < squareEndingBy9696.size() ; i ++ ) {
			
			// test every thousand (264, 1264, 2264, ..),
			for (int j=squareEndingBy9696.get(i); j < 100000 ; j += 10000) {
				
				String result = Integer.toString(j*j);
				
				// and watch for the last numbers, if it ends by 9696, save it
				if (result.substring(result.length() - 5).equals("69696")) {
					squareEndingBy69696.add(j);
					
					// check if the numbers ends by 269,696, if yes, print it
					if (result.length() >= 6 && result.substring(result.length() - 6).equals("269696")) {
						System.out.println("This is it, we find it ! number is : " + j);
					}
				}
			}
		}
			
		return squareEndingBy69696;
	}
}
