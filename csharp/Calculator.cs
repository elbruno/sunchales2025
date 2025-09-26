using System;

namespace GitHubCopilotExamples
{
    /// <summary>
    /// Calculator class to demonstrate GitHub Copilot's ability to generate methods
    /// Try writing comments like "// Method to add two numbers" and let Copilot complete it
    /// </summary>
    public class Calculator
    {
        // Method to add two numbers
        public double Add(double a, double b)
        {
            return a + b;
        }

        // Method to subtract two numbers
        public double Subtract(double a, double b)
        {
            return a - b;
        }

        // Method to multiply two numbers
        public double Multiply(double a, double b)
        {
            return a * b;
        }

        // Method to divide two numbers with error handling
        public double Divide(double a, double b)
        {
            if (b == 0)
                throw new DivideByZeroException("Cannot divide by zero");
            return a / b;
        }

        // Method to calculate power of a number
        public double Power(double baseNumber, double exponent)
        {
            return Math.Pow(baseNumber, exponent);
        }

        // Method to calculate square root
        public double SquareRoot(double number)
        {
            if (number < 0)
                throw new ArgumentException("Cannot calculate square root of negative number");
            return Math.Sqrt(number);
        }

        // Method to calculate percentage
        public double CalculatePercentage(double value, double percentage)
        {
            return (value * percentage) / 100;
        }
    }

    /// <summary>
    /// Demo program to test the Calculator class
    /// </summary>
    class CalculatorDemo
    {
        static void Main(string[] args)
        {
            Calculator calc = new Calculator();
            
            // Test basic operations
            Console.WriteLine("Calculator Demo with GitHub Copilot");
            Console.WriteLine("===================================");
            
            double num1 = 10;
            double num2 = 5;
            
            Console.WriteLine($"Numbers: {num1} and {num2}");
            Console.WriteLine($"Addition: {calc.Add(num1, num2)}");
            Console.WriteLine($"Subtraction: {calc.Subtract(num1, num2)}");
            Console.WriteLine($"Multiplication: {calc.Multiply(num1, num2)}");
            Console.WriteLine($"Division: {calc.Divide(num1, num2)}");
            Console.WriteLine($"Power: {calc.Power(num1, 2)}");
            Console.WriteLine($"Square Root of {num1}: {calc.SquareRoot(num1)}");
            Console.WriteLine($"25% of {num1}: {calc.CalculatePercentage(num1, 25)}");
        }
    }
}