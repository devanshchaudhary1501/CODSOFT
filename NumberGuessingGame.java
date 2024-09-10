import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
    private static final int MAX_ATTEMPTS = 10;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean playAgain;
        int totalRounds = 0;
        int totalWins = 0;

        do {
            totalRounds++;
            int attempts = startGame();
            if (attempts <= MAX_ATTEMPTS) {
                totalWins++;
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
            } else {
                System.out.println("Sorry, you did not guess the number within the maximum attempts.");
            }
            
            System.out.println("Would you like to play another round? (yes/no)");
            String response = scanner.nextLine();
            playAgain = response.equalsIgnoreCase("yes");
        } while (playAgain);

        System.out.println("Game Over! You played " + totalRounds + " rounds and won " + totalWins + " rounds.");
    }

    private static int startGame() {
        Random random = new Random();
        int numberToGuess = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
        int attempts = 0;
        boolean guessedCorrectly = false;

        while (attempts < MAX_ATTEMPTS && !guessedCorrectly) {
            System.out.println("Enter your guess (" + (MAX_ATTEMPTS - attempts) + " attempts remaining): ");
            int userGuess = getUserGuess();
            attempts++;

            if (userGuess == numberToGuess) {
                guessedCorrectly = true;
            } else if (userGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }
        return attempts;
    }

    private static int getUserGuess() {
        while (true) {
            try {
                int guess = Integer.parseInt(scanner.nextLine());
                if (guess >= MIN_NUMBER && guess <= MAX_NUMBER) {
                    return guess;
                } else {
                    System.out.println("Please enter a number between " + MIN_NUMBER + " and " + MAX_NUMBER + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}

