package datastructure.linkedlist;

public class DoublyLinkedListTest {

	public static void main(String[] args) {

		DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
		list.addNode(10);
		list.addNode(20);
		list.addNode(30);
		list.addNode(40);
		list.displayAllNodes();
		list.reverseList();
		System.out.println();
		list.displayAllNodes();
	}

}
