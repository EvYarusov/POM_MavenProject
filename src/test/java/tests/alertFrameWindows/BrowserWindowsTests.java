package tests.alertFrameWindows;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SidePanel;
import pages.alertsFrameWindows.BrowserWindowsPage;
import tests.TestBase;

public class BrowserWindowsTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getAlertFrameWindows();
        new SidePanel(driver).selectBrowserWindows();
    }

    @Test
    public void newTabTest() {
        new BrowserWindowsPage(driver)
                .switchToNewTab(1)
                .assertNewTabByMessage("This is a sample page");
    }

    // ДЗ вторая и третья кнопка

    @Test
    public void newWindowTest() {
        new BrowserWindowsPage(driver)
                .switchToNewWindow(1)
                .assertNewTabByMessage("This is a sample page");
    }

    @Test(enabled = false)
    public void newWindowWithMessageTest() {
        new BrowserWindowsPage(driver)
                .switchToNewWindowWithMessage(1)
                .assertNewMessageWindowByMessage("Knowledge increases by sharing but not by saving");
    }
}
