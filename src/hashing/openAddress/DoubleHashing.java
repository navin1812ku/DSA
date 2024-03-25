package hashing.openAddress;

import java.util.ArrayList;

public class DoubleHashing {
    String[] hashTable;
    int usedNoOfIndex;

    DoubleHashing(int size){
        hashTable=new String[size];
        this.usedNoOfIndex=0;
    }

    private int firstHashFunction(String word, int n){
        int sum=0;
        for(char ch:word.toCharArray()){
            sum+=ch;
        }
        return sum%n;
    }

    private int sumOfAllDigits(int n){
        int sum=0;
        while(n>0){
            sum=n%10;
            n/=10;
        }
        return sum;
    }

    private int secondHashFunction(String word,int n){
        int sum=0;
        for(char ch:word.toCharArray()){
            sum+=ch;
        }
        while(sum>hashTable.length){
            sum=sumOfAllDigits(sum);
        }
        return sum%n;
    }

    private double loadFactor(){
        return usedNoOfIndex*1.0/hashTable.length;
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
            int x= firstHashFunction(word,hashTable.length);
            int y=secondHashFunction(word,hashTable.length);
            for(int i=0;i<hashTable.length;i++){
                int newIndex=(x+(i*y))%hashTable.length;
                if(hashTable[newIndex]==null){
                    hashTable[newIndex]=word;
                    System.out.println("Word "+word+" is inserted in "+newIndex);
                    break;
                }
                else{
                    System.out.println("The space is occupied");
                }
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
        int index= firstHashFunction(word,hashTable.length);
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
        int index= firstHashFunction(word,hashTable.length);
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

        DoubleHashing hash=new DoubleHashing(13);

        hash.insertHashKey("The");
        hash.insertHashKey("quick");
        hash.insertHashKey("brown");
        hash.insertHashKey("fox");
        hash.insertHashKey("over");
        hash.insertHashKey("lazy");

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
