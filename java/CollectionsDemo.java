import java.util.*;
import java.util.stream.Collectors;

/**
 * Collections and Streams Demo for GitHub Copilot in Java
 * This example demonstrates how Copilot can help with Java collections and streams
 * Try typing comments like "// Create a list of integers" and let Copilot complete
 */
public class CollectionsDemo {
    
    /**
     * Method to demonstrate ArrayList operations
     */
    public static void demonstrateArrayList() {
        System.out.println("ArrayList Demo");
        System.out.println("==============");
        
        // Create a list of strings
        List<String> fruits = new ArrayList<>();
        
        // Add elements to the list
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Grape");
        fruits.add("Mango");
        
        System.out.println("Original list: " + fruits);
        System.out.println("Size: " + fruits.size());
        
        // Access elements
        System.out.println("First fruit: " + fruits.get(0));
        System.out.println("Last fruit: " + fruits.get(fruits.size() - 1));
        
        // Check if list contains an element
        System.out.println("Contains 'Apple': " + fruits.contains("Apple"));
        System.out.println("Contains 'Kiwi': " + fruits.contains("Kiwi"));
        
        // Remove an element
        fruits.remove("Banana");
        System.out.println("After removing 'Banana': " + fruits);
        
        // Insert at specific position
        fruits.add(1, "Strawberry");
        System.out.println("After adding 'Strawberry' at index 1: " + fruits);
        
        // Sort the list
        Collections.sort(fruits);
        System.out.println("Sorted list: " + fruits);
    }
    
