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
//       System.setProperty("webdriver.openqa.driver","C:\\Users\\shira\\Downloads\\msedgedriver.exe");
//       EdgeDriver driver=new EdgeDriver();
//        String pathToRecipientWhatsapp = Constants.RECIPIENT_START_PATH + "972523525518";
//        driver.get(pathToRecipientWhatsapp);
//
//        new Thread(() ->{
//            while (true){
//                try {
//                    WebElement messageBox = driver.findElement(By.id("main"));
//                    List<WebElement> tagMessage = messageBox.findElements(By.className("_1beEj"));
//                    List<WebElement> afterTag = tagMessage.get(tagMessage.size() - 1).findElements(By.tagName("span"));
//                    String statusWeb = afterTag.get(1).getAttribute("aria-label");
//                    System.out.println("found");
//
//                    WebElement saveAllMessages = driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div[2]/div[3]"));
//                   List<WebElement> rows= saveAllMessages.findElements(By.xpath("./*"));//child
//                    List<WebElement> r = rows.get(rows.size() - 1).findElement(By.className("CzM4m")).findElements(By.tagName("div")
//                            .findElement(By.className("_1BOF7 _2AOIt")));
//                    List<WebElement> r = rows.get(rows.size() - 1).findElements(By.tagName("span"));
//                    String status = r.get(r.size()-2).getAttribute("aria-label");
//                    System.out.println(status.contains("נקראה"));
//                    for (WebElement webElement: r)
//                    {
//                        String status = webElement.getAttribute("aria-label");
//                        System.out.println(status);
//                    }
//                    break;
//
//                }catch (Exception exception)
//                {
//                    System.out.println("no found");
//                }
//
//            }
//        }).start();

        //_3sxvM message-out focusable-list-item _1AOLJ _2UtSC _1jHIY
        //message-out focusable-list-item _1AOLJ _2UtSC _1jHIY

       // do8e0lj9 l7jjieqr k6y3xtnu
        //do8e0lj9 l7jjieqr k6y3xtnu

        //"//*[@id=\"main\"]/div[2]/div/div[2]/div[3]"
        //*[@id="main"]/div[2]/div/div[2]/div[3]/div[45]
        //*[@id="main"]/div[2]/div/div[2]/div[3]/div[29]/div/div/div/div[1]/div[1]/div[1]/div/span[1]/span
        //*[@id="main"]/div[2]/div/div[2]/div[3]/div[50]/div/div/div/div[1]/div[1]/div[1]/div/span[1]/span
//       new Thread(() ->{
//           while (true){
//               try {
//                   WebElement saveAllMessages = driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div[2]/div[3]"));
//                   List<WebElement> rows= saveAllMessages.findElements(By.xpath("./*"));//child
//                   rows.get(5).findElement(By.className("CzM4m")).
//                           findElement(By.className("_3sxvM message-in focusable-list-item _1AOLJ _2UtSC _1jHIY"));
//                   System.out.println("found");
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
