package tree.binaryTree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class BinaryTreeNode{
    String val;
    BinaryTreeNode left;
    BinaryTreeNode right;
    int height;
}

public class BinaryTree {

    BinaryTreeNode root;

    BinaryTree(){
        this.root=null;
    }

    void preOrder(BinaryTreeNode node){
        if(node==null){
            return;
        }
        System.out.print(node.val+" ");
        preOrder(node.left);
        preOrder(node.right);
    }

    void inOrder(BinaryTreeNode node){
        if(node==null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.val+" ");
        inOrder(node.right);
    }

    void postOrder(BinaryTreeNode node){
        if(node==null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val+" ");
    }

    void levelOrder(){
        Queue<BinaryTreeNode> queue=new LinkedList<>();
        queue.add(this.root);
        while(!queue.isEmpty()){
            BinaryTreeNode presentNode=queue.remove();
            System.out.print(presentNode.val+" ");
            if(presentNode.left!=null){
                queue.add(presentNode.left);
            }
            if(presentNode.right!=null){
                queue.add(presentNode.right);
            }
        }
    }

    void search(String value){
        Queue<BinaryTreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryTreeNode presentNode=queue.remove();
            if(presentNode.val.equals(value)){
                System.out.println("The value "+value+" present in the tree");
                return;
            }
            else{
                if(presentNode.left!=null){
                    queue.add(presentNode.left);
                }
                if(presentNode.right!=null){
                    queue.add(presentNode.right);
                }
            }
        }
        System.out.println("The value "+value+" not found in the tree");
    }

    void insert(String value){
        BinaryTreeNode newNode=new BinaryTreeNode();
        newNode.val=value;

        if(root==null){
            root=newNode;
            System.out.println("Value inserted at the root level");
            return;
        }

        Queue<BinaryTreeNode> queue=new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            BinaryTreeNode presentNode=queue.remove();
            if(presentNode.left==null){
                presentNode.left=newNode;
                System.out.println("Value is added to the left of "+ presentNode.val);
                return;
            } else if (presentNode.right==null) {
                presentNode.right=newNode;
                System.out.println("Value is added to the right of "+ presentNode.val);
                return;
            }else {
                queue.add(presentNode.left);
                queue.add(presentNode.right);
            }
        }
    }

    public BinaryTreeNode getDeepestNode(){
        Queue<BinaryTreeNode> queue=new LinkedList<>();
        queue.add(this.root);
        BinaryTreeNode presentNode=null;
        while(!queue.isEmpty()){
            presentNode=queue.remove();
            if(presentNode.left!=null){
                queue.add(presentNode.left);
            }
            if(presentNode.right!=null){
                queue.add(presentNode.right);
            }
        }
        return presentNode;
    }

    public void deleteDeepestNode(){
        Queue<BinaryTreeNode> queue=new LinkedList<>();
        queue.add(root);
        BinaryTreeNode presentNode = null,previousNode=null;
        while(!queue.isEmpty()){
            previousNode=presentNode;
            presentNode=queue.remove();
            if(presentNode.left==null){
                previousNode.right=null;
                return;
            }
            if(presentNode.right==null){
                presentNode.left=null;
                return;
            }
            queue.add(presentNode.left);
            queue.add(presentNode.right);
        }
    }

    public void deleteNode(String value){
        Queue<BinaryTreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            BinaryTreeNode presentNode=queue.remove();
            if(presentNode.val.equals(value)){
                presentNode.val= getDeepestNode().val;
                deleteDeepestNode();
                return;
            }
            if(presentNode.left!=null){
                queue.add(presentNode.left);
            }
            if(presentNode.right!=null){
                queue.add(presentNode.right);
            }
        }
        System.out.println("Value is not found in the tree");
    }

    public void deleteTree(){
        root=null;
        if(root==null){
            System.out.println("Tree is deleted");
        }
    }

    public static void allOperations(){
        BinaryTree tree=new BinaryTree();

        tree.insert("N1");
        tree.insert("N2");
        tree.insert("N3");
        tree.insert("N4");
        tree.insert("N5");
        tree.insert("N6");
        tree.insert("N7");
        tree.insert("N8");
        tree.insert("N9");

        tree.preOrder(tree.root);

        System.out.println(" -> PreOrder Traversal");

        tree.inOrder(tree.root);

        System.out.println(" -> In-Order Traversal");

        tree.postOrder(tree.root);

        System.out.println(" -> PostOrder Traversal");

        tree.levelOrder();

        System.out.println(" -> LevelOrder Traversal");

        tree.search("N5");

        tree.deleteNode("N3");

        tree.levelOrder();

        System.out.println(" -> LevelOrder Traversal");

        tree.deleteTree();

    }
}
