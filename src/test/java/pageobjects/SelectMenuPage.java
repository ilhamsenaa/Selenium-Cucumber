package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;

public class SelectMenuPage {

    public SelectMenuPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getSelected(WebElement dropdown) {
        return new Select(dropdown).getFirstSelectedOption().getText().trim();
    }

    public WebElement SelectOptionDropdown(String xpathText, WebDriver driver) {
       return driver.findElement(By.xpath("//*[contains(text(),  \""+ xpathText +"\")]"));
    }

    @FindBy(id = "withOptGroup")
    public WebElement selectValueDropdownField;

    @FindBy(id = "selectOne")
    public WebElement selectOneDropdownField;

    @FindBy(id = "react-select-4-input")
    public WebElement multiSelectDropdownField;

    @FindBy(id = "oldSelectMenu")
    public WebElement oldMenuSelectDropdownField;

    @FindBy(css = ".main-header")
    public WebElement selectMenuHeader;

    @FindBy(css = ".css-1rhbuit-multiValue")
    public WebElement selectedMultiValue;
}
