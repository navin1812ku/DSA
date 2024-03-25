package queue;

public class CirucularQueueArray {

    public int[] queue;
    public int front;
    public int rear;
    public int size;

    CirucularQueueArray(int size){
        this.queue=new int[size];
        this.size=size;
        this.front=-1;
        this.rear=-1;
    }

    public boolean isEmpty(){
        if(front==-1 && rear==-1){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if(front==0 && rear+1==size){
            return true;
        } else if (rear+1==front) {
            return true;
        }
        return false;
    }

    public void enqueue(int value){
        if(isFull()){
            System.out.println("Queue is full");
        }
        else{
            if(isEmpty()){
                front=0;
                rear++;
                queue[rear]=value;
            }
            else {
                if(rear+1==size){
                    rear=0;
                }
                else {
                    rear++;
                }
                queue[rear]=value;
            }
        }
    }

    public int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        else{
            int result=queue[front];
            queue[front]=0;
            if(front==rear){
                front=rear=-1;
            } else if (front+1==size) {
                front=0;
            }
            else {
                front++;
            }
            return result;
        }
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        else{
            return queue[front];
        }
    }

    public void delete(){
        queue=null;
        front=-1;
        rear=-1;
        if(queue==null){
            System.out.println("Queue is deleted successfully");
        }
    }

    public static void allOperations(){
        CirucularQueueArray queueArray=new CirucularQueueArray(3);
        queueArray.enqueue(10);
        queueArray.enqueue(20);
        queueArray.enqueue(30);
        System.out.println(queueArray.dequeue());
        System.out.println(queueArray.peek());
        queueArray.enqueue(40);
        queueArray.delete();
        System.out.println(queueArray.isEmpty());
        System.out.println(queueArray.isFull());
    }
}
