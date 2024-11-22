/*
 Title Name : Employee Management System
 Author Name : Thanya V
 Created on : 09.10.2022
 Modified by : 20.10.2022 
 Reviewed by : Anushya
 Reviewed Date : 12.10.2022
 */


package employeemanagementapplication;

import java.util.Scanner;
class ListOfOpearations{
	public static void  Menu() {
		System.out.println("Employee Managment System "
				+ "\n1.Add Employee "
				+ "\n2.View Employee"
				+ "\n3.Update Employee"
				+ "\n4.Delete Employee"
				+ "\n5.View All Employee"
				+ "\n6. Exit ");
	}
}
public class Main extends ListOfOpearations {

	EmployeeService service = new EmployeeService();
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			EmployeeService service = new EmployeeService();
			do {
				ListOfOpearations.Menu();
				System.out.println("Enter your Choice");
				int choice = scanner.nextInt();
				switch (choice) {

					case 1:
						System.out.println("Add Employee");
						service.addEmployee();
						break;
					case 2:
						System.out.println("View Employee");
						service.viewEmployee();
						break;
					case 3:
						System.out.println("Update Employee");
						service.updateEmployee();
						break;
					case 4:
						System.out.println("Delete Employee");
						service.deleteEmployee();
						break;
					case 5:
						System.out.println("view All Employee");
						service.viewAllEmployees();
						break;
					case 6:
						System.out.println("Exit");
						System.exit(0);

					default:
						System.out.println("Please enter valid choice");
						break;

				}

			} while (true);
		} catch (Exception e) {
			System.out.println("Something went Wrong!Please Retry by Entering an Integer Value");
		} finally {
			System.out.println("Thank you for using application!!");
		}

	}

}