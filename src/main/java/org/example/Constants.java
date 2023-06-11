package org.example;

import java.awt.*;

public class Constants {

    public static final int WINDOW_WIDTH = 1000, WINDOW_HEIGHT =650;
    public static final Font myFont = new Font("Gisha", Font.BOLD,24);
    public static final String[] INFORMATION = {"Welcome","Press log in to start"};

    public static final int LABEL_WIDTH = 250, LABEL_HEIGHT = 30;

    public static final int MARGIN_FROM_TOP = 40 , MARGIN_FROM_LEFT = 60 ;

    public static final int TEXT_FILED_WIDTH = 175, TEXT_FILED_HEIGHT = 50;

    public static final int TEXT_AREA_WIDTH = 200, TEXT_AREA_HEIGHT = 200;

    public static final int BUTTON_WIDTH = 200, BUTTON_HEIGHT = 50;

    public static final String QR_CODE_CLASS = "_19vUU" , WHATSAPP_PATH = "https://web.whatsapp.com/",
            RECIPIENT_START_PATH = "https://web.whatsapp.com/send?phone=",
    TEXT_BOX_PATH = "//*[@id=\"main\"]/footer/div[1]/div/span[2]/div/div[2]/div[1]/div/div[1]/p",
    V_ELEMENT_PATH ="*[@id=\"main\"]/div[2]/div/div[2]/div[3]/div[17]/div/div/div/div[1]/div[1]/div[2]/div/div/span",
    TEXT_PATH = "/div/div/div/div[1]/div[1]/div[1]/div/span[1]/span";

    //*[@id="main"]/div[2]/div/div[2]/div[3]/div[17]/div/div/div/div[1]/div[1]/div[2]/div/div/span
    public static final int NOT_SEND = 1, SEND_NOT_SEE = 2, SEND_AND_SEE =3 ,COUNT_MESSAGES = 1,
    CHECK_RESPONSE = 2;

    public static final String PARAMETER_NAME_STATUS_V ="aria-label", SEND_NOT_SEE_PARAMETER ="נמסרה", SEND_AND_SEE_PARAMETER = "נקראה";

    public static final int TIME_FOR_LOADING = 5000;

    public static final String PHONE_NUM_PREFIX = "9725" ,EMPTY = "";

    public static final char MAKAV = '-';
    public static final int REGULAR_PHONE_NUM = 10,PHONE_NUM_MAKAV = 11, PHONE_NUM_972 = 12 ,
    INDEX_0 = 0, INDEX_5 = 1, REGULAR_START_INDEX_REST = 2, MAKAV_INDEX =3 ,MAKAV_START_INDEX_REST = 4,
            REST_START_INDEX_972 = 4;
}
