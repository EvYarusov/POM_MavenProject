package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.alertsFrameWindows.AlertsPage;
import pages.alertsFrameWindows.BrowserWindowsPage;
import pages.bookStore.BookStorePage;
import pages.bookStore.LoginPage;
import pages.bookStore.ProfilePage;
import pages.interactions.DroppablePage;
import pages.widgets.SelectMenuPage;

public class SidePanel extends BasePage {
    public SidePanel(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[.='Login']")
    WebElement login;
    public LoginPage selectLogin() {
        clickWithJSExecutor(login,0,100);
        return new LoginPage(driver);
    }

    @FindBy(xpath = "//span[.='Alerts']")
    WebElement alerts;
    public AlertsPage selectAlerts() {
        click(alerts);
        return new AlertsPage(driver);
    }

    @FindBy(xpath = "//span[.='Book Store']")
    WebElement bookStore;
    public BookStorePage selectBookStore() {
        clickWithJSExecutor(bookStore, 0,200);
        return new BookStorePage(driver);
    }

    @FindBy(xpath = "//span[.='Profile']")
    WebElement profile;
    public ProfilePage selectProfile() {
        clickWithJSExecutor(profile,0,300);
        return new ProfilePage(driver);
    }

    @FindBy(xpath = "//span[.='Browser Windows']")
    WebElement drowserWindows;
    public BrowserWindowsPage selectBrowserWindows() {
        click(drowserWindows);
        return new BrowserWindowsPage(driver);
    }

    @FindBy(xpath = "//span[.='Select Menu']")
    WebElement selectMenu;
    public SelectMenuPage selectSelectMenu() {
        clickWithJSExecutor(selectMenu,0,500);
        return new SelectMenuPage(driver);
    }

    @FindBy(xpath = "//span[.='Droppable']")
    WebElement droppable;
    public DroppablePage selectDroppable() {
        clickWithJSExecutor(droppable,0,200);
        return new DroppablePage(driver);
    }
}
