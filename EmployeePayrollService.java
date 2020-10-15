package myPackage.vinay.fileIO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
	public static Scanner userInputScanner = new Scanner(System.in);
	public EmployeePayrollFileIOService employeePayrollFileIOService = new EmployeePayrollFileIOService();

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
		employeePayrollService.writeEmployeePayrollData(IOService.FILE_1O);
		employeePayrollService.printData(IOService.FILE_1O);
		System.out.println(employeePayrollService.countEntries(IOService.FILE_1O));
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
		if (ioService.equals(IOService.CONSOLE_IO))
			System.out.println("Writing Employee Payroll Roaster to console :" + employeePayRollList);
		else if (ioService.equals(IOService.FILE_1O)) {
			employeePayrollFileIOService.writeData(employeePayRollList);
		}
	}

	public void printData(IOService iOService) {
		if (iOService.equals(IOService.CONSOLE_IO))
			System.out.println(this.employeePayRollList);
		else if (iOService.equals(IOService.FILE_1O))
			employeePayrollFileIOService.printData();
	}

	public long countEntries(IOService ioService) {
		long entries = 0;
		if (ioService.equals(IOService.CONSOLE_IO))
			entries = employeePayRollList.size();
		else if (ioService.equals(IOService.FILE_1O))
			entries = employeePayrollFileIOService.countEntries();
		return entries;
	}

}
