package ssspp;

import graph.BFSAdjacencyList;

import java.util.ArrayList;
import java.util.LinkedList;

class BFSForSSSPPList {
    public String name;
    public int next;
    public boolean isVisited=false;
    public BFSForSSSPPList parent;

    public ArrayList<BFSForSSSPPList> neighbor=new ArrayList<BFSForSSSPPList>();

    public BFSForSSSPPList(String name,int next){
        this.name=name;
        this.next=next;
    }
}
public class BFSForSSSPP {
    ArrayList<BFSForSSSPPList> nodeList=new ArrayList<>();

    public BFSForSSSPP(ArrayList<BFSForSSSPPList> nodeList){
        this.nodeList=nodeList;
    }

    public void addUndirectedGraph(int i,int j){
        BFSForSSSPPList first=nodeList.get(i);
        BFSForSSSPPList second=nodeList.get(j);
        first.neighbor.add(second);
        second.neighbor.add(first);
    }

    public static void pathPrint(BFSForSSSPPList node){
        if(node.parent!=null){
            pathPrint(node.parent);
        }
        System.out.print(node.name+" ");
    }

    public void bfsForSSSPP(BFSForSSSPPList node){
        LinkedList<BFSForSSSPPList> queue=new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            BFSForSSSPPList curNode=queue.remove();
            curNode.isVisited=true;
            System.out.print("Printing path for node "+curNode.name+": ");
            pathPrint(curNode);
            System.out.println();
            for(BFSForSSSPPList neighbor: curNode.neighbor){
                if(!neighbor.isVisited){
                    queue.add(neighbor);
                    neighbor.isVisited=true;
                    neighbor.parent=curNode;
                }
            }
        }
    }
    public static void allOperations(){
        ArrayList<BFSForSSSPPList> nodeList=new ArrayList<>();
        nodeList.add(new BFSForSSSPPList("A",0));
        nodeList.add(new BFSForSSSPPList("B",1));
        nodeList.add(new BFSForSSSPPList("C",2));
        nodeList.add(new BFSForSSSPPList("D",3));
        nodeList.add(new BFSForSSSPPList("E",4));

        BFSForSSSPP g=new BFSForSSSPP(nodeList);
        g.addUndirectedGraph(0,1);
        g.addUndirectedGraph(0,2);
        g.addUndirectedGraph(0,3);
        g.addUndirectedGraph(1,4);
        g.addUndirectedGraph(2,3);
        g.addUndirectedGraph(3,4);

        g.bfsForSSSPP(nodeList.get(0));
    }
}
