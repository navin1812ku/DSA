package stack;

public class StackArray {
    int[] arr;
    int top;

    public StackArray(int size){
        this.arr=new int[size];
        this.top=-1;
    }

    public boolean isEmpty(){
        if(top==-1){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if(top== arr.length-1){
            return true;
        }
        return false;
    }

    public void push(int data){
        if(!isFull()){
            arr[top+1]=data;
            top++;
        }
        else{
            System.out.println("Stack is full");
        }
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        return arr[top--];
    }

    public int peep(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        return arr[top];
    }

    public void delete(){
        arr=null;
        if(arr==null){
            System.out.println("Stack was deleted");
        }
    }

    public static void allOperations(){
        StackArray stackArray=new StackArray(5);
        stackArray.push(1);
        stackArray.push(2);
        stackArray.push(3);
        stackArray.push(4);
        stackArray.push(5);
        stackArray.push(5);
        System.out.println(stackArray.pop());
        System.out.println(stackArray.peep());
        System.out.println(stackArray.isEmpty());
        System.out.println(stackArray.isFull());
        stackArray.delete();
    }
}
