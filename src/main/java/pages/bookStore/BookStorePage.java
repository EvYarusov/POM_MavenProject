package pages.bookStore;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.BasePage;

import java.time.Duration;

public class BookStorePage extends BasePage {
    public BookStorePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "searchBox")
    WebElement searchBox;

    public BookStorePage typeInSearchField(String text) {
        type(searchBox, text);
        return this;
    }

    @FindBy(xpath = "//span[@class = 'mr-2']/a")
    WebElement nameOfBook;
    public BookStorePage
    assertNameOfBook(String text) {
        Assert.assertTrue(nameOfBook.getText().contains(text));
        return this;
    }

    @FindBy(xpath = "//div[@class = 'text-right fullButton']/button")
    WebElement addBookToCollectionButton;
    public BookStorePage addBookToCollection() {
        click(nameOfBook);
        clickWithJSExecutor(addBookToCollectionButton, 0, 200);
        acceptAlert(10);
        return this;
    }


}
