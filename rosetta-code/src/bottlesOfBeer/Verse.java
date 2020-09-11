package bottlesOfBeer;

public class Verse {
    private int howManyBottlesLeft;

    public Verse(int bottleNumber) {
        this.howManyBottlesLeft = bottleNumber;
    }

    @Override
    public String toString() {
        return howManyBottlesLeft + " bottles of beer on the wall\n" +
                howManyBottlesLeft + " bottles of beer\n" +
                "Take one down, pass it around\n" +
                (howManyBottlesLeft - 1) + " bottles of beer on the wall\n\n";
    }
}
