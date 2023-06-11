package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class LogIn extends JPanel {

    private JButton logInButton;
    private JLabel statusLabel;

    private Thread scanTread;
    EdgeDriver driver = null;

    private boolean isScan;

    private ImageIcon background;

    public LogIn(int x, int y, int width, int height){

        this.setBounds(x,y,width,height);
        this.setLayout(null);
        this.background = new ImageIcon("src/main/java/org/example/whatsapp.jpg");
        System.setProperty("webdriver.openqa.driver","C:\\Users\\shira\\Downloads\\msedgedriver.exe");

        this.logInButton = Utils.newButton("Log In",
                this.getWidth()/2 - Constants.BUTTON_WIDTH/2,
                (this.getHeight()/4)*3);
        this.statusLabel = Utils.newLabel("Please scan the code",
                this.getWidth()/2 - Constants.LABEL_WIDTH/2,
                (this.getHeight()/4)*3);
        this.statusLabel.setVisible(false);
        this.isScan = false;


        this.scanTread = new Thread(()->{
            while (true)
            {
                try {
                    WebElement webElement = driver.findElement(By.className(Constants.QR_CODE_CLASS));
                } catch (Exception exception) {
                    this.isScan = true;
                    break;
                }
            }
        });

        this.logInButton.addActionListener((e) ->{
            this.logInButton.setVisible(false);
            this.statusLabel.setVisible(true);
            new Thread(() ->{
                driver = new EdgeDriver();
                driver.get(Constants.WHATSAPP_PATH);
                driver.manage().window().maximize();
                Utils.sleep(Constants.TIME_FOR_LOADING);
                this.scanTread.start();
                while (!this.isScan)
                {
                    repaint();
                }
                this.statusLabel.setText("Successfully logged in");
                driver.manage().window().minimize();
                this.statusLabel.setVisible(false);
                this.add(new SendMessage(this.getX(),this.getY(),this.getWidth(),this.getHeight(),driver));
            }).start();

        });

        addObjects();
        this.setVisible(true);
    }


    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(this.background.getImage(),this.getX(),this.getY(),this.getWidth(), this.getHeight(),null );
        graphics.drawImage(this.background.getImage(),this.getX(),this.getY(),this.getWidth(), this.getHeight(),null );

    }

    private void addObjects(){

        this.add(this.logInButton);
        this.add(this.statusLabel);
    }


//    public static void main(String[] args) {
//       System.setProperty("webdriver.openqa.driver","C:\\Users\\shira\\Downloads\\msedgedriver.exe");
//        EdgeDriver driver = new EdgeDriver();
//
//        driver.get("https://web.whatsapp.com/");
//        driver.manage().window().maximize();
//        try {
//            Thread.sleep(6000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        new Thread(()->{
//            while (true)
//            {
//
//                try {
//                    WebElement webElement = driver.findElement(By.className("_19vUU"));
//                    System.out.println("found");
//                } catch (Exception e) {
//                    System.out.println("logged in");
//                }
//
//            }

     //   }).start();

//         WebElement element =driver.findElement(By.className("_19vUU"));
         //driver.quit();


//        driver.get("https://www.aac.ac.il/");
//        driver.manage().window().maximize();
//        WebElement element = driver.findElement(By.className(""));
    //}
}