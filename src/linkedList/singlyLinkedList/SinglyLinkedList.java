package linkedList.singlyLinkedList;

class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;
}

public class SinglyLinkedList {
    public static SinglyLinkedListNode head;
    public static SinglyLinkedListNode tail;
    public static int size;

    public static SinglyLinkedListNode creationOfNode(int value){
        head=new SinglyLinkedListNode();
        SinglyLinkedListNode node=new SinglyLinkedListNode();
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
        SinglyLinkedListNode node=new SinglyLinkedListNode();
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
        SinglyLinkedListNode node=new SinglyLinkedListNode();
        node.data=value;
        node.next=null;
        SinglyLinkedListNode tempNode=head;
        int i=0;
        while (i<position-1){
            tempNode=tempNode.next;
            i++;
        }
        SinglyLinkedListNode curNext=tempNode.next;
        tempNode.next=node;
        node.next=curNext;
        size+=1;
    }

    public static void insertAtLast(int value){
        if(head==null){
            creationOfNode(value);
            return;
        }
        SinglyLinkedListNode node=new SinglyLinkedListNode();
        node.data=value;
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
        SinglyLinkedListNode tempNode=head;
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
        SinglyLinkedListNode tempNode=head;
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
        SinglyLinkedListNode tempNode=head;
        while(tempNode!=null){
            System.out.print(tempNode.data);
            if(tempNode.next!=null){
                System.out.print(" -> ");
            }
            tempNode=tempNode.next;
        }
        System.out.println("\nSize of the linked list is "+size);
    }

    public static void allMethodsOfSingleLinkedList(){
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
