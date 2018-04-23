package datastructure.linkedlist;



public class LinkedListTest {

	public static void main(String[] args) {

		CustomLinkedList list = new CustomLinkedList();
		list.addNode(10, "Raj");
		list.addNode(12, "Ravi");
		list.addNode(30, "Suraj");
		list.addNode(40, "XYZ");
		list.addNode(50, "ABC");
		list.display();
		//deleting by position
		System.out.println("Deleted Node: "+list.deleteNode(2));
		//deleting by Name
		System.out.println("Deleted Node: "+list.deleteNode("Suraj")); 
		list.display();
		
	}

}
