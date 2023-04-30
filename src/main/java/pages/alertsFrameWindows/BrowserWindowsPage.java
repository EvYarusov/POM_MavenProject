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
    public BrowserWindowsPage switchToNewTab(int indexOfTab) {
        click(tabButton);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(indexOfTab));
        return this;
    }

    @FindBy(id = "sampleHeading")
    WebElement sampleHeading;
    public BrowserWindowsPage assertNewTabByMessage(String text) {
        Assert.assertTrue(shouldHaveText(sampleHeading, text, 15));
        return this;
    }
}
