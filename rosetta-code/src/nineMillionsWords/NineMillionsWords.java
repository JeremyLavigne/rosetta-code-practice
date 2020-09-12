package nineMillionsWords;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
	
	This task is a variation of the short story by Arthur C. Clarke.
	
	(Solvers should be aware of the consequences of completing this task.)
	
	In detail, to specify what is meant by a   “name”:
	
	The integer 1 has 1 name     “1”.
	The integer 2 has 2 names   “1+1”,   and   “2”.
	The integer 3 has 3 names   “1+1+1”,   “2+1”,   and   “3”.
	The integer 4 has 5 names   “1+1+1+1”,   “2+1+1”,   “2+2”,   “3+1”,   “4”.
	The integer 5 has 7 names   “1+1+1+1+1”,   “2+1+1+1”,   “2+2+1”,   “3+1+1”,   “3+2”,   “4+1”,   “5”.
	
	
	Where row  n corresponds to integer  n, and each column  C 
	in row from left to right corresponds to the number of names beginning with  C
	
	Task
	Implement a function that returns the sum of the  n-th row.
	(Say differently, means : return how many "names" has the integer n)

*/



public class NineMillionsWords {

	public static void solveProblem() {
		
		List<String> integer1names = findAllNames(1);
		List<String> integer2names = findAllNames(2);
		List<String> integer3names = findAllNames(3);
		List<String> integer4names = findAllNames(4);
		List<String> integer5names = findAllNames(5);

		// Recursive option is probably not optimal, computer doesn't like as soon as we ask bigger numbers..
		// See maybe by digging with "Optionally note that the sum of the the n-th row is the "integer partition function.""
		
		//List<String> integer23names = findAllNames(23);

		
		
		System.out.println("The integer 1 has " + integer1names.size() + " names : " + integer1names.toString());
		System.out.println("The integer 2 has " + integer2names.size() + " names : " + integer2names.toString());
		System.out.println("The integer 3 has " + integer3names.size() + " names : " + integer3names.toString());
		System.out.println("The integer 4 has " + integer4names.size() + " names : " + integer4names.toString());
		System.out.println("The integer 5 has " + integer5names.size() + " names : " + integer5names.toString());
		//System.out.println("The integer 23 has " + integer23names.size() + " names : " + integer23names.toString());
		
	}

	/*
		Must(?) be a recursive function :
		  - The integer n have all (n-1) names, when adding + 1 at the end of each name
		  - The integer n have all (n-1) names, when one integer of the name is the next integer
		  - Then, we must remove the doubles
	*/
	private static List<String> findAllNames(int givenInteger) {
		
		List<String> names = new ArrayList<>();

		if (givenInteger == 1) {
			names.add("1");
			return names;
		}
		
		List<String> previousNames = findAllNames(givenInteger - 1);
		
		//  - The integer n have all (n-1) names, when adding + 1 at the end of each name
		for (int i = 0; i < previousNames.size(); i++) {
			names.add(previousNames.get(i) + "+1");
		}
		
		//  - The integer n have all (n-1) names, when one integer of the name is the next integer
		for (int i = 0; i < previousNames.size(); i++) {
			
			char [] charArrayName = previousNames.get(i).toCharArray();
			
			if (charArrayName.length == 1) {
				charArrayName[0] += 1;
				String newName = new String(charArrayName);
				names.add(newName);
			}
			
			for (int j = 0; j < charArrayName.length-1 ; j += 2) { 
				
				charArrayName[j] += 1;
				
				// Need to check if it is still a name (sum == integer)
				int sum = 1;

				for (int k = 0; k < charArrayName.length-1 ; k +=2) {
					sum += Character.getNumericValue(charArrayName[k]);
				}
				
				if (sum == givenInteger + 1 ) {
					// remove the last "+1"
					String newName = new String(charArrayName).substring(0, new String(charArrayName).length() - 2);
					names.add(newName);
				}
				
				if (sum == givenInteger ) {
					String newName = new String(charArrayName);
					names.add(newName);
				}
			}
		}
		
		//  - Then, we must remove the duplicates
        List<String> noDuplicatesNames = names.stream() 
        										.distinct() 
        										.collect(Collectors.toList()); 

		return noDuplicatesNames;
	}
}
