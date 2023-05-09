package tests.levelvan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.elements.BrokenLinksImages;

import java.time.Duration;

public class LevelvanLinksAndImagesTests {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();

        driver.get("https://levelvan.ru/courses/renaissancecourse");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void checkLinksTest() {
        new BrokenLinksImages(driver).checkBrokenLinks();
    }

    @Test
    public void checkBrokenImagesTest() {
        new BrokenLinksImages(driver).checkBrokenImages();
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }
}
