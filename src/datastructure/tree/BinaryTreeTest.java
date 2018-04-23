package datastructure.tree;

public class BinaryTreeTest {

	public static void main(String[] args) {

		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.addNode(50);
		tree.addNode(40);
		tree.addNode(60);
		tree.addNode(20);
		tree.addNode(45);
		tree.addNode(25);
		tree.addNode(22);
		tree.addNode(41);
		tree.addNode(46);
		tree.addNode(55);
		tree.addNode(65);
		tree.addNode(58);
		tree.addNode(52);
		tree.inOrderTraversal(tree);
		System.out.println();
		System.out.println("Max Element From tree: "+tree.findMaxElement(tree));
		//System.out.println(tree.delete(22));
		System.out.println();
		//tree.inOrderTraversal(tree);
		System.out.println("Print Level Order");
		tree.printLevelOrder(tree);
		System.out.println();
		BinaryTree tree1 = tree.createMirrorOfTree(tree);
		tree1.printLevelOrder(tree1);
		System.out.println();
		System.out.println("Tree Mirror of Tree1 : "+tree.isMirror(tree,tree1));
		
	}

}
