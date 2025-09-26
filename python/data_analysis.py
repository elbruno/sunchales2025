#!/usr/bin/env python3
"""
Data Analysis example for GitHub Copilot in Python
This example demonstrates how Copilot can help with pandas operations
Try typing comments like "# Create a DataFrame with sample data"
"""

import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns
from datetime import datetime, timedelta


def create_sample_data():
    """Create sample sales data for analysis"""
    # Generate sample data
    np.random.seed(42)
    
    # Create date range
    dates = pd.date_range(start='2023-01-01', end='2023-12-31', freq='D')
    
    # Create sample sales data
    n_records = len(dates)
    data = {
        'date': dates,
        'product': np.random.choice(['Product A', 'Product B', 'Product C'], n_records),
        'sales': np.random.normal(1000, 200, n_records),
        'region': np.random.choice(['North', 'South', 'East', 'West'], n_records),
        'customer_age': np.random.randint(18, 65, n_records),
        'discount': np.random.uniform(0, 0.3, n_records)
    }
    
    # Ensure sales are positive
    data['sales'] = np.abs(data['sales'])
    
    return pd.DataFrame(data)


def analyze_sales_data(df):
    """Perform basic analysis on sales data"""
    print("Sales Data Analysis")
    print("=" * 50)
    
    # Display basic information about the dataset
    print(f"Dataset shape: {df.shape}")
    print(f"Date range: {df['date'].min()} to {df['date'].max()}")
    
    # Calculate basic statistics
    print("\nBasic Statistics:")
    print(df['sales'].describe())
    
    # Group by product and calculate total sales
    product_sales = df.groupby('product')['sales'].sum().sort_values(ascending=False)
    print("\nTotal Sales by Product:")
    print(product_sales)
    
    # Group by region and calculate average sales
    region_avg_sales = df.groupby('region')['sales'].mean().sort_values(ascending=False)
    print("\nAverage Sales by Region:")
    print(region_avg_sales)
    
    # Calculate monthly sales trends
    df['month'] = df['date'].dt.to_period('M')
    monthly_sales = df.groupby('month')['sales'].sum()
    print("\nMonthly Sales Trend (first 6 months):")
    print(monthly_sales.head(6))
    
    return product_sales, region_avg_sales, monthly_sales


def find_top_customers(df, top_n=10):
    """Find top customers by total sales"""
    # Simulate customer IDs
    df['customer_id'] = np.random.randint(1000, 9999, len(df))
    
    # Group by customer and calculate total sales
    customer_sales = df.groupby('customer_id')['sales'].sum().sort_values(ascending=False)
    
    print(f"\nTop {top_n} Customers:")
    print(customer_sales.head(top_n))
    
    return customer_sales.head(top_n)


def calculate_sales_metrics(df):
    """Calculate various sales metrics"""
    metrics = {}
    
    # Total sales
    metrics['total_sales'] = df['sales'].sum()
    
    # Average daily sales
    metrics['avg_daily_sales'] = df['sales'].mean()
    
    # Best sales day
    best_day = df.loc[df['sales'].idxmax()]
    metrics['best_sales_day'] = {
        'date': best_day['date'],
        'sales': best_day['sales'],
        'product': best_day['product']
    }
    
    # Sales growth rate (comparing first and last month)
    df['month'] = df['date'].dt.to_period('M')
    monthly_sales = df.groupby('month')['sales'].sum()
    first_month = monthly_sales.iloc[0]
    last_month = monthly_sales.iloc[-1]
    metrics['growth_rate'] = ((last_month - first_month) / first_month) * 100
    
    return metrics


def create_visualizations(df):
    """Create basic visualizations (would work with matplotlib/seaborn)"""
    print("\nCreating visualizations...")
    
    # Note: In a real scenario, you would uncomment these lines
    # This is just to show what Copilot might suggest
    
    # plt.figure(figsize=(12, 8))
    
    # # Sales by product
    # plt.subplot(2, 2, 1)
    # product_sales = df.groupby('product')['sales'].sum()
    # plt.bar(product_sales.index, product_sales.values)
    # plt.title('Total Sales by Product')
    # plt.xticks(rotation=45)
    
    # # Sales by region
    # plt.subplot(2, 2, 2)
    # region_sales = df.groupby('region')['sales'].sum()
    # plt.pie(region_sales.values, labels=region_sales.index, autopct='%1.1f%%')
    # plt.title('Sales Distribution by Region')
    
    # # Monthly sales trend
    # plt.subplot(2, 2, 3)
    # df['month'] = df['date'].dt.to_period('M')
    # monthly_sales = df.groupby('month')['sales'].sum()
    # plt.plot(range(len(monthly_sales)), monthly_sales.values)
    # plt.title('Monthly Sales Trend')
    # plt.xlabel('Month')
    # plt.ylabel('Sales')
    
    # # Sales vs Age correlation
    # plt.subplot(2, 2, 4)
    # plt.scatter(df['customer_age'], df['sales'], alpha=0.5)
    # plt.title('Sales vs Customer Age')
    # plt.xlabel('Customer Age')
    # plt.ylabel('Sales')
    
    # plt.tight_layout()
    # plt.show()
    
    print("Visualization code is ready (uncomment matplotlib code to see plots)")


def main():
    """Main function to demonstrate data analysis with GitHub Copilot"""
    print("Python Data Analysis with GitHub Copilot")
    print("=" * 50)
    
    # Create sample data
    df = create_sample_data()
    
    # Perform analysis
    product_sales, region_sales, monthly_sales = analyze_sales_data(df)
    
    # Find top customers
    top_customers = find_top_customers(df)
    
    # Calculate metrics
    metrics = calculate_sales_metrics(df)
    
    print(f"\nSales Metrics:")
    print(f"Total Sales: ${metrics['total_sales']:,.2f}")
    print(f"Average Daily Sales: ${metrics['avg_daily_sales']:,.2f}")
    print(f"Best Sales Day: {metrics['best_sales_day']['date']} - ${metrics['best_sales_day']['sales']:,.2f}")
    print(f"Growth Rate: {metrics['growth_rate']:.2f}%")
    
    # Create visualizations
    create_visualizations(df)
    
    # Filter data example
    high_sales = df[df['sales'] > df['sales'].quantile(0.9)]
    print(f"\nHigh-value transactions (top 10%): {len(high_sales)} records")
    print(f"Average of high-value transactions: ${high_sales['sales'].mean():,.2f}")


if __name__ == "__main__":
    main()