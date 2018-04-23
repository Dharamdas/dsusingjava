package datastructure.stack;

public class StackTest {

	public static void main(String[] args) {

		StackCustom<Integer> stack = new StackCustom<Integer>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.displayStack();
		System.out.println();
		System.out.println("Stack Size: "+stack.getSize());
		System.out.println("Stack Capacity: "+stack.getCapacity());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println("Stack Size: "+stack.getSize());
		System.out.println("Stack Capacity: "+stack.getCapacity());
	}

}
