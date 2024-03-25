package stack;

import java.util.Stack;

public class StackClass {

    public static void allOperations(){
        Stack stack=new Stack();

        stack.push(10);
        stack.push("20");
        System.out.println(stack.push(30));

        System.out.println(stack.pop());

        System.out.println(stack.peek());

        System.out.println(stack.isEmpty());

        stack.add(0,40);

        System.out.println(stack.capacity());

        System.out.println(stack.remove(0));

        System.out.println(stack);
    }
}
