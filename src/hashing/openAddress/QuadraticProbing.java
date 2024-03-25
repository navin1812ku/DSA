package hashing.openAddress;

import java.util.ArrayList;

public class QuadraticProbing {
    String[] hashTable;
    int usedNoOfIndex;

    QuadraticProbing(int size){
        hashTable=new String[size];
        this.usedNoOfIndex=0;
    }

    private int modASCIIValue(String word,int n){
        int sum=0;
        for(char ch:word.toCharArray()){
            sum+=ch;
        }
        return sum%n;
    }

    private double loadFactor(){
        return (double) usedNoOfIndex*1.0/hashTable.length;
    }

    private void reHashing(String word){
        usedNoOfIndex=0;
        ArrayList<String> arr=new ArrayList<>();
        for(String s:hashTable){
            if(s!=null) {
                arr.add(s);
            }
        }
        arr.add(word);
        hashTable=new String[2*hashTable.length];
        for(String s:arr){
            insertHashKey(s);
        }
    }

    public void insertHashKey(String word){
        if(loadFactor()>=0.75){
            reHashing(word);
        }
        else{
            int index=modASCIIValue(word,hashTable.length);
            int counter=0;
            for(int i=index;i<index+hashTable.length;i++){
                int newIndex=(i+(counter*counter))%hashTable.length;
                if(hashTable[newIndex]==null){
                    hashTable[newIndex]=word;
                    System.out.println("Word "+word+" is inserted in "+newIndex);
                    break;
                }
                else{
                    System.out.println("The space is occupied");
                }
                counter++;
            }
        }
        usedNoOfIndex++;
    }

    public void print(){
        if(hashTable.length==0) {
            System.out.println("Table is empty");
            return;
        }
        for(int i=0;i<hashTable.length;i++){
            System.out.println("Value :"+hashTable[i]+" Index : "+i);
        }
    }

    public void searchHashKey(String word){
        int index=modASCIIValue(word,hashTable.length);
        for(int i=index;i<index+hashTable.length;i++){
            int newIndex=i%hashTable.length;
            if(hashTable[newIndex]!=null && hashTable[newIndex].equals(word)){
                System.out.println("Word "+word+" found in the table");
                return;
            }
        }
        System.out.println("Word "+word+" does not exist");
    }

    public void deleteHashKey(String word){
        int index=modASCIIValue(word,hashTable.length);
        for(int i=index;i<index+hashTable.length;i++){
            int newIndex=i%hashTable.length;
            if(hashTable[newIndex]!=null && hashTable[newIndex].equals(word)){
                hashTable[newIndex]=null;
                System.out.println("Word "+word+" deleted");
                return;
            }
        }
        System.out.println("Word "+word+" does not exists");
    }

    public static void allOperations(){

        QuadraticProbing hash=new QuadraticProbing(13);

        hash.insertHashKey("The");
        hash.insertHashKey("quick");
        hash.insertHashKey("brown");
        hash.insertHashKey("fox");
        hash.insertHashKey("over");

        System.out.println();
        hash.searchHashKey("fox");

        System.out.println();
        hash.deleteHashKey("fox");

        System.out.println();
        hash.searchHashKey("fox");

        System.out.println();
        hash.deleteHashKey("a");

        System.out.println();
        hash.print();
    }
}
