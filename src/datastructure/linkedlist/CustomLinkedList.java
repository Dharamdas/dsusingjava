/*
 *  Link list  ( age integer , name string  ) to add / delete nodes.  Deletion of node by 2 options
a.      By node position
b.      By  name.
 * */

package datastructure.linkedlist;

public class CustomLinkedList {

	/*this member will be a  root node
	 * */
	Node headNode;  
	/*this will contain the total number of node in linked list
	 * */
	int size;
	
	
	public void addNode(Integer value,String name){
		if(value==null || name==null)
			throw new NullPointerException();
		Node newNode = new Node(value,name);
		
		if(headNode==null)  // add first Node
		{
			headNode = newNode;
			size++;
		}
		else{   // if there are more than 1 node 
			Node temp = headNode;
			while(temp.next!=null)
			{
				temp = temp.next;
			}
			temp.next=newNode;
			size++;
		}
		
	}
	
	
	
	public Integer deleteNode(Integer index) // delete node by Position
	{
		if(index>size || index<0)
			throw new ArrayIndexOutOfBoundsException("Index : "+index);
		
		if(index==1) //if only single Node
		{
			int age = headNode.employee.getAge();
			headNode= headNode.next;
			size--;
			return age;
			}else{  // if not first node
				
			int count=1;
			Node temp = headNode;
			Node prev = null;
			while(count!=index){
				prev = temp;
				temp = temp.next;
				count++;
			}
			prev.next = temp.next;
			prev=temp;
			int age = temp.employee.getAge();
			temp=null;
			size--;
			return age;
		}
	}
	
	public String deleteNode(String value) // delete node by Name
	{
		
		if(value==null || value=="") // if input value is null
			throw new NullPointerException("String Value : "+value);
		String empName=null;
		if(headNode.employee.getName().equalsIgnoreCase(value)) /// if value matches with first Node
		{
			empName = headNode.employee.getName();
			headNode=headNode.next;
			size--;
			return empName;
		}else{
			Node temp = headNode;
			Node prev=null;
			while(true){
				if(temp==null)
					return empName; // if Name not found
				if(temp.employee.getName().equalsIgnoreCase(value))
				{
					empName = temp.employee.getName();
					prev.next=temp.next;
					prev=temp;temp=null;
					size--;
					return empName;
				}
				prev = temp;
				temp = temp.next;
			}
			
		}
	}
	
	public void display()
	{
		Node temp = headNode;
		while(temp!=null)
		{
			System.out.println(temp.employee.getAge()+" "+temp.employee.getName());
			temp = temp.next;
		}
	}
	
	public int getSize() {
		return size;
	}
	class Node
	{
		Employee employee; // data part of the Linked List
		Node next;   // address node of the Linked List
		Node(Integer age,String name){
			employee = new Employee();
			employee.setAge(age);
			employee.setName(name);
			next=null;
		}
	}
}
// Employee Object to hold the data
class Employee{
	Integer age;
	String name;
	
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getAge() {
		return age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
}

