package datastructure.queue;

public class QueueCustomTest {

	public static void main(String[] args) {

		QueueCustom<Integer> q = new QueueCustom<Integer>();
		q.enQueue(10);
		q.enQueue(20);
		q.enQueue(30);
		q.enQueue(40);
		q.displayAll();
		q.enQueue(50);
		q.enQueue(60);
		System.out.println();
		System.out.println("DeQueue Value: "+q.deQueue());
		q.displayAll();

		System.out.println();
		System.out.println("Queue Size: "+q.getSize());
		System.out.println("Queue Capacity: "+q.getCapacity());
		
	}

}
