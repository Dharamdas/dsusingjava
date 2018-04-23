package datastructure.queue;

public class CircularQueueCustomTest {

	public static void main(String[] args) {

		CircularQueueCustom<Integer> cq = new CircularQueueCustom<Integer>();
		cq.enQueue(10);
		cq.enQueue(30);
		cq.enQueue(40);
		cq.enQueue(120);
		cq.enQueue(300);
		cq.enQueue(540);
		cq.displayAll();
		
	}

}
