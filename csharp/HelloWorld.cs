using System;

namespace GitHubCopilotExamples
{
    /// <summary>
    /// This is a simple Hello World example to demonstrate GitHub Copilot
    /// Try typing comments like "// Create a method that prints hello world"
    /// and see how Copilot suggests the implementation
    /// </summary>
    class HelloWorld
    {
        static void Main(string[] args)
        {
            // Create a method call to print "Hello, GitHub Copilot!"
            PrintGreeting();
            
            // Create a variable to store user name and greet them
            string userName = GetUserName();
            GreetUser(userName);
            
            // Create a method to display current date and time
            DisplayCurrentDateTime();
        }

        // Method to print a greeting message
        static void PrintGreeting()
        {
            Console.WriteLine("Hello, GitHub Copilot!");
        }

        // Method to get user name from input
        static string GetUserName()
        {
            Console.Write("Please enter your name: ");
            return Console.ReadLine();
        }

        // Method to greet a specific user
        static void GreetUser(string name)
        {
            Console.WriteLine($"Hello, {name}! Welcome to GitHub Copilot examples.");
        }

        // Method to display current date and time
        static void DisplayCurrentDateTime()
        {
            DateTime now = DateTime.Now;
            Console.WriteLine($"Current date and time: {now:yyyy-MM-dd HH:mm:ss}");
        }
    }
}