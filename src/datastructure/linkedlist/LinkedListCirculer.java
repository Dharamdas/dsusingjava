package datastructure.linkedlist;

public class LinkedListCirculer {
	 	
	Node first=null;
	Node circularPoint1; //points used to make LinkedList circular.
	Node circularPoint2;
	Node slowPointer; //will step over LinkedList by 1 Node.
	Node fastPointer; //will step over LinkedList by 2 Node.
	
	/**
     * Insert New Node at first position
     */
    public void insert(int data){
           
           Node newNode=new Node(data);
           newNode.next=first;
           first=newNode;
           /*
            * Below we have kept track of two Nodes so that later we can make LinkedList circular(If required).
            * Note:- I have kept track of below two nodes just for demonstration purpose. You may provide some other implementation for making LinkedList circular.
            */
           if(data==33)
                  circularPoint1=newNode;        
           if(data==66)
                  circularPoint2=newNode;
    }
    
    public void findIntersectionPoint(){
    	
    	slowPointer = first;
    	fastPointer = first;
    	
    	while(slowPointer!=fastPointer || slowPointer!=first && fastPointer!=null 
    			&& fastPointer.next.next!=null){
    		slowPointer = slowPointer.next;
    		fastPointer = fastPointer.next.next;
    	}
    	
    	slowPointer = first;
    	while(slowPointer!=fastPointer){
    		slowPointer = slowPointer.next;
    		fastPointer = fastPointer.next;
    	}
    	System.out.println("Linked List Intersect at :"+slowPointer.data);
    	
    }
    
    public boolean findCirculerOrNot()
    {
    	slowPointer = first;
    	fastPointer = first;
    	
    	while(slowPointer!=fastPointer || slowPointer!=first && fastPointer!=null 
    			&& fastPointer.next.next!=null){
    		slowPointer = slowPointer.next;
    		fastPointer = fastPointer.next.next;
    	}
    	if(slowPointer==fastPointer)
    	{
    		System.out.println("Return Circuler Position: "+slowPointer.data);
    		return true;
    	}
    	return false;
    }
	
    /**
     *This method makes LikedList circular- by making end Node point to some middle Node of LinkedList.
     *end Node--->middle Node.
     */
    public void makeLinkedListCircular(){
    	if(circularPoint2!=null || circularPoint1!=null)
           circularPoint2.next=circularPoint1;
           System.out.println("LinkedList has been succesfully converted into CircularLinkedList");
    }	
	
	class Node {
	    public int data; // data in Node.
	    public Node next; // points to next Node in list.
	    
	    public Node(int data){
	           this.data = data;
	    }
	 
	 	}

}
