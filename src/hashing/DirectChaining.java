package hashing;

import java.util.LinkedList;

public class DirectChaining {
    LinkedList<String>[] hashTable;

    public DirectChaining(int size){
        hashTable=new LinkedList[size];
    }

    private int modASCII(String str,int n){
        int sum=0;
        for(char ch:str.toCharArray()){
            sum+=ch;
        }
        return sum%n;
    }

    public void insertHashTable(String value){
        int newIndex=modASCII(value,hashTable.length);
        if(hashTable[newIndex]==null){
            hashTable[newIndex]=new LinkedList<String>();
            hashTable[newIndex].add(value);
        }
        else{
            hashTable[newIndex].add(value);
        }
    }

    public boolean searchHashTable(String word){
        int newIndex=modASCII(word,hashTable.length);
        if(hashTable[newIndex]!=null && hashTable[newIndex].contains(word)){
            System.out.println("The word "+word+" found in the hash table");
            return true;
        }
        return false;
    }

    public void deleteWord(String word){
        int newIndex=modASCII(word,hashTable.length);
        if(hashTable[newIndex]!=null && searchHashTable(word)){
            hashTable[newIndex].remove(word);
            System.out.println("THe word "+word+" deleted from hash table");
        }
    }

    public void print(){
        if(hashTable==null){
            System.out.println("HashTable is empty");
            return;
        }
        for(int i=0;i<hashTable.length;i++){
            System.out.println("Index "+i+" ,Key : "+hashTable[i]);
        }
    }

    public static void allOperations(){
        DirectChaining directChaining=new DirectChaining(15);
        directChaining.insertHashTable("The");
        directChaining.insertHashTable("quick");
        directChaining.insertHashTable("brown");
        directChaining.insertHashTable("fox");
        directChaining.insertHashTable("over");
        directChaining.insertHashTable("of");
        directChaining.insertHashTable("in");
        directChaining.insertHashTable("a");

        directChaining.searchHashTable("a");

        directChaining.deleteWord("a");

        directChaining.print();
    }
}
