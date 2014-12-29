package com.capgemini.StarterKit;

import java.awt.Color;

public class Main {

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Window MainWindow = new Window();
                MainWindow.setVisible(false);
                MainWindow.setBackground(Color.blue);
            }
        });
    }

}