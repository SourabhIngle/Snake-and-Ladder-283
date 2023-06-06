package com.sankeandladder;

public class SnakeAndLadder {

    static int playerPosition = 0;
    static int dice = 0;
    static int rollDice()
    {
        dice = (int) Math.floor(Math.random() * 10) % 6 + 1;
        return dice ;
    }

    public static void main(String[] args) {
        System.out.println("Player position stating from " + playerPosition);
        System.out.println("Dice roll is " + rollDice());
        System.out.println("Your current Position is " + playerPosition);
    }
}
    