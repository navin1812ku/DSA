package tree.binaryHeap;

public class BinaryHeap {
    int[] array;
    int size;

    public BinaryHeap(int size){
        array=new int[size+1];
        this.size=0;
    }

    public boolean isEmpty(){
        return size==0 ? true : false;
    }

    public int peek(){
        return size==0 ? -1 : array[1];
    }

    public void levelOrder(){
        for(int i=1;i<=size;i++){
            System.out.print(array[i]+" ");
        }
    }

    public int sizeOfHeap(){
        return size;
    }

    private void heapifyBottomToTop(int index,String heapType){
        if(index<=1){
            return;
        }
        int parent=index/2;
        if(heapType=="Min" && array[index] < array[parent]){
            int temp=array[index];
            array[index]=array[parent];
            array[parent]=temp;
        }else if(heapType=="Max" && array[index] > array[parent]){
            int temp=array[index];
            array[index]=array[parent];
            array[parent]=temp;
        }
        heapifyBottomToTop(parent,heapType);
    }

    public void insert(int value,String heapType){
        array[size+1]=value;
        size++;
        heapifyBottomToTop(size,heapType);
        System.out.println("Value added");
    }

    private void heapifyTopToBottom(int index, String heapType){
        int left=index*2;
        int right=index*2+1;
        int swapChild=0;
        if(size<left){
            return;
        }
        if(heapType=="Max"){
            if(size==left){
                if(array[index] < array[left]){
                    int temp=array[index];
                    array[index]=array[left];
                    array[left]=temp;
                }
                return;
            }
            else{
                if(array[left]>array[right]){
                    swapChild=left;
                }
                else{
                    swapChild=right;
                }
                if(array[index]<array[swapChild]){
                    int temp=array[index];
                    array[index]=array[swapChild];
                    array[swapChild]=temp;
                }
            }
        }
        else if(heapType=="Min"){
            if(size==left){
                if(array[index] > array[left]){
                    int temp=array[index];
                    array[index]=array[left];
                    array[left]=temp;
                }
                return;
            }
            else{
                if(array[left]<array[right]){
                    swapChild=left;
                }
                else{
                    swapChild=right;
                }
                if(array[index]>array[swapChild]){
                    int temp=array[index];
                    array[index]=array[swapChild];
                    array[swapChild]=temp;
                }
            }
        }
        heapifyTopToBottom(swapChild,heapType);
    }

    public int extractHead(String heapType){
        if(isEmpty()) return -1;
        int extractedHead=array[1];
        array[1]=array[size];
        size--;
        heapifyTopToBottom(1,heapType);
        return extractedHead;
    }

    public void delete(){
        array=null;
        System.out.println(array==null? "Array deleted":"Array not deleted");
    }

    public static void allOperations(){
        BinaryHeap heap=new BinaryHeap(9);
        String heapType="Min";
        heap.insert(10,heapType);
        heap.insert(5,heapType);
        heap.insert(15,heapType);
        heap.insert(1,heapType);

        heap.levelOrder();
        System.out.println(" -> LevelOrder");

        System.out.println(heap.peek());

        System.out.println(heap.extractHead(heapType));
        heap.levelOrder();
        System.out.println(" -> LevelOrder");

        heap.delete();
    }
}
