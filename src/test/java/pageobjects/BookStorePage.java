package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookStorePage {

    public BookStorePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "searchBox")
    public WebElement searchBoxField;

    @FindBy(class = "main-header")
    public WebElement bookStoreHeader;

    @FindBy(class = "rt-noData")
    public WebElement noDataFoundWording;

    @FindBy(id = "see-book-Git Pocket Guide")
    public WebElement gitPockerGuideTittleButton;
}