package hundredDoors;

import java.util.ArrayList;

/*
 
    There are 100 doors in a row that are all initially closed.

	You make 100 passes by the doors.

	The first time through, visit every door and  toggle  the door  (if the door is closed,  open it;   if it is open,  close it).

	The second time, only visit every 2nd door   (door #2, #4, #6, ...),   and toggle it.

	The third time, visit every 3rd door   (door #3, #6, #9, ...), etc,   until you only visit the 100th door.



	Task
	Answer the question:   what state are the doors in after the last pass?   Which are open, which are closed?
	
 */



public class HundredDoors {

	public static void solveProblem() {
		
		ArrayList<Door> doors = setDoors();
		
		// Loop with 100 iterations, symbolizing the 100 passes by the doors
		for (int i = 1; i <= 100; i++) {
			
			// Toggle every door which is a multiple of i
			for (int j=i; j<=100; j+=i) {
				
				doors.get(j-1).toggle(); // (j-1) = indice of door number j
				
			}
		}
		
		// Print the state of every door
		/*
		for (int i = 0; i < 100; i++) {
			
			System.out.println(doors.get(i));
			
		}
		*/
		
		// Or print only the number of open doors
		for (int i = 0; i < 100; i++) {
			
			if (doors.get(i).isOpen()) {
				
				System.out.println(doors.get(i));
				
			}

		}
		System.out.println("Others are closed");
		
		
		System.out.println("\n\n100 doors problem solved :)");
		
	}
	
	
	public static ArrayList<Door> setDoors() {
		ArrayList<Door> doors = new ArrayList<>();
		
		// Create 100 doors and add it to the list
		for (int i = 1; i <= 100; i++) {
		
			Door door = new Door(i);
			doors.add(door);
			
		}
		
		return doors;
	}
	
}
