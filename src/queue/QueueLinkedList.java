package queue;

class QueueLinkedListNode{
    public int data;
    public QueueLinkedListNode next;
}
public class QueueLinkedList {
    public static QueueLinkedListNode head;
    public static QueueLinkedListNode tail;
    public static int size;

    public static QueueLinkedListNode creationOfNode(int value){
        head=new QueueLinkedListNode();
        QueueLinkedListNode node=new QueueLinkedListNode();
        node.data=value;
        node.next=null;
        head=node;
        tail=node;
        size+=1;
        return head;
    }

    public boolean isEmpty(){
        if(head==null){
            return true;
        }
        return false;
    }

    public void enqueue(int value){
        if(isEmpty()){
            creationOfNode(value);
            return;
        }
        QueueLinkedListNode node=new QueueLinkedListNode();
        node.data=value;
        node.next=null;
        tail.next=node;
        tail=node;
        size+=1;
    }

    public int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
        }
        int result=head.data;
        head=head.next;
        size--;
        return result;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        return head.data;
    }

    public void delete(){
        head=null;
        if(isEmpty()){
            System.out.println("Queue is deleted");
        }
    }

    public static void allOperations(){
        QueueLinkedList linkedList=new QueueLinkedList();
        linkedList.enqueue(10);
        linkedList.enqueue(20);
        linkedList.enqueue(30);
        System.out.println(linkedList.dequeue());
        System.out.println(linkedList.peek());
        System.out.println(linkedList.isEmpty());
        linkedList.delete();
    }
}
