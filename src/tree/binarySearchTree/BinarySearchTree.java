package tree.binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

class BinarySearchTreeNode{
    int val;
    BinarySearchTreeNode left;
    BinarySearchTreeNode right;
    int height;
}

public class BinarySearchTree {

    BinarySearchTreeNode root;

    BinarySearchTree(){
        this.root=null;
    }

    private BinarySearchTreeNode insertNode(BinarySearchTreeNode curNode,int value){
        if(curNode==null){
            BinarySearchTreeNode node=new BinarySearchTreeNode();
            node.val=value;
            System.out.println("The value "+value+" is inserted");
            return node;
        }
        else if(value<=curNode.val){
            curNode.left=insertNode(curNode.left,value);
            return curNode;
        }
        else{
            curNode.right=insertNode(curNode.right,value);
            return curNode;
        }
    }

    void insert(int value){
        root=insertNode(root,value);
    }

    void preOrder(BinarySearchTreeNode node){
        if(node==null){
            return;
        }
        System.out.print(node.val+" ");
        preOrder(node.left);
        preOrder(node.right);
    }

    void inOrder(BinarySearchTreeNode node){
        if(node==null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.val+" ");
        inOrder(node.right);
    }

    void postOrder(BinarySearchTreeNode node){
        if(node==null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val+" ");
    }

    void levelOrder(){
        Queue<BinarySearchTreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinarySearchTreeNode node=queue.remove();
            System.out.print(node.val+" ");
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
    }

    void search(BinarySearchTreeNode node,int value){
        if(node==null){
            return;
        }
        if(value==node.val){
            System.out.println("The value "+value+" is found");
        }
        else if(value<node.val && node.left!=null){
            search(node.left,value);
        }
        else if(value>node.val && node.right!=null){
            search(node.right,value);
        }
        else {
            System.out.println("The value " + value + " not found in BST");
        }
    }

    private BinarySearchTreeNode minimumNode(BinarySearchTreeNode node) {
        if(node.left==null){
            return node;
        }
        else{
            return minimumNode(node.left);
        }
    }

    BinarySearchTreeNode deleteNode(BinarySearchTreeNode node, int value){
        if(node == null){
            System.out.println("Value not found in BST");
            return null;
        }
        if(value<node.val){
            node.left=deleteNode(node.left,value);
        }
        else if(value>node.val){
            node.right=deleteNode(node.right,value);
        }
        else{
            if(node.left!=null && node.right!=null){
                BinarySearchTreeNode temp=node;
                BinarySearchTreeNode minRight=minimumNode(temp.right);
                node.val=minRight.val;
                node.right=deleteNode(node.right,minRight.val);
            }
            else if(node.left!=null){
                node=node.left;
            }
            else if(node.right!=null){
                node=node.right;
            }
            else{
                node=null;
            }
        }
        return node;
    }

    void delete(){
        root=null;
        System.out.println(root==null ? "BST is deleted" : "BST not deleted");
    }

    public static void allOperations(){
        BinarySearchTree tree=new BinarySearchTree();

        tree.insert(70);
        tree.insert(50);
        tree.insert(90);
        tree.insert(30);
        tree.insert(60);
        tree.insert(80);
        tree.insert(100);
        tree.insert(20);
        tree.insert(40);

        tree.preOrder(tree.root);
        System.out.println(" -> PreOrder");

        tree.inOrder(tree.root);
        System.out.println(" -> InOrder");

        tree.postOrder(tree.root);
        System.out.println(" -> PostOrder");

        tree.levelOrder();
        System.out.println(" -> LevelOrder");

        tree.search(tree.root, 99);

        tree.deleteNode(tree.root, 30);
        tree.levelOrder();
        System.out.println(" -> LevelOrder");

        tree.delete();
    }
}
