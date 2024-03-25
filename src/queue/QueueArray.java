package queue;

public class QueueArray {
    int[] queue;
    int front;
    int rear;

    QueueArray(int size){
        this.queue=new int[size];
        this.front=-1;
        this.rear=-1;
    }

    public boolean isEmpty(){
        if(front==-1|| front==queue.length || front>rear){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if(rear==queue.length-1){
            return true;
        }
        return false;
    }

    public void enqueue(int value){
        if(isFull()){
            System.out.println("Queue is full");
            return;
        }
        else if (front==-1) {
            front=0;
            rear++;
            queue[rear]=value;
        }
        else{
            rear++;
            queue[rear]=value;
        }
    }

    public int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        else{
            int result=queue[front];
            front++;
            if(front>rear){
                front=rear=-1;
            }
            return result;
        }
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[front];
    }

    public void delete(){
        queue=null;
        if(queue==null){
            System.out.println("Queue was deleted");
        }
    }

    public static void allOperations(){
        QueueArray queueArray=new QueueArray(3);
        queueArray.enqueue(10);
        queueArray.enqueue(20);
        queueArray.enqueue(30);
        queueArray.enqueue(40);

        System.out.println(queueArray.dequeue());

        System.out.println(queueArray.peek());

        System.out.println(queueArray.dequeue());
        System.out.println(queueArray.dequeue());

        System.out.println(queueArray.peek());

        System.out.println(queueArray.isFull());

        System.out.println(queueArray.isEmpty());

        queueArray.delete();
    }
}
