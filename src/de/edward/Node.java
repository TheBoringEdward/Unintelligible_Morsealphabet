package de.edward;

import java.util.Objects;
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

    // Prints out the value, the left child and the right child.
    // Are either children not existent, print null.
    public void print(){
        System.out.println(value + "\n");
        /*
        if (left != null) {
            System.out.println(left + "\n");
        } else {        // I have a lingering feeling that there's a better way of doing this.
            System.out.println("null" + "\n");
        }
         */
        System.out.println(Objects.requireNonNullElse(left, "null") + "\n");
        System.out.println(Objects.requireNonNullElse(right, "null") + "\n");
    }

    public String get( String s ){ //TODO: Do the reverse.
        System.out.println("About to print 's'.");
        System.out.println(s);
        System.out.println("'s' has been printed.");
        String ret = "";
        if (s.length() == 0){
            ret =  value;
        } else if (s.charAt(0) == '.' && left != null){
            return left.get(s.substring(1));
        } else if (s.charAt(0) == '_' && right != null) {
            return right.get(s.substring(1));
        } else if (s.charAt(0) == '-' && right != null) { // for the use of dashes and underscores alike
            return right.get(s.substring(1));
        } else {
            ret = "#";
            System.out.println("Invalid character! Watch your input!\n");
        }
        System.out.println("\n'" + ret + "' will be printed.\nNext letter...\n");
        return ret;
    }
}
