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

    @FindBy(css = ".main-header")
    public WebElement bookStoreHeader;

    @FindBy(css = ".rt-noData")
    public WebElement noDataFoundWording;

    @FindBy(id = "see-book-Git Pocket Guide")
    public WebElement gitPocketGuideTittleButton;

    @FindBy(xpath = "//*[contains(text(), 'Git Pocket Guide')]")
    public WebElement gitPocketGuideTittleText;

    @FindBy(xpath = "//*[contains(text(), 'Richard E. Silverman')]")
    public WebElement gitPocketGuideAuthorText;

    @FindBy(xpath = "//*[contains(text(),  \"O'Reilly Media\")]")
    public WebElement gitPocketGuidePublisherText;
}