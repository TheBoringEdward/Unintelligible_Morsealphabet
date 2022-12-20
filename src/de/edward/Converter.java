package de.edward;

// The input file should be encoded in ISO-8859-15.
// The editor kate allows to choose the encoding manually.

// A fully-worked out example for a morse code converter 
// where the alphabet is stored as a binary tree

// Klaus Wiele November 2022

import java.io.*;
import java.nio.file.*;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.nio.charset.StandardCharsets;

public class Converter extends JFrame{

    private Tree my_tree = new Tree();
    private RandomAccessFile database;
    private JTextArea JTA_morse;
    private JTextArea JTA_plain;
    private JButton JB_convert;

    Converter(){

        // set up the text areas
        // The JTextArea needs a surrounding JScrollPane for scrolling.
        JTA_morse = new JTextArea("_._ ._ _ ._ ... _ ._. ___ .__. .... .");
        JTA_morse.setLineWrap(true);
        JTA_morse.setWrapStyleWord(true);
        JScrollPane JSP_morse = new JScrollPane(JTA_morse);

        JTA_plain = new JTextArea("");
        JTA_plain.setLineWrap(true);
        JTA_plain.setWrapStyleWord(true);
        JScrollPane JSP_plain = new JScrollPane(JTA_plain);

        // set up the buttons, each with an action listener
        JB_convert = new JButton("Convert");
        JB_convert.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String text = JTA_morse.getText();
                JTA_plain.setText( my_tree.convert(text) );
                JTA_morse.setText("");
            }
        });

        // All buttons are grouped in one JPanel.
        JPanel JP_buttons = new JPanel( new FlowLayout() );
        JP_buttons.add( JB_convert );

        // add the buttons and the text fields to the JFrame
        setLayout( new GridLayout(3,1) );
        add( JSP_morse );
        add( JSP_plain );
        add( JP_buttons );

        // open the input file for reading and writing
        try{
            database = new RandomAccessFile("International_Morse_Code.dat","rw");
        }catch( FileNotFoundException fnf ){
            System.out.println("\n File could not found.\n\n");
            JTA_morse.setText("Problem: I cannot find the input file.");
        }

        // read data from input file
        String entry = "";
        while( entry!=null ){
            try{
                entry = database.readLine();
            }catch( IOException io ){
                System.out.println("\n\n Error reading the data file.\n\n");
                JTA_morse.setText("Error reading the data file.");
            }
            if( entry != null ){
                Node n = my_tree.getRoot();

                // The Node n points currently to the tree's root. It will shift to
                // the Node which shall contain the newly read String.

                // In every step the first letter in entry is saved in s
                // and entry is stripped off the first letter.

                // If s is a "." then the tree is continued to the left, otherwise
                // to the right. If that node does not yet exist, it is generated
                // as a new Node. The node n always points to the actual node in the
                // tree.

                // Once all .'s and _'s in the entry have been used, the actual node
                // n gets the remainder of entry as its new value.

                String s = entry.substring(0,1);
                entry = entry.substring(1);
                while( !s.equals(" ") ){
                    if( s.equals(".") ){  // continue to the left
                        if( n.getLeft() == null ){
                            n.setLeft( new Node(n,null,null,"") );
                        }
                        n = n.getLeft();
                    }
                    if( s.equals("_") ){  // continue to the right
                        if( n.getRight() == null ){
                            n.setRight( new Node(n,null,null,"") );
                        }
                        n = n.getRight();
                    }
                    s = entry.substring(0,1);
                    entry = entry.substring(1);
                }  // while( !s.equals(" ") )
                n.setValue(entry);
            }
        }  // while( entry!=null )
    } // end of constructor

    public static void main(String [] args){
        Converter app = new Converter();
        app.setSize(600,600);
        app.setResizable(false);
        app.setTitle("Morse Converter v1.0 by KW with the help of TBE");
        app.setVisible(true);
        System.out.println("\n ======= This code has been provided by TheBoringEdward with the help of some fellows =======\n\n");
    }

}