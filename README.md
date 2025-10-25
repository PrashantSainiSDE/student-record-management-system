# 🎓 Student Record Management System (CLI - Java)

A simple **command-line based CRUD application** built using **Core Java** to manage student records efficiently.  
This project demonstrates **Object-Oriented Programming (OOP)** principles, **exception handling**, and **user input validation** in a real-world scenario.

---

## 🧩 Project Overview

This system allows users to:

- ➕ **Add** new student records
- ✏️ **Update** existing student details
- ❌ **Delete** student records
- 📋 **Display** all stored records

The project is built as a **Maven Quickstart** project using standard Java utilities like `ArrayList` and `Scanner` for data storage and input handling.

---

## ⚙️ Tech Stack

| Component | Description                          |
|------------|--------------------------------------|
| Language | Java 14+                             |
| Build Tool | Maven                                |
| IDE | VS Code / IntelliJ Community Edition |
| Project Type | CLI Application (No Database)        |

---

## 📘 Class Details

### 1. `Student`
A simple POJO (Plain Old Java Object) representing a student record.

**Fields:**
- `id` — Student ID (Integer)
- `name` — Student Name (String)
- `marks` — Student Marks (Integer)

**Methods:**
- Getters and Setters for each field
- `toString()` for readable output

---

### 2. `StudentRecords`
The main driver class responsible for performing CRUD operations and handling user input.

**Key Methods:**

| Method | Description |
|--------|--------------|
| `addStudent()` | Adds a new student after validating input |
| `updateStudent()` | Updates name or marks of an existing student |
| `deleteStudent()` | Deletes a student record by ID |
| `displayStudents()` | Displays all records in a table format |
| `findStudentById()` | Finds and returns a student object by ID |
| `getIntegerInput()` | Ensures safe numeric input from user |
| `getMenuChoice()` | Handles and validates menu selection |

---

## 🧠 Features & Validations

✅ Prevents duplicate student IDs  
✅ Ensures names are not empty or blank  
✅ Handles invalid numeric inputs gracefully  
✅ Validates marks to be positive numbers  
✅ Uses formatted table output for better readability  
✅ Modular design for better maintainability

---

## 🧰 How to Run

### **1. Clone the Repository**
```bash
git clone https://github.com/PrashantSainiSDE/student-record-management-system.git
cd student-record-management-system
```
### **2. Compile the Project**
```bash
mvn clean compile
```   

### **3. Run the Application**
```bash
 mvn exec:java -Dexec.mainClass="com.srms.app.StudentRecords"
```  

---
### 🖥️ Sample Output
```shell
--------- Student Record Management System ---------
Please select an operation:
1. Add new student
2. Update student details
3. Remove student
4. Display all students
5. Exit
Enter choice (1-5): 4

------------- Student Records --------------------
ID         Name                 Marks     
101        Prince               460       
102        PK                   400       
103        ProNoobda            360       
--------------------------------------------------

Press Enter to continue...

4
Please select an operation:
1. Add new student
2. Update student details
3. Remove student
4. Display all students
5. Exit
Enter choice (1-5): 
------------- Student Records --------------------
ID         Name                 Marks     
101        Prince               460       
102        PK                   400       
103        ProbDelta            360       
--------------------------------------------------

Press Enter to continue...

Please select an operation:
1. Add new student
2. Update student details
3. Remove student
4. Display all students
5. Exit
Enter choice (1-5): 5
Shutting down system. Goodbye!
```
---
#### 🚀 Learning Outcomes
By completing this project, you will:
- Understand Java OOP fundamentals
- Learn CLI-based user interaction
- Practice ArrayList operations for CRUD
- Apply input validation and exception handling

### 📄 License
This project is open-source and available under the MIT License.

### 👨‍💻 Author
Prashant Saini