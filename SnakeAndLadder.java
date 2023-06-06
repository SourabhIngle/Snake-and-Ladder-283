package com.sankeandladder;

public class SnakeAndLadder {

    static int playerPosition = 0;
    static int dice = 0;
    static int option = 0;
    static int noPlay = 1;
    static int ladder = 2;
    static int snake = 3;
    static int win = 100;
    static void gettingOptionSnakeLadderAndNoPlay() {
        option = (int) Math.floor(Math.random() * 10) % 3 + 1;
    }
    static int rollDice()
    {
        dice = (int) Math.floor(Math.random() * 10) % 6 + 1;
        return dice ;
    }

    static void ensureGettingExactPosition() {
        if (playerPosition > 100) {
            System.out.println("sorry, your dice is " + dice + " " +
                    "and player position is " + playerPosition + " out of the win position" +
                    " try again better luck next time to get the right number");
            playerPosition = playerPosition - dice;
        }
    }

    static void playerCondition() {
        if (noPlay == option) {
            System.out.println("(NO-PLAY)=> NO LADDER, NO SNAKE, JUST POSITION");
            System.out.println();
        }

        if (ladder == option) {
            System.out.println("YOU GOT A LADDER");
            if (playerPosition + dice <= 100) {
                playerPosition = playerPosition + dice;
                System.out.println("+" + dice);
                System.out.println("yes, You got a Ladder now your position is " + playerPosition);
                System.out.println();
            }
        }

        if (snake == option) {
            playerPosition = playerPosition - (dice + dice);
            if (playerPosition < 0) {
                System.out.println("OH NO, SNAKE APPEAR");
                System.out.println("It is not possible to assign " + playerPosition + " negative position ");
                playerPosition = 0;
                System.out.println("Now your position going to be " + playerPosition);
                System.out.println();
            }
            if (playerPosition - dice < 100 && playerPosition - dice > 0) {
                System.out.println("OH NO, SNAKE APPEAR");

                System.out.print("-");
                System.out.println(dice + dice);
                System.out.println("Sorry, Snake bites you now your position " + playerPosition);
            }
        }
        System.out.println("-------------------------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("Player position stating from " + playerPosition);
        System.out.println("Player position stating from " + playerPosition);
        while (playerPosition <= win) {
            rollDice();
            gettingOptionSnakeLadderAndNoPlay();
            System.out.println("Dice roll is " + rollDice());
            System.out.println("Your current Position is " + playerPosition);
            playerCondition();
        }

    }
}
    