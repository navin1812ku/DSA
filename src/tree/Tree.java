package tree;

import java.util.ArrayList;

class TreeNode {
    String data;
    ArrayList<TreeNode> node;

    TreeNode(String data){
        this.data=data;
        this.node=new ArrayList<TreeNode>();
    }

    public void addChild(TreeNode node){
        this.node.add(node);
    }

    public String print(int level){
        String ret;
        ret="  ".repeat(level)+data+"\n";
        for(TreeNode treeNode:this.node){
            ret+=treeNode.print(level+1);
        }
        return ret;
    }
}

public class Tree{
    public static void allOperations(){
        TreeNode drinks=new TreeNode("Drinks");
        TreeNode hot=new TreeNode("Hot");
        TreeNode cold=new TreeNode("Cold");
        drinks.addChild(hot);
        drinks.addChild(cold);
        TreeNode tea=new TreeNode("Tea");
        TreeNode coffee=new TreeNode("Coffee");
        TreeNode nonAlcoholic=new TreeNode("NonAlcoholic");
        TreeNode alcoholic=new TreeNode("Alcoholic");
        hot.addChild(tea);
        hot.addChild(coffee);
        cold.addChild(nonAlcoholic);
        cold.addChild(alcoholic);

        System.out.println(drinks.print(0));
    }
}
