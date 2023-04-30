package tests.interactions;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SidePanel;
import pages.interactions.DroppablePage;
import tests.TestBase;

public class DragDropTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getInteractions();
        new SidePanel(driver).selectDroppable();
    }

    @Test
    public void actionDragMeTest() {
        new DroppablePage(driver).actionDragMe();
    }

    @Test
    public void dragAndDropByTest() {
        new DroppablePage(driver).dragAndDropBy(25,55);
    }
}
