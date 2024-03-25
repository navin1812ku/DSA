package graph;

import java.util.ArrayList;

class GraphNode{
    public String name;
    public int next;

    public GraphNode(String name,int next){
        this.name=name;
        this.next=next;
    }
}
public class AdjacencyMatrix {
    ArrayList<GraphNodeList> nodeList=new ArrayList<GraphNodeList>();
    int[][] adjacencyMatrix;

    public AdjacencyMatrix(ArrayList<GraphNodeList> nodeList){
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

    public static void allOperations(){
        ArrayList<GraphNodeList> nodeList=new ArrayList<>();
        nodeList.add(new GraphNodeList("A",0));
        nodeList.add(new GraphNodeList("B",1));
        nodeList.add(new GraphNodeList("C",2));
        nodeList.add(new GraphNodeList("D",3));
        nodeList.add(new GraphNodeList("E",4));

        AdjacencyMatrix g=new AdjacencyMatrix(nodeList);
        g.addUndirectedGraph(0,1);
        g.addUndirectedGraph(0,2);
        g.addUndirectedGraph(0,3);
        g.addUndirectedGraph(1,4);
        g.addUndirectedGraph(2,3);
        g.addUndirectedGraph(3,4);

        System.out.println(g.matrix());
    }
}
