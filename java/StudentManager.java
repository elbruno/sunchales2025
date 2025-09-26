import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Student class to represent a student entity
 * Try typing "// Constructor for Student class" and let Copilot suggest the implementation
 */
class Student {
    private int id;
    private String name;
    private String email;
    private int age;
    private double grade;
    private LocalDate enrollmentDate;
    
    // Constructor
    public Student(int id, String name, String email, int age, double grade) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.grade = grade;
        this.enrollmentDate = LocalDate.now();
    }
    
    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getAge() { return age; }
    public double getGrade() { return grade; }
    public LocalDate getEnrollmentDate() { return enrollmentDate; }
    
    // Setters
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setAge(int age) { this.age = age; }
    public void setGrade(double grade) { this.grade = grade; }
    
    // Method to check if student is honor roll (grade >= 90)
    public boolean isHonorRoll() {
        return grade >= 90.0;
    }
    
    // Method to get grade letter
    public String getGradeLetter() {
        if (grade >= 90) return "A";
        else if (grade >= 80) return "B";
        else if (grade >= 70) return "C";
        else if (grade >= 60) return "D";
        else return "F";
    }
    
    @Override
    public String toString() {
        return String.format("Student{id=%d, name='%s', email='%s', age=%d, grade=%.1f, enrollmentDate=%s}",
                id, name, email, age, grade, enrollmentDate.format(DateTimeFormatter.ISO_LOCAL_DATE));
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return id == student.id;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

/**
 * Student manager class to demonstrate CRUD operations and collections
 * This example shows how GitHub Copilot can help with common patterns
 */
class StudentManager {
    private List<Student> students;
    private Map<Integer, Student> studentMap;
    private int nextId;
    
    public StudentManager() {
        this.students = new ArrayList<>();
        this.studentMap = new HashMap<>();
        this.nextId = 1;
    }
    
    // Method to add a new student
    public void addStudent(String name, String email, int age, double grade) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be null or empty");
        }
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Student email cannot be null or empty");
        }
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Student age must be between 0 and 120");
        }
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Student grade must be between 0 and 100");
        }
        
        Student student = new Student(nextId++, name.trim(), email.trim(), age, grade);
        students.add(student);
        studentMap.put(student.getId(), student);
    }
    
    // Method to get a student by ID
    public Student getStudentById(int id) {
        return studentMap.get(id);
    }
    
    // Method to get all students
    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }
    
    // Method to update a student
    public boolean updateStudent(int id, String name, String email, int age, double grade) {
        Student student = getStudentById(id);
        if (student == null) {
            return false;
        }
        
        if (name != null && !name.trim().isEmpty()) {
            student.setName(name.trim());
        }
        if (email != null && !email.trim().isEmpty()) {
            student.setEmail(email.trim());
        }
        if (age >= 0 && age <= 120) {
            student.setAge(age);
        }
        if (grade >= 0 && grade <= 100) {
            student.setGrade(grade);
        }
        
        return true;
    }
    
    // Method to delete a student by ID
    public boolean deleteStudent(int id) {
        Student student = getStudentById(id);
        if (student != null) {
            students.remove(student);
            studentMap.remove(id);
            return true;
        }
        return false;
    }
    
    // Method to get students with grade above threshold
    public List<Student> getStudentsWithGradeAbove(double threshold) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getGrade() > threshold) {
                result.add(student);
            }
        }
        return result;
    }
    
    // Method to get students on honor roll
    public List<Student> getHonorRollStudents() {
        return students.stream()
                .filter(Student::isHonorRoll)
                .sorted((s1, s2) -> Double.compare(s2.getGrade(), s1.getGrade()))
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
    
    // Method to get average grade of all students
    public double getAverageGrade() {
        if (students.isEmpty()) {
            return 0.0;
        }
        
        double sum = 0.0;
        for (Student student : students) {
            sum += student.getGrade();
        }
        return sum / students.size();
    }
    
    // Method to get students count
    public int getStudentCount() {
        return students.size();
    }
    
    // Method to find students by name (partial match)
    public List<Student> findStudentsByName(String namePattern) {
        List<Student> result = new ArrayList<>();
        String pattern = namePattern.toLowerCase();
        
        for (Student student : students) {
            if (student.getName().toLowerCase().contains(pattern)) {
                result.add(student);
            }
        }
        
        return result;
    }
    
    // Method to get grade statistics
    public Map<String, Object> getGradeStatistics() {
        Map<String, Object> stats = new HashMap<>();
        
        if (students.isEmpty()) {
            stats.put("count", 0);
            stats.put("average", 0.0);
            stats.put("min", 0.0);
            stats.put("max", 0.0);
            return stats;
        }
        
        double sum = 0.0;
        double min = students.get(0).getGrade();
        double max = students.get(0).getGrade();
        
        for (Student student : students) {
            double grade = student.getGrade();
            sum += grade;
            if (grade < min) min = grade;
            if (grade > max) max = grade;
        }
        
        stats.put("count", students.size());
        stats.put("average", sum / students.size());
        stats.put("min", min);
        stats.put("max", max);
        
        return stats;
    }
    
    // Method to get students grouped by grade letter
    public Map<String, List<Student>> getStudentsByGradeLetter() {
        Map<String, List<Student>> grouped = new HashMap<>();
        
        for (Student student : students) {
            String gradeLetter = student.getGradeLetter();
            grouped.computeIfAbsent(gradeLetter, k -> new ArrayList<>()).add(student);
        }
        
        return grouped;
    }
    
    // Method to sort students by different criteria
    public List<Student> getSortedStudents(String sortBy) {
        List<Student> sorted = new ArrayList<>(students);
        
        switch (sortBy.toLowerCase()) {
            case "name":
                sorted.sort(Comparator.comparing(Student::getName));
                break;
            case "grade":
                sorted.sort((s1, s2) -> Double.compare(s2.getGrade(), s1.getGrade()));
                break;
            case "age":
                sorted.sort(Comparator.comparing(Student::getAge));
                break;
            case "id":
                sorted.sort(Comparator.comparing(Student::getId));
                break;
            default:
                // Default sort by ID
                sorted.sort(Comparator.comparing(Student::getId));
        }
        
        return sorted;
    }
}

/**
 * Demo program to show how to use the StudentManager
 */
public class StudentManagerDemo {
    
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        
        System.out.println("Student Management System Demo");
        System.out.println("==============================");
        
        // Add some sample students
        manager.addStudent("Alice Johnson", "alice@email.com", 20, 85.5);
        manager.addStudent("Bob Smith", "bob@email.com", 22, 92.0);
        manager.addStudent("Carol Davis", "carol@email.com", 19, 78.3);
        manager.addStudent("David Wilson", "david@email.com", 21, 95.2);
        manager.addStudent("Eve Brown", "eve@email.com", 20, 88.7);
        
        // Display all students
        System.out.println("\nTotal students: " + manager.getStudentCount());
        System.out.println("\nAll students:");
        for (Student student : manager.getAllStudents()) {
            System.out.println(student);
        }
        
        // Show grade statistics
        Map<String, Object> stats = manager.getGradeStatistics();
        System.out.println("\nGrade Statistics:");
        System.out.printf("Average: %.2f\n", stats.get("average"));
        System.out.printf("Min: %.1f, Max: %.1f\n", stats.get("min"), stats.get("max"));
        
        // Show honor roll students
        System.out.println("\nHonor Roll Students (Grade >= 90):");
        for (Student student : manager.getHonorRollStudents()) {
            System.out.printf("%s - Grade: %.1f (%s)\n", 
                student.getName(), student.getGrade(), student.getGradeLetter());
        }
        
        // Show students grouped by grade letter
        System.out.println("\nStudents by Grade Letter:");
        Map<String, List<Student>> byGrade = manager.getStudentsByGradeLetter();
        for (Map.Entry<String, List<Student>> entry : byGrade.entrySet()) {
            System.out.println("Grade " + entry.getKey() + ": " + entry.getValue().size() + " students");
        }
        
        // Demonstrate search functionality
        System.out.println("\nSearching for students with 'o' in name:");
        for (Student student : manager.findStudentsByName("o")) {
            System.out.println("  " + student.getName());
        }
        
        // Update a student
        System.out.println("\nUpdating student with ID 1...");
        boolean updated = manager.updateStudent(1, "Alice Johnson-Smith", null, -1, 87.5);
        System.out.println("Update successful: " + updated);
        
        if (updated) {
            Student updatedStudent = manager.getStudentById(1);
            System.out.println("Updated student: " + updatedStudent);
        }
        
        // Show sorted students
        System.out.println("\nStudents sorted by grade (highest first):");
        for (Student student : manager.getSortedStudents("grade")) {
            System.out.printf("%s: %.1f\n", student.getName(), student.getGrade());
        }
        
        System.out.println("\nDemo completed!");
    }
}