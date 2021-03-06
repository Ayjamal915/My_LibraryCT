package com.LibraryCT.step_definitions;

import com.LibraryCT.pages.DashboardPage;
import com.LibraryCT.pages.LoginPage;
import com.LibraryCT.pages.UsersPage;
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

public class US_9_10_StepDefinition {
    UsersPage usersPage = new UsersPage();
    DashboardPage dashboardPage = new DashboardPage();
    LoginPage loginPage = new LoginPage();
    Select select;

    @Given("the user {string} on the homepage")
    public void the_user_on_the_homepage(String string) {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.loginAs(string);
    }

    @When("the user click users module")
    public void the_user_click_users_module() {
        dashboardPage.usersTab.click();
    }

    @When("the user click Status dropdown")
    public void the_user_click_status_dropdown() {
        usersPage.statusDropDown.click();
    }
    @Then("the user should see the following options")
    public void the_user_should_see_the_following_options(List<String> options)  {
        Select select = new Select(usersPage.statusDropDown);
        List<WebElement> actualOptions = select.getOptions();
        List<String> optionText= BrowserUtils.getElementsText(actualOptions);
        System.out.println("\"%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("optionText = " + optionText);
        System.out.println("options = " + options);
        Assert.assertEquals(options,optionText);
    }
    @When("the user click User Group dropdown")
    public void the_user_click_user_group_dropdown() {
        usersPage.userGroupDropDown.click();
    }

    @Then("the user should see the following user group options:")
    public void the_user_should_see_the_following_user_group_options(List<String> userGroupOptions) {
        Select select = new Select(usersPage.userGroupDropDown);
        List<WebElement> actualOptions = select.getOptions();
        List<String> userGroupOptionText= BrowserUtils.getElementsText(actualOptions);
        System.out.println("#######################");
        System.out.println("userGroupOptionText = " + userGroupOptionText);
        System.out.println("userGroupOptions = " + userGroupOptions);

        Assert.assertEquals(userGroupOptions,userGroupOptionText);
    }

    @Then("the user should see the following column names")
    public void the_user_should_see_the_following_column_names(List<String> expectedTableHeaders)  {
        List<String> actualHeaders=BrowserUtils.getElementsText(usersPage.tableHeaders);
        Assert.assertEquals(expectedTableHeaders,actualHeaders);
        System.out.println("expectedTableHeaders = " + expectedTableHeaders);
        System.out.println("\"============================\" = " + "============================");
        System.out.println("actualHeaders = " + actualHeaders);
    }

}
