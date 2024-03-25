package linkedList.doublyLinkedList;

class CircularDoublyLinkedListNode{
    public CircularDoublyLinkedListNode prev;
    public int data;
    public CircularDoublyLinkedListNode next;
}

public class CircularDoublyLinkedList {
    public static CircularDoublyLinkedListNode head;
    public static CircularDoublyLinkedListNode tail;
    public static int size;

    public static CircularDoublyLinkedListNode creationOfNode(int value){
        head=new CircularDoublyLinkedListNode();
        CircularDoublyLinkedListNode node=new CircularDoublyLinkedListNode();
        node.data=value;
        node.prev=null;
        node.next=null;
        head=node;
        tail=node;
        size+=1;
        return head;
    }

    public static void insertAtFirst(int value){
        if(head==null){
            creationOfNode(value);
            return;
        }
        CircularDoublyLinkedListNode node=new CircularDoublyLinkedListNode();
        node.data=value;
        node.prev=null;
        node.next=head;
        head=node;
        size+=1;
    }

    public static void insertAtMiddle(int value,int position){
        if(position==0 || position-1==0){
            insertAtFirst(value);
            return;
        }
        if(head==null){
            creationOfNode(value);
            return;
        }
        CircularDoublyLinkedListNode node=new CircularDoublyLinkedListNode();
        node.data=value;
        node.prev=null;
        node.next=null;
        CircularDoublyLinkedListNode tempNode=head;
        int i=0;
        while (i<position-1){
            tempNode=tempNode.next;
            i++;
        }
        CircularDoublyLinkedListNode curNext=tempNode.next;
        node.prev=tempNode;
        tempNode.next=node;
        node.next=curNext;
        curNext.prev=node;
        size+=1;
    }

    public static void insertAtLast(int value){
        if(head==null){
            creationOfNode(value);
            return;
        }
        CircularDoublyLinkedListNode node=new CircularDoublyLinkedListNode();
        node.data=value;
        node.prev=tail;
        node.next=head;
        tail.next=node;
        tail=node;
        size+=1;
    }

    public static void deleteAtFirst(){
        if(head==null){
            System.out.println("LinkedList is empty");
        }
        head=head.next;
        head.prev=null;
        size--;
    }

    public static void deleteAtMiddle(int position){
        if(position==0 || position-1==0){
            deleteAtFirst();
            return;
        }
        if(position>size){
            System.out.println("Position is greater than the linked list size");
            return;
        }
        if(position==size){
            deleteAtLast();
            return;
        }
        CircularDoublyLinkedListNode tempNode=head;
        int i=0;
        while (i<position-2){
            tempNode=tempNode.next;
            i++;
        }
        CircularDoublyLinkedListNode curNode=tempNode;
        tempNode.next=tempNode.next.next;
        tempNode.next.prev=curNode;
        size--;
    }

    public static void deleteAtLast(){
        if(head==null){
            System.out.println("LinkedList is empty");
        }
        CircularDoublyLinkedListNode tempNode=head;
        int i=0;
        while (i<size){
            tempNode=tempNode.next;
            i++;
        }
        tempNode.next=head;
        tail=tempNode;
        size--;
    }

    public static void traversalOfLinkedList(){
        if(head==null){
            System.out.println("LinkedList is empty");
            return;
        }
        CircularDoublyLinkedListNode tempNode=head;
        int i=0;
        while(i<size){
            System.out.print(tempNode.data);
            if(i<size-1){
                System.out.print(" -> ");
            }
            if(tempNode.next==null){
                break;
            }
            tempNode=tempNode.next;
            i++;
        }
        System.out.println("\nSize of the linked list is "+size);
    }

    public static void allMethodsOfCircularDoublyLinkedList(){
        creationOfNode(2);
        traversalOfLinkedList();
        insertAtFirst(1);
        traversalOfLinkedList();
        insertAtMiddle(3,1);
        traversalOfLinkedList();
        insertAtLast(4);
        traversalOfLinkedList();
        deleteAtFirst();
        traversalOfLinkedList();
        deleteAtMiddle(2);
        traversalOfLinkedList();
        deleteAtLast();
        traversalOfLinkedList();
    }
}
