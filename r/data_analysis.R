# Data Analysis example for GitHub Copilot in R
# This example demonstrates how Copilot can help with data manipulation and analysis
# Try typing comments like "# Create a data frame with sales data"

# Load required libraries (install if needed)
# install.packages(c("dplyr", "ggplot2", "lubridate"))
library(dplyr)
# Uncomment the following lines if you have these packages installed
# library(ggplot2)
# library(lubridate)

# Function to create sample sales data
create_sample_sales_data <- function(n_records = 1000) {
  set.seed(42)  # For reproducible results
  
  # Create sample data
  data <- data.frame(
    date = seq(as.Date("2023-01-01"), as.Date("2023-12-31"), by = "day")[1:n_records],
    product = sample(c("Product A", "Product B", "Product C"), n_records, replace = TRUE),
    sales = abs(rnorm(n_records, mean = 1000, sd = 200)),
    region = sample(c("North", "South", "East", "West"), n_records, replace = TRUE),
    customer_age = sample(18:65, n_records, replace = TRUE),
    discount = runif(n_records, min = 0, max = 0.3)
  )
  
  return(data)
}

# Function to perform basic data analysis
analyze_sales_data <- function(data) {
  cat("Sales Data Analysis\n")
  cat(rep("=", 50), "\n", sep = "")
  
  # Display basic information
  cat("Dataset dimensions:", nrow(data), "rows,", ncol(data), "columns\n")
  cat("Date range:", as.character(min(data$date)), "to", as.character(max(data$date)), "\n\n")
  
  # Basic statistics for sales
  cat("Sales Statistics:\n")
  cat("Min:", round(min(data$sales), 2), "\n")
  cat("Max:", round(max(data$sales), 2), "\n")
  cat("Mean:", round(mean(data$sales), 2), "\n")
  cat("Median:", round(median(data$sales), 2), "\n")
  cat("Standard Deviation:", round(sd(data$sales), 2), "\n\n")
  
  return(data)
}

# Function to analyze sales by product
analyze_by_product <- function(data) {
  cat("Sales Analysis by Product:\n")
  
  # Group by product and calculate total sales
  product_summary <- data %>%
    group_by(product) %>%
    summarise(
      total_sales = sum(sales),
      avg_sales = mean(sales),
      count = n(),
      .groups = 'drop'
    ) %>%
    arrange(desc(total_sales))
  
  print(product_summary)
  return(product_summary)
}

# Function to analyze sales by region
analyze_by_region <- function(data) {
  cat("\nSales Analysis by Region:\n")
  
  # Group by region and calculate statistics
  region_summary <- data %>%
    group_by(region) %>%
    summarise(
      total_sales = sum(sales),
      avg_sales = mean(sales),
      count = n(),
      avg_age = mean(customer_age),
      .groups = 'drop'
    ) %>%
    arrange(desc(total_sales))
  
  print(region_summary)
  return(region_summary)
}

# Function to find top performing days
find_top_sales_days <- function(data, top_n = 10) {
  cat("\nTop", top_n, "Sales Days:\n")
  
  # Group by date and calculate daily totals
  daily_sales <- data %>%
    group_by(date) %>%
    summarise(
      daily_total = sum(sales),
      transactions = n(),
      .groups = 'drop'
    ) %>%
    arrange(desc(daily_total)) %>%
    head(top_n)
  
  print(daily_sales)
  return(daily_sales)
}

# Function to analyze customer age groups
analyze_age_groups <- function(data) {
  cat("\nSales Analysis by Age Groups:\n")
  
  # Create age groups
  data <- data %>%
    mutate(
      age_group = case_when(
        customer_age < 25 ~ "18-24",
        customer_age < 35 ~ "25-34",
        customer_age < 45 ~ "35-44",
        customer_age < 55 ~ "45-54",
        TRUE ~ "55+"
      )
    )
  
  # Analyze by age groups
  age_summary <- data %>%
    group_by(age_group) %>%
    summarise(
      total_sales = sum(sales),
      avg_sales = mean(sales),
      count = n(),
      avg_discount = mean(discount),
      .groups = 'drop'
    ) %>%
    arrange(desc(total_sales))
  
  print(age_summary)
  return(age_summary)
}

