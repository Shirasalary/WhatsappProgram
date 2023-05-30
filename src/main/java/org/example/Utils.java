package org.example;

import javax.swing.*;

public class Utils {

    public static JLabel newLabel (String text, int x, int y )
    {
        JLabel label = new JLabel(text);
        label.setBounds(x,y,Constants.LABEL_WIDTH,Constants.LABEL_HEIGHT);
        label.setFont(Constants.myFont);
        return label;
    }

    public static JButton newButton (String text, int x, int y)
    {
        JButton button = new JButton(text);
        button.setBounds(x,y,Constants.BUTTON_WIDTH,Constants.BUTTON_HEIGHT);
        button.setFocusable(false);
        button.setFont(Constants.myFont);
        return button;
    }

    public static void sleep(int seconds){
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static JTextField newTextField(int x, int y)
    {
        JTextField textFiled = new JTextField();
        textFiled.setBounds(x,y,Constants.TEXT_FILED_WIDTH,Constants.TEXT_FILED_HEIGHT);
        textFiled.setFont(Constants.myFont);
        return textFiled;
    }

}
