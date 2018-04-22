package org.estafeta.pages;

import org.estafeta.users.UserDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by user on 22.04.18.
 */
public class CardDriverPage extends BasePage {

    public CardDriverPage(WebDriver webdriver) {
        super(webdriver);
        PageFactory.initElements(webdriver, this);
    }

    @FindBy(xpath = "//*[@id='document-header-section']//span[text()='Drivers']")
    private WebElement headerDocumentTitle;

    @FindBy(id = "IsActive")
    private WebElement isActiveCheckBox;

    @FindBy(id = "LastName")
    private WebElement lastNameField;

    @FindBy(id = "FirstName")
    private WebElement firstNameField;

    @FindBy(id = "SecondName")
    private WebElement secondNameField;

    @FindBy(id = "EnglishLastName")
    private WebElement englishLastNameField;

    @FindBy(id = "EnglishFirstName")
    private WebElement englishFirstNameField;

    @FindBy(id = "EnglishSecondName")
    private WebElement englishSecondNameField;

    @FindBy(id = "Email")
    private WebElement emailField;

    @FindBy(xpath = "//a[text()='Add phone number']")
    private WebElement addPhoneNumberLink;

    @FindBy(name = "PhoneNumber")
    private WebElement phoneNumberField;

    @FindBy(id = "CultureId")
    private WebElement selectLanguage;

    @FindBy(id = "Login")
    private WebElement loginFIeld;

    @FindBy(id = "Password")
    private WebElement passwordFIeld;

    @FindBy(xpath = "//select[@id='brandsControl']//following-sibling::button")
    private WebElement selectBrands;

    @FindBy(xpath = "//span[text()='Audi']/preceding-sibling::input")
    private WebElement brandsCheckBox;

    @FindBy(name = "UserCompanyId_input")
    private WebElement systemCompanyField;

    @FindBy(id = "saveButton")
    private WebElement saveButton;

    public boolean verifyCreateDriversPage() {
        return isElementPresent(headerDocumentTitle);
    }

    public void createDriver(UserDriver userDriver) {
        isActiveCheckBox.click();
        type(lastNameField, userDriver.getLastName());
        type(firstNameField, userDriver.getFirstName());
        type(secondNameField, userDriver.getSecondName());
        type(englishLastNameField, userDriver.getEnglishLastName());
        type(englishFirstNameField, userDriver.getEnglishFirstName());
        type(englishSecondNameField, userDriver.getEnglishSecondName());
        type(emailField, userDriver.getEmail());
        addPhoneNumberLink.click();
        type(phoneNumberField, userDriver.getPhoneNumber());
        selectByText(selectLanguage, userDriver.getLanguage());
        type(loginFIeld, userDriver.getLogin());
        type(passwordFIeld, userDriver.getPassword());
        selectBrands.click();
        brandsCheckBox.click();
        type(systemCompanyField, userDriver.getSystemCompany());
        saveButton.click();
    }

    public String getLoginDriver() {
        return loginFIeld.getAttribute("value");
    }
}