# Function to calculate monthly trends
calculate_monthly_trends <- function(data) {
  cat("\nMonthly Sales Trends:\n")
  
  # Extract month from date and analyze
  monthly_data <- data %>%
    mutate(
      month = format(date, "%Y-%m")
    ) %>%
    group_by(month) %>%
    summarise(
      monthly_sales = sum(sales),
      transactions = n(),
      avg_transaction = mean(sales),
      .groups = 'drop'
    ) %>%
    arrange(month)
  
  print(monthly_data)
  return(monthly_data)
}

# Function to find correlations
analyze_correlations <- function(data) {
  cat("\nCorrelation Analysis:\n")
  
  # Select numeric variables
  numeric_vars <- data %>%
    select(sales, customer_age, discount)
  
  # Calculate correlation matrix
  cor_matrix <- cor(numeric_vars)
  
  cat("Correlation Matrix:\n")
  print(round(cor_matrix, 3))
  
  # Specific correlations
  cat("\nKey Correlations:\n")
  cat("Sales vs Age:", round(cor(data$sales, data$customer_age), 3), "\n")
  cat("Sales vs Discount:", round(cor(data$sales, data$discount), 3), "\n")
  cat("Age vs Discount:", round(cor(data$customer_age, data$discount), 3), "\n")
  
  return(cor_matrix)
}

# Function to create summary report
create_summary_report <- function(data) {
  cat("\n")
  cat(rep("=", 60), "\n", sep = "")
  cat("EXECUTIVE SUMMARY REPORT\n")
  cat(rep("=", 60), "\n", sep = "")
  
  # Calculate key metrics
  total_sales <- sum(data$sales)
  avg_daily_sales <- mean(data$sales)
  total_transactions <- nrow(data)
  
  # Best performing product
  best_product <- data %>%
    group_by(product) %>%
    summarise(total = sum(sales), .groups = 'drop') %>%
    arrange(desc(total)) %>%
    slice(1)
  
  # Best performing region
  best_region <- data %>%
    group_by(region) %>%
    summarise(total = sum(sales), .groups = 'drop') %>%
    arrange(desc(total)) %>%
    slice(1)
  
  cat("Total Sales:", paste0("$", format(round(total_sales, 2), big.mark = ",")), "\n")
  cat("Average Transaction Value:", paste0("$", round(avg_daily_sales, 2)), "\n")
  cat("Total Transactions:", format(total_transactions, big.mark = ","), "\n")
  cat("Best Product:", best_product$product, paste0("($", format(round(best_product$total, 2), big.mark = ","), ")"), "\n")
  cat("Best Region:", best_region$region, paste0("($", format(round(best_region$total, 2), big.mark = ","), ")"), "\n")
  
  # Calculate growth trend (comparing first and last month)
  monthly_data <- data %>%
    mutate(month = format(date, "%Y-%m")) %>%
    group_by(month) %>%
    summarise(monthly_sales = sum(sales), .groups = 'drop') %>%
    arrange(month)
  
  if (nrow(monthly_data) > 1) {
    first_month <- monthly_data$monthly_sales[1]
    last_month <- monthly_data$monthly_sales[nrow(monthly_data)]
    growth_rate <- ((last_month - first_month) / first_month) * 100
    cat("Growth Rate (first to last month):", round(growth_rate, 2), "%\n")
  }
}

# Main function to run the complete analysis
main <- function() {
  cat("R Data Analysis with GitHub Copilot\n")
  cat(rep("=", 50), "\n", sep = "")
  
  # Create sample data
  cat("Creating sample sales data...\n")
  sales_data <- create_sample_sales_data(1000)
  
  # Perform various analyses
  analyze_sales_data(sales_data)
  
  product_analysis <- analyze_by_product(sales_data)
  region_analysis <- analyze_by_region(sales_data)
  top_days <- find_top_sales_days(sales_data, 5)
  age_analysis <- analyze_age_groups(sales_data)
  monthly_trends <- calculate_monthly_trends(sales_data)
  correlations <- analyze_correlations(sales_data)
  
  # Create summary report
  create_summary_report(sales_data)
  
  cat("\nAnalysis completed!\n")
  cat("Try adding your own analysis functions using GitHub Copilot!\n")
  
  return(sales_data)
}

# Run the analysis
sales_data <- main()