package com.sankeandladder;

public class SnakeAndLadder {

    static int playerPosition = 0;
    static int dice = 0;
    static int option = 0;
    static final int noPlay = 1;
    static final int ladder = 2;
    static final int snake = 3;
    static final int win = 100;

    void gettingOptionSnakeLadderAndNoPlay() {
        option = (int) Math.floor(Math.random() * 10) % 3 + 1;
    }

    void rollDice() {
        dice = (int) Math.floor(Math.random() * 10) % 6 + 1;
    }

    void playerCondition() {
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

    void ensureGettingExactPosition() {
        if (playerPosition > 100) {
            System.out.println("sorry, your dice is " + dice + " " +
                    "and player position is " + playerPosition + " out of the win position" +
                    " try again better luck next time to get the right number");
            playerPosition = playerPosition - dice;
        }
    }


    public static void main(String[] args) {

        int diceRollCount = 0;
        System.out.println("Welcome to Snake and Ladder");
        System.out.println("Player Position Stating from " + playerPosition);
        com.sankeandladder.SnakeAndLadder method = new com.sankeandladder.SnakeAndLadder();

        while (playerPosition <= win) {

            //ROLL THE DICE GETTING 1 TO 6.
            method.rollDice();
            System.out.println("Dice roll is " + dice);
            System.out.println("Your current Position is " + playerPosition);

            //GETTING AN OPTION NO-PLAY ,SNAKE AND LADDER.
            method.gettingOptionSnakeLadderAndNoPlay();

            // FIRST ASSIGN PLAYER POSITION AFTER CHECK OPTIONS.
            playerPosition = playerPosition + dice;

            // HERE WE ARE CHECKING CONDITION PLAYER SNAKE , LADDER AND NO_PLAY.
            method.playerCondition();


            method.ensureGettingExactPosition();

            if (playerPosition == win) {
                System.out.println("Yes, you have reached the position is " + playerPosition + " .You are the winner.");
                break;
            }
            diceRollCount++;
        }
        System.out.println("Total dice rolls is " + diceRollCount);
    }
}
    