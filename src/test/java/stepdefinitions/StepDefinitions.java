package stepdefinitions;

import org.junit.Assert;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobjects.SelectMenuPage;
import pageobjects.BookStorePage;
import pageobjects.BookDetailPage;
import utils.FileUtils;
import utils.Validations;
import utils.Waits;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class StepDefinitions {

    private WebDriver driver;

    private String gitPocketGuideTittleText;
    private String gitPocketGuideAuthorText;
    private String gitPocketGuidePublisherText;

    public void startDriver(String url){

        System.setProperty("webdriver.chrome.driver", new File("chromedriver.exe").getPath());
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

    }

    @After
    public void tearDown(Scenario scenario) throws IOException {

        if(scenario.isFailed()){
            FileUtils fileUtils = new FileUtils();
            fileUtils.addScreenshot(scenario, driver);
        }

        driver.quit();

    }

    @Given("User go to {string}")
    public void User_go_to(String s) {
       String url = "";

        switch (s.toLowerCase()){
            case "selectmenu":
                url = "https://demoqa.com/select-menu";
                break;
            case "books":
                url = "https://demoqa.com/books/";
                break;
        }

        startDriver(url);
        Waits waits = new Waits(driver);

        switch (s.toLowerCase()){
            case "selectmenu":
                SelectMenuPage selectMenuPage = new SelectMenuPage(driver);
                waits.waitForElement(selectMenuPage.selectValueDropdownField);
                break;
            case "books":
                BookStorePage bookStorePage = new BookStorePage(driver);
                waits.waitForElement(bookStorePage.bookStoreHeader);
                break;
        }
    }

    @When("User in “select menu” page")
    public void User_in_select_menu_page() {
        SelectMenuPage selectMenuPage = new SelectMenuPage(driver);
        String actualText = selectMenuPage.selectMenuHeader.getText();
        String expectedText = "Select Menu";
        Assert.assertEquals(expectedText, actualText);
    }

    @When("User choose select value “Another root option”")
    public void User_choose_select_value_Another_root_option() {
        SelectMenuPage selectMenuPage = new SelectMenuPage(driver);
        selectMenuPage.selectValueDropdownField.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(selectMenuPage.SelectOptionDropdown("Another root option", this.driver)));
        selectMenuPage.SelectOptionDropdown("Another root option", this.driver).click();
    }

    @When("User choose select one “Other”")
    public void User_choose_select_one_Other() {
       SelectMenuPage selectMenuPage = new SelectMenuPage(driver);
        selectMenuPage.selectOneDropdownField.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(selectMenuPage.SelectOptionDropdown("Other", this.driver)));
        selectMenuPage.SelectOptionDropdown("Other", this.driver).click();
    }

    @When("User choose old style select menu “Aqua”")
    public void User_choose_old_style_select_menu_Aqua() {
        SelectMenuPage selectMenuPage = new SelectMenuPage(driver);
        Select selectOptionMenuDropdown = new Select(selectMenuPage.oldMenuSelectDropdownField);
        selectOptionMenuDropdown.selectByVisibleText("Aqua");
    }

    @When("User choose multi select drop down “all color”")
    public void User_choose_multi_select_drop_down_all_color() {
        SelectMenuPage selectMenuPage = new SelectMenuPage(driver);

        selectMenuPage.multiSelectDropdownField.sendKeys("Green");
        selectMenuPage.multiSelectDropdownField.sendKeys(Keys.RETURN);

        selectMenuPage.multiSelectDropdownField.sendKeys("Blue");
        selectMenuPage.multiSelectDropdownField.sendKeys(Keys.RETURN);

        selectMenuPage.multiSelectDropdownField.sendKeys("Black");
        selectMenuPage.multiSelectDropdownField.sendKeys(Keys.RETURN);

        selectMenuPage.multiSelectDropdownField.sendKeys("Red");
        selectMenuPage.multiSelectDropdownField.sendKeys(Keys.RETURN);
    }

    @Then("User success input all select menu")
    public void User_success_input_all_select_menu() {
        SelectMenuPage selectMenuPage = new SelectMenuPage(driver);

        // String selectedValueOptionDropdown = selectMenuPage.selectValueDropdownField.getAttribute("value");
        // Assert.assertEquals("Another root option", selectedValueOptionDropdown);

        // String selectOneOptionDropdown = selectMenuPage.SelectOptionDropdown("Other", this.driver).getText();
        // Assert.assertEquals("Other", selectOneOptionDropdown);

        Select selectedOldMenu = new Select(selectMenuPage.oldMenuSelectDropdownField);
        String oldSelectOptionDropdown = selectedOldMenu.getFirstSelectedOption().getText();
        Assert.assertEquals("Aqua", oldSelectOptionDropdown);
        
        // String selectMultiOptionDropdown = selectMenuPage.multiSelectDropdownField.getText();
        // Assert.assertEquals("Other", selectMultiOptionDropdown);
    }

    @When("User in “Book Store” page")
    public void User_in_Book_Store_page() {
       BookStorePage bookStorePage = new BookStorePage(driver);
       String actualText = bookStorePage.bookStoreHeader.getText();
       String expectedText = "Book Store";
       Assert.assertEquals(expectedText, actualText);
    }

    @When("User search book “qa engineer”")
    public void User_search_book_qa_engineer() {
       BookStorePage bookStorePage = new BookStorePage(driver);
       bookStorePage.searchBoxField.sendKeys("qa engineer");
    }

    @Then("User see “No rows found”")
    public void User_see_No_rows_found() {
       BookStorePage bookStorePage = new BookStorePage(driver);
       WebDriverWait wait = new WebDriverWait(driver, 5);
       wait.until(ExpectedConditions.visibilityOf(bookStorePage.noDataFoundWording));
       String actualText = bookStorePage.noDataFoundWording.getText();
       String expectedText = "No rows found";
       Assert.assertEquals(expectedText, actualText);
    }

    @When("User search book “Git Pocket Guide”")
    public void User_search_book_Git_Pocket_Guide() {
       BookStorePage bookStorePage = new BookStorePage(driver);
       bookStorePage.searchBoxField.sendKeys("Git Pocket Guide");
    }

    @When("User click book “Git Pocket Guide”")
    public void User_click_book_Git_Pocket_Guide() {
       BookStorePage bookStorePage = new BookStorePage(driver);
       this.gitPocketGuideTittleText = bookStorePage.gitPocketGuideTittleText.getText();
       this.gitPocketGuideAuthorText = bookStorePage.gitPocketGuideAuthorText.getText();
       this.gitPocketGuidePublisherText = bookStorePage.gitPocketGuidePublisherText.getText();
       
       bookStorePage.gitPocketGuideTittleButton.click();
    }

    @Then("User see “Git Pocket Guide”")
    public void User_see_Git_Pocket_Guide() {
        BookDetailPage bookDetailPage = new BookDetailPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlContains("https://demoqa.com/books?book="));
        String actualText = bookDetailPage.BookDetailText(this.gitPocketGuideTittleText, this.driver).getText();
        Assert.assertEquals(actualText, this.gitPocketGuideTittleText);

        actualText = bookDetailPage.BookDetailText(this.gitPocketGuideAuthorText, this.driver).getText();
        Assert.assertEquals(actualText, this.gitPocketGuideAuthorText);

        actualText = bookDetailPage.BookDetailText(this.gitPocketGuidePublisherText, this.driver).getText();
        Assert.assertEquals(actualText, this.gitPocketGuidePublisherText);
    }
}
