package SnakeAndLadder.services;

public class DiceService {
    public static int rollDice(int numOfDice){
        int min = 1;
        int max = numOfDice*6; // one dice can have max value as 6 eg = if 2 dice are there 2*6 = 12
        return (int) (Math.random() *(max-min+1)+min); // formula to create random number
    }
}

// https://www.baeldung.com/java-generating-random-numbers-in-range
