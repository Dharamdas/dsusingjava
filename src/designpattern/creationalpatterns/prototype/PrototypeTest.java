package designpattern.creationalpatterns.prototype;

import java.util.List;

public class PrototypeTest {

	public static void main(String[] args)throws Exception {

		Employee e = new Employee();
		e.loadData();
		System.out.println(e.getEmployeeList());
		//after clone object
		
		Employee e1 = (Employee)e.clone();
		System.out.println(e1.getEmployeeList());
		List<String> list = e1.getEmployeeList();
		list.remove("Raj");
		list.remove("Ravi");
		System.out.println(list);
		
	}

}
