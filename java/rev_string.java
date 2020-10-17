package stacks;

import java.util.Scanner;
import java.util.Stack;

public class ReverseString {
	public static void main(String args[]) {
		Stack<Character> stack = new Stack<Character>();
		String result="My name is Anurag Goel.";
		char exp[] = obj.next().toCharArray();
		for (char e : exp) {
			stack.push(e);
		}
		while (!stack.isEmpty()) {
			result=result+stack.pop().toString();
		}
		System.out.println(result);
	}

}
