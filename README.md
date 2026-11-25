# Student Management System

A simple console-based Student Management System built with **Core Java (Java 21)**.

## Features

- Add a new student (with duplicate ID and input validation)
- View all students
- Search for a student by ID
- Update student details
- Delete a student
- Exit the application

## Project Structure

- `Student.java` — Defines the `Student` class with fields, constructor, getters, setters, and `toString()`.
- `StudentManagementSystem.java` — Contains the `main` method, menu loop, `ArrayList` storage, `Scanner` input handling, and CRUD operations.
- `.gitignore` — Excludes compiled `.class` files and IDE metadata from Git.
- `README.md` — Project overview and instructions.

## Requirements

- **Java 21** (JDK 21 or newer)

## How to Compile and Run

1. Open a terminal in the project folder.
2. Compile the Java files:
   ```bash
   javac Student.java StudentManagementSystem.java
   ```
3. Run the application:
   ```bash
   java StudentManagementSystem
   ```
