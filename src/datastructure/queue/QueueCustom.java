package datastructure.queue;

import java.util.Arrays;

public class QueueCustom<E> {
	
	private int size;
	private Object[] queueBucket;
	private int capacity;
	private int front,rare;
	
	public QueueCustom() {
		this(5);
	}
	public QueueCustom(int initialSize) {
		queueBucket = new Object[initialSize];
		this.front=this.rare=-1;
		this.capacity=initialSize;
	}
	
	public void enQueue(E value){
		ensureCapacity(rare+1);
		queueBucket[++rare]=value;
		size++;
		if(front==-1)
			front++;
	}
	public E deQueue(){
		if(front==-1 || front==rare+1){
			//throw new ArrayIndexOutOfBoundsException("Queue is empty");
			return null;
		}
		E dequeueValue = (E) queueBucket[front];
		front++;size--;
		return dequeueValue;
	}
	public void displayAll(){
		int count=0;
		if(front!=-1)
		count=front;
		while(count<=rare){ 
			System.out.print(queueBucket[count]+" ");
			count++;
		}
	}
	
	public int getSize() {
		return size;
	}
	public int getCapacity() {
		return capacity;
	}
	private void ensureCapacity(int currentSize){
		if(currentSize<=this.capacity){
			int newCapacity=capacity*2;
			this.capacity=newCapacity;
			queueBucket = Arrays.copyOf(queueBucket, newCapacity);
		}
	}
	
	public boolean isEmpty(){
		if(size>0)
			return true;
		else
			return false;
	}

}
