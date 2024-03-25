package queue;

import java.util.PriorityQueue;

public class PriorityQueueClass {
    public static void allOperations(){
        PriorityQueue<Integer> queue=new PriorityQueue<>();

        queue.add(10);
        queue.add(50);
        queue.add(40);
        queue.add(20);
        queue.add(30);

        System.out.println(queue.peek());

        System.out.println(queue.poll());

        System.out.println(queue.poll());

        System.out.println(queue.remove());

        System.out.println(queue.size());

        System.out.println(queue);
    }
}
