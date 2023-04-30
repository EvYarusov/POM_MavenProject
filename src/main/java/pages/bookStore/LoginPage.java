package pages.bookStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName")
    WebElement userName;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login")
    WebElement loginButton;

    public ProfilePage login(String uName, String pwd) {
        type(userName, uName);
        type(password, pwd);
        click(loginButton);
        return new ProfilePage(driver);
    }

    public LoginPage loginNegative(String uName, String pwd) {
        type(userName, uName);
        type(password, pwd);
        click(loginButton);
        return this;
    }
}
