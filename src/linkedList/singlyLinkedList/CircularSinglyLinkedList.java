package linkedList.singlyLinkedList;

class CircularSinglyLinkedListNode{
    public int data;
    public CircularSinglyLinkedListNode next;
}

public class CircularSinglyLinkedList {
    public static CircularSinglyLinkedListNode head;
    public static CircularSinglyLinkedListNode tail;
    public static int size;

    public static CircularSinglyLinkedListNode creationOfNode(int value){
        head=new CircularSinglyLinkedListNode();
        CircularSinglyLinkedListNode node=new CircularSinglyLinkedListNode();
        node.data=value;
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
        CircularSinglyLinkedListNode node=new CircularSinglyLinkedListNode();
        node.data=value;
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
        CircularSinglyLinkedListNode node=new CircularSinglyLinkedListNode();
        node.data=value;
        node.next=null;
        CircularSinglyLinkedListNode tempNode=head;
        int i=0;
        while (i<position-2){
            tempNode=tempNode.next;
            i++;
        }
        CircularSinglyLinkedListNode curNext=tempNode.next;
        tempNode.next=node;
        node.next=curNext;
        size+=1;
    }

    public static void insertAtLast(int value){
        if(head==null){
            creationOfNode(value);
            return;
        }
        CircularSinglyLinkedListNode node=new CircularSinglyLinkedListNode();
        node.data=value;
        node.next=null;
        tail.next=node;
        tail=node;
        tail.next=head;
        size+=1;
    }

    public static void deleteAtFirst(){
        if(head==null){
            System.out.println("LinkedList is empty");
        }
        head=head.next;
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
        CircularSinglyLinkedListNode tempNode=head;
        int i=0;
        while (i<position-2){
            tempNode=tempNode.next;
            i++;
        }
        tempNode.next=tempNode.next.next;
        size--;
    }

    public static void deleteAtLast(){
        if(head==null){
            System.out.println("LinkedList is empty");
        }
        CircularSinglyLinkedListNode tempNode=head;
        int i=0;
        while (i<size){
            tempNode=tempNode.next;
            i++;
        }
        tempNode.next=null;
        tail=tempNode;
        tail.next=head;
        size--;
    }

    public static void traversalOfLinkedList(){
        if(head==null){
            System.out.println("LinkedList is empty");
            return;
        }
        CircularSinglyLinkedListNode tempNode=head;
        int i=0;
        while(i<size){
            System.out.print(tempNode.data);
            if(tempNode.next==null){
                break;
            }
            if(i<size-1){
                System.out.print(" -> ");
            }
            tempNode=tempNode.next;
            i++;
        }
        System.out.println("\nSize of the linked list is "+size);
    }

    public static void allMethodsOfCircularSingleLinkedList(){
        creationOfNode(2);
        traversalOfLinkedList();
        insertAtFirst(1);
        traversalOfLinkedList();
        insertAtMiddle(3,2);
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
