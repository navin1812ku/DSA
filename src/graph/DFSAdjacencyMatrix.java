package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

class DFSNode {
    public String name;
    public int next;
    public boolean isVisited;

    public DFSNode(String name,int next){
        this.name=name;
        this.next=next;
    }
}
public class DFSAdjacencyMatrix {
    ArrayList<DFSNode> nodeList=new ArrayList<DFSNode>();
    int[][] adjacencyMatrix;

    public DFSAdjacencyMatrix(ArrayList<DFSNode> nodeList){
        this.nodeList=nodeList;
        this.adjacencyMatrix=new int[nodeList.size()][nodeList.size()];
    }

    public void addUndirectedGraph(int i,int j){
        adjacencyMatrix[i][j]=1;
        adjacencyMatrix[j][i]=1;
    }

    public String matrix(){
        StringBuilder s=new StringBuilder();
        s.append("  ");
        for(int i=0;i< nodeList.size();i++){
            s.append(nodeList.get(i).name+" ");
        }
        s.append("\n");
        for(int i=0;i< nodeList.size();i++){
            s.append(nodeList.get(i).name+": ");
            for(int j:adjacencyMatrix[i]){
                s.append((j)+" ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public ArrayList<DFSNode> getNeighbors(DFSNode node){
        ArrayList<DFSNode> neighbors=new ArrayList<>();
        int nodeIndex=node.next;
        for (int i=0;i<adjacencyMatrix.length;i++){
            if(adjacencyMatrix[nodeIndex][i]==1){
                neighbors.add(nodeList.get(i));
            }
        }
        return neighbors;
    }

    public void dfsVisit(DFSNode node){
        Stack<DFSNode> stack=new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            DFSNode curNode=stack.pop();
            curNode.isVisited=true;
            System.out.print(curNode.name+" ");
            ArrayList<DFSNode> neighbors=getNeighbors(curNode);
            for(DFSNode neighbor:neighbors){
                if(neighbor.isVisited==false){
                    stack.push(neighbor);
                    neighbor.isVisited=true;
                }
            }
        }
    }

    public void dfs(){
        for(DFSNode node:nodeList){
            if (!node.isVisited){
                dfsVisit(node);
            }
        }
    }

    public static void allOperations(){
        ArrayList<DFSNode> nodeList=new ArrayList<>();
        nodeList.add(new DFSNode("A",0));
        nodeList.add(new DFSNode("B",1));
        nodeList.add(new DFSNode("C",2));
        nodeList.add(new DFSNode("D",3));
        nodeList.add(new DFSNode("E",4));

        DFSAdjacencyMatrix g=new DFSAdjacencyMatrix(nodeList);
        g.addUndirectedGraph(0,1);
        g.addUndirectedGraph(0,2);
        g.addUndirectedGraph(0,3);
        g.addUndirectedGraph(1,4);
        g.addUndirectedGraph(2,3);
        g.addUndirectedGraph(3,4);

        System.out.println(g.matrix());

        g.dfs();
    }
}