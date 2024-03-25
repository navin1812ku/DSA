package graph;

import java.util.ArrayList;
import java.util.LinkedList;

class BFSNode {
    public String name;
    public int next;
    public boolean isVisited;

    public BFSNode(String name,int next){
        this.name=name;
        this.next=next;
    }
}
public class BFSAdjacencyMatrix {
    ArrayList<BFSNode> nodeList=new ArrayList<BFSNode>();
    int[][] adjacencyMatrix;

    public BFSAdjacencyMatrix(ArrayList<BFSNode> nodeList){
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

    public ArrayList<BFSNode> getNeighbors(BFSNode node){
        ArrayList<BFSNode> neighbors=new ArrayList<>();
        int nodeIndex=node.next;
        for (int i=0;i<adjacencyMatrix.length;i++){
            if(adjacencyMatrix[nodeIndex][i]==1){
                neighbors.add(nodeList.get(i));
            }
        }
        return neighbors;
    }

    public void bfsVisit(BFSNode node){
        LinkedList<BFSNode> queue=new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            BFSNode curNode=queue.remove();
            curNode.isVisited=true;
            System.out.print(curNode.name+" ");
            ArrayList<BFSNode> neighbors=getNeighbors(curNode);
            for(BFSNode neighbor:neighbors){
                if(neighbor.isVisited==false){
                    queue.add(neighbor);
                    neighbor.isVisited=true;
                }
            }
        }
    }

    public void bfs(){
        for(BFSNode node:nodeList){
            if (!node.isVisited){
                bfsVisit(node);
            }
        }
    }

    public static void allOperations(){
        ArrayList<BFSNode> nodeList=new ArrayList<>();
        nodeList.add(new BFSNode("A",0));
        nodeList.add(new BFSNode("B",1));
        nodeList.add(new BFSNode("C",2));
        nodeList.add(new BFSNode("D",3));
        nodeList.add(new BFSNode("E",4));

        BFSAdjacencyMatrix g=new BFSAdjacencyMatrix(nodeList);
        g.addUndirectedGraph(0,1);
        g.addUndirectedGraph(0,2);
        g.addUndirectedGraph(0,3);
        g.addUndirectedGraph(1,4);
        g.addUndirectedGraph(2,3);
        g.addUndirectedGraph(3,4);

        System.out.println(g.matrix());

        g.bfs();
    }
}
