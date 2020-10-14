package myPackage.vinay.fileIO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
	public static Scanner userInputScanner = new Scanner(System.in);

	private enum IOService {
		CONSOLE_IO, FILE_1O, DB_IO, REST_IO
	}

	public List<EmployeePayrollData> employeePayRollList;

	public EmployeePayrollService() {
	}

	public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {
		this.employeePayRollList = employeePayrollList;
	}

	public static void main(String[] args) {
		ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<>();
		EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
		employeePayrollService.readEmployeePayrollData();
	}

	public void readEmployeePayrollData() {
		System.out.println("Enter Employee Id : ");
		int id = userInputScanner.nextInt();
		userInputScanner.nextLine();
		System.out.println("Enter Employee Name : ");
		String name = userInputScanner.nextLine();
		System.out.println("Enter salary");
		int salary = userInputScanner.nextInt();
		employeePayRollList.add(new EmployeePayrollData(id, name, salary));

	}

	public void writeEmployeePayrollData(IOService ioService) {
		if(ioService.equals(IOService.CONSOLE_IO))
			System.out.println("Writing Employee Payroll Roaster to console :" + employeePayRollList);
		else if(ioService.equals(IOService.FILE_1O)) {
			new EmployeePayrollFileIOService().writeData(employeePayRollList);
		}
	}
	
}
