package AdvanceDSA.BinaryTrees;

import java.util.Scanner;

public class BinartTreeUse {
    public static void main(String[] args) {
        printTreeDetailed(takeTreeInputBetter(true,0,true));

    }
    public static void printTree(BinaryTreeNode<Integer> root){
        if(root==null){
            return ;
        }
        System.out.println(root.data);
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
                System.out.println("Enter right Child of"+ parentData);
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
}
