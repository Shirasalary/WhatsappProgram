package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

import javax.swing.*;

public class ManegeData {

    private JLabel messageForUserLabel;
    private JTextArea messageText;
    private JTextField phoneNum;
    private JButton sendButton;


    public ManegeData(JLabel messageForUserLabel, JTextArea messageText, JTextField phoneNum,
                      JButton sendButton, EdgeDriver driver){
        this.messageForUserLabel = messageForUserLabel;
        this.messageText = messageText;
        this.phoneNum = phoneNum;
        this.sendButton = sendButton;

        this.sendButton.addActionListener((e) ->{
             if (isAllDetailsValid()){
               String recipientPhone  = getValidPhoneNum(this.phoneNum.getText());
               String pathToRecipientWhatsapp = Constants.RECIPIENT_START_PATH + recipientPhone;
               driver.get(pathToRecipientWhatsapp);
               driver.findElement(By.id("action-button")).click();//למה לא לוחץ?
               driver.manage().window().maximize();
             }

        });



    }

    private boolean isAllDetailsValid(){
        boolean result = true;
        if (this.messageText.getText().equals(Constants.EMPTY))
        {
            this.messageForUserLabel.setText("Enter message");
            result = false;
        }

        if (this.phoneNum.getText().equals(Constants.EMPTY))
        {
            this.messageForUserLabel.setText("Enter phone num");
            result = false;
        }else if (getValidPhoneNum(this.phoneNum.getText()).equals("")){
            this.messageForUserLabel.setText("Not valid phone num");
            result = false;
        }

        return result;
    }

    private String getValidPhoneNum (String cellNum)
    {
        String returnCell= "";
        if (cellNum.length() == Constants.REGULAR_PHONE_NUM )
        { if (cellNum.charAt(Constants.INDEX_0)=='0'&& cellNum.charAt(Constants.INDEX_5)=='5'
                && isAllNum(cellNum.substring(Constants.REGULAR_START_INDEX_REST)))
            returnCell +=Constants.PHONE_NUM_PREFIX + cellNum.substring(Constants.REGULAR_START_INDEX_REST);

        }else if (cellNum.length() == Constants.PHONE_NUM_MAKAV)
        {
            if (cellNum.charAt(Constants.INDEX_0)=='0'&& cellNum.charAt(Constants.INDEX_5)=='5'
                    && cellNum.charAt(Constants.MAKAV_INDEX)==Constants.MAKAV
                    && isAllNum(cellNum.substring(Constants.MAKAV_START_INDEX_REST)))
                returnCell += Constants.PHONE_NUM_PREFIX + cellNum.charAt(2) + cellNum.substring(Constants.MAKAV_START_INDEX_REST) ;

        }else if (cellNum.length() == Constants.PHONE_NUM_972)
        {
            if (cellNum.charAt(0)=='9'&& cellNum.charAt(1)=='7' && cellNum.charAt(2)=='2' &&
                    cellNum.charAt(3)=='5'&& isAllNum(cellNum.substring(Constants.REST_START_INDEX_972)) )
                returnCell = cellNum;

        }
        return returnCell;
    }

    private boolean isAllNum(String number) {
        boolean only = false;
        int counter = 0;
        for (int i = 0; i < number.length(); i++) {
            if (Character.isDigit(number.charAt(i)))
                counter++;
        }
        if (counter == number.length())
            only = true;
        return only;
    }
}
