package tree.avlTree;

import java.util.LinkedList;
import java.util.Queue;

class AVLTreeNode{
    int val;
    AVLTreeNode left;
    AVLTreeNode right;
    int height;

    AVLTreeNode(){
        this.height=0;
    }
}

public class AVLTree {
    AVLTreeNode root;

    AVLTree(){
        root=null;
    }

    void preOrder(AVLTreeNode node){
        if(node==null){
            return;
        }
        System.out.print(node.val+" ");
        preOrder(node.left);
        preOrder(node.right);
    }

    void inOrder(AVLTreeNode node){
        if(node==null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.val+" ");
        inOrder(node.right);
    }

    void postOrder(AVLTreeNode node){
        if(node==null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val+" ");
    }

    void levelOrder(){
        Queue<AVLTreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            AVLTreeNode node=queue.remove();
            System.out.print(node.val+" ");
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
    }

    void search(AVLTreeNode node,int value){
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

    private int getHeight(AVLTreeNode node){
        if(node ==null){
            return 0;
        }
        return node.height;
    }

    private int getBalance(AVLTreeNode node){
        if(node == null){
            return 0;
        }
        return getHeight(node.left)-getHeight(node.right);
    }

    private AVLTreeNode rotateRight(AVLTreeNode disBalanceNode){
        AVLTreeNode newNode=disBalanceNode.left;
        disBalanceNode.left=disBalanceNode.left.right;
        newNode.right=disBalanceNode;
        disBalanceNode.height=1+Math.max(getHeight(disBalanceNode.left),getHeight(disBalanceNode.right));
        newNode.height=1+Math.max(getHeight(newNode.left),getHeight(newNode.right));
        return newNode;
    }
    private AVLTreeNode rotateLeft(AVLTreeNode disBalanceNode){
        AVLTreeNode newNode=disBalanceNode.right;
        disBalanceNode.right=disBalanceNode.right.left;
        newNode.left=disBalanceNode;
        disBalanceNode.height=1+Math.max(getHeight(disBalanceNode.left),getHeight(disBalanceNode.right));
        newNode.height=1+Math.max(getHeight(newNode.left),getHeight(newNode.right));
        return newNode;
    }

    private AVLTreeNode insertNode(AVLTreeNode node,int value){
        if(node==null){
            AVLTreeNode newNode=new AVLTreeNode();
            newNode.val=value;
            newNode.height=1;
            return newNode;
        }
        else if(value<node.val){
            node.left=insertNode(node.left,value);
        }
        else if(value>node.val){
            node.right=insertNode(node.right,value);
        }

        node.height=1+Math.max(getHeight(node.left),getHeight(node.right));
        int balance=getBalance(node);

        if(balance > 1 && value < node.left.val){
            return rotateRight(node);
        }
        if(balance > 1 && value > node.left.val){
            node.left=rotateLeft(node.left);
            return rotateRight(node);
        }
        if(balance < -1 && value > node.right.val){
            return rotateLeft(node);
        }
        if(balance < -1 && value < node.right.val){
            node.right=rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }

    public void insert(int value){
        root=insertNode(root,value);
    }

    private AVLTreeNode minimumNode(AVLTreeNode node){
        if(node.left == null){
            return node;
        }
        return minimumNode(node.left);
    }

    public AVLTreeNode deleteNode(AVLTreeNode node,int value){
        if(node==null){
            System.out.println("Value not found in the AVL tree");
            return node;
        }
        if(value<node.val){
            node.left=deleteNode(node.left,value);
        }
        else if(value>node.val){
            node.right=deleteNode(node.right,value);
        }
        else{
            if(node.left!=null && node.right!=null){
                AVLTreeNode temp=node;
                AVLTreeNode minNode=minimumNode(temp.right);
                node.val=minNode.val;
                node.right=deleteNode(node.right,minNode.val);
            }
            else if(node.left!=null){
                node =node.left;
            }
            else if(node.right!=null){
                node=node.right;
            }
            else{
                node=null;
            }
        }
        int balance=getBalance(node);
        if(balance > 1 && getBalance(node.left)>=0){
            return rotateRight(node);
        }
        if(balance >1 && getBalance(node.left)<0){
            node.left=rotateLeft(node.left);
            return rotateRight(node);
        }
        if(balance < -1 && getBalance(node.right)<=0){
            return rotateLeft(node);
        }
        if(balance < -1 && getBalance(node.right)>0){
            node.right=rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }

    public void delete(int value){
        root=deleteNode(root,value);
    }

    public void deleteTree(){
        root=null;
        System.out.println(root==null ? "AVL Tree deleted":"AVL Tree not deleted");
    }

    public static void allOperations(){
        AVLTree tree=new AVLTree();

        tree.insert(5);
        tree.insert(10);
        tree.insert(15);
        tree.insert(20);

        tree.preOrder(tree.root);
        System.out.println(" -> PreOrder");

        tree.inOrder(tree.root);
        System.out.println(" -> InOrder");

        tree.postOrder(tree.root);
        System.out.println(" -> PostOrder");

        tree.levelOrder();
        System.out.println(" -> LevelOrder");

        tree.search(tree.root, 20);

        tree.delete(5);
        tree.levelOrder();
        System.out.println(" -> LevelOrder");

        tree.deleteTree();

    }
}
