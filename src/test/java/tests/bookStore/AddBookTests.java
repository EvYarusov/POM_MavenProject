package tests.bookStore;

import data.BookData;
import data.UserData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SidePanel;
import pages.bookStore.BookStorePage;
import pages.bookStore.LoginPage;
import pages.bookStore.ProfilePage;
import tests.TestBase;

public class AddBookTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getBookStoreApplication();
        new SidePanel(driver).selectLogin();
        new LoginPage(driver)
                .login(UserData.USER_NAME, UserData.USER_PASSWORD)
                .assertAccount(UserData.USER_NAME);
    }

    @Test
    public void addBookPositiveTest() {
        new SidePanel(driver).selectBookStore();
        new BookStorePage(driver)
                .typeInSearchField(BookData.BOOK_TITLE)
                .assertNameOfBook(BookData.BOOK_TITLE)
                .addBookToCollection();
        new SidePanel(driver).selectProfile();
        new ProfilePage(driver).assertBook(BookData.BOOK_TITLE);
    }

    @AfterMethod(enabled = true)
    public void removeBookFromProfile() {
        new SidePanel(driver)
                .selectProfile()
                .assertBook(BookData.BOOK_TITLE)
                .deleteBook();
    }
}
