package myPackage.vinay.fileIO;

public class EmployeePayrollData {
	public int employeeId;
	public String employeeName;
	public int employeeSalary;

	public EmployeePayrollData(int employeeId, String employeeName, int employeeSalary) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeSalary = employeeSalary;
	}

	@Override
	public String toString() {
		return "EmployeePayrollData [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeSalary="
				+ employeeSalary + "]";
	}		
}
