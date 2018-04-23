package immutableclass;

public class Employee {

	int empId;
	String name;
	
	public Employee(int id,String name) {
		this.empId=id;
		this.name=name;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
