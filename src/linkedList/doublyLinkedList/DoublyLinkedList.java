package linkedList.doublyLinkedList;

class DoublyLinkedListNode {
    public DoublyLinkedListNode prev;
    public int data;
    public DoublyLinkedListNode next;
}

public class DoublyLinkedList {
    public static DoublyLinkedListNode head;
    public static DoublyLinkedListNode tail;
    public static int size;

    public static DoublyLinkedListNode creationOfNode(int value){
        head=new DoublyLinkedListNode();
        DoublyLinkedListNode node=new DoublyLinkedListNode();
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
        DoublyLinkedListNode node=new DoublyLinkedListNode();
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
        DoublyLinkedListNode node=new DoublyLinkedListNode();
        node.data=value;
        node.prev=null;
        node.next=null;
        DoublyLinkedListNode tempNode=head;
        int i=0;
        while (i<position-1){
            tempNode=tempNode.next;
            i++;
        }
        DoublyLinkedListNode curNext=tempNode.next;
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
        DoublyLinkedListNode node=new DoublyLinkedListNode();
        node.data=value;
        node.prev=tail;
        node.next=null;
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
        DoublyLinkedListNode tempNode=head;
        int i=0;
        while (i<position-2){
            tempNode=tempNode.next;
            i++;
        }
        DoublyLinkedListNode curNode=tempNode;
        tempNode.next=tempNode.next.next;
        tempNode.next.prev=curNode;
        size--;
    }

    public static void deleteAtLast(){
        if(head==null){
            System.out.println("LinkedList is empty");
        }
        DoublyLinkedListNode tempNode=head;
        while (tempNode.next.next!=null){
            tempNode=tempNode.next;
        }
        tempNode.next=null;
        tail=tempNode;
        size--;
    }

    public static void traversalOfLinkedList(){
        if(head==null){
            System.out.println("LinkedList is empty");
            return;
        }
        DoublyLinkedListNode tempNode=head;
        while(tempNode!=null){
            System.out.print(tempNode.data);
            if(tempNode.next!=null){
                System.out.print(" -> ");
            }
            tempNode=tempNode.next;
        }
        System.out.println("\nSize of the linked list is "+size);
    }

    public static void allMethodsOfDoublyLinkedList(){
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
        deleteAtMiddle(3);
        traversalOfLinkedList();
        deleteAtLast();
        traversalOfLinkedList();
    }
}
