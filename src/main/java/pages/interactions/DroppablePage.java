package pages.interactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class DroppablePage extends BasePage {
    public DroppablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "draggable")
    WebElement dragMe;
    @FindBy(id = "droppable")
    WebElement dropHere;
    public DroppablePage actionDragMe() {
        Actions action = new Actions(driver);
        pause(2000);
        action.dragAndDrop(dragMe, dropHere).build().perform();

        String textTo = dropHere.getText();
        if (textTo.equals("Dropped!")) {
            System.out.println("PASS: Source is dropped to target as expected!");
        } else {
            System.out.println("FAIL: Source couldn't be dropped to target as expected!");
        }
        return this;
    }

    public DroppablePage dragAndDropBy(int x, int y) {

        Actions action = new Actions(driver);

        int xOffset1 = dragMe.getLocation().getX();
        int yOffset1 = dragMe.getLocation().getY();
        System.out.println("xOffset1 --> " + xOffset1 + ", yOffset1 --> " + yOffset1);

        int xOffset = dropHere.getLocation().getX();
        int yOffset = dropHere.getLocation().getY();
        System.out.println("xOffset --> " + xOffset + ", yOffset --> " + yOffset);

        xOffset = (xOffset - xOffset1) + x;
        yOffset = (yOffset - yOffset1) + y;
        pause(1000);

        action.dragAndDropBy(dragMe, xOffset, yOffset).perform();

        String textTo = dropHere.getText();
        if (textTo.equals("Dropped!")) {
            System.out.println("PASS: Source is dropped to target as expected!");
        } else {
            System.out.println("FAIL: Source couldn't be dropped to target as expected!");
        }

        return this;
    }
}