    /**
     * Method to demonstrate HashMap operations
     */
    public static void demonstrateHashMap() {
        System.out.println("\nHashMap Demo");
        System.out.println("============");
        
        // Create a map of student grades
        Map<String, Double> studentGrades = new HashMap<>();
        
        // Add key-value pairs
        studentGrades.put("Alice", 85.5);
        studentGrades.put("Bob", 92.0);
        studentGrades.put("Carol", 78.3);
        studentGrades.put("David", 95.2);
        studentGrades.put("Eve", 88.7);
        
        System.out.println("Student grades: " + studentGrades);
        System.out.println("Size: " + studentGrades.size());
        
        // Get a specific value
        System.out.println("Bob's grade: " + studentGrades.get("Bob"));
        
        // Check if key exists
        System.out.println("Contains 'Alice': " + studentGrades.containsKey("Alice"));
        System.out.println("Contains 'Frank': " + studentGrades.containsKey("Frank"));
        
        // Update a value
        studentGrades.put("Alice", 87.0);
        System.out.println("After updating Alice's grade: " + studentGrades.get("Alice"));
        
        // Iterate over the map
        System.out.println("\nIterating over entries:");
        for (Map.Entry<String, Double> entry : studentGrades.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        // Get all keys and values
        System.out.println("All students: " + studentGrades.keySet());
        System.out.println("All grades: " + studentGrades.values());
    }
    
    /**
     * Method to demonstrate HashSet operations
     */
    public static void demonstrateHashSet() {
        System.out.println("\nHashSet Demo");
        System.out.println("============");
        
        // Create a set of unique numbers
        Set<Integer> numbers = new HashSet<>();
        
        // Add elements (duplicates will be ignored)
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(2); // Duplicate
        numbers.add(4);
        numbers.add(1); // Duplicate
        
        System.out.println("Numbers set: " + numbers);
        System.out.println("Size: " + numbers.size());
        
        // Check if element exists
        System.out.println("Contains 3: " + numbers.contains(3));
        System.out.println("Contains 5: " + numbers.contains(5));
        
        // Create another set for operations
        Set<Integer> moreNumbers = new HashSet<>(Arrays.asList(3, 4, 5, 6));
        System.out.println("More numbers: " + moreNumbers);
        
        // Union (combine sets)
        Set<Integer> union = new HashSet<>(numbers);
        union.addAll(moreNumbers);
        System.out.println("Union: " + union);
        
        // Intersection (common elements)
        Set<Integer> intersection = new HashSet<>(numbers);
        intersection.retainAll(moreNumbers);
        System.out.println("Intersection: " + intersection);
        
        // Difference (elements in first set but not in second)
        Set<Integer> difference = new HashSet<>(numbers);
        difference.removeAll(moreNumbers);
        System.out.println("Difference: " + difference);
    }
    
    /**
     * Method to demonstrate Queue operations
     */
    public static void demonstrateQueue() {
        System.out.println("\nQueue Demo");
        System.out.println("==========");
        
        // Create a queue using LinkedList
        Queue<String> queue = new LinkedList<>();
        
        // Add elements to the queue
        queue.offer("First");
        queue.offer("Second");
        queue.offer("Third");
        queue.offer("Fourth");
        
        System.out.println("Queue: " + queue);
        System.out.println("Size: " + queue.size());
        
        // Peek at the front element without removing it
        System.out.println("Front element (peek): " + queue.peek());
        System.out.println("Queue after peek: " + queue);
        
        // Remove elements from the front
        System.out.println("Removed: " + queue.poll());
        System.out.println("Queue after poll: " + queue);
        
        System.out.println("Removed: " + queue.poll());
        System.out.println("Queue after second poll: " + queue);
        
        // Check if queue is empty
        System.out.println("Is empty: " + queue.isEmpty());
    }
    
    /**
     * Method to demonstrate Priority Queue
     */
    public static void demonstratePriorityQueue() {
        System.out.println("\nPriorityQueue Demo");
        System.out.println("==================");
        
        // Create a priority queue of integers
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        
        // Add elements (they will be ordered by natural ordering)
        pQueue.offer(30);
        pQueue.offer(10);
        pQueue.offer(50);
        pQueue.offer(20);
        pQueue.offer(40);
        
        System.out.println("Priority queue: " + pQueue);
        
        // Remove elements (will come out in sorted order)
        System.out.println("Removing elements in priority order:");
        while (!pQueue.isEmpty()) {
            System.out.println("Removed: " + pQueue.poll());
        }
        
        // Priority queue with custom comparator (reverse order)
        PriorityQueue<String> stringPQ = new PriorityQueue<>(Collections.reverseOrder());
        stringPQ.offer("Banana");
        stringPQ.offer("Apple");
        stringPQ.offer("Orange");
        stringPQ.offer("Grape");
        
        System.out.println("\nString priority queue (reverse order): " + stringPQ);
        System.out.println("Removing elements:");
        while (!stringPQ.isEmpty()) {
            System.out.println("Removed: " + stringPQ.poll());
        }
    }
    
    /**
     * Method to demonstrate Java 8 Streams
     */
    public static void demonstrateStreams() {
        System.out.println("\nStreams Demo");
        System.out.println("============");
        
        // Create a list of numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Original numbers: " + numbers);
        
        // Filter even numbers
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Even numbers: " + evenNumbers);
        
        // Square all numbers
        List<Integer> squares = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("Squares: " + squares);
        
        // Find sum of all numbers
        int sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum: " + sum);
        
        // Find average
        OptionalDouble average = numbers.stream()
                .mapToInt(Integer::intValue)
                .average();
        System.out.println("Average: " + (average.isPresent() ? average.getAsDouble() : "N/A"));
        
        // Find max and min
        Optional<Integer> max = numbers.stream().max(Integer::compareTo);
        Optional<Integer> min = numbers.stream().min(Integer::compareTo);
        System.out.println("Max: " + (max.isPresent() ? max.get() : "N/A"));
        System.out.println("Min: " + (min.isPresent() ? min.get() : "N/A"));
        
        // Count elements greater than 5
        long count = numbers.stream()
                .filter(n -> n > 5)
                .count();
        System.out.println("Numbers greater than 5: " + count);
        
        // Demonstrate with strings
        List<String> words = Arrays.asList("Java", "Python", "C++", "JavaScript", "Go", "Rust");
        System.out.println("\nOriginal words: " + words);
        
        // Filter words with length > 4 and convert to uppercase
        List<String> longWordsUpper = words.stream()
                .filter(word -> word.length() > 4)
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Long words (uppercase, sorted): " + longWordsUpper);
        
        // Group words by length
        Map<Integer, List<String>> wordsByLength = words.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("Words grouped by length: " + wordsByLength);
    }
    
    /**
     * Method to demonstrate advanced stream operations
     */
    public static void demonstrateAdvancedStreams() {
        System.out.println("\nAdvanced Streams Demo");
        System.out.println("=====================");
        
        // Create a list of Person objects
        class Person {
            String name;
            int age;
            String city;
            
            Person(String name, int age, String city) {
                this.name = name;
                this.age = age;
                this.city = city;
            }
            
            @Override
            public String toString() {
                return name + " (" + age + ", " + city + ")";
            }
        }
        
        List<Person> people = Arrays.asList(
            new Person("Alice", 25, "New York"),
            new Person("Bob", 30, "London"),
            new Person("Carol", 28, "New York"),
            new Person("David", 35, "Paris"),
            new Person("Eve", 22, "London")
        );
        
        System.out.println("People: " + people);
        
        // Find people older than 25
        List<Person> older = people.stream()
                .filter(person -> person.age > 25)
                .collect(Collectors.toList());
        System.out.println("People older than 25: " + older);
        
        // Group people by city
        Map<String, List<Person>> peopleByCity = people.stream()
                .collect(Collectors.groupingBy(person -> person.city));
        System.out.println("People by city: " + peopleByCity);
        
        // Get average age by city
        Map<String, Double> avgAgeByCity = people.stream()
                .collect(Collectors.groupingBy(
                    person -> person.city,
                    Collectors.averagingInt(person -> person.age)
                ));
        System.out.println("Average age by city: " + avgAgeByCity);
        
        // Find the oldest person
        Optional<Person> oldest = people.stream()
                .max(Comparator.comparing(person -> person.age));
        System.out.println("Oldest person: " + (oldest.isPresent() ? oldest.get() : "N/A"));
        
        // Check if any person is from Paris
        boolean anyFromParis = people.stream()
                .anyMatch(person -> "Paris".equals(person.city));
        System.out.println("Any person from Paris: " + anyFromParis);
        
        // Check if all people are older than 20
        boolean allOlderThan20 = people.stream()
                .allMatch(person -> person.age > 20);
        System.out.println("All people older than 20: " + allOlderThan20);
    }
    
    /**
     * Main method to run all demonstrations
     */
    public static void main(String[] args) {
        System.out.println("Java Collections and Streams Demo with GitHub Copilot");
        System.out.println("======================================================");
        
        demonstrateArrayList();
        demonstrateHashMap();
        demonstrateHashSet();
        demonstrateQueue();
        demonstratePriorityQueue();
        demonstrateStreams();
        demonstrateAdvancedStreams();
        
        System.out.println("\nDemo completed!");
        System.out.println("Try writing your own collection operations using GitHub Copilot!");
        System.out.println("Tips for using Copilot with Java collections:");
        System.out.println("- Write descriptive comments about what you want to do");
        System.out.println("- Specify the collection type (List, Map, Set, etc.)");
        System.out.println("- Mention the operations you want (filter, map, sort, etc.)");
    }
}