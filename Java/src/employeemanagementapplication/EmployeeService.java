package employeemanagementapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Scanner;

abstract class Details{
	abstract void addEmployee();
	abstract void viewEmployee();
	abstract void updateEmployee();
	abstract void deleteEmployee();
	abstract void viewAllEmployees();
}

class EmployeeService extends Details {

	HashSet<Employee> employeeDetails = new HashSet<Employee>();

	Employee emp1 = new Employee(1, "Thanya", 21, "Coimbatore", 20000);
	Employee emp2 = new Employee(2, "Abi", 22, "Mumbai", 57000);
	Employee emp3 = new Employee(3, "Nithya", 23, "Coimbatore", 30000);
	Employee emp4 = new Employee(4, "Thasneem", 24, "Chennai", 10000);
 

	Scanner sc = new Scanner(System.in);
	boolean found = false;
	int id;
	String name;
	int age;
	String address;
	double salary; 
    

	public EmployeeService() {

		employeeDetails.add(emp1);
		employeeDetails.add(emp2);
		employeeDetails.add(emp3);
		employeeDetails.add(emp4);

	}

	public void viewAllEmployees() {
		Connection connection;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","1234");
			Statement statement=connection.createStatement();
	        String s;
	        s="SELECT * FROM employeedetails";
	        ResultSet resultset=statement.executeQuery(s);
	        while (resultset.next()) {
       
                int id = resultset.getInt("employeeid");
                String name = resultset.getString("name");
                int age = resultset.getInt("age");
                String address = resultset.getString("address");
                int salary = resultset.getInt("salary");

                System.out.println("Employee \nID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Address: " + address);
                System.out.println("Salary: " + salary);
            }
	        connection.close();
	        System.out.println("Successfull");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*for (Employee emp : employeeDetails) {
			System.out.println(emp);
		}*/
	}

	public void viewEmployee() {

		System.out.println("Enter id: ");
		id = sc.nextInt();
		Connection connection;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","1234");
			Statement statement=connection.createStatement();
	        String s;
	        s="SELECT * FROM employeedetails WHERE employeeid =" + id;
	        ResultSet resultset=statement.executeQuery(s);
	        while (resultset.next()) {
       
                int id = resultset.getInt("employeeid");
                String name = resultset.getString("name");
                int age = resultset.getInt("age");
                String address = resultset.getString("address");
                int salary = resultset.getInt("salary");

                System.out.println("Employee \nID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Address: " + address);
                System.out.println("Salary: " + salary);
            }
	        connection.close();
	        System.out.println("Successfull");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/* for (Employee emp : employeeDetails) {
			if (emp.getId() == id) {
				System.out.println(emp);
				found = true;
			}

		}
		if(!found) {
			System.out.println("Employee with this id is not present");
		} */
	}

	public void updateEmployee() {
		System.out.println("Enter id: ");
		id = sc.nextInt();
		boolean found = false;
		for (Employee emp : employeeDetails) {
			if (emp.getId() == id) {
				System.out.println("Enter new Salary");
				salary = sc.nextDouble();
				Database database = new Database();
		        String s;
		        s="UPDATE employeedetails SET salary ="+ salary +"WHERE employeeid =" + id;
		        database.databasedetails( s);
				emp.setSalary(salary);
				System.out.println("Updated Details of employee are: ");
				System.out.println(emp);
				found = true;
			}
		}
		if (!found) {
			System.out.println("Employee is not present");
		} else {
			System.out.println("Employee details updated successfully !!");
		}
	}

	public void deleteEmployee() {
		System.out.println("Enter id");
		id = sc.nextInt();
		boolean found = false;
		Employee empdelete = null;
		Database database = new Database();
        String s;
        s="DELETE FROM employeedetails WHERE employeeid =" + id;
        database.databasedetails( s);
		for (Employee emp : employeeDetails) {
			if (emp.getId() == id) {
				empdelete = emp;
				found = true;
			}
		}
		if (!found) {
			System.out.println("Employee is not present");
		} else {
			employeeDetails.remove(empdelete);
			System.out.println("Employee deleted successfully!!");
		}
	}

	public void addEmployee() {
		System.out.println("Enter Id:");
		id = sc.nextInt();
		System.out.println("Enter Name");
		name = sc.next();
		System.out.println("Enter Age");
		age = sc.nextInt();
		System.out.println("Enter Address");
		address = sc.next();
		System.out.println("Enter Salary");
		salary = sc.nextDouble();
        Database database = new Database();
        String s;
        s="INSERT INTO employeedetails VALUES ("+id+",'"+name+"',"+age+",'"+address+"',"+salary+")";
        database.databasedetails( s);
        		
		Employee emp = new Employee(id, name, age, address, salary);

		employeeDetails.add(emp);
		System.out.println(emp);
		System.out.println("Employtee addeed successsfully");

	}

}