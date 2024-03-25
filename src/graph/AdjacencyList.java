package graph;

import java.util.ArrayList;

class GraphNodeList {
    public String name;
    public int next;

    public ArrayList<GraphNodeList> neighbor=new ArrayList<GraphNodeList>();

    public GraphNodeList(String name,int next){
        this.name=name;
        this.next=next;
    }
}
public class AdjacencyList {

    ArrayList<GraphNodeList> nodeList=new ArrayList<>();

    public AdjacencyList(ArrayList<GraphNodeList> nodeList){
        this.nodeList=nodeList;
    }

    public void addUndirectedGraph(int i,int j){
        GraphNodeList first=nodeList.get(i);
        GraphNodeList second=nodeList.get(j);
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

    public static void allOperations(){
        ArrayList<GraphNodeList> nodeList=new ArrayList<>();
        nodeList.add(new GraphNodeList("A",0));
        nodeList.add(new GraphNodeList("B",1));
        nodeList.add(new GraphNodeList("C",2));
        nodeList.add(new GraphNodeList("D",3));
        nodeList.add(new GraphNodeList("E",4));

        AdjacencyList g=new AdjacencyList(nodeList);
        g.addUndirectedGraph(0,1);
        g.addUndirectedGraph(0,2);
        g.addUndirectedGraph(0,3);
        g.addUndirectedGraph(1,4);
        g.addUndirectedGraph(2,3);
        g.addUndirectedGraph(3,4);

        System.out.println(g.list());
    }
}
