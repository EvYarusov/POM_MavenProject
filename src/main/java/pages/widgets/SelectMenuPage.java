package pages.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

import java.util.List;

public class SelectMenuPage extends BasePage {
    public SelectMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "oldSelectMenu")
    WebElement oldSelectMenu;

    public SelectMenuPage selectOldStyle(String color) {
        Select select = new Select(oldSelectMenu);
        select.selectByVisibleText(color);
        List<WebElement> options = select.getOptions();
        // распечатаем первую опцию
        //System.out.println(select.getFirstSelectedOption().getText() + " is first");
        // распечатаем все опции
//        for (int i=0; i< options.size(); i++) {
//            System.out.println(options.get(i).getText());
//        }
        return this;
    }

    @FindBy(xpath = "(//div[@class=' css-1hwfws3'])[3]")
    WebElement multiselectDropDown;
    @FindBy(xpath = "//html")
    WebElement space;
    public SelectMenuPage multiSelect(String color) {
        click(multiselectDropDown);
        WebElement element = driver.findElement(By.xpath(String.format("//div[text() = '%s']", color)));
        click(element);
        click(space);
        return this;
    }

    @FindBy(id = "react-select-4-input")
    WebElement inputSelect;
    public SelectMenuPage multiSelect2(String[] colors) {
        for (int i=0; i < colors.length; i++) {
            if(colors[i] != null) {
                inputSelect.sendKeys(colors[i]);
                inputSelect.sendKeys(Keys.ENTER);
            }
            click(space);
        }
        return this;
    }

    @FindBy(id = "cars")
    WebElement cars;
    public SelectMenuPage standartMultiSelect(int index) {
        Select multi = new Select(cars);
        if (multi.isMultiple()) {
            multi.selectByIndex(index);
        }
        return this;
    }
}
