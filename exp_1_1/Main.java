import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int quitGame = 0;
        while (quitGame == 0) { //game loop
            int nextRound = 0,max = 100,min = 1;
            Random r = new Random();
            int answer = r.nextInt(99) + 1;
            Scanner input = new Scanner(System.in);
            System.out.println("Number guessing game. Please follow the instruction.");
            System.out.println("At anytime, you can also input 0 to start a new round or input -1 to quit.");
            while (nextRound == 0) {
                System.out.print("Please input a number between " + min + " and " + max + ": ");
                int guess = input.nextInt();
                if (guess < -1 || guess > 100) {
                    System.out.println("Incorrect input. Please input a number between " + min + " and " + max + ": ");
                } else if(guess == -1) {
                    nextRound = 1;
                    quitGame = 1;
                } else if (guess == 0) {
                    nextRound = 1;
                } else if (guess > answer) {
                    System.out.println("Your answer is too large.");
                    max = guess;
                } else if (guess == answer) {
                    System.out.println("Congratulations! Your answer is correct!");
                    System.out.println("Starting a new round...");
                    nextRound = 1;
                } else if (guess < answer) {
                    System.out.println("Your answer is too small.");
                    min = guess;
                }
            }
        }
    }
}