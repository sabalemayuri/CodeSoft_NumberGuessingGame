import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        boolean playAgain = true;

        System.out.println("=====================================");
        System.out.println("   WELCOME TO THE NUMBER GUESSING GAME");
        System.out.println("=====================================");

        while (playAgain) {
            int lowerBound = 1;
            int upperBound = 100;
            int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;

            int maxAttempts = 7;
            int attemptsUsed = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI'm thinking of a number between " + lowerBound + " and " + upperBound + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attemptsUsed < maxAttempts && !guessedCorrectly) {
                System.out.print("\nEnter your guess: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("That's not a valid number. Try again.");
                    scanner.next(); 
                    continue;
                }

                int guess = scanner.nextInt();
                attemptsUsed++;

                if (guess < numberToGuess) {
                    System.out.println("Too low!");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    guessedCorrectly = true;
                    System.out.println("Correct! You guessed it in " + attemptsUsed + " attempt(s).");

                    
                    int roundScore = Math.max((maxAttempts - attemptsUsed + 1) * 10, 10);
                    totalScore += roundScore;
                    System.out.println("You earned " + roundScore + " points this round.");
                }

                int attemptsLeft = maxAttempts - attemptsUsed;
                if (!guessedCorrectly && attemptsLeft > 0) {
                    System.out.println("Attempts left: " + attemptsLeft);
                }
            }

            if (!guessedCorrectly) {
                System.out.println("\nOut of attempts! The number was: " + numberToGuess);
            }

            System.out.println("Total score so far: " + totalScore);

            System.out.print("\nDo you want to play again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("y");
        }

        System.out.println("\n=====================================");
        System.out.println("Thanks for playing! Final score: " + totalScore);
        System.out.println("=====================================");

        scanner.close();
    }
}