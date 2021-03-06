package bottlesOfBeer;

/*
    Task
    Display the complete lyrics for the song: 99 Bottles of Beer on the Wall.

        The beer song
        The lyrics follow this form:

        99 bottles of beer on the wall
        99 bottles of beer
        Take one down, pass it around
        98 bottles of beer on the wall

        98 bottles of beer on the wall
        98 bottles of beer
        Take one down, pass it around
        97 bottles of beer on the wall
        ... and so on, until reaching 0.


    Grammatical support for "1 bottle of beer" is optional.

 */
public class BottlesOfBeer {

    public static void solveProblem() {

        for (int i = 99; i > 0; i--) {
            System.out.println(new Verse(i));
        }
    }
}
