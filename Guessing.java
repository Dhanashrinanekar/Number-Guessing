package task1;

import java.util.*;

public class Guessing {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 5; 
        int attempts = 0;
        int rounds = 1;
        int totalPoints = 0;

        System.out.println("Welcome to Guess the Number Game!!!");
        
        while (playAgain) {
            int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int points = 100; 

            System.out.println("\nRound " + rounds);
            System.out.println("I have selected a number between " + lowerBound + " and " + upperBound + ".");
            System.out.println("You have " + maxAttempts + " attempts. Can you guess it?");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You've guessed the correct number in " + attempts + " attempts.");
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low!!! Try guessing a higher number.");
                } else {
                    System.out.println("Too high!!! Try guessing a lower number.");
                }

                points = points-10;
            }

            totalPoints += points;
            System.out.println("The correct number was: " + randomNumber);
            System.out.println("Total points earned in this round: " + points);
            
            System.out.println("Do you want to play again? (yes/no):");
            String playAgainInput = sc.next();
            if (!playAgainInput.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
            
            attempts = 0;
            rounds++;
        }
        
        System.out.println("Total points earned in all rounds: " + totalPoints);
        System.out.println("Thanks for playing!");
        sc.close();
    }
}
