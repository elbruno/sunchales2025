#!/usr/bin/env python3
"""
Hello World example for GitHub Copilot in Python
Try typing comments like "# Function to print hello world"
and see how Copilot suggests the implementation
"""

import datetime


def print_greeting():
    """Print a greeting message"""
    print("Hello, GitHub Copilot!")


def get_user_name():
    """Get user name from input"""
    return input("Please enter your name: ")


def greet_user(name):
    """Greet a specific user"""
    print(f"Hello, {name}! Welcome to GitHub Copilot examples.")


def display_current_datetime():
    """Display current date and time"""
    now = datetime.datetime.now()
    print(f"Current date and time: {now.strftime('%Y-%m-%d %H:%M:%S')}")


def get_random_fact():
    """Generate a random programming fact"""
    facts = [
        "Python was named after Monty Python's Flying Circus",
        "GitHub Copilot uses OpenAI Codex to suggest code",
        "Python is great for data science and machine learning",
        "GitHub Copilot can help you write code faster",
        "Python's zen: 'Simple is better than complex'"
    ]
    import random
    return random.choice(facts)


def main():
    """Main function to demonstrate GitHub Copilot capabilities"""
    print("Python GitHub Copilot Demo")
    print("=" * 30)
    
    # Call greeting function
    print_greeting()
    
    # Get user name and greet them
    user_name = get_user_name()
    greet_user(user_name)
    
    # Display current date and time
    display_current_datetime()
    
    # Show a random fact
    print(f"\nRandom fact: {get_random_fact()}")
    
    # Create a list of numbers and calculate their sum
    numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    total = sum(numbers)
    print(f"\nSum of numbers {numbers}: {total}")
    
    # Create a dictionary with user information
    user_info = {
        "name": user_name,
        "timestamp": datetime.datetime.now().isoformat(),
        "favorite_language": "Python"
    }
    print(f"\nUser info: {user_info}")


if __name__ == "__main__":
    main()