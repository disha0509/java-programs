import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int rounds = 0;
        int totalAttempts = 0;
        int roundsWon = 0;

        while (true) {
            System.out.println("\n--- New Round ---");
            rounds++;
            System.out.println("Round " + rounds);

            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = playRound(targetNumber, maxAttempts);

            totalAttempts += attempts;
            if (attempts <= maxAttempts) {
                roundsWon++;
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("\nGame Over! You played " + rounds + " rounds, won " + roundsWon + " rounds, and your average attempts per round was " + (double) totalAttempts / rounds);
    }

    public static int playRound(int targetNumber, int maxAttempts) {
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;

        while (attempts < maxAttempts) {
            System.out.print("Guess the number: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess < targetNumber) {
                System.out.println("Too low!");
            } else if (userGuess > targetNumber) {
                System.out.println("Too high!");
            } else {
                System.out.println("Congratulations! You guessed the number " + targetNumber + " correctly in " + attempts + " attempts.");
                return attempts;
            }
        }

        System.out.println("Sorry, you've reached the maximum number of attempts. The number was " + targetNumber + ".");
        return attempts;
    }
}
