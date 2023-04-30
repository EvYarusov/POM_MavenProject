package pages.bookStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.BasePage;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName-value")
    WebElement user;

    public ProfilePage assertAccount(String uName) {
        Assert.assertTrue(shouldHaveText(user, uName, 10));
        return this;
    }

    @FindBy(xpath = "//span[@class = 'mr-2']/a")
    WebElement book;

    public ProfilePage assertBook(String bookTitle) {
        Assert.assertTrue(shouldHaveText(book, bookTitle, 10));
        return this;
    }
    @FindBy(id = "delete-record-undefined")
    WebElement deleteRecordBtn;
    @FindBy(id = "closeSmallModal-ok")
    WebElement deleteBookBtn;
    public ProfilePage deleteBook() {
        click(deleteRecordBtn);
        click(deleteBookBtn);
        acceptAlert(10);
        return this;
    }
}
