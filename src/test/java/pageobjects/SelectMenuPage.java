package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectMenuPage {

    public SelectMenuPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "withOptGroup")
    public WebElement selectValueDropdownField;

    @FindBy(id = "selectOne")
    public WebElement selectOneDropdownField;

    @FindBy(css = "#selectMenuContainer > div:nth-child(7) > div > div > div > div.css-1hwfws3")
    public WebElement multiSelectDropdownField;

    @FindBy(id = "oldSelectMenu")
    public WebElement oldMenuSelectDropdownField;

    @FindBy(class = "main-header")
    public WebElement selectMenuHeader;
}
