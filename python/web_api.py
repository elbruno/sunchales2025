#!/usr/bin/env python3
"""
Simple Web API example for GitHub Copilot in Python using Flask
Try typing comments like "# Create a route for getting all users"
and see how Copilot suggests the implementation

To run this API:
1. Install Flask: pip install flask
2. Run: python web_api.py
3. Test endpoints using curl or a browser
"""

from flask import Flask, jsonify, request
from datetime import datetime
import json


# Initialize Flask app
app = Flask(__name__)

# Sample data storage (in production, use a proper database)
users = [
    {"id": 1, "name": "Alice Johnson", "email": "alice@example.com", "age": 28},
    {"id": 2, "name": "Bob Smith", "email": "bob@example.com", "age": 34},
    {"id": 3, "name": "Carol Davis", "email": "carol@example.com", "age": 25}
]

tasks = [
    {"id": 1, "title": "Learn GitHub Copilot", "completed": False, "user_id": 1},
    {"id": 2, "title": "Build a Flask API", "completed": True, "user_id": 1},
    {"id": 3, "title": "Write documentation", "completed": False, "user_id": 2}
]


@app.route('/')
def home():
    """Home endpoint with API information"""
    return jsonify({
        "message": "Welcome to the GitHub Copilot Flask API Demo",
        "version": "1.0.0",
        "endpoints": {
            "users": "/api/users",
            "tasks": "/api/tasks",
            "health": "/health"
        },
        "timestamp": datetime.now().isoformat()
    })


@app.route('/health')
def health_check():
    """Health check endpoint"""
    return jsonify({
        "status": "healthy",
        "timestamp": datetime.now().isoformat()
    })


# User endpoints
@app.route('/api/users', methods=['GET'])
def get_all_users():
    """Get all users"""
    return jsonify({
        "users": users,
        "count": len(users)
    })


@app.route('/api/users/<int:user_id>', methods=['GET'])
def get_user_by_id(user_id):
    """Get a specific user by ID"""
    user = next((u for u in users if u["id"] == user_id), None)
    if user:
        return jsonify(user)
    return jsonify({"error": "User not found"}), 404


@app.route('/api/users', methods=['POST'])
def create_user():
    """Create a new user"""
    data = request.get_json()
    
    # Validate required fields
    if not data or not all(field in data for field in ["name", "email", "age"]):
        return jsonify({"error": "Missing required fields: name, email, age"}), 400
    
    # Generate new ID
    new_id = max([u["id"] for u in users]) + 1 if users else 1
    
    # Create new user
    new_user = {
        "id": new_id,
        "name": data["name"],
        "email": data["email"],
        "age": data["age"]
    }
    
    users.append(new_user)
    return jsonify(new_user), 201


@app.route('/api/users/<int:user_id>', methods=['PUT'])
def update_user(user_id):
    """Update an existing user"""
    user = next((u for u in users if u["id"] == user_id), None)
    if not user:
        return jsonify({"error": "User not found"}), 404
    
    data = request.get_json()
    if not data:
        return jsonify({"error": "No data provided"}), 400
    
    # Update user fields
    user.update({
        "name": data.get("name", user["name"]),
        "email": data.get("email", user["email"]),
        "age": data.get("age", user["age"])
    })
    
    return jsonify(user)


@app.route('/api/users/<int:user_id>', methods=['DELETE'])
def delete_user(user_id):
    """Delete a user"""
    global users
    user = next((u for u in users if u["id"] == user_id), None)
    if not user:
        return jsonify({"error": "User not found"}), 404
    
    users = [u for u in users if u["id"] != user_id]
    return jsonify({"message": f"User {user_id} deleted successfully"})


# Task endpoints
@app.route('/api/tasks', methods=['GET'])
def get_all_tasks():
    """Get all tasks with optional filtering"""
    completed = request.args.get('completed')
    user_id = request.args.get('user_id')
    
    filtered_tasks = tasks.copy()
    
    # Filter by completion status
    if completed is not None:
        completed_bool = completed.lower() == 'true'
        filtered_tasks = [t for t in filtered_tasks if t["completed"] == completed_bool]
    
    # Filter by user ID
    if user_id:
        try:
            user_id_int = int(user_id)
            filtered_tasks = [t for t in filtered_tasks if t["user_id"] == user_id_int]
        except ValueError:
            return jsonify({"error": "Invalid user_id format"}), 400
    
    return jsonify({
        "tasks": filtered_tasks,
        "count": len(filtered_tasks)
    })


@app.route('/api/tasks', methods=['POST'])
def create_task():
    """Create a new task"""
    data = request.get_json()
    
    if not data or not all(field in data for field in ["title", "user_id"]):
        return jsonify({"error": "Missing required fields: title, user_id"}), 400
    
    # Check if user exists
    user_exists = any(u["id"] == data["user_id"] for u in users)
    if not user_exists:
        return jsonify({"error": "User not found"}), 404
    
    # Generate new ID
    new_id = max([t["id"] for t in tasks]) + 1 if tasks else 1
    
    # Create new task
    new_task = {
        "id": new_id,
        "title": data["title"],
        "completed": data.get("completed", False),
        "user_id": data["user_id"]
    }
    
    tasks.append(new_task)
    return jsonify(new_task), 201


@app.route('/api/tasks/<int:task_id>', methods=['PUT'])
def update_task(task_id):
    """Update a task"""
    task = next((t for t in tasks if t["id"] == task_id), None)
    if not task:
        return jsonify({"error": "Task not found"}), 404
    
    data = request.get_json()
    if not data:
        return jsonify({"error": "No data provided"}), 400
    
    # Update task fields
    task.update({
        "title": data.get("title", task["title"]),
        "completed": data.get("completed", task["completed"]),
        "user_id": data.get("user_id", task["user_id"])
    })
    
    return jsonify(task)


@app.route('/api/statistics', methods=['GET'])
def get_statistics():
    """Get API statistics"""
    completed_tasks = sum(1 for t in tasks if t["completed"])
    pending_tasks = len(tasks) - completed_tasks
    
    return jsonify({
        "users": {
            "total": len(users),
            "average_age": sum(u["age"] for u in users) / len(users) if users else 0
        },
        "tasks": {
            "total": len(tasks),
            "completed": completed_tasks,
            "pending": pending_tasks,
            "completion_rate": (completed_tasks / len(tasks) * 100) if tasks else 0
        },
        "timestamp": datetime.now().isoformat()
    })


# Error handlers
@app.errorhandler(404)
def not_found(error):
    """Handle 404 errors"""
    return jsonify({"error": "Endpoint not found"}), 404


@app.errorhandler(500)
def internal_error(error):
    """Handle 500 errors"""
    return jsonify({"error": "Internal server error"}), 500


if __name__ == '__main__':
    print("Starting GitHub Copilot Flask API Demo...")
    print("Available endpoints:")
    print("- GET  /")
    print("- GET  /health")
    print("- GET  /api/users")
    print("- POST /api/users")
    print("- GET  /api/users/<id>")
    print("- PUT  /api/users/<id>")
    print("- DELETE /api/users/<id>")
    print("- GET  /api/tasks")
    print("- POST /api/tasks")
    print("- PUT  /api/tasks/<id>")
    print("- GET  /api/statistics")
    print("\nRunning on http://127.0.0.1:5000")
    
    app.run(debug=True, host='127.0.0.1', port=5000)