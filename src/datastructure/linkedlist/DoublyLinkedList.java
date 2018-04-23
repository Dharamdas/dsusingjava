package datastructure.linkedlist;

public class DoublyLinkedList<E> {
	private Node mainNode;
	private int size;
	
	
	public void addNode(E value){
		
		if(value==null)
			throw new NullPointerException();
		Node newNode = new Node(value);
		if(mainNode==null){
			mainNode=newNode;
		}else{
			Node temp = mainNode;
			while(temp.next!=null){
				temp  = temp.next;
			}
			temp.next=newNode;
			newNode.prev=temp;
			
		}
	}
	
	public void reverseList(){
		
		Node currPointer=mainNode;
		Node tempPointer=null;
		
		while(currPointer!=null){
			
			tempPointer = currPointer.prev;
			currPointer.prev=currPointer.next;
			currPointer.next=tempPointer;
			currPointer = currPointer.prev;
		}
		mainNode = tempPointer.prev;
		
	}
	
	public void deleteNode(){
		
		Node temp = mainNode;
		while(temp.next.next!=null)
		{
			temp = temp.next;
		}
		System.out.println("Deleted Node:"+temp.next.data);
		temp.next=null;
	}
	
	public void displayAllNodes(){
		Node temp = mainNode;
		
		while(temp!=null){
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
	
	
	
	
	public int getSize() {
		return size;
	}
	
	
	class Node<E>{
		E data;
		Node next,prev;
		Node(E data){
			this.data=data;
			next=prev=null;
		}
		
	}

}
