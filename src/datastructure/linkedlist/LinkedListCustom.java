package datastructure.linkedlist;


public class LinkedListCustom<E> {
	private  Node mainNode; 
	private int size;
	
	
	public void addNode(E value)
	{
		Node newNode = new Node(value);
		//if no node is created
		if(mainNode==null){
			mainNode=newNode;
			size++;
		}else{
			//if already nodes are there
			Node temp = mainNode;
			while(temp.next!=null)
			{
				temp = temp.next;
			}
			temp.next = newNode;
			size++;
		}
	}
	
	public void addAtStart(E value)
	{
		Node newNode = new Node(value);
		if(mainNode==null){
			mainNode = newNode;
			size++;
		}else{
		newNode.next = mainNode;
		mainNode = newNode;
		size++;
		}
	}
	
	public E deleteNode(E value)
	{
		Node temp = mainNode;
		Node prev = mainNode;
		boolean found=false;
		E deletedValue=null;
		while(temp!=null)
		{
			if(temp.data==value){
				found=true;
				size--;
				break;
			}
			prev = temp;
			temp = temp.next;
		}
		if(found){
			prev.next=temp.next;
			deletedValue = (E) temp.data;
			temp=null;
			size--;
		}
		return deletedValue;
	}
	
	public void displayAllNode(){
		Node temp = mainNode;
		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
	
	// find the kth node from end.
		public E kThNodeFromEnd(E value){
			
			int kth = Integer.parseInt(value.toString());
			
			Node tempNode = mainNode;
			Node kthNode = mainNode;
			int k=1;
			while(k<=kth){
				tempNode = tempNode.next;
				k++;
			}
			while(tempNode!=null)
			{
				kthNode = kthNode.next;
				tempNode = tempNode.next;
			}
			return (E)kthNode.data;
		}
		
	public void reverseLinkedList(){
		
		Node nextPointer = mainNode;
		Node prevPointer = null;
		Node currPointer=mainNode;
		
		while(nextPointer!=null){
			
			nextPointer = nextPointer.next;
			currPointer.next=prevPointer;
			prevPointer=currPointer;
			currPointer = nextPointer;
		}
		mainNode=prevPointer;
		
	}	
	
	public E twoListMergingOrNot(LinkedListCustom list1,LinkedListCustom list2){
		
		Node smallerList=list1.mainNode;
		Node largerList=list2.mainNode;
		
		//find out the diff of the list
		Integer listDiff = list2.getSize()-list1.getSize();
		int count=0;
		//if difference is negative, swap the references of lists.
		if(listDiff<0){
			smallerList = list2.mainNode;
			largerList = list1.mainNode;
			listDiff = Math.abs(listDiff);
		}
		
		while(largerList!=null)
		{
			E lvalue = (E) largerList.data;
			if(count<listDiff){
				count++;
				continue;
			}
			E svalue = (E)smallerList.data;
			if(lvalue==svalue)
			{
				System.out.println("Node is merging");
				return lvalue;
			}
			largerList = largerList.next;
			smallerList = smallerList.next;
		}
		
		return null;
	}
		
	public int getSize() {
		return size;
	}
// inner class to create Node
	class Node<E>{
		E data;
		Node next;
		
		Node(E value){
			this.data=value;
			next=null;
		}
	}

}
