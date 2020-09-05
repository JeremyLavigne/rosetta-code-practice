package dateFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
    Task
    Display the   current date   in the formats of:

      2007-11-23 and  Friday, November 23, 2007
 */

public class DateFormat {
    public static void solveProblem() {

        String[] todayDate = getFormattedDates();
        System.out.println("Today is : " + todayDate[0] + ", or if you prefer " + todayDate[1] + ".");
    }

    private static String[] getFormattedDates() {
        String[] todayDate = new String[2];

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy");

        todayDate[0] = date.format(format1);
        todayDate[1] = date.format(format2);

        return todayDate;
    }
}
