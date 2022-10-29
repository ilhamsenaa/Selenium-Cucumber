package stepdefinitions;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.After;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pageobjects.SelectMenuPage;
import pageobjects.Searchresults;
import pageobjects.AutomationStore;
import utils.FileUtils;
import utils.Validations;
import utils.Waits;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class StepDefinitions {

    private WebDriver driver;

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

        switch (site.toLowerCase()){
            case "https://demoqa.com/select-menu":
                url = "“https://demoqa.com/select-menu”";
                break;
            case "https://demoqa.com/books":
                url = "https://demoqa.com/books/";
                break;
            default:
                Assert.fail("Something is wrong. The website '" + site + "' you are trying to open in not recognised. ");
        }

        startDriver(url);
        Waits waits = new Waits(driver);

        switch (site.toLowerCase()){
            case "https://demoqa.com/select-menu":
                SelectMenuPage selectMenuPage = new SelectMenuPage(driver);
                waits.waitForElement(SelectMenuPage.selectValueDropdownField);
                break;
            case "https://demoqa.com/books":
                AutomationStore automationStore = new AutomationStore(driver);
                waits.waitForElement(automationStore.logoStore);
                break;
            default:
                System.out.println("Something is wrong. The website '" + site + "' you are trying to open in not recognised. ");
        }
    }

    @When("User in “select menu” page")
    public void User_in_select_menu_page() {
        SelectMenuPage selectMenuPage = new SelectMenuPage(driver);
        String actualText = SelectMenuPage.selectMenuHeader.getText();
        String expectedText = "Select Menu";
        Assert.assertEquals(expectedText, actualText);
    }

    @When("User choose select value “Another root option”")
    public void User_choose_select_value_Another_root_option() {
        SelectMenuPage selectMenuPage = new SelectMenuPage(driver);
        SelectMenuPage.selectValueDropdownField.click();
        SelectMenuPage.selectValueDropdownField.sendKeys("Another root option");
        SelectMenuPage.selectValueDropdownField.sendKeys(Keys.RETURN);
    }

    @When("User choose select one “Other”")
    public void User_choose_select_one_Other() {
       SelectMenuPage selectMenuPage = new SelectMenuPage(driver);
       SelectMenuPage.selectOneDropdownField.click();
       SelectMenuPage.selectOneDropdownField.sendKeys("Other");
       SelectMenuPage.selectOneDropdownField.sendKeys(Keys.RETURN);
    }

    @When("User choose old style select menu “Aqua”")
    public void User_choose_old_style_select_menu_Aqua() {
        SelectMenuPage selectMenuPage = new SelectMenuPage(driver);
        SelectMenuPage.oldMenuSelectDropdownField.selectByVisibleText("Aqua");
    }

    @When("User choose multi select drop down “all color”")
    public void User_choose_multi_select_drop_down_all_color() {
        SelectMenuPage selectMenuPage = new SelectMenuPage(driver);
        SelectMenuPage.multiSelectDropdownField.click();
        SelectMenuPage.selectValueDropdownField.sendKeys("Green");
        SelectMenuPage.selectValueDropdownField.sendKeys(Keys.RETURN);
        
        SelectMenuPage.selectValueDropdownField.sendKeys("Red");
        SelectMenuPage.selectValueDropdownField.sendKeys(Keys.RETURN);

        SelectMenuPage.selectValueDropdownField.sendKeys("Blue");
        SelectMenuPage.selectValueDropdownField.sendKeys(Keys.RETURN);

        SelectMenuPage.selectValueDropdownField.sendKeys("Black");
        SelectMenuPage.selectValueDropdownField.sendKeys(Keys.RETURN);
    }

    @Then("User success input all select menu")
    public void User_success_input_all_select_menu() {
        SelectMenuPage selectMenuPage = new SelectMenuPage(driver);
        SelectMenuPage.selectValueDropdownField.isSelect;
    }

    @When("User in “Book Store” page")
    public void User_in_Book_Store_page() {
       BookStorePage bookStorePage = new BookStorePage(driver);
       String actualText = BookStorePage.bookStoreHeader.getText();
       String expectedText = "Book Store";
       Assert.assertEquals(expectedText, actualText);
    }

    @When("User search book “qa engineer”")
    public void User_search_book_qa_engineer() {
       BookStorePage bookStorePage = new BookStorePage(driver);
       BookStorePage.searchBoxField.sendKeys("qa engineer");
    }

    @Then("User see “No rows found”")
    public void User_see_No_rows_found() {
       BookStorePage bookStorePage = new BookStorePage(driver);
       String actualText = BookStorePage.noDataFoundWording.getText();
       String expectedText = "No rows found";
       Assert.assertEquals(expectedText, actualText);
    }

    @When("User search book “Git Pocket Guide”")
    public void User_search_book_Git_Pocket_Guide() {
       BookStorePage bookStorePage = new BookStorePage(driver);
       BookStorePage.searchBoxField.sendKeys("Git Pocket Guide");
    }

    @When("User click book “Git Pocket Guide”")
    public void User_click_book_Git_Pocket_Guide() {
       BookStorePage bookStorePage = new BookStorePage(driver);
       String gitPockerGuideTittleText = BookStorePage.gitPockerGuideTittleButton.getText();
       
       BookStorePage.gitPockerGuideTittleButton.click();
    }

    @Then("User see “Git Pocket Guide”")
    public void User_see_Git_Pocket_Guide() {
        // Write code here that turns the phrase above into concrete actions
    }
}
