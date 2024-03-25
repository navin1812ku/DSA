package tree.binaryTree;

public class BinaryTreeArray {
    String[] array;
    int lastUsedIndex;

    public BinaryTreeArray(int size){
        this.array=new String[size+1];
        this.lastUsedIndex=0;
    }

    boolean isFull(){
        if(array.length-1==lastUsedIndex){
            return true;
        }
        return false;
    }

    void insert(String value){
        if(!isFull()){
            array[lastUsedIndex+1]=value;
            lastUsedIndex++;
            System.out.println("Value is added");
            return;
        }
        System.out.println("BT is full");
    }

    void preOrder(int index){
        if(index>lastUsedIndex){
            return;
        }
        System.out.print(array[index]+" ");
        preOrder(index*2);
        preOrder(index*2+1);
    }

    void inOrder(int index){
        if(index>lastUsedIndex){
            return;
        }
        inOrder(index*2);
        System.out.print(array[index]+" ");
        inOrder(index*2+1);
    }

    void postOrder(int index){
        if(index>lastUsedIndex){
            return;
        }
        postOrder(index*2);
        postOrder(index*2+1);
        System.out.print(array[index]+" ");
    }

    void levelOrder(int index){
        for(int i=index;i<=lastUsedIndex;i++){
            System.out.print(array[i]+" ");
        }
    }

    int search(String value){
        for(int i=1;i<=lastUsedIndex;i++){
            if(array[i].equals(value)){
                return i;
            }
        }
        return -1;
    }

    void deleteNode(String value){
        int location=search(value);
        if(location==-1){
            return;
        }
        else{
            array[location]=array[lastUsedIndex];
            lastUsedIndex--;
            System.out.println("The node "+value+" was replaced by "+array[location]);
        }
    }

    void delete(){
        try {
            array=null;
            if(array==null){
                System.out.println("BT is deleted successfully");
            }
        }
        catch (Exception e){
            System.out.println("There was an error in deleting a BT "+e);
        }
    }

    public static void allOperations(){
        BinaryTreeArray treeArray=new BinaryTreeArray(9);

        treeArray.insert("N1");
        treeArray.insert("N2");
        treeArray.insert("N3");
        treeArray.insert("N4");
        treeArray.insert("N5");
        treeArray.insert("N6");
        treeArray.insert("N7");
        treeArray.insert("N8");
        treeArray.insert("N9");

        treeArray.preOrder(1);
        System.out.println(" -> PreOrder Traversal");

        treeArray.inOrder(1);
        System.out.println(" -> InOrder Traversal");

        treeArray.postOrder(1);
        System.out.println(" -> PostOrder Traversal");

        treeArray.levelOrder(1);
        System.out.println(" -> LevelOrder Traversal");

        System.out.println("The value found in the index of "+treeArray.search("N6"));

        treeArray.deleteNode("N5");
        treeArray.levelOrder(1);
        System.out.println(" -> LevelOrder Traversal");

        treeArray.delete();
    }
}
