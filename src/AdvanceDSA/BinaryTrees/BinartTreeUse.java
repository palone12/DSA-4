package AdvanceDSA.BinaryTrees;

import java.util.Scanner;

public class BinartTreeUse {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeTreeInputBetter(true,0,true);
        System.out.println("Number of Nodes is "+numOfNodes(root));
        System.out.println("Sum of Nodes  is Eqaul to " + sumOFNodes(root));

        preOrder(root);
        System.out.println();
        postOrderTraversal(root);
        System.out.println();
        inorderTravwersal(root);
        System.out.println();
        System.out.println("Largest Node is "+ largestNode(root));


    }
    public static void printTree(BinaryTreeNode<Integer> root){
        if(root==null){
            return ;
        }
        System.out.print(root.data +" ");
        printTree(root.left);
        printTree(root.right);

    }
    public static void printTreeDetailed(BinaryTreeNode<Integer>root){
        if(root==null){
            return ;
        }
        System.out.print(root.data+":");
        if(root.left!=null){
            System.out.print("L :"+root.left.data+",");
        }
        if(root.right!=null){
            System.out.print("R :"+root.right.data);
        }
        System.out.println();
        printTreeDetailed(root.left);
        printTreeDetailed(root.right);
    }
    public static BinaryTreeNode<Integer> takeTreeInput(){
        Scanner sc = new Scanner( System.in);
        System.out.println("Enter the Root Data");
        int rootData = sc.nextInt();

        if(rootData==-1){
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        BinaryTreeNode<Integer>leftChild = takeTreeInput();
        BinaryTreeNode<Integer>rightChild =takeTreeInput();
        root.left = leftChild;
        root.right=rightChild;
        return root;
    }
    public static BinaryTreeNode<Integer> takeTreeInputBetter(boolean isRoot ,int parentData ,boolean  isLeft){
        if(isRoot){
            System.out.println("Enter Root Data");
        }
        else{
            if(isLeft){
                System.out.println("Enter left Child of "+parentData);
            }
            else {
                System.out.println("Enter right Child of "+ parentData);
            }
        }
        Scanner sc = new Scanner( System.in);
        int rootData = sc.nextInt();

        if(rootData==-1){
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        BinaryTreeNode<Integer>leftChild = takeTreeInputBetter(false,rootData,true);
        BinaryTreeNode<Integer>rightChild =takeTreeInputBetter(false,rootData,false);
        root.left = leftChild;
        root.right=rightChild;
        return root;
    }

    // Number of Nodes in Binary Tree
    public static  int numOfNodes (BinaryTreeNode<Integer>root){
        if(root==null){
            return 0;
        }
        int leftNodeCount = numOfNodes(root.left);
        int righNodeCount = numOfNodes(root.right);
        return 1+ leftNodeCount  +righNodeCount;


    }

    //Sumn of Nodes in  Binary Treee
    public static int sumOFNodes (BinaryTreeNode<Integer> root){
        if(root==null){
            return 0;

        }
        int leftNodeData =sumOFNodes(root.left);
        int rightNodeData = sumOFNodes(root.right);
        return  root.data +leftNodeData +rightNodeData;
    }

    // Tree Traversals
    // Pre-Order Traversal --> root-->left-->right
    public static void preOrder(BinaryTreeNode<Integer>root){
        if(root==null){
            return;
        }
        System.out.print(root.data+ " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //Post Order Traversal In BinaryTrees
    //left--> right--> root
    public static void postOrderTraversal(BinaryTreeNode<Integer>root){
        if(root==null){
            return ;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data+" ");
    }

    // Inorder Taversal left--> root-->right
    public static void inorderTravwersal(BinaryTreeNode<Integer>root){
        if(root==null){
            return ;
        }
        inorderTravwersal(root.left);
        System.out.print(root.data+" ");
        inorderTravwersal(root.right);
    }
    // Largest Node in Binary Tree
    public static  int largestNode(BinaryTreeNode<Integer>root){
        if(root==null){
            return  -1;
        }
        int largestNodeLeft= largestNode(root.left);
        int largestNodeRight =largestNode(root.right);
        return Math.max(root.data,Math.max(largestNodeLeft,largestNodeRight));

    }
}
