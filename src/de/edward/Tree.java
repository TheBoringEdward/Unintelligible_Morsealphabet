package de.edward;

public class Tree {

    private Node root;

    Tree(){
        root = new Node(null, null, null, "");
    }

    public Node getRoot() {
        return root;
    }

    public String convert(String s) {
        StringBuilder plain = new StringBuilder();
        String extract = "";

        while (0 != s.length()) {

            while (s.charAt(0) != ' ') {
                extract = extract + s.charAt(0);
                s = s.substring(1);
            }
            plain.append(root.get(extract));
        }

        //get chars till space
        //give chars to root
        //give root return to plain
        //if finished return plain

        return plain.toString();
    }

    public void print(){
        root.print();
    }
}
