package letterFrequency;

import java.util.HashMap;
import java.util.Map;

/*
    Task
    Given an text, count the occurrences of each letter (including punctuation).
 */
public class LetterFrequency {
    public static void solveProblem() {

        String text = "Yeah yeah yeah yeah yeah\n" +
                "Yeah yeah yeah yeah yeah yeah\n" +
                "I think I did it again\n" +
                "I made you believe we're more than just friends\n" +
                "Oh baby\n" +
                "It might seem like a crush\n" +
                "But it doesn't mean that I'm serious\n" +
                "'Cause to lose all my senses\n" +
                "That is just so typically me\n" +
                "Oh baby, baby\n" +
                "Oops, I did it again\n" +
                "I played with your heart, got lost in the game\n" +
                "Oh baby, baby\n" +
                "Oops, you think I'm in love\n" +
                "That I'm sent from above\n" +
                "I'm not that innocent";

        System.out.println("Example text : \n\n" + text);

        System.out.println("\n\nLetter Frequency : \n\n" + giveLetterFrequency(text));

    }

    private static String giveLetterFrequency(String text) {

        Map frequency = new HashMap<>();
        char[] letters = text.toCharArray();

        for (char letter : letters) {

            // Is the letter already met ? No -> create it and initialize to 0
            if (frequency.size() == 0 || !frequency.containsKey(letter)){

                frequency.put(letter, 1);

            } else {  //Yes -> add 1 iteration,
                frequency.replace(letter, frequency.get(letter), (int )frequency.get(letter) + 1);
            }

        }

        return frequency.toString();

    }
}
