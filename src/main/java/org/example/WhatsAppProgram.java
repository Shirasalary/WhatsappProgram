package org.example;

import javax.swing.*;

public class WhatsAppProgram extends JFrame {

    public static void main(String[] args) {
        new WhatsAppProgram();
    }
    public WhatsAppProgram(){
        this.setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setTitle("WhatsApp Program by Shira & Hila & Sara");
        this.add(new LogIn(0,0,Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT));
        this.setVisible(true);
    }
}
