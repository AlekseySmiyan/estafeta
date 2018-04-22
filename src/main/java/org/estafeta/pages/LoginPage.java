package org.estafeta.pages;

import org.estafeta.users.UserAdmin;
import org.estafeta.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Aleksey Smiyan on 22.04.18.
 */
public class LoginPage extends BasePage{

    public LoginPage(WebDriver webdriver) {
        super(webdriver);
        PageFactory.initElements(webdriver, this);
    }

    @FindBy(id = "UserName")
    private WebElement loginField;

    @FindBy(id = "Password")
    private WebElement passwordField;

    @FindBy(name = "signin")
    private WebElement signinButton;

    public void goLoginPage() {
        goPage(PropertiesReader.getProperties("login.page"));
    }

    public boolean compareTitle(String title) {
        return title.equals(getTitlePage());
    }

    public HomePage loginUser(UserAdmin userAdmin) {
        type(loginField, userAdmin.getLogin());
        type(passwordField, userAdmin.getPassword());
        signinButton.click();
        return new HomePage(webdriver);
    }
}
