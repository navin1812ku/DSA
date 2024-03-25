package dijkstrasAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

class Graph implements Comparable<Graph> {
    public String name;
    public ArrayList<Graph> neighbor=new ArrayList<>();
    public HashMap<Graph,Integer> weight=new HashMap<>();
    public boolean isVisited=false;
    public Graph parent;
    public int distance;
    public int index;

    public Graph(String name,int index){
        this.name=name;
        distance=Integer.MAX_VALUE;
        this.index=index;
    }

    @Override
    public String toString(){
        return name;
    }

    @Override
    public int compareTo(Graph o) {
        return this.distance-o.distance;
    }
}
public class DijkstrasAlgorithm {
    ArrayList<Graph> nodeList=new ArrayList<>();

    public DijkstrasAlgorithm(ArrayList<Graph> nodeList){
        this.nodeList=nodeList;
    }

    public void pathPrint(Graph node){
        if(node.parent!=null){
            pathPrint(node.parent);
        }
        System.out.print(node.name+" ");
    }

    void dijkstraAlgorithm(Graph node){
        PriorityQueue<Graph> queue=new PriorityQueue<>();
        node.distance=0;
        queue.addAll(nodeList);
        while(!queue.isEmpty()){
            Graph curNode=queue.remove();
            for(Graph neighbor:curNode.neighbor){
                if(queue.contains(neighbor)){
                    if(neighbor.distance> curNode.distance+curNode.weight.get(neighbor)){
                        neighbor.distance=(curNode.distance+curNode.weight.get(neighbor));
                        neighbor.parent=curNode;
                        queue.remove(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }
        for(Graph i : nodeList){
            System.out.print("Node "+i+", distance: "+i.distance+", Path: ");
            pathPrint(i);
            System.out.println();
        }
    }

    public void addWeightEdge(int i,int j,int d){
        Graph first=nodeList.get(i);
        Graph second=nodeList.get(j);
        first.neighbor.add(second);
        first.weight.put(second,d);
    }

    public static void allOperations(){
        ArrayList<Graph> nodeList=new ArrayList<>();
        nodeList.add(new Graph("A",0));
        nodeList.add(new Graph("B",1));
        nodeList.add(new Graph("C",2));
        nodeList.add(new Graph("D",3));
        nodeList.add(new Graph("E",4));
        nodeList.add(new Graph("F",5));
        nodeList.add(new Graph("G",6));

        DijkstrasAlgorithm algorithm=new DijkstrasAlgorithm(nodeList);
        algorithm.addWeightEdge(0,1,2);
        algorithm.addWeightEdge(0,2,5);
        algorithm.addWeightEdge(1,2,6);
        algorithm.addWeightEdge(1,3,1);
        algorithm.addWeightEdge(1,4,3);
        algorithm.addWeightEdge(2,5,8);
        algorithm.addWeightEdge(2,4,4);
        algorithm.addWeightEdge(4,6,9);
        algorithm.addWeightEdge(5,6,7);

        System.out.println("Printing Dijkstra from source from A");
        algorithm.dijkstraAlgorithm(nodeList.get(0));
    }
}
