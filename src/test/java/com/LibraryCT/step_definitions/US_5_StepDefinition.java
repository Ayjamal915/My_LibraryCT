package com.LibraryCT.step_definitions;

import com.LibraryCT.pages.*;
import com.LibraryCT.utilities.BrowserUtils;
import com.LibraryCT.utilities.ConfigurationReader;
import com.LibraryCT.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class US_5_StepDefinition {
    LoginPage loginPage = new LoginPage();
    Student_BasePage studentBasePage = new Student_BasePage();
    Librarian_BasePage librarian_basePage = new Librarian_BasePage();
    DashboardPage dashboardPage = new DashboardPage();
    UsersPage usersPage = new UsersPage();
    Select select;
    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.loginAs("librarian");
    }

    @When("I click on {string} link")
    public void i_click_on_link(String link) {
        switch (link.toLowerCase()) {
            case "dashboard":
                dashboardPage.dashBoardTab.click();
                break;
            case "user":
                dashboardPage.usersTab.click();
                break;
            case "books":
                librarian_basePage.booksLink.click();
                break;
        }
    }
    @Then("Show records default value should be {int}")
    public void show_records_default_value_should_be(Integer expected) {
        select=new Select(usersPage.showRecordsDropDown);
        String actual = select.getFirstSelectedOption().getText();
        System.out.println("actual = " + actual);
        Assert.assertEquals(expected+ "",actual);
    }
    @Then("show records should have following options:")
    public void show_records_should_have_following_options(List<String> expectedOptions) {
        System.out.println("expectedOptions = " + expectedOptions);
        select = new Select(usersPage.showRecordsDropDown);
        List<WebElement> webElements = select.getOptions();
        List<String> actualTexts = BrowserUtils.getElementsText(webElements);
        System.out.println("actualTexts = " + actualTexts);
        Assert.assertEquals(expectedOptions,actualTexts);
    }

}
