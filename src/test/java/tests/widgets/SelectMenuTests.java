package tests.widgets;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SidePanel;
import pages.widgets.SelectMenuPage;
import tests.TestBase;

public class SelectMenuTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getWidgets();
        new SidePanel(driver).selectSelectMenu();
    }

    // ДЗ два первых селекта

    @Test
    public void selectOldStyleTest() {
        new SelectMenuPage(driver).selectOldStyle("Blue");
    }

    @Test
    public void multiSelectTest() {
        new SelectMenuPage(driver).multiSelect("Red");
    }
    @Test
    public void multiSelectTest2() {
        new SelectMenuPage(driver).multiSelect2(new String[]{"Red", "Blue", "Green"});
    }
    @Test
    public void standartMultiSelectTest() {
        new SelectMenuPage(driver).standartMultiSelect(1);
    }
}
