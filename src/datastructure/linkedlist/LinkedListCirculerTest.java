package datastructure.linkedlist;

public class LinkedListCirculerTest {

	public static void main(String[] args) {

		LinkedListCirculer list = new LinkedListCirculer();
		list.insert(20);
		list.insert(70);
		list.insert(3);
		list.insert(80);
		list.insert(6);
		list.insert(100);
		list.insert(95);
		list.makeLinkedListCircular();
		System.out.println(list.findCirculerOrNot());
		list.findIntersectionPoint();
	}

}
