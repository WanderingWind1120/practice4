package org.example;

import javax.naming.BinaryRefAddr;

public class BinarySearchTree {
    Node root;
    public BinarySearchTree(){
        root = new Node();
    }
    public Node insertNode (Node node){
        return insertHelper(root, node);
    }
    public Node insertHelper (Node root, Node node){
        if (root == null){
            root = node;
            return root;
        }
        else if (node.data < root.data){
            insertHelper(root.left, node);
        }
        else if (node.data > root.data){
            insertHelper(root.right, node);
        }
        return root;

    }
    public boolean searchNode (int data){
        return searchHelper(root, data);
    }
    public boolean searchHelper (Node root, int data){
        if(root == null){
            return false;
        }
        else if (data == root.data){
            return true;
        }
        else if ( data > root.data){
            searchHelper(root.right, data);
        }
        else {
            insertHelper(root.left,data);
        }
    }
    public void displayNode(){
        displayHelper(root);
    }
    public void displayHelper (Node root){
        if (root != null){
            displayHelper(root.left);
            System.out.println(root.data);
            displayHelper(root.right);
        }
    }

    public Node removeNode (int data){
        if (searchNode(data)){
            return removeHelper(root, data);
        }
    }
    public Node removeHelper (Node root, int data){
        if (root == null){
            return root;
        }
        else if (data > root.data){
            removeHelper(root.right, data);
        } else if (data < root.data) {
            removeHelper(root.left,data);
        }
        else {
            if (root.left == null & root.right == null){
                root = null;
            }
            else if ( root.right != null){
                root.data = successor(root);
                root.right = removeHelper(root.right, root.data);
            }
            else {
                root.data = predecessor(root);
                root.left = removeHelper(root.left, root.data);
            }
        }
        return root;
    }
    public int successor (Node root){
        root = root.right;
        while (root.left != null){
            root = root.left;
        }
        return root.data;
    }

    public int predecessor (Node root){
        root = root.left;
        while (root.right != null){
            root = root.right;
        }
        return root.data;
    }
}
