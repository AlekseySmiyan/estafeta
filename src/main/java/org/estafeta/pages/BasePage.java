package org.estafeta.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Aleksey Smiyan on 22.04.18.
 */
public class BasePage {

    protected WebDriver webdriver;

    public BasePage(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    protected void goPage(String url) {
        webdriver.get(url);
    }

    protected String getTitlePage() {
        return webdriver.getTitle();
    }

    protected String getTextElement(WebElement element) {
        return element.getText();
    }


    protected boolean isElementPresent(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected void type(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    protected void selectByText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    protected void waitElementNotVisible(By element, int timeOut) {
        Wait<WebDriver> wait = new WebDriverWait(webdriver, timeOut);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }
}
