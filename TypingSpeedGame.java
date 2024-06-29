import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TypingSpeedGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String sentence = "Well-formatted documents reflect professionalism and attention to detail. Use appropriate fonts, margins, and line spacing for readability. Create clear headings and subheadings to organize information. Utilize lists and tables to present data effectively.";
        System.out.println("Type the following sentence as fast as you can:");
        System.out.println(sentence);

        System.out.println("\nPress Enter when you're ready to start...");
        scanner.nextLine();

        long startTime = System.currentTimeMillis();

        String userInput = scanner.nextLine();

        long endTime = System.currentTimeMillis();

        if (userInput.equals(sentence)) {
            long timeTaken = endTime - startTime;
            long timeTakenInSeconds = TimeUnit.MILLISECONDS.toSeconds(timeTaken);

            int wordCount = sentence.split("\\s+").length;
            double wpm = (wordCount / (timeTakenInSeconds / 60.0));

            System.out.println("Time taken: " + timeTakenInSeconds + " seconds");
            System.out.println("Your typing speed is: " + wpm + " words per minute (WPM)");
        } else {
            System.out.println("The entered sentence is incorrect.");
        }

        scanner.close();
    }
}
