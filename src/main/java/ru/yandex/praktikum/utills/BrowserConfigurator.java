package ru.yandex.praktikum.utills;

import com.codeborne.selenide.Configuration;

public class BrowserConfigurator {

    private static void setUpYandex() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        System.setProperty("chromeoptions.args", "--incognito");
        Configuration.browserBinary = "/Applications/Yandex.app/Contents/MacOS/Yandex";
    }

    public static void setUpBrowser(String browserName) {
        Configuration.browserSize = "1920x1080";

        if (browserName.equals("yandex")) {
            setUpYandex();
        }
    }

}
