package datastructure.tree;

import datastructure.queue.QueueCustom;

import java.util.Comparator;

public class BinaryTree<E> {
	
	private BinaryTreeNode rootNode;
	int totalNode;
	ComparatorImpl comparatorImpl=null;
	public BinaryTree() {
		comparatorImpl = new ComparatorImpl();
	}
	public BinaryTree(BinaryTreeNode root) {
		this();
		this.rootNode=root;
	}
	public void printLevelOrder(BinaryTree tree)
	{
	   printLevelOrder(tree.rootNode);
	}
	private void printLevelOrder(BinaryTreeNode root){
		if(root==null)
			throw new NullPointerException();
		
		QueueCustom q = new QueueCustom();
		q.enQueue(root);
		while(q.isEmpty()){
			BinaryTreeNode temp = (BinaryTreeNode) q.deQueue();
			System.out.print(temp.data+" ");
			if(temp.leftChild!=null)
				q.enQueue(temp.leftChild);
			if(temp.rightChild!=null)
				q.enQueue(temp.rightChild);
		}
		
	}
	public boolean isMirror(BinaryTree tree1,BinaryTree tree2){
		return isMirror(tree1.rootNode, tree2.rootNode);
	}
	private boolean isMirror(BinaryTreeNode root1,BinaryTreeNode root2){
		if(root1==null && root2==null)
			return true;
		if(root1==null || root2==null)
			return false;
		if(root1.data!=root2.data)
			return false;
		else return(isMirror(root1.leftChild, root2.rightChild) 
				&& isMirror(root1.rightChild, root2.leftChild));
	}
	
	public BinaryTree createMirrorOfTree(BinaryTree tree){
		
		BinaryTreeNode node = mirrorOfTree(tree.rootNode);
		BinaryTree tree1 = new BinaryTree(node);
		return tree1;
	}
	private BinaryTreeNode mirrorOfTree(BinaryTreeNode node){
		if(node==null)
			return null;
		if(node!=null){
		mirrorOfTree(node.leftChild);
		mirrorOfTree(node.rightChild);
		//  swap the pointer at this node
		BinaryTreeNode temp = node.leftChild;
		node.leftChild = node.rightChild;
		node.rightChild=temp;
		}
		return node;
	}
	public void addNode(E data){
		if(data==null)
			throw new NullPointerException();
		
		BinaryTreeNode newTreeNode = new BinaryTreeNode(data);
		if(rootNode==null)
		{
			rootNode=newTreeNode;	
		}else{
			BinaryTreeNode temp =rootNode;
			while(true){
				int v = comparatorImpl.compare(data,(E)temp.data);
				if(v>=0)
				{
					if(temp.rightChild==null)
						{
						 temp.rightChild=newTreeNode;
						 break;
						}
					temp = temp.rightChild;
				}else{
					if(temp.leftChild==null){
						temp.leftChild=newTreeNode;
						break;
					}
					temp = temp.leftChild;
				}
			}
			
		}
		
	}
	
	public boolean delete(E key)
	{
		BinaryTreeNode current,parent;
		boolean isLeftChild=true;
		current=parent=rootNode;
		
		while(current.data!=key){
			
			parent = current;
			
			int v = comparatorImpl.compare(key, (E)current.data);
			if(v>0){
				
				isLeftChild=false;
				current = current.rightChild;
			}else{

				isLeftChild=true;
				current = current.leftChild;
			}
			if(current==null)
				return false;
		}
		if(current.leftChild==null && current.rightChild==null){
			if(current==rootNode)
				rootNode = current.leftChild;
			if(isLeftChild){
				parent.leftChild=current.leftChild;
			}else{
				parent.rightChild=current.rightChild;
			}
			
		}else if(current.rightChild==null)
		{
			if(current==rootNode)
				rootNode=current.rightChild;
			if(isLeftChild)
				parent.leftChild=current.leftChild;
			else
				parent.rightChild=current.rightChild;
		}else if(current.leftChild==null)
		{
			if(current==rootNode)
				rootNode=current.leftChild;
			else if(isLeftChild)
				parent.leftChild=current.leftChild;
			else
				parent.rightChild=current.rightChild;
		}else  // if current having both child
		{
			BinaryTreeNode successor = findSuccessor(current, isLeftChild);
			if(current==successor)
				rootNode=successor;
			else if(isLeftChild)
				parent.leftChild=successor;
			else
				parent.rightChild=successor;
			
			successor.leftChild=current.leftChild;
		}
		
		return true;
	}
	
	private BinaryTreeNode findSuccessor(BinaryTreeNode temp,boolean isLeft){
		
		BinaryTreeNode replaceNode=null;
		if(isLeft) // delete node from left sub tree
		{
			replaceNode = temp.leftChild;
			while(replaceNode.leftChild!=null)
			{
				replaceNode = replaceNode.leftChild;
			}
		}
		else // node delete from right sub tree
		{
			replaceNode = temp.rightChild;
			while(replaceNode.rightChild!=null)
			{
				replaceNode = replaceNode.rightChild;
			}
		}
		return replaceNode;

	}
	
	public void preOrderTraversal(BinaryTree root){
		preOrderTraversal(root.rootNode);
	}
	private void preOrderTraversal(BinaryTreeNode node){
		if(node==null)
			return;
		System.out.print(node.data+" ");
		preOrderTraversal(node.leftChild);
		preOrderTraversal(node.rightChild);
	}
	
	public void inOrderTraversal(BinaryTree root){
		inOrderTraversal(root.rootNode);
	}
	private void inOrderTraversal(BinaryTreeNode node){
		if(node==null)
			return;
		inOrderTraversal(node.leftChild);
		System.out.print(node.data+" ");
		inOrderTraversal(node.rightChild);
		
	}
	
	public void postOrderTraversal(BinaryTree root){
		postOrderTraversal(root.rootNode);
	}
	private void postOrderTraversal(BinaryTreeNode node){
		if(node==null)
			return;
		postOrderTraversal(node.leftChild);
		postOrderTraversal(node.rightChild);
		System.out.print(node.data+" ");
	}
	public int findMaxElement(BinaryTree tree){
		return findMaxElement(tree.rootNode);
	}
	private int findMaxElement(BinaryTreeNode node){
		int root_val,left,right,max=0;
		if(node!=null)
		{
			root_val = (int) node.data;
			left = (int)findMaxElement(node.leftChild);
			right = (int)findMaxElement(node.rightChild);
			//find the larget of 3 values
			if(left>right)
				max=left;
			else
				max=right;
			if(max<root_val)
				max=root_val;
		}
		return max;
	}
	public int findMinElement(BinaryTree tree)
	{
		return findMaxElement(tree.rootNode);
	}
	private int findMinElement(BinaryTreeNode node){
		int root_val,min=0,left,right;
		if(node!=null){
			root_val= (int)node.data;
			left = findMinElement(node.leftChild);
			right = findMinElement(node.rightChild);
			if(left<right)
				min=left;
			else
				min=right;
			if(root_val<min)
				min=root_val;
		}
		return min;
	}
	class ComparatorImpl implements Comparator<E>{

		@Override
		public int compare(E o1,E o2) {
			return ((Comparable)o1).compareTo(o2);
		}
		
	}

}
