import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

/**
 * Hello World example for GitHub Copilot in Java
 * Try typing comments like "// Method to print hello world"
 * and see how Copilot suggests the implementation
 */
public class HelloWorld {
    
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    
    /**
     * Method to print a greeting message
     */
    public static void printGreeting() {
        System.out.println("Hello, GitHub Copilot!");
    }
    
    /**
     * Method to get user name from input
     */
    public static String getUserName() {
        System.out.print("Please enter your name: ");
        return scanner.nextLine();
    }
    
    /**
     * Method to greet a specific user
     */
    public static void greetUser(String name) {
        System.out.println("Hello, " + name + "! Welcome to GitHub Copilot examples.");
    }
    
    /**
     * Method to display current date and time
     */
    public static void displayCurrentDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current date and time: " + now.format(formatter));
    }
    
    /**
     * Method to generate random Java facts
     */
    public static String getRandomJavaFact() {
        String[] facts = {
            "Java was originally called Oak",
            "Java is platform independent thanks to JVM",
            "Java follows 'Write Once, Run Anywhere' principle",
            "GitHub Copilot can help you write Java code faster",
            "Java is strongly typed and object-oriented"
        };
        
        return facts[random.nextInt(facts.length)];
    }
    
    /**
     * Method to demonstrate basic array operations
     */
    public static void demonstrateArrayOperations() {
        System.out.println("\nArray Operations Demo:");
        
        // Create an array of numbers
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        System.out.print("Numbers: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if (i < numbers.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
        
        // Calculate sum
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        System.out.println("Sum: " + sum);
        
        // Calculate average
        double average = (double) sum / numbers.length;
        System.out.println("Average: " + String.format("%.2f", average));
        
        // Find min and max
        int min = numbers[0];
        int max = numbers[0];
        for (int number : numbers) {
            if (number < min) min = number;
            if (number > max) max = number;
        }
        System.out.println("Min: " + min + ", Max: " + max);
    }
    
    /**
     * Method to demonstrate string operations
     */
    public static void demonstrateStringOperations() {
        System.out.println("\nString Operations Demo:");
        
        String text = "GitHub Copilot helps developers";
        
        System.out.println("Original text: " + text);
        System.out.println("Length: " + text.length());
        System.out.println("Uppercase: " + text.toUpperCase());
        System.out.println("Lowercase: " + text.toLowerCase());
        System.out.println("Contains 'Copilot': " + text.contains("Copilot"));
        System.out.println("Starts with 'GitHub': " + text.startsWith("GitHub"));
        System.out.println("Replace 'helps' with 'assists': " + text.replace("helps", "assists"));
        
        // Split the string
        String[] words = text.split(" ");
        System.out.print("Words: ");
        for (int i = 0; i < words.length; i++) {
            System.out.print(words[i]);
            if (i < words.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
    
    /**
     * Method to create and display user information
     */
    public static void createUserInfo(String userName) {
        System.out.println("\nUser Information:");
        System.out.println("Name: " + userName);
        System.out.println("Timestamp: " + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        System.out.println("Favorite Language: Java");
        System.out.println("Using: GitHub Copilot");
        
        // Calculate name statistics
        System.out.println("Name length: " + userName.length());
        System.out.println("Name in uppercase: " + userName.toUpperCase());
        System.out.println("First character: " + (userName.isEmpty() ? "N/A" : userName.charAt(0)));
    }
    
    /**
     * Main method to demonstrate GitHub Copilot capabilities
     */
    public static void main(String[] args) {
        System.out.println("Java GitHub Copilot Demo");
        System.out.println("========================");
        
        // Print greeting
        printGreeting();
        
        // Get user name and greet them
        String userName = getUserName();
        greetUser(userName);
        
        // Display current date and time
        displayCurrentDateTime();
        
        // Show a random Java fact
        System.out.println("\nRandom Java fact: " + getRandomJavaFact());
        
        // Demonstrate array operations
        demonstrateArrayOperations();
        
        // Demonstrate string operations
        demonstrateStringOperations();
        
        // Create user information
        createUserInfo(userName);
        
        System.out.println("\nDemo completed!");
        System.out.println("Try writing your own methods using GitHub Copilot!");
        
        scanner.close();
    }
}