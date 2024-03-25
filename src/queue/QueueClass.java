package queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueClass {
    public static void allOperations(){
        Queue queue=new LinkedList();

        queue.add("naveen");

        queue.addAll(Arrays.asList(10,20,30,40,"kavi"));

        System.out.println(queue.contains(10));

        System.out.println(queue.containsAll(Arrays.asList(20,30)));

        System.out.println(queue.element());

        System.out.println(queue.equals(Arrays.asList("naveen",10,20,30,40,"kavi")));

        System.out.println(queue.isEmpty());

        System.out.println(queue.offer(Arrays.asList(40,50)));

        System.out.println(queue.peek());

        System.out.println(queue.poll());

        System.out.println(queue.remove());

        System.out.println(queue.size());

        System.out.println(queue);
    }
}
