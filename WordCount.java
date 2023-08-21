import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 'text' to input text directly or 'file' to provide a file:");
        String inputType = scanner.nextLine().toLowerCase();

        String text = "";
        if (inputType.equals("text")) {
            System.out.println("Enter your text:");
            text = scanner.nextLine();
        } else if (inputType.equals("file")) {
            System.out.println("Enter the path to the file:");
            String filePath = scanner.nextLine();
            text = readFile(filePath);
        } else {
            System.out.println("Invalid input. Please enter 'text' or 'file'.");
            return;
        }

        String[] words = text.split("[\\s\\p{Punct}]+");
        int totalWordCount = words.length;
        
        // Optional: Ignore common words or stop words
        Set<String> stopWords = new HashSet<>(Arrays.asList("the", "and", "is", "of", "in", "to", "a"));
        int filteredWordCount = 0;
        for (String word : words) {
            if (!stopWords.contains(word.toLowerCase())) {
                filteredWordCount++;
            }
        }

        System.out.println("Total word count: " + totalWordCount);
        System.out.println("Word count after filtering: " + filteredWordCount);

        // Optional: Count frequency of each word
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }
        System.out.println("Word frequency: " + wordFrequency);
    }

    public static String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
        return content.toString();
    }
}
