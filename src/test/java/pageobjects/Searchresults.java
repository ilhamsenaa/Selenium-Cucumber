package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Searchresults {

    public Searchresults(WebDriver driver)  {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "search_form_input")
    public WebElement sidebarTitle;
}
