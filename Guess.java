import java.util.Random;
import java.util.Scanner;

public class Guess {
    public static void main(String[] args) {
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5;
        int score = 0;
        boolean playAgain = true;
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to Guess the Number Game!");
        
        while (playAgain) {
            System.out.println("I have generated a random number between " + minRange + " and " + maxRange + ".");
            
            Random random = new Random();
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            
            System.out.println("You have " + maxAttempts + " attempts to guess the number.");
            
            int attempt = 1;
            boolean guessedCorrectly = false;
            
            while (attempt <= maxAttempts) {
                System.out.print("Attempt " + attempt + ": Enter your guess: ");
                int guess = scanner.nextInt();
                
                if (guess == randomNumber) {
                    System.out.println("Congratulations! You guessed the number correctly.");
                    guessedCorrectly = true;
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("Your guess is lower than the generated number.");
                } else {
                    System.out.println("Your guess is higher than the generated number.");
                }
                
                attempt++;
            }
            
            if (!guessedCorrectly) {
                System.out.println("Sorry! You ran out of attempts. The number was: " + randomNumber);
            }
            
            score += maxAttempts - attempt + 1;
            System.out.println("Your score: " + score);
            
            System.out.print("Do you want to play again? (Y/N): ");
            String playAgainInput = scanner.next();
            
            if (!playAgainInput.equalsIgnoreCase("Y")) {
                playAgain = false;
            }
        }
        
        System.out.println("Thank you for playing Guess the Number Game!");
    }
}

