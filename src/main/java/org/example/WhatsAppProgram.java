package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import javax.lang.model.element.Element;
import javax.swing.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class WhatsAppProgram extends JFrame {

    static int kindAct = 1;
    static int count = 0;
    public static void main(String[] args) {
       new WhatsAppProgram();
//        System.setProperty("webdriver.openqa.driver","C:\\Users\\shira\\Downloads\\msedgedriver.exe");
//        EdgeDriver driver=new EdgeDriver();
//        String pathToRecipientWhatsapp = Constants.RECIPIENT_START_PATH + "972523639354";
//        driver.get(pathToRecipientWhatsapp);
//
//        //"//*[@id=\"main\"]/div[2]/div/div[2]/div[3]"
//        //*[@id="main"]/div[2]/div/div[2]/div[3]/div[45]
//        //*[@id="main"]/div[2]/div/div[2]/div[3]/div[29]/div/div/div/div[1]/div[1]/div[1]/div/span[1]/span
//        //*[@id="main"]/div[2]/div/div[2]/div[3]/div[50]/div/div/div/div[1]/div[1]/div[1]/div/span[1]/span
//       new Thread(() ->{
//           while (true){
//               try {
//                   WebElement saveAllMessages = driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div[2]/div[3]"));
//                   List<WebElement> rows= saveAllMessages.findElements(By.xpath("./*"));//child
//                   if (kindAct ==1)
//                   {
//                       count = rows.size();
//                       System.out.println(rows.size());
//                       kindAct++;
//                   }else if (kindAct == 2)
//                   {
//                       //אם כמות השורות העכשוית גדולה מהכמות ששמרנו אזיי נשלחה הודעה
//                       //לעשות פונקציה שתביא את כל ההודעות שנשלחו אחרינו עד ההודעה שאנחנו נשלח
//                       System.out.println(count);
//                       System.out.println( rows.get(rows.size()-1).getTagName());
//                   }
//
//               }catch (Exception e)
//               {
//                   System.out.println("no found");
//               }
//
//           }
//       }).start();
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
