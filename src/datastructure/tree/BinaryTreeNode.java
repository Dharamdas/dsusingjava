package datastructure.tree;

public class BinaryTreeNode<E> {

	BinaryTreeNode leftChild;
	BinaryTreeNode rightChild;
	E data;
	
	BinaryTreeNode(E data){
		this.data=data;
		this.leftChild=null;
		this.rightChild=null;
				
	}
}
