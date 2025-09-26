# Hello World example for GitHub Copilot in R
# Try typing comments like "# Function to print hello world"
# and see how Copilot suggests the implementation

# Function to print a greeting message
print_greeting <- function() {
  print("Hello, GitHub Copilot!")
}

# Function to get user name from input
get_user_name <- function() {
  cat("Please enter your name: ")
  name <- readline()
  return(name)
}

# Function to greet a specific user
greet_user <- function(name) {
  cat(paste("Hello,", name, "! Welcome to GitHub Copilot examples.\n"))
}

# Function to display current date and time
display_current_datetime <- function() {
  current_time <- Sys.time()
  cat("Current date and time:", format(current_time, "%Y-%m-%d %H:%M:%S"), "\n")
}

# Function to generate random R facts
get_random_r_fact <- function() {
  facts <- c(
    "R was created by Ross Ihaka and Robert Gentleman",
    "R is excellent for statistical computing and graphics",
    "R has thousands of packages available on CRAN",
    "GitHub Copilot can help you write R code faster",
    "R's vectorized operations make it very efficient"
  )
  
  # Return a random fact
  return(sample(facts, 1))
}

# Function to create and analyze a simple vector
analyze_numbers <- function() {
  # Create a vector of numbers
  numbers <- c(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  
  cat("Numbers:", paste(numbers, collapse = ", "), "\n")
  cat("Sum:", sum(numbers), "\n")
  cat("Mean:", mean(numbers), "\n")
  cat("Median:", median(numbers), "\n")
  cat("Standard deviation:", sd(numbers), "\n")
  
  return(numbers)
}

# Function to create a simple data frame
create_sample_data <- function() {
  # Create sample data
  data <- data.frame(
    name = c("Alice", "Bob", "Carol", "David", "Eve"),
    age = c(25, 30, 28, 35, 22),
    score = c(85, 92, 78, 88, 95),
    city = c("New York", "London", "Paris", "Tokyo", "Sydney")
  )
  
  cat("Sample data created:\n")
  print(data)
  return(data)
}

# Function to perform basic data analysis
analyze_sample_data <- function(data) {
  cat("\nData Analysis Summary:\n")
  cat("Number of records:", nrow(data), "\n")
  cat("Average age:", mean(data$age), "\n")
  cat("Average score:", mean(data$score), "\n")
  cat("Age range:", min(data$age), "to", max(data$age), "\n")
  cat("Score range:", min(data$score), "to", max(data$score), "\n")
  
  # Find highest scorer
  highest_scorer <- data[which.max(data$score), ]
  cat("Highest scorer:", highest_scorer$name, "with score", highest_scorer$score, "\n")
}

# Main function to demonstrate R with GitHub Copilot
main <- function() {
  cat("R GitHub Copilot Demo\n")
  cat(rep("=", 30), "\n", sep = "")
  
  # Print greeting
  print_greeting()
  
  # Get user name and greet them
  # Uncomment the following lines for interactive mode
  # user_name <- get_user_name()
  # greet_user(user_name)
  
  # For demo purposes, use a default name
  user_name <- "R Programmer"
  greet_user(user_name)
  
  # Display current date and time
  display_current_datetime()
  
  # Show a random R fact
  cat("\nRandom R fact:", get_random_r_fact(), "\n\n")
  
  # Analyze numbers
  cat("Number Analysis:\n")
  numbers <- analyze_numbers()
  
  # Create and analyze sample data
  cat("\nData Frame Example:\n")
  sample_data <- create_sample_data()
  analyze_sample_data(sample_data)
  
  # Create a simple plot (if running in an environment that supports graphics)
  if (interactive()) {
    cat("\nCreating a simple plot...\n")
    plot(sample_data$age, sample_data$score, 
         main = "Age vs Score", 
         xlab = "Age", 
         ylab = "Score",
         pch = 19, 
         col = "blue")
    
    # Add a trend line
    lm_model <- lm(score ~ age, data = sample_data)
    abline(lm_model, col = "red", lwd = 2)
  }
  
  cat("\nDemo completed!\n")
}

# Run the main function
main()