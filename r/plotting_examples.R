# Plotting Examples for GitHub Copilot in R
# This example demonstrates how Copilot can help with data visualization
# Try typing comments like "# Create a scatter plot of x vs y"

# Load required libraries
# Uncomment the following line if you have ggplot2 installed
# library(ggplot2)

# Function to create sample data for plotting
create_plot_data <- function() {
  set.seed(123)
  
  data <- data.frame(
    x = 1:50,
    y = 2 * (1:50) + rnorm(50, 0, 10),
    category = rep(c("A", "B", "C", "D", "E"), each = 10),
    size_var = runif(50, 1, 10),
    group = sample(c("Group1", "Group2"), 50, replace = TRUE)
  )
  
  return(data)
}

# Function to create basic plots using base R
create_base_plots <- function(data) {
  cat("Creating Base R Plots\n")
  cat(rep("=", 30), "\n", sep = "")
  
  # Set up plotting area for multiple plots
  if (interactive()) {
    par(mfrow = c(2, 2))
    
    # 1. Simple scatter plot
    plot(data$x, data$y, 
         main = "Scatter Plot", 
         xlab = "X values", 
         ylab = "Y values",
         pch = 19, 
         col = "blue")
    
    # Add trend line
    lm_model <- lm(y ~ x, data = data)
    abline(lm_model, col = "red", lwd = 2)
    
    # 2. Histogram
    hist(data$y, 
         main = "Histogram of Y values", 
         xlab = "Y values", 
         col = "lightblue", 
         breaks = 10)
    
    # 3. Box plot by category
    boxplot(y ~ category, data = data,
            main = "Box Plot by Category",
            xlab = "Category",
            ylab = "Y values",
            col = rainbow(5))
    
    # 4. Bar plot
    category_means <- tapply(data$y, data$category, mean)
    barplot(category_means,
            main = "Mean Y by Category",
            xlab = "Category",
            ylab = "Mean Y",
            col = "lightgreen")
    
    # Reset plotting parameters
    par(mfrow = c(1, 1))
    
    cat("Base R plots created!\n")
  } else {
    cat("Base R plotting code is ready (run in interactive mode to see plots)\n")
  }
}

# Function to demonstrate ggplot2 examples (commented out for compatibility)
create_ggplot_examples <- function(data) {
  cat("\nggplot2 Examples (uncomment if ggplot2 is installed)\n")
  cat(rep("=", 50), "\n", sep = "")
  
  # Note: Uncomment the following code if you have ggplot2 installed
  
  # # 1. Basic scatter plot with ggplot2
  # p1 <- ggplot(data, aes(x = x, y = y)) +
  #   geom_point(color = "blue", size = 2) +
  #   geom_smooth(method = "lm", color = "red") +
  #   labs(title = "Scatter Plot with Trend Line",
  #        x = "X values",
  #        y = "Y values") +
  #   theme_minimal()
  # 
  # print(p1)
  # 
  # # 2. Scatter plot with colors by category
  # p2 <- ggplot(data, aes(x = x, y = y, color = category)) +
  #   geom_point(size = 3) +
  #   labs(title = "Scatter Plot by Category",
  #        x = "X values",
  #        y = "Y values",
  #        color = "Category") +
  #   theme_minimal()
  # 
  # print(p2)
  # 
  # # 3. Box plot with ggplot2
  # p3 <- ggplot(data, aes(x = category, y = y, fill = category)) +
  #   geom_boxplot() +
  #   labs(title = "Box Plot by Category",
  #        x = "Category",
  #        y = "Y values") +
  #   theme_minimal() +
  #   theme(legend.position = "none")
  # 
  # print(p3)
  # 
  # # 4. Histogram with ggplot2
  # p4 <- ggplot(data, aes(x = y)) +
  #   geom_histogram(bins = 15, fill = "lightblue", color = "black", alpha = 0.7) +
  #   labs(title = "Histogram of Y values",
  #        x = "Y values",
  #        y = "Frequency") +
  #   theme_minimal()
  # 
  # print(p4)
  # 
  # # 5. Faceted scatter plot
  # p5 <- ggplot(data, aes(x = x, y = y)) +
  #   geom_point(aes(color = group), size = 2) +
  #   facet_wrap(~category) +
  #   labs(title = "Faceted Scatter Plot",
  #        x = "X values",
  #        y = "Y values",
  #        color = "Group") +
  #   theme_minimal()
  # 
  # print(p5)
  
  cat("ggplot2 plotting code is ready (uncomment to use with ggplot2)\n")
}

# Function to create advanced base R plots
create_advanced_base_plots <- function(data) {
  cat("\nAdvanced Base R Plots\n")
  cat(rep("=", 30), "\n", sep = "")
  
  if (interactive()) {
    # 1. Bubble chart
    plot(data$x, data$y,
         cex = data$size_var / 3,  # Size based on size_var
         col = rainbow(5)[as.numeric(as.factor(data$category))],
         pch = 19,
         main = "Bubble Chart",
         xlab = "X values",
         ylab = "Y values")
    
    # Add legend
    legend("topright", 
           legend = levels(as.factor(data$category)),
           col = rainbow(5),
           pch = 19,
           title = "Category")
    
    # 2. Multiple line plot
    categories <- unique(data$category)
    plot(range(data$x), range(data$y), 
         type = "n",
         main = "Line Plot by Category",
         xlab = "X values",
         ylab = "Y values")
    
    colors <- rainbow(length(categories))
    for (i in 1:length(categories)) {
      cat_data <- data[data$category == categories[i], ]
      lines(cat_data$x, cat_data$y, col = colors[i], lwd = 2)
    }
    
    legend("topleft", 
           legend = categories,
           col = colors,
           lwd = 2,
           title = "Category")
    
    cat("Advanced base R plots created!\n")
  } else {
    cat("Advanced plotting code is ready (run in interactive mode to see plots)\n")
  }
}

# Function to create statistical plots
create_statistical_plots <- function(data) {
  cat("\nStatistical Plots\n")
  cat(rep("=", 25), "\n", sep = "")
  
  if (interactive()) {
    par(mfrow = c(2, 2))
    
    # 1. Q-Q plot to check normality
    qqnorm(data$y, main = "Q-Q Plot of Y values")
    qqline(data$y, col = "red")
    
    # 2. Residuals plot
    lm_model <- lm(y ~ x, data = data)
    plot(fitted(lm_model), residuals(lm_model),
         main = "Residuals Plot",
         xlab = "Fitted Values",
         ylab = "Residuals",
         pch = 19)
    abline(h = 0, col = "red", lty = 2)
    
    # 3. Density plot
    plot(density(data$y),
         main = "Density Plot of Y values",
         xlab = "Y values",
         ylab = "Density",
         col = "blue",
         lwd = 2)
    
    # 4. Correlation matrix visualization (simplified)
    numeric_data <- data[, sapply(data, is.numeric)]
    cor_matrix <- cor(numeric_data)
    
    # Simple correlation plot using base R
    image(1:ncol(cor_matrix), 1:nrow(cor_matrix), 
          as.matrix(cor_matrix),
          main = "Correlation Matrix",
          xlab = "Variables",
          ylab = "Variables",
          axes = FALSE,
          col = heat.colors(20))
    
    axis(1, at = 1:ncol(cor_matrix), labels = colnames(cor_matrix))
    axis(2, at = 1:nrow(cor_matrix), labels = rownames(cor_matrix))
    
    par(mfrow = c(1, 1))
    cat("Statistical plots created!\n")
  } else {
    cat("Statistical plotting code is ready (run in interactive mode to see plots)\n")
  }
}

# Function to demonstrate plot customization
demonstrate_plot_customization <- function(data) {
  cat("\nPlot Customization Examples\n")
  cat(rep("=", 35), "\n", sep = "")
  
  if (interactive()) {
    # Create a highly customized plot
    plot(data$x, data$y,
         type = "n",  # Don't plot points yet
         main = "Customized Scatter Plot",
         xlab = "X Values (Custom Label)",
         ylab = "Y Values (Custom Label)",
         xlim = range(data$x) + c(-2, 2),
         ylim = range(data$y) + c(-5, 5),
         cex.main = 1.5,
         col.main = "darkblue",
         cex.lab = 1.2,
         col.lab = "darkgreen")
    
    # Add grid
    grid(col = "lightgray", lty = 2)
    
    # Add points with different colors for each category
    categories <- unique(data$category)
    colors <- rainbow(length(categories))
    
    for (i in 1:length(categories)) {
      cat_data <- data[data$category == categories[i], ]
      points(cat_data$x, cat_data$y, 
             col = colors[i], 
             pch = 19, 
             cex = 1.2)
    }
    
    # Add trend line
    lm_model <- lm(y ~ x, data = data)
    abline(lm_model, col = "red", lwd = 3, lty = 2)
    
    # Add custom legend
    legend("bottomright",
           legend = c(categories, "Trend Line"),
           col = c(colors, "red"),
           pch = c(rep(19, length(categories)), NA),
           lty = c(rep(NA, length(categories)), 2),
           lwd = c(rep(NA, length(categories)), 3),
           title = "Legend",
           bg = "white",
           box.col = "black")
    
    # Add text annotation
    text(max(data$x) * 0.8, max(data$y) * 0.9, 
         paste("R² =", round(summary(lm_model)$r.squared, 3)),
         cex = 1.2, col = "red")
    
    cat("Customized plot created!\n")
  } else {
    cat("Plot customization code is ready (run in interactive mode to see plots)\n")
  }
}

# Main function to demonstrate all plotting techniques
main <- function() {
  cat("R Plotting Examples with GitHub Copilot\n")
  cat(rep("=", 50), "\n", sep = "")
  
  # Create sample data
  cat("Creating sample data for plotting...\n")
  plot_data <- create_plot_data()
  
  cat("Data summary:\n")
  print(summary(plot_data))
  cat("\n")
  
  # Demonstrate different plotting techniques
  create_base_plots(plot_data)
  create_ggplot_examples(plot_data)
  create_advanced_base_plots(plot_data)
  create_statistical_plots(plot_data)
  demonstrate_plot_customization(plot_data)
  
  cat("\nPlotting examples completed!\n")
  cat("Try creating your own plots using GitHub Copilot!\n")
  cat("Tips for using Copilot with R plots:\n")
  cat("- Write descriptive comments about what you want to plot\n")
  cat("- Specify the type of plot (scatter, bar, line, etc.)\n")
  cat("- Mention styling preferences (colors, themes, etc.)\n")
  
  return(plot_data)
}

# Run the plotting examples
plot_data <- main()