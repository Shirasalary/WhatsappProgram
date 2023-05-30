package org.example;

import org.openqa.selenium.edge.EdgeDriver;

import javax.swing.*;

public class SendMessage extends JPanel{

     private JTextArea messageText;
     private JTextField phoneNum;
     private JLabel phoneNumTitle;
    private JLabel messageTextTitle;

    private JLabel messageForUserLabel;
    private JButton sendButton;

  //לעשות מחלקה שתנהל את המידע על השליחת הודעה ולהגדיר לה תיבת ליבל להודעות


    public SendMessage(int x, int y, int width, int height, EdgeDriver driver)
    {
        this.setBounds(x,y,width,height);
        this.setLayout(null);

        this.messageTextTitle = Utils.newLabel("Message Text",
                this.getX()  + Constants.MARGIN_FROM_LEFT,
                (this.getHeight()/5));
        this.messageText = new JTextArea("Please write a message");
        this.messageText.setBounds(this.messageTextTitle.getX(),
                this.messageTextTitle.getY() + Constants.LABEL_HEIGHT + Constants.MARGIN_FROM_TOP,
                Constants.TEXT_AREA_WIDTH,Constants.TEXT_AREA_HEIGHT);
        this.messageText.setLineWrap(true);
        this.messageText.setWrapStyleWord(true);

        this.phoneNumTitle = Utils.newLabel("Phone number",
                this.messageTextTitle.getX() + Constants.LABEL_WIDTH + Constants.MARGIN_FROM_LEFT,
                this.messageTextTitle.getY());

        this.phoneNum =Utils.newTextField( this.phoneNumTitle.getX(),
                this.phoneNumTitle.getY() + Constants.LABEL_HEIGHT + Constants.MARGIN_FROM_TOP);

        this.sendButton=Utils.newButton("Send Message",this.getWidth()/2-Constants.BUTTON_WIDTH/2
                ,this.getHeight()/4*3);

        this.messageForUserLabel = Utils.newLabel("Enter message",
                this.getX() + Constants.MARGIN_FROM_LEFT,this.sendButton.getY());

        addObjects();

        new ManegeData(this.messageForUserLabel, this.messageText,this.phoneNum,this.sendButton,driver);

        this.setVisible(true);
    }


    private void addObjects()
    {
        this.add(this.messageTextTitle);
        this.add(this.messageText);
        this.add(this.phoneNumTitle);
        this.add(this.phoneNum);
        this.add(this.sendButton);
        this.add(this.messageForUserLabel);
    }

}
