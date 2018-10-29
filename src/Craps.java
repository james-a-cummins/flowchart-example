public class Craps {
    /**
     * These enums can be used to govern the status of the game
     */
    private enum Status {CONTINUE, WON, LOST};

    /**
     * We need to sound like we know what we are doing, so
     * define some cool sounding casino lingo
     */
    private static final int SNAKE_EYES = 2;
    //Final is a keyword that will make a variable unchangeable
    private static final int TREY = 3;
    private static final int YO_LEVEN = 11;
    private static final int BOX_CARS = 12;

    public static void main(String[] args)
    {
        Dice die1 = new Dice();
        Dice die2 = new Dice();


        int sumOfDice = die1.rollDice() + die2.rollDice();
        System.out.println("Sum of dice: " +sumOfDice);

        Status gameStatus;

        int myPoint=0;

        switch(sumOfDice){
            //These are the scenarios where the player wins
            case 7: //win with a 7 on the first roll
            case YO_LEVEN: //win with an 11 on the first roll
                gameStatus = Status.WON;
                break;

                //These are the scenarios where the player loses.

            case TREY:
            case SNAKE_EYES:
            case BOX_CARS:
                    gameStatus = Status.LOST;
                    break;

            default:
                gameStatus = Status.CONTINUE;
                myPoint=sumOfDice;
                System.out.printf("Point is %d%n", myPoint);
                break;
        }

        while (gameStatus == Status.CONTINUE){
            sumOfDice = die1.rollDice() + die2.rollDice();
            System.out.println("Sum of dice: " +sumOfDice);

            //check for a win
            if (sumOfDice == myPoint)
                gameStatus = Status.WON;


            if (sumOfDice == 7)
                gameStatus = Status.LOST;
        }//end of while loop

        //display the outcomes

        if (gameStatus == Status.WON)
            System.out.println("Player wins");
        else
            System.out.println("The house wins");
    }



}
