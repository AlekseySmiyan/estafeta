package org.estafeta.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by driver on 22.04.18.
 */
public class HomePage extends BasePage {

    public HomePage(WebDriver webdriver) {
        super(webdriver);
        PageFactory.initElements(webdriver, this);
    }

    @FindBy(xpath = "//*[text()='Welcome to Estafeta Automotive']")
    private WebElement welcomeElement;

    @FindBy(xpath = "//*[text()='Transports']")
    private WebElement transportsMenu;

    @FindBy(xpath = "//a[text()='Drivers']")
    private WebElement driversButton;

    public boolean verifyHomePage() {
        return isElementPresent(welcomeElement);
    }

    public ListDriversPage goListDriversPage() {
        transportsMenu.click();
        driversButton.click();
        return new ListDriversPage(webdriver);
    }
}
