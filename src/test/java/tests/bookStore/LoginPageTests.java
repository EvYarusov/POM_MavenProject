package tests.bookStore;

import data.UserData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SidePanel;
import pages.bookStore.LoginPage;
import tests.TestBase;

public class LoginPageTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getBookStoreApplication();
        new SidePanel(driver).selectLogin();
    }

    @Test
    public void loginPositiveTest() {
        new LoginPage(driver)
                .login(UserData.USER_NAME, UserData.USER_PASSWORD)
                .assertAccount(UserData.USER_NAME);
    }
}
