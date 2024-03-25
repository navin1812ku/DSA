package graph;

import java.util.ArrayList;
import java.util.LinkedList;

class BFSNodeList {
    public String name;
    public int next;
    public boolean isVisited=false;

    public ArrayList<BFSNodeList> neighbor=new ArrayList<BFSNodeList>();

    public BFSNodeList(String name,int next){
        this.name=name;
        this.next=next;
    }
}
public class BFSAdjacencyList {

    ArrayList<BFSNodeList> nodeList=new ArrayList<>();

    public BFSAdjacencyList(ArrayList<BFSNodeList> nodeList){
        this.nodeList=nodeList;
    }

    public void addUndirectedGraph(int i,int j){
        BFSNodeList first=nodeList.get(i);
        BFSNodeList second=nodeList.get(j);
        first.neighbor.add(second);
        second.neighbor.add(first);
    }

    public String list(){
        StringBuilder s=new StringBuilder();
        for(int i=0;i<nodeList.size();i++){
            s.append(nodeList.get(i).name+": ");
            for(int j=0;j<nodeList.get(i).neighbor.size();j++){
                if(j==nodeList.get(i).neighbor.size()-1){
                    s.append(nodeList.get(i).neighbor.get(j).name);
                }
                else{
                    s.append(nodeList.get(i).neighbor.get(j).name+" -> ");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }

    public void bfsVisit(BFSNodeList node){
        LinkedList<BFSNodeList> queue=new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            BFSNodeList curNode=queue.remove();
            curNode.isVisited=true;
            System.out.print(curNode.name+" ");
            for(BFSNodeList neighbor: curNode.neighbor){
                if(!neighbor.isVisited){
                    queue.add(neighbor);
                    neighbor.isVisited=true;
                }
            }
        }
    }

    public void bfs(){
        for(BFSNodeList node:nodeList){
            if(!node.isVisited){
                bfsVisit(node);
            }
        }
    }

    public static void allOperations(){
        ArrayList<BFSNodeList> nodeList=new ArrayList<>();
        nodeList.add(new BFSNodeList("A",0));
        nodeList.add(new BFSNodeList("B",1));
        nodeList.add(new BFSNodeList("C",2));
        nodeList.add(new BFSNodeList("D",3));
        nodeList.add(new BFSNodeList("E",4));

        BFSAdjacencyList g=new BFSAdjacencyList(nodeList);
        g.addUndirectedGraph(0,1);
        g.addUndirectedGraph(0,2);
        g.addUndirectedGraph(0,3);
        g.addUndirectedGraph(1,4);
        g.addUndirectedGraph(2,3);
        g.addUndirectedGraph(3,4);

        System.out.println(g.list());

        g.bfs();
    }
}
