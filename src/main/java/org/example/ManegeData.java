package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import javax.swing.*;
import java.util.List;

public class ManegeData {

    private JLabel messageForUserLabel;
    private JTextArea messageText;
    private JTextField phoneNum;
    private JButton sendButton;

    private boolean isEnterWeb;

    private WebElement textBoxElement;

    private EdgeDriver driver;

    private int statusSend;

    private int countMessagesInChat;

    private JLabel responseTitle;
    private JTextArea responseText;

//לעשות תכונה שהיא תספור את כמות השליחות ואז ככה נוכל לעשות תנאי שאם שולחים הודעה באמצע אז התהליכונים מפסיקים
    //לשנות לכל 10 שניות את בדיקת שליחת תגובה

    public ManegeData(JLabel messageForUserLabel, JTextArea messageText, JTextField phoneNum,
                      JButton sendButton, EdgeDriver driver , JLabel responseTitle,
                      JTextArea responseText){
        this.messageForUserLabel = messageForUserLabel;
        this.messageText = messageText;
        this.phoneNum = phoneNum;
        this.sendButton = sendButton;
        this.isEnterWeb = false;
        this.textBoxElement = null;
        this.driver= driver;
        this.statusSend = Constants.NOT_SEND;
        this.countMessagesInChat = 0;
        this.responseTitle =responseTitle;
        this.responseText = responseText;

        this.sendButton.addActionListener((e) ->{
             if (isAllDetailsValid()){
                 sendMessage();
             }

        });

    }

    private void changeStatusV(){
        if (this.statusSend == Constants.NOT_SEND)
        {
            this.statusSend = Constants.SEND_NOT_SEE;
        } else if (this.statusSend == Constants.SEND_NOT_SEE) {
            this.statusSend = Constants.SEND_AND_SEE;
        }
    }

    private void checkStatusV(){
        new Thread(() -> {
            while (true){

                try {
                    WebElement vElement = driver.findElement(By.xpath(Constants.V_ELEMENT_PATH));
                    String statusV = vElement.getAttribute(Constants.PARAMETER_NAME_STATUS_V);
                    if (statusV.equals(Constants.SEND_NOT_SEE_PARAMETER) &&
                    this.statusSend == Constants.NOT_SEND ) {
                        System.out.println("Worked 1");
                        this.messageForUserLabel.setText("Message Sent");
                        changeStatusV();
                    } else if (statusV.equals(Constants.SEND_AND_SEE_PARAMETER) &&
                            this.statusSend == Constants.SEND_NOT_SEE) {
                        System.out.println("Worked 2");
                        this.messageForUserLabel.setText("Message was read");
                        changeStatusV();
                    } else if (this.statusSend == Constants.SEND_AND_SEE) {
                        System.out.println("Worked 3");
                        checkResponse(Constants.CHECK_RESPONSE);
                        break;
                    }
                }catch (Exception e){
                    System.out.print("");
                }

            }
        }).start();

    }

    private void checkResponse(int kindAct){
        new Thread(() ->{
            while (true){
                try {
                    WebElement saveAllMessages = driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div[2]/div[3]"));
                    List<WebElement> rows= saveAllMessages.findElements(By.xpath("./*"));//child
                    if (kindAct ==Constants.COUNT_MESSAGES)
                    {
                        this.countMessagesInChat = rows.size();
                        break;
                    }else if (kindAct == Constants.CHECK_RESPONSE)
                    {
                        //אם כמות השורות העכשוית גדולה מהכמות ששמרנו אזיי נשלחה הודעה
                        //לעשות פונקציה שתביא את כל ההודעות שנשלחו אחרינו עד ההודעה שאנחנו נשלח
                        if (this.countMessagesInChat < rows.size())
                        {
                            this.messageForUserLabel.setText("get Message");
                            break;
                        }
                    }

                }catch (Exception e)
                {
                    System.out.println("no found");
                }
            }
        }).start();
    }

    private void sendMessage(){
        String recipientPhone  = getValidPhoneNum(this.phoneNum.getText());
        String pathToRecipientWhatsapp = Constants.RECIPIENT_START_PATH + recipientPhone;
        driver.get(pathToRecipientWhatsapp);
        driver.manage().window().maximize();

        new Thread(() ->{
            while (true){
                try {
                    this.textBoxElement = driver.findElement(By.xpath(Constants.TEXT_BOX_PATH));
                    isEnterWeb = true;
                    break;
                }catch (Exception exception){
                    System.out.print("");
                }
            }
        }).start();

        while (!this.isEnterWeb){
            System.out.print("");
        }
        this.textBoxElement.sendKeys(this.messageText.getText());
        this.textBoxElement.sendKeys(Keys.ENTER);
        checkResponse(Constants.COUNT_MESSAGES);
        checkStatusV();
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
