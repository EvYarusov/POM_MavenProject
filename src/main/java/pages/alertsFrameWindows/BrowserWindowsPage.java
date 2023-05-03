package pages.alertsFrameWindows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

public class BrowserWindowsPage extends BasePage {
    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "tabButton")
    WebElement tabButton;
    public BrowserWindowsPage switchToNewTab(int index) {
        click(tabButton);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        return this;
    }

    @FindBy(id = "sampleHeading")
    WebElement sampleHeading;
    public BrowserWindowsPage assertNewTabByMessage(String text) {
        Assert.assertTrue(shouldHaveText(sampleHeading, text, 15));
        return this;
    }

    @FindBy(id = "windowButton")
    WebElement windowButton;
    public BrowserWindowsPage switchToNewWindow(int index) {
        click(windowButton);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        return this;
    }

    @FindBy(id = "messageWindowButton")
    WebElement messageWindowButton;
    public BrowserWindowsPage switchToNewWindowWithMessage(int index) {
        click(messageWindowButton);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        return this;
    }
    @FindBy(xpath = "//body")
    WebElement body;
    public BrowserWindowsPage assertNewMessageWindowByMessage(String text) {
        pause(2000);
        Assert.assertTrue(body.getText().contains(text));
        return this;
    }
}
