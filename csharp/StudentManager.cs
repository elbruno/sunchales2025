using System;
using System.Collections.Generic;
using System.Linq;

namespace GitHubCopilotExamples
{
    /// <summary>
    /// Student class to represent a student entity
    /// Try typing "// Property for student ID" and let Copilot suggest the implementation
    /// </summary>
    public class Student
    {
        // Property for student ID
        public int Id { get; set; }
        
        // Property for student name
        public string Name { get; set; }
        
        // Property for student email
        public string Email { get; set; }
        
        // Property for student age
        public int Age { get; set; }
        
        // Property for student grade
        public double Grade { get; set; }

        // Constructor
        public Student(int id, string name, string email, int age, double grade)
        {
            Id = id;
            Name = name;
            Email = email;
            Age = age;
            Grade = grade;
        }

        // Override ToString method for better display
        public override string ToString()
        {
            return $"ID: {Id}, Name: {Name}, Email: {Email}, Age: {Age}, Grade: {Grade}";
        }
    }

    /// <summary>
    /// Student manager class to demonstrate CRUD operations
    /// This example shows how GitHub Copilot can help with common patterns
    /// </summary>
    public class StudentManager
    {
        private List<Student> students;

        public StudentManager()
        {
            students = new List<Student>();
        }

        // Method to add a new student
        public void AddStudent(Student student)
        {
            if (student == null)
                throw new ArgumentNullException(nameof(student));
            
            if (students.Any(s => s.Id == student.Id))
                throw new InvalidOperationException($"Student with ID {student.Id} already exists");
            
            students.Add(student);
        }

        // Method to get a student by ID
        public Student GetStudentById(int id)
        {
            return students.FirstOrDefault(s => s.Id == id);
        }

        // Method to get all students
        public List<Student> GetAllStudents()
        {
            return new List<Student>(students);
        }

        // Method to update a student
        public void UpdateStudent(Student updatedStudent)
        {
            if (updatedStudent == null)
                throw new ArgumentNullException(nameof(updatedStudent));

            var existingStudent = GetStudentById(updatedStudent.Id);
            if (existingStudent == null)
                throw new InvalidOperationException($"Student with ID {updatedStudent.Id} not found");

            existingStudent.Name = updatedStudent.Name;
            existingStudent.Email = updatedStudent.Email;
            existingStudent.Age = updatedStudent.Age;
            existingStudent.Grade = updatedStudent.Grade;
        }

        // Method to delete a student by ID
        public bool DeleteStudent(int id)
        {
            var student = GetStudentById(id);
            if (student != null)
            {
                students.Remove(student);
                return true;
            }
            return false;
        }

        // Method to get students with grade above threshold
        public List<Student> GetStudentsWithGradeAbove(double threshold)
        {
            return students.Where(s => s.Grade > threshold).ToList();
        }

        // Method to get average grade of all students
        public double GetAverageGrade()
        {
            if (students.Count == 0)
                return 0;
            return students.Average(s => s.Grade);
        }

        // Method to get students count
        public int GetStudentCount()
        {
            return students.Count;
        }
    }

    /// <summary>
    /// Demo program to show how to use the StudentManager
    /// </summary>
    class StudentManagerDemo
    {
        static void Main(string[] args)
        {
            StudentManager manager = new StudentManager();
            
            Console.WriteLine("Student Management System Demo");
            Console.WriteLine("==============================");
            
            // Add some sample students
            manager.AddStudent(new Student(1, "Alice Johnson", "alice@email.com", 20, 85.5));
            manager.AddStudent(new Student(2, "Bob Smith", "bob@email.com", 22, 92.0));
            manager.AddStudent(new Student(3, "Carol Davis", "carol@email.com", 19, 78.3));
            
            // Display all students
            Console.WriteLine($"\nTotal students: {manager.GetStudentCount()}");
            Console.WriteLine("\nAll students:");
            foreach (var student in manager.GetAllStudents())
            {
                Console.WriteLine(student);
            }
            
            // Show average grade
            Console.WriteLine($"\nAverage grade: {manager.GetAverageGrade():F2}");
            
            // Show students with grade above 80
            Console.WriteLine("\nStudents with grade above 80:");
            foreach (var student in manager.GetStudentsWithGradeAbove(80))
            {
                Console.WriteLine(student);
            }
            
            // Update a student
            var studentToUpdate = manager.GetStudentById(1);
            if (studentToUpdate != null)
            {
                studentToUpdate.Grade = 88.0;
                manager.UpdateStudent(studentToUpdate);
                Console.WriteLine($"\nUpdated student: {studentToUpdate}");
            }
        }
    }
}