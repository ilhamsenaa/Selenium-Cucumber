package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;

public class BookDetailPage {

    public BookDetailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement BookDetailText(String xpathText, WebDriver driver) {
       return driver.findElement(By.xpath("//*[contains(text(),  \""+ xpathText +"\")]"));
    }
}