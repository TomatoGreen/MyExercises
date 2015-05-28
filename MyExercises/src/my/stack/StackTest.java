package my.stack;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();

		stack.push("1");
		stack.push("2");
		stack.push("3");

		int index = stack.search("3");
		System.out.println(index);
		index = stack.search("2");
		System.out.println(index);
		index = stack.search("1");
		System.out.println(index);

	}

}
