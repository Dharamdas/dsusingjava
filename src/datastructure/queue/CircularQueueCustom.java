package datastructure.queue;

import java.util.Arrays;

public class CircularQueueCustom<E> {
	
	private int size;
	private Object[] queueBucket;
	private int capacity;
	private int front,rare;
	
	public CircularQueueCustom() {
		this(5);
	}
	public CircularQueueCustom(int initialSize) {
		queueBucket = new Object[initialSize];
		this.front=this.rare=-1;
		this.capacity=initialSize;
	}
	
	public void enQueue(E value){
		ensureCapacity(size+1);
		if(front==-1)
			front++;
		if(rare==-1)
			rare++;
		queueBucket[rare]=value;
		this.rare = (rare+1)%capacity;
		size++;
	
	}
	public E deQueue(){
		if(front==-1 || front==rare){
			throw new ArrayIndexOutOfBoundsException("Queue is empty");
		}
		E dequeueValue = (E) queueBucket[front];
		front = (front+1)%capacity;
		size--;
		return dequeueValue;
	}
	public void displayAll(){
		int count=0;
		if(front!=-1)
		count=front;
		for(int i=0;i<size-1;i++)
			System.out.print(queueBucket[i]+" ");
	}
	public int getSize() {
		return size;
	}
	public int getCapacity() {
		return capacity;
	}
	private void ensureCapacity(int currentSize){
		if(this.capacity<currentSize){
			int newCapacity=capacity*2;
			this.capacity=newCapacity;
			queueBucket = Arrays.copyOf(queueBucket, newCapacity);
		}
	}
	
	
	
	

}
