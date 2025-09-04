import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int numberToGuess = rand.nextInt(100) + 1; // random number between 1 and 100
        int userGuess = 0;
        int attempts = 0;
        int maxAttempts = 5;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have chosen a number between 1 and 100.");
        System.out.println("Try to guess it! You have 5 attempts."); 

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            userGuess = sc.nextInt();
            attempts++;

            if (userGuess == numberToGuess) {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                break;
            } else if (userGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }

            // Give hint only on the 2nd attempt
            if (attempts == 2) {
                int hintStart = Math.max(numberToGuess - 9, 1); // Start of range
                int hintEnd = numberToGuess;                     // End of range
                System.out.println("Hint: The number is between " + hintStart + " and " + hintEnd);
            }

            // Reveal number after 5 attempts
            if (attempts == maxAttempts && userGuess != numberToGuess) {
                System.out.println("Game Over! The number was: " + numberToGuess);
            }
        }

        sc.close();
    }
}
