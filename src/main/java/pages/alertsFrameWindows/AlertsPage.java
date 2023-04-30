package pages.alertsFrameWindows;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.BasePage;

import java.time.Duration;

public class AlertsPage extends BasePage {
    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "timerAlertButton")
    WebElement timerAlertButton;
    public AlertsPage clickByAlertWithTimer() {
        click(timerAlertButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert myAlert = wait.until(ExpectedConditions.alertIsPresent());
        myAlert.accept();
        return this;
    }

    @FindBy(id = "confirmButton")
    WebElement confirmButton;
    public AlertsPage selectConfirm(String text) {
        click(confirmButton);
        if(text != null && text.equals("Ok")) {
            driver.switchTo().alert().accept();
        } else if (text != null && text.equals("Cancel")) {
            driver.switchTo().alert().dismiss();
        }
        return this;
    }

    @FindBy(id = "confirmResult")
    WebElement confirmResult;
    public AlertsPage assertResult(String text) {
        Assert.assertTrue(confirmResult.getText().contains(text));
        return this;
    }

    @FindBy(id = "promtButton")
    WebElement promtButton;
    public AlertsPage sendMessageToAlert(String message) {
        click(promtButton);
        if(message != null) {
            driver.switchTo().alert().sendKeys(message);
        }
        driver.switchTo().alert().accept();
        return this;
    }

    @FindBy(id = "promptResult")
    WebElement promptResult;
    public AlertsPage assertMessage(String res) {
        Assert.assertTrue(promptResult.getText().contains(res));
        return this;
    }
}
