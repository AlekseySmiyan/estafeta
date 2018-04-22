package org.estafeta.tests;

import org.estafeta.pages.CardDriverPage;
import org.estafeta.pages.ListDriversPage;
import org.estafeta.pages.HomePage;
import org.estafeta.pages.LoginPage;
import org.estafeta.users.UserAdmin;
import org.estafeta.users.UserDriver;
import org.estafeta.utils.PropertiesReader;
import org.testng.Assert;
import org.testng.annotations.*;


/**
 * Created by Aleksey Smiyan on 21.04.18.
 */
public class LoginTest extends BaseTest {

    private LoginPage loginPage;
    private HomePage homePage;
    private ListDriversPage listDriversPage;
    private CardDriverPage cardDriverPage;
    private UserAdmin userAdmin;
    private UserDriver userDriver;

    @Parameters("browser")
    @BeforeTest
    public void setupTest(String browser) {
        getWebDriver(browser);
    }

    @AfterTest
    public void tearDownTest() {
        //closeWebDriver();
    }

    @BeforeClass
    public void setupClass() {
        loginPage = new LoginPage(webdriver);
        userAdmin = new UserAdmin(PropertiesReader.getProperties("login"),
                PropertiesReader.getProperties("password"));
        userDriver = new UserDriver();
    }

    @Test(priority = 1)
    public void goLoginPage() {
        loginPage.goLoginPage();
        Assert.assertTrue(loginPage.compareTitle("Estafeta Automotive"));
    }

    @Test(priority = 2)
    public void loginUser() {
        homePage = loginPage.loginUser(userAdmin);
        Assert.assertTrue(homePage.verifyHomePage());
    }

    @Test(priority = 3)
    public void goDriversListPage() {
        listDriversPage = homePage.goListDriversPage();
        Assert.assertTrue(listDriversPage.verifyDriversListPage());
    }

    @Test(priority = 4)
    public void goDriversCreatePage() {
        cardDriverPage = listDriversPage.goCardDriverPage();
        Assert.assertTrue(cardDriverPage.verifyCreateDriversPage());
    }

    @Test(priority = 5)
    public void createDriver() {
        cardDriverPage.createDriver(userDriver);
        listDriversPage.searchDriver(userDriver);
        Assert.assertTrue(listDriversPage.verifyDriverInGrid(userDriver));
    }

    @Test(priority = 6)
    public void openDriverCard() {
        listDriversPage.openCardDriver(userDriver);
        Assert.assertEquals(cardDriverPage.getLoginDriver(), userDriver.getLogin());
    }
}
