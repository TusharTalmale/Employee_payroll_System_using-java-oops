**Employee Payroll Management System**
Overview
Developed a comprehensive Employee Payroll Management System using Java, which allows users to manage employee information efficiently. The system supports functionalities such as adding new employees, removing existing ones, and generating detailed payroll reports. It also includes features like sorting employees by name or salary and searching for employees by ID. Robust input validation ensures enhanced usability and data accuracy.

Features
Add/Remove Employees: Easily add new employees or remove existing ones using intuitive commands.
Salary Calculation: Automatically calculates salaries for full-time and part-time employees.
Employee Search: Quickly find employees by their unique ID.
Sorting: Sort employees by name or salary to view them in a preferred order.
Payroll Reporting: Generate and display detailed payroll reports.
Employee Types: Support for different employee types (Full-Time and Part-Time) with appropriate salary calculations.
Installation
Clone the repository:
git clone https://github.com/yourusername/EmployeePayrollSystem.git
Navigate to the project directory:
cd EmployeePayrollSystem
Compile the Java files:
javac -d bin src/*.java
Run the application:
java -cp bin Main
Usage
Add Employees: Follow prompts to add full-time or part-time employees by entering their name, ID, and salary details.
Remove Employees: Remove an employee by entering their ID.
Generate Payroll Report: View a detailed report of all employees, including their salaries and types.
Search Employees: Find an employee by entering their ID.
Sort Employees: Choose to sort employees by name or salary.

Example Usage
1. Adding Employees
-------------------------------------------
Enter Employee Name: Tushar Talmale
Enter Employee ID: 101
Enter Employee Type (Full-Time/Part-Time): Full-Time
Enter Monthly Salary: 5000.0
-------------------------------------------
Employee Added Successfully!

-------------------------------------------
Enter Employee Name: Jane Doe
Enter Employee ID: 102
Enter Employee Type (Full-Time/Part-Time): Part-Time
Enter Hourly Rate: 20.0
Enter Hours Worked: 40
-------------------------------------------
Employee Added Successfully!
2. Displaying Employees
plaintext
Copy code
-------------------------------------------
Current Employees:
-------------------------------------------
Employee [name=Tushar Talmale, id=101, salary=5000.0, type=Full-Time]
Employee [name=Jane Doe, id=102, salary=800.0, type=Part-Time]
-------------------------------------------
3. Searching for an Employee
plaintext
Copy code
-------------------------------------------
Enter Employee ID to Search: 102
-------------------------------------------
Employee Found: 
Employee [name=Jane Doe, id=102, salary=800.0, type=Part-Time]
-------------------------------------------
4. Removing an Employee
plaintext
Copy code
-------------------------------------------
Enter Employee ID to Remove: 102
-------------------------------------------
Employee Removed Successfully!
5. Sorting Employees by Name
plaintext
Copy code
-------------------------------------------
Employees Sorted by Name:
-------------------------------------------
Employee [name=Jane Doe, id=102, salary=800.0, type=Part-Time]
Employee [name=Tushar Talmale, id=101, salary=5000.0, type=Full-Time]
-------------------------------------------
6. Sorting Employees by Salary
plaintext
Copy code
-------------------------------------------
Employees Sorted by Salary:
-------------------------------------------
Employee [name=Jane Doe, id=102, salary=800.0, type=Part-Time]
Employee [name=Tushar Talmale, id=101, salary=5000.0, type=Full-Time]
-------------------------------------------
7. Generating Payroll Report
plaintext
Copy code
-------------------------------------------
Payroll Report:
-------------------------------------------
Employee [name=Tushar Talmale, id=101, salary=5000.0, type=Full-Time]
Employee [name=Jane Doe, id=102, salary=800.0, type=Part-Time]
-------------------------------------------
Total Payroll: $5800.0
-------------------------------------------
8. Updating Employee Details
plaintext
Copy code
-------------------------------------------
Enter Employee ID to Update: 101
Enter New Name: Tushar Amaka
Enter New Salary: 6000.0
-------------------------------------------
Employee Details Updated Successfully!
-------------------------------------------
Updated Employee:
Employee [name=Tushar Amaka, id=101, salary=6000.0, type=Full-Time]
-------------------------------------------
9. Final Display of All Employees
plaintext
Copy code
-------------------------------------------
Final Employee List:
-------------------------------------------
Employee [name=Tushar Amaka, id=101, salary=6000.0, type=Full-Time]
Employee [name=Jane Doe, id=102, salary=800.0, type=Part-Time]
-------------------------------------------

Technologies Used
Java: Core logic and implementation.
Collections Framework: Used for managing employee records.

Contributing
Contributions are welcome! Please fork this repository and submit a pull request.

License
This project is licensed under the MIT License.

Contact
For any inquiries, feel free to reach out via LinkedIn.
