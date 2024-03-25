package linkedList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.function.Predicate;

public class LinkedListClass {
    public static void linkedListClassOperations(){
        LinkedList linkedList=new LinkedList();


        linkedList.add(10);
        linkedList.add("naveen");
        linkedList.add(true);
        linkedList.add(23.21);
        linkedList.add(21.243345456);
        linkedList.add('a');

        linkedList.add(2,"kavi");

        linkedList.addAll(4, Arrays.asList(10,20,30));

        linkedList.addAll(Arrays.asList("naveen","kavi","dharz","enid"));

        linkedList.addFirst("kavi");

        linkedList.addLast("object");

        Object newList=linkedList.clone();

        System.out.println(newList);

        System.out.println(linkedList.contains("naveen"));

//        linkedList.clear();

        System.out.println(linkedList.containsAll(Arrays.asList(45)));

        Iterator iterator=linkedList.descendingIterator();

        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }

        System.out.println("\n"+linkedList.element());

        System.out.println(linkedList.equals(newList));

        linkedList.forEach(list -> System.out.print(list+" "));

        System.out.println("\n"+linkedList.get(2));

        System.out.println(linkedList.getClass());

        System.out.println(linkedList.getFirst());

        System.out.println(linkedList.getLast());

        System.out.println(linkedList.hashCode());

        System.out.println(linkedList.indexOf("object"));

        System.out.println(linkedList.isEmpty());

        Iterator li=linkedList.iterator();

        while (li.hasNext()){
            System.out.print(li.next()+" ");
        }

        System.out.println("\n"+linkedList.lastIndexOf("kavi"));

        System.out.println(linkedList.peek());

        System.out.println(linkedList.peekFirst());

        System.out.println(linkedList.peekLast());

        System.out.println(linkedList.poll());

        System.out.println(linkedList.pollFirst());

        System.out.println(linkedList.pollLast());

        System.out.println(linkedList.pop());

        linkedList.push("kavi");

        System.out.println(linkedList.remove());

        System.out.println(linkedList.remove(Arrays.asList(10,20,30,"naveen")));

        System.out.println(linkedList.remove(2));

        System.out.println(linkedList.removeFirst());

        System.out.println(linkedList.removeFirstOccurrence(20));

        System.out.println(linkedList.size());

        System.out.println(linkedList);

    }
}
