package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import javax.swing.*;
import java.awt.*;

public class SendMessage extends JPanel{

     private JTextArea messageText;
     private JTextField phoneNum;
     private JLabel phoneNumTitle;
    private JLabel messageTextTitle;

    private JLabel messageForUserLabel;
    private JButton sendButton;

    private JLabel responseTitle;
    private JTextArea responseText;

    private ImageIcon image;

    public SendMessage(int x, int y, int width, int height, EdgeDriver driver)
    {
        this.setBounds(x,y,width,height);
        this.setLayout(null);
        this.image = new ImageIcon("src/main/java/org/example/background.jpg");
        this.messageTextTitle = Utils.newLabel("Message Text",
                this.getX()  + Constants.MARGIN_FROM_LEFT,
                (this.getHeight()/5));

        this.messageText = Utils.newTextArea("Please write a message",
                this.messageTextTitle.getX(),
                this.messageTextTitle.getY() + Constants.LABEL_HEIGHT + Constants.MARGIN_FROM_TOP);

        this.phoneNumTitle = Utils.newLabel("Phone number",
                this.messageTextTitle.getX() + Constants.LABEL_WIDTH + Constants.MARGIN_FROM_LEFT,
                this.messageTextTitle.getY());

        this.phoneNum =Utils.newTextField( this.phoneNumTitle.getX(),
                this.phoneNumTitle.getY() + Constants.LABEL_HEIGHT + Constants.MARGIN_FROM_TOP);

        this.sendButton=Utils.newButton("Send Message",this.getWidth()/2-Constants.BUTTON_WIDTH/2
                ,this.getHeight()/4*3);

        this.messageForUserLabel = Utils.newLabel("Enter message",
                this.getX() + Constants.MARGIN_FROM_LEFT,this.sendButton.getY());

        this.responseTitle = Utils.newLabel("Respond back",
                this.getWidth() - Constants.MARGIN_FROM_LEFT -Constants.LABEL_WIDTH,
                this.phoneNumTitle.getY());

        this.responseText = Utils.newTextArea("", this.responseTitle.getX(),
                this.responseTitle.getY() + Constants.MARGIN_FROM_TOP+Constants.LABEL_HEIGHT);

        addObjects();

        new ManegeData(this.messageForUserLabel, this.messageText,this.phoneNum,this.sendButton,driver,
                this.responseTitle, this.responseText);

        this.setVisible(true);
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(this.image.getImage(),this.getX(),this.getY(),this.getWidth(), this.getHeight(),null );
        graphics.drawImage(this.image.getImage(),this.getX(),this.getY(),this.getWidth(), this.getHeight(),null );

    }

    private void addObjects()
    {
        this.add(this.messageTextTitle);
        this.add(this.messageText);
        this.add(this.phoneNumTitle);
        this.add(this.phoneNum);
        this.add(this.sendButton);
        this.add(this.messageForUserLabel);
        this.add(this.responseTitle);
        this.add(this.responseText);
    }

}
