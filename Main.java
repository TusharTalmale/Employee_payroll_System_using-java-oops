import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

abstract class Employee {
    private  String name;
    private final int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
    public void setName(String name){
        this.name=name;
    }

    public abstract double calculateSalary();
    public abstract String getEmployeeType();

    @Override
    public String toString() {
//        return "Employee [name=" + name + ", id=" + id + ", salary=" + calculateSalary() + "]";
        return String.format("Employee [Name: %s, ID: %d, Type: %s, Salary: $%.2f]",
                name, id, getEmployeeType(), calculateSalary());
    }
}

class FullTimeEmployee extends Employee {
    private  double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary){
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }

    @Override
    public String getEmployeeType() {
        return "Full-Time Employee";
    }
}

class PartTimeEmployee extends Employee {
    private  double hourrate;
    private  int hoursworked;

    public PartTimeEmployee(String name, int id, double hourrate, int hoursworked) {
        super(name, id);
        this.hourrate = hourrate;
        this.hoursworked = hoursworked;
    }
    public void setHourrate(double hourrate){
        this.hourrate=hourrate;
    }
    public void setHoursworked(int hoursworked){
        this.hoursworked=hoursworked;
    }
    @Override
    public double calculateSalary() {
        return hourrate * hoursworked;
    }

    @Override
    public String getEmployeeType() {
        return "Part Time Employee";
    }
}

class PayrollSystem {
    private final List<Employee> employeeList;

    PayrollSystem() {
        employeeList = new ArrayList<Employee>();
    }

    public void addEmployee(Employee emp) {
        employeeList.add(emp);
    }

    public void removeEmployee(int id) {
        Employee employeeToRemove = null;
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployees() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    public Employee searchEmployeeById(int id) {
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public double calculatepayrolls() {
        double totalamount = 0;
        for (Employee employee : employeeList) {
            totalamount += employee.calculateSalary();
        }
        return totalamount;
    }

    public void gereratereport(){
        System.out.println("\nPayroll System Report");
        for(Employee emp : employeeList){
            System.out.println(emp);

        }
        System.out.println("Total payroll : Rs "+ calculatepayrolls());

    }

    public void sortEmployeeByname(){
        Collections.sort(employeeList, Comparator.comparing(Employee::getName));
    }
    public void sortEmployeeBySalary(){
        Collections.sort(employeeList, Comparator.comparing(Employee::calculateSalary).reversed());
    }

    public void updateEmployeeDetails(int id, String newName, double newSalary){
        Employee employee = searchEmployeeById(id);
        if(employee != null){
            employee.setName(newName);
            if(employee instanceof FullTimeEmployee){
                ((FullTimeEmployee) employee).setMonthlySalary(newSalary);

            } else if (employee instanceof PartTimeEmployee){
                ((PartTimeEmployee)employee).setHourrate(newSalary);
            }
            System.out.println("Employee details updated successfully.");
        }
        else{
            System.out.println("Employee nor Found .");
        }
    }
}



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PayrollSystem payrollSystem = new PayrollSystem();

        while (true) {
            try {
                System.out.println("=====================================");
                System.out.println("         Payroll System Menu         ");
                System.out.println("=====================================");
                System.out.println("1. Add Employee");
                System.out.println("2. Remove Employee");
                System.out.println("3. Display All Employees");
                System.out.println("4. Search Employee by ID");
                System.out.println("5. Calculate Total Payroll");
                System.out.println("6. Exit");
                System.out.println("-------------------------------------");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.println("=====================================");
                        System.out.println("          Add a New Employee         ");
                        System.out.println("-------------------------------------");
                        System.out.print("Enter Employee Full Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Employee ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        System.out.println("\nSelect Employee Type:");
                        System.out.println("1. Full-Time Employee");
                        System.out.println("2. Part-Time Employee");
                        System.out.print("Choose an option: ");
                        int type = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        if (type == 1) {
                            System.out.print("Enter Monthly Salary: ");
                            double monthlySalary = scanner.nextDouble();
                            scanner.nextLine(); // Consume newline
                            FullTimeEmployee fullTimeEmp = new FullTimeEmployee(name, id, monthlySalary);
                            payrollSystem.addEmployee(fullTimeEmp);
                            System.out.println("Full-Time Employee Added Successfully!");
                        } else if (type == 2) {
                            System.out.print("Enter Hourly Rate: ");
                            double hourRate = scanner.nextDouble();
                            System.out.print("Enter Hours Worked: ");
                            int hoursWorked = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            PartTimeEmployee partTimeEmp = new PartTimeEmployee(name, id, hourRate, hoursWorked);
                            payrollSystem.addEmployee(partTimeEmp);
                            System.out.println("Part-Time Employee Added Successfully!");
                        } else {
                            System.out.println("Invalid option. Please try again.");
                        }
                        break;

                    case 2:
                        System.out.println("-------------------------------------");
                        System.out.println("         Remove an Employee          ");
                        System.out.println("-------------------------------------");
                        System.out.print("Enter Employee ID to remove: ");
                        int removeId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        payrollSystem.removeEmployee(removeId);
                        System.out.println("Employee Removed Successfully!");
                        break;

                    case 3:
                        System.out.println("-------------------------------------");
                        System.out.println("          All Employee Details       ");
                        System.out.println("-------------------------------------");
                        payrollSystem.displayEmployees();
                        break;

                    case 4:
                        System.out.println("-------------------------------------");
                        System.out.println("        Search Employee by ID        ");
                        System.out.println("-------------------------------------");
                        System.out.print("Enter Employee ID to search: ");
                        int searchId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        Employee foundEmployee = payrollSystem.searchEmployeeById(searchId);
                        if (foundEmployee != null) {
                            System.out.println("Employee Found: " + foundEmployee);
                        } else {
                            System.out.println("Employee not found.");
                        }
                        break;

                    case 5:
                        System.out.println("-------------------------------------");
                        System.out.println("         Calculate Total Payroll     ");
                        System.out.println("-------------------------------------");
                        System.out.println("Total Payroll: $" + payrollSystem.calculatepayrolls());
                        break;

                    case 6:
                        System.out.println("Exiting the Payroll System. Goodbye!");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter the correct data type.");
                scanner.nextLine(); // Clear the buffer
            }
        }
    }
}



//public class Main {
//    public static void main(String[] args) {
//        PayrollSystem payrollSystem = new PayrollSystem();
//        Scanner scanner = new Scanner(System.in);
//
//        while (true) {
//            System.out.println("\n=====================================");
//            System.out.println("         Payroll System Menu         ");
//            System.out.println("=====================================");
//            System.out.println("1. Add Employee");
//            System.out.println("2. Remove Employee");
//            System.out.println("3. Display All Employees");
//            System.out.println("4. Search Employee by ID");
//            System.out.println("5. Calculate Total Payroll");
//            System.out.println("6. Exit");
//            System.out.println("=====================================");
//            System.out.print("Choose an option: ");
//            int choice = scanner.nextInt();
//            scanner.nextLine();
//
//            switch (choice) {
//                case 1:
//                    addEmployee(scanner, payrollSystem);
//                    break;
//                case 2:
//                    removeEmployee(scanner, payrollSystem);
//                    break;
//                case 3:
//                    displayAllEmployees(payrollSystem);
//                    break;
//                case 4:
//                    searchEmployee(scanner, payrollSystem);
//                    break;
//                case 5:
//                    calculateTotalPayroll(payrollSystem);
//                    break;
//                case 6:
//                    System.out.println("\nExiting the Payroll System. Goodbye!");
//                    scanner.close();
//                    return;
//                default:
//                    System.out.println("\nInvalid option. Please try again.");
//            }
//        }
//    }
//
//    private static void addEmployee(Scanner scanner, PayrollSystem payrollSystem) {
//        System.out.println("\n-------------------------------------");
//        System.out.println("          Add a New Employee         ");
//        System.out.println("-------------------------------------");
//        System.out.print("Enter Employee Name: ");
//        String name = scanner.next();
//        System.out.print("Enter Employee ID: ");
//        int id = scanner.nextInt();
//
//        System.out.println("\nSelect Employee Type:");
//        System.out.println("1. Full-Time Employee");
//        System.out.println("2. Part-Time Employee");
//        System.out.print("Choose an option: ");
//        int typeChoice = scanner.nextInt();
//        scanner.nextLine();
//
//        switch (typeChoice) {
//            case 1:
//                System.out.print("Enter Monthly Salary: ");
//                double monthlySalary = scanner.nextDouble();
//                payrollSystem.addEmployee(new FullTimeEmployee(name, id, monthlySalary));
//                System.out.println("Full-Time Employee Added Successfully!");
//                break;
//            case 2:
//                System.out.print("Enter Hourly Rate: ");
//                double hourRate = scanner.nextDouble();
//                System.out.print("Enter Hours Worked: ");
//                int hoursWorked = scanner.nextInt();
//                scanner.nextLine();
//                payrollSystem.addEmployee(new PartTimeEmployee(name, id, hourRate, hoursWorked));
//                System.out.println("Part-Time Employee Added Successfully!");
//                break;
//            default:
//                System.out.println("Invalid employee type. Employee not added.");
//        }
//    }
//
//    private static void removeEmployee(Scanner scanner, PayrollSystem payrollSystem) {
//        System.out.println("\n-------------------------------------");
//        System.out.println("         Remove an Employee          ");
//        System.out.println("-------------------------------------");
//        System.out.print("Enter Employee ID to remove: ");
//        int id = scanner.nextInt();
//        scanner.nextLine();
//        payrollSystem.removeEmployee(id);
//        System.out.println("Employee Removed Successfully!");
//    }
//
//    private static void displayAllEmployees(PayrollSystem payrollSystem) {
//        System.out.println("\n-------------------------------------");
//        System.out.println("          All Employee Details       ");
//        System.out.println("-------------------------------------");
//        payrollSystem.displayEmployees();
//    }
//
//    private static void searchEmployee(Scanner scanner, PayrollSystem payrollSystem) {
//        System.out.println("\n-------------------------------------");
//        System.out.println("        Search Employee by ID        ");
//        System.out.println("-------------------------------------");
//        System.out.print("Enter Employee ID to search: ");
//        int id = scanner.nextInt();
//        scanner.nextLine();
//        Employee employee = payrollSystem.searchEmployeeById(id);
//        if (employee != null) {
//            System.out.println("Employee Found: " + employee);
//        } else {
//            System.out.println("Employee with ID " + id + " not found.");
//        }
//    }
//
//    private static void calculateTotalPayroll(PayrollSystem payrollSystem) {
//        System.out.println("\n-------------------------------------");
//        System.out.println("          Payroll Calculation        ");
//        System.out.println("-------------------------------------");
//        double totalPayroll = payrollSystem.calculatepayrolls();
//        System.out.println("Total Payroll: $" + totalPayroll);
//    }
//}
//
