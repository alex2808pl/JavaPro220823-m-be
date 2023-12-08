package de.telran.module_2.lesson_7;

import java.util.Stack;

public class SimpleStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.add(5);
//        stack.push(null);
        System.out.println(stack);

        System.out.println(stack.size() + " --- "+stack.capacity());

        if(!stack.empty()) {
            System.out.println(stack.peek());
            System.out.println(stack);

            int out = stack.pop();
            System.out.println(out);
            System.out.println(stack);
        }

    }
}
