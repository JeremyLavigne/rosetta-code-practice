package convertSeconds;

/*
	Task
	Write a function or program which:
	
	Takes a positive integer representing a duration in seconds as input (e.g., 100), and
	returns a string which shows the same duration decomposed into weeks, days, hours, minutes, and seconds as detailed below (e.g., "1 min, 40 sec").
	
	Demonstrate that it passes the following three test-cases:
	
	Test Cases
	
	input number =>	output string
	7259	=> "2 hr, 59 sec"
	86400	=> "1 d"
	6000000	=> "9 wk, 6 d, 10 hr, 40 min"
	
	Details
	
	The following five units should be used:
	
	week	=> wk	1 week = 7 days
	day		=> d	1 day = 24 hours
	hour	=> hr	1 hour = 60 minutes
	minute	=> min	1 minutes = 60 seconds
	second	=> sec	
	
	However, only include quantities with non-zero values in the output (e.g., return "1 d" and not "0 wk, 1 d, 0 hr, 0 min, 0 sec").
	Give larger units precedence over smaller ones as much as possible (e.g., return 2 min, 10 sec and not 1 min, 70 sec or 130 sec)
	Mimic the formatting shown in the test-cases (quantities sorted from largest unit to smallest and separated by comma+space; value and unit of each quantity separated by space).
	
 */


public class ConvertSeconds {

	public static void solveProblem() {
		
		System.out.println("7259 secondes => " + secondsToDuration(7259));
		System.out.println("86 000 secondes => " + secondsToDuration(86400));
		System.out.println("6 000 000 secondes => " + secondsToDuration(6000000));
		
	}

	private static String secondsToDuration(int input) {
		
		// Process : Start from the end and go left (sec - min - h ...)
		
		
		// First, seconds
		int seconds = input % 60;
		int rest = (input - seconds)/60; // rest will be an int, can not be a double

		// Then minutes
		int minutes = rest % 60;
		rest = (rest - minutes)/60;
		
		// Then hours
		int hours = rest % 24;
		rest = (rest - hours)/24;
		
		// Then days
		int days = rest % 7;
		rest = (rest - days)/7;
		
		// Then weeks
		int weeks = rest; // Assuming regarding the task we do not go further 
				
		//System.out.println(seconds + "s - " + minutes + "m - " + hours + "h - " + days + "d - " + weeks + "w - ");
		
		
		
		// Now build the String to return starting from the beginning and go right (week - d - h ...)
		
		// First weeks
		String conversion = (weeks == 0) ? "" : weeks + " wk";
		
		// Need comma ? 
		conversion += (weeks != 0 && (days != 0 || hours != 0 || minutes != 0 || seconds != 0)) ? ", " : "";
		
		// Then days
		conversion += (days == 0) ? "" : days + " d";
			
		// Need comma ? 
		conversion += (days != 0 && (hours != 0 || minutes != 0 || seconds != 0)) ? ", " : "";
				
		// Then hours
		conversion += (hours == 0) ? "" : hours + " hr";
		
		// Need comma ? 
		conversion += (hours != 0 && (minutes != 0 || seconds != 0)) ? ", " : "";
		
		// Then minutes
		conversion += (minutes == 0) ? "" : minutes + " min";
		
		// Need comma ? 
		conversion += (minutes != 0 && seconds != 0) ? ", " : "";
				
		// Then seconds
		conversion += (seconds == 0) ? "" : seconds + " sec";
		
		
		return conversion;
	}

}
