package de.edward;

public class Tree {

    private Node root;

    Tree(){
        root = new Node(null, null, null, "");
    }

    public Node getRoot() {
        return root;
    }

    public String convert(String s){
        String plain = "";
        // Gonna need a string builder here
        return plain; //Huh?
    }

    public void print(){
        root.print();
    }
}
