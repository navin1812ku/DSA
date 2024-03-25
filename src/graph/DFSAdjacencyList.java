package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

class DFSNodeList {
    public String name;
    public int next;
    public boolean isVisited=false;

    public ArrayList<DFSNodeList> neighbor=new ArrayList<DFSNodeList>();

    public DFSNodeList(String name,int next){
        this.name=name;
        this.next=next;
    }
}
public class DFSAdjacencyList {

    ArrayList<DFSNodeList> nodeList=new ArrayList<>();

    public DFSAdjacencyList(ArrayList<DFSNodeList> nodeList){
        this.nodeList=nodeList;
    }

    public void addUndirectedGraph(int i,int j){
        DFSNodeList first=nodeList.get(i);
        DFSNodeList second=nodeList.get(j);
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

    public void dfsVisit(DFSNodeList node){
        Stack<DFSNodeList> stack=new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            DFSNodeList curNode=stack.pop();
            curNode.isVisited=true;
            System.out.print(curNode.name+" ");
            for(DFSNodeList neighbor: curNode.neighbor){
                if(!neighbor.isVisited){
                    stack.push(neighbor);
                    neighbor.isVisited=true;
                }
            }
        }
    }

    public void dfs(){
        for(DFSNodeList node:nodeList){
            if(!node.isVisited){
                dfsVisit(node);
            }
        }
    }

    public static void allOperations(){
        ArrayList<DFSNodeList> nodeList=new ArrayList<>();
        nodeList.add(new DFSNodeList("A",0));
        nodeList.add(new DFSNodeList("B",1));
        nodeList.add(new DFSNodeList("C",2));
        nodeList.add(new DFSNodeList("D",3));
        nodeList.add(new DFSNodeList("E",4));

        DFSAdjacencyList g=new DFSAdjacencyList(nodeList);
        g.addUndirectedGraph(0,1);
        g.addUndirectedGraph(0,2);
        g.addUndirectedGraph(0,3);
        g.addUndirectedGraph(1,4);
        g.addUndirectedGraph(2,3);
        g.addUndirectedGraph(3,4);

        System.out.println(g.list());

        g.dfs();
    }
}
