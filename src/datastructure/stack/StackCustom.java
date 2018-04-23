package datastructure.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;

public class StackCustom<E> {
	
	private int top;
	private int size;
	private int capacity;
	private Object[] stackBucket;

	public StackCustom() {
		this(5);
	}
	StackCustom(int initialSize){
		if(initialSize<0)
			throw new IllegalArgumentException();
		this.capacity=initialSize;
		this.stackBucket = new Object[initialSize];
		top=-1;
		
	
	}
	
	public void push(E value){
		
		ensureCapacity(size+1);
		stackBucket[++top]=value;
		size++;
	}
	
	public E pop(){
		if(top==-1)
			throw new ArrayIndexOutOfBoundsException("Stack is Empty");
		E popValue=(E) stackBucket[top];
		top--;size--;
		return popValue;
	}
	
	public void displayStack(){
		for(int i=0;i<size;i++){
			System.out.print(stackBucket[i]+" ");
		}
	}
	public int getSize() {
		return size;
	}
	public int getCapacity() {
		return capacity;
	}
	private void ensureCapacity(int currentSize){
		if(this.capacity<currentSize)
		{
			int newCapacity = capacity*2;
			this.capacity=newCapacity;
			stackBucket = Arrays.copyOf(stackBucket, newCapacity);
		}
	}
	
}
