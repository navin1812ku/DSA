package stack;

class StackLinkedListNode {
    public int data;
    public StackLinkedListNode next;
}

public class StackLinkedList {
    static StackLinkedListNode head;

    public static StackLinkedListNode creationOfNode(int value){
        head=new StackLinkedListNode();
        StackLinkedListNode node=new StackLinkedListNode();
        node.data=value;
        node.next=null;
        head=node;
        return head;
    }

    public static void push(int value){
        if(isEmpty()){
            creationOfNode(value);
            return;
        }
        StackLinkedListNode node=new StackLinkedListNode();
        node.data=value;
        node.next=head;
        head=node;
    }

    public static int pop(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        int result=head.data;
        head=head.next;
        return result;
    }

    public static int peep(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        return head.data;
    }

    public static void delete(){
        head=null;
        if(isEmpty()){
            System.out.println("Stack is deleted");
        }
    }

    public static boolean isEmpty(){
        if(head==null){
            return true;
        }
        return false;
    }

    public static void allOperations(){
        push(10);
        push(20);
        push(30);

        System.out.println(pop());

        System.out.println(peep());

        delete();

        System.out.println(isEmpty());
    }
}
