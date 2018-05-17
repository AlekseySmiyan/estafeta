package org.estafeta.pages;

import org.estafeta.users.UserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by driver on 22.04.18.
 */
public class ListDriversPage extends BasePage {

    public ListDriversPage(WebDriver webdriver) {
        super(webdriver);
        PageFactory.initElements(webdriver, this);
    }

    By loader = By.id("loadingOverlay");

    @FindBy(xpath = "//*[@id='headerSection']/h3[text()='Drivers']")
    private WebElement headerTitle;

    @FindBy(xpath = "//a[text()='Create']")
    private WebElement createDriversButton;

    @FindBy(id = "searchText")
    private WebElement searchTextField;

    @FindBy(xpath = "//i[@class='icon-search']")
    private WebElement searchButton;

    public boolean verifyDriversListPage() {
       return isElementPresent(headerTitle);
    }

    public CardDriverPage goCardDriverPage() {
        waitElementNotVisible(loader, 10);
        createDriversButton.click();
        return new CardDriverPage(webdriver);
    }

    public ListDriversPage searchDriver(UserDriver userDriver) {
        waitElementNotVisible(loader, 60);
        type(searchTextField, userDriver.getLastName());
        waitElementNotVisible(loader, 10);
        searchButton.click();
        waitElementNotVisible(loader, 10);
        return this;
    }

    public boolean verifyDriverInGrid(UserDriver userDriver) {
        WebElement row = webdriver.findElement(By.xpath
                ("//*[text()='" + userDriver.getLastName() + "']//ancestor::td//following-sibling::td[text()='"
                        + userDriver.getFirstName() + "']//following-sibling::td[text()='" + userDriver.getSecondName() + "']"));
        return isElementPresent(row);
    }

    public void openCardDriver(UserDriver userDriver) {
        WebElement linkDriver = webdriver.findElement(By.xpath("//*[text()='" + userDriver.getLastName() + "']//ancestor::a"));
        linkDriver.click();
    }
}
