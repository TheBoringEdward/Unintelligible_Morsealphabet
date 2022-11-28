package de.edward;

import java.util.logging.Level;

public class Node {
    private Node pre;   // parent node
    private Node left;  // left child node
    private Node right; // right child node
    private String value;   // letter or just ""

    Node ( Node pre, Node left, Node right, String value){
        this.pre = pre;
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public Node getPre(){
        return pre;
    }

    public void setPre(Node pre){
        this.pre = pre;
    }

    public Node getLeft(){
        return left;
    }

    public void setLeft(Node left){
        this.left = left;
    }

    public Node getRight(){
        return right;
    }

    public void setRight(Node right){
        this.right = right;
    }

    public String getValue(){
        return value;
    }

    public void setValue(String value){
        this.value = value;
    }

    public void print(){

    }

    public String get( String s ){

    }
}
