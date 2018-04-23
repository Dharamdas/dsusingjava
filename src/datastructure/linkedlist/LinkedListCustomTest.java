package datastructure.linkedlist;

public class LinkedListCustomTest {

	public static void main(String[] args) {

		LinkedListCustom<Integer> list = new LinkedListCustom<Integer>();
		list.addNode(10);list.addNode(20);list.addNode(30);	list.addNode(40);
		list.addNode(50);list.addNode(60);
		list.displayAllNode();
		System.out.println();
		System.out.println("Second List");
		LinkedListCustom<Integer> list1 = new LinkedListCustom<Integer>();
		list1.addNode(90);list1.addNode(80);list1.addNode(70);	list1.addNode(40);
		list1.addNode(50);list1.addNode(60);
		list1.displayAllNode();
		
		System.out.println("Merging Node Value: "+list.twoListMergingOrNot(list, list1));
		
		
		
		//list.reverseLinkedList();
		//System.out.println();
		//list.displayAllNode();
		//list.addAtStart(60);
		//System.out.println();
		//list.displayAllNode();
		//list.deleteNode(20);
		//System.out.println();
	//	list.displayAllNode();
		//System.out.println();
		//System.out.println("Kth Node from the End: "+list.kThNodeFromEnd(5));
	}

}
