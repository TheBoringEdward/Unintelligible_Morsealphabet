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
        StringBuilder extract = new StringBuilder();

        while (s.length() != 0) {

            while (s.length() != 0 && s.charAt(0) != ' ') {

                extract.append(s.charAt(0));
                System.out.println("---next char---");
                s = s.substring(1);

                System.out.println("Extract: " + extract);

            }

            plain.append(root.get(extract.toString()));

            if(s.length() > 1 && s.charAt(0) == ' ' && s.charAt(1) == ' '){
                plain.append(" ");
                System.out.println("A space has been printed.\n");
            }

            if (s.length() != 0) {
                s = s.substring(1);
            }
            extract = new StringBuilder();
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
