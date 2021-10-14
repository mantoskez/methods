
import java.util.Scanner;
import java.util.Random;

public class Kodävetyr3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean gameOn = true;
        int points = 0;

        System.out.println("################ \"YATZEE\" ############");
        System.out.println();
        System.out.println("Enter your name");
        System.out.print(">>>>>>>> ");
        String name = input.nextLine();
        System.out.printf("Hey %s, welcome to the \"YATZEE\"\n", name);

        while (gameOn) {
            System.out.println("1. Throw the dice");
            System.out.println("2. Quit the game");

            int menuchoice = input.nextInt();

            switch (menuchoice) {
                case 1:
                    points += game();

                    break;
                case 2:
                    System.out.printf("Thank you for a game %s\n ", name);
                    gameOn = false;
                    break;
                default:
                    System.out.println("Wrong choice, options are 1 or 2");
            }
        }
    }

    public static int throwDie() {
        Random random = new Random();
        int dice = random.nextInt(6) + 1;

        return dice;
    }


    public static int[] throwFiveDice(int numberOfDice) {
        int[] fiveDice = new int[numberOfDice];
        for (int i = 0; i < numberOfDice; i++) {
            fiveDice[i] = throwDie();
        }
        return fiveDice;
    }

    public static int sumNumbers(int[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    public static int numberOfValue(int []arrayToSearch, int searchingFor) {
        int numbersOfPairs = 0;

        for (int i = 0; i < arrayToSearch.length; i++) {
            if (arrayToSearch[i] == searchingFor) {
                numbersOfPairs++;
            }
        }
        return numbersOfPairs;
    }

    public static int game (){
        int points = 0;
        System.out.println("Dice show:");
        int[] myFiveDice = throwFiveDice(5);
        for (int i = 0; i < myFiveDice.length; i++) {
            System.out.printf("%d", myFiveDice[i]);
            System.out.println();
        }
        int total = sumNumbers(myFiveDice);
        System.out.print(">>>> ");
        System.out.println("Your score is " + total);

        int[] combination = new int [6]; // why here is array to 6

        int search = 1;

        for(int i = 0; i < combination.length; i++){
            combination[i] = numberOfValue(myFiveDice, search);
            search++;
        }
        int numberOfPairs = 0;
        int numberOfThrees = 0;
        int numberOfFours = 0;
        int numberOfFives = 0;
        int singleNumber = 0;

        for (int i = 0; i < combination.length; i++) {

            if (combination[i] == 2){
                numberOfPairs++;
            } else if (combination[i] == 3){
                numberOfThrees++;
            } else if (combination[i] == 4){
                numberOfFours++;
            } else if (combination[i] == 5){
                numberOfFives++;
            } else if (combination[i] == 1){
                singleNumber++;
            }
        }

        if (numberOfPairs == 1 && numberOfThrees == 1){
            System.out.println("You got full house!");
            points = total;
            } else if(numberOfPairs==1){
                System.out.println("You got one pair!");
            } else if (numberOfPairs==2){
                System.out.println("You got two pairs!");
            } else if (numberOfThrees==1){
                System.out.println("You got three of the kind!");
            } else if (numberOfFours==1){
                System.out.println("You got four of the kind!");
            } else if (numberOfFives==1){
                System.out.println("Yatzee!!!");
            } else if (combination[0]==1 && combination[1]==1 && combination[2]==1 && combination[3]==1 && combination[4]==1){
                System.out.println("You have a low straight");
                points = total;
            } else if (combination[1]==1 && combination[2]==1 && combination[3]==1 && combination[4]==1 && combination[5]==1){
                System.out.println("You have a high straight");
                points = total;
        }
        else System.out.println("You have no combination");


        return points;



    }


}







