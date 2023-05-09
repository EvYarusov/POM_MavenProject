package tests;

import data.UserData;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.JSExecutor;
import pages.SidePanel;

public class JSExecutorTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getElements();
        new SidePanel(driver).selectTextBox();
    }

    @Test
    public void executorTest() {
        new JSExecutor(driver).enterDataWithJS(
                UserData.USER_NAME, UserData.USER_EMAIL)
                .clickOnSubmitWithJS()
                .checkInnerTextWithJS()
                .refreshWithJS()
                .checkURLWithJS()
                .checkTitleOfPageWithJS();
    }
}
