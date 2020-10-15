package myPackage.vinay.fileIO;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import myPackage.vinay.fileIO.EmployeePayrollService.IOService;

class EmployeePayrollServiceTest {
	
	@Test
	public void given3EmployeesWhenWrittenToFileShouldMatchEmployees() throws Exception {
		EmployeePayrollData[] arrayOfEmployees =  {
				new EmployeePayrollData(1,"vinay",1000),
				new EmployeePayrollData(2, "Harika",2000),
				new EmployeePayrollData(3, "Chandu", 3000),
		};
		EmployeePayrollService employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmployees));
		employeePayrollService.writeEmployeePayrollData(IOService.FILE_1O);
		employeePayrollService.printData(IOService.FILE_1O);
		assertEquals(employeePayrollService.countEntries(IOService.FILE_1O), 3);		
	}
	
	@Test
	public void testForReadFileIO() throws Exception {
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		employeePayrollService.readEmployeePayrollData(IOService.FILE_1O);
		assertEquals(employeePayrollService.employeePayRollList.size(), 3);
	}
}
