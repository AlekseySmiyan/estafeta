package org.estafeta.tests;

import org.estafeta.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Aleksey Smiyan on 21.04.18.
 */
public class BaseTest {

    protected WebDriver webdriver;

    protected void getWebDriver(String browser) {
        if(browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", PropertiesReader.getProperties("chromedriver"));
            webdriver = new ChromeDriver();
        }
        else if(browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", PropertiesReader.getProperties("geckodriver"));
            webdriver = new FirefoxDriver();
        }
        webdriver.manage().window().maximize();
    }

    protected void closeWebDriver() {
        if(webdriver != null)
            webdriver.quit();
    }
}
