package com.LibraryCT.step_definitions;

import com.LibraryCT.pages.BooksPage;
import com.LibraryCT.pages.LoginPage;
import com.LibraryCT.utilities.BrowserUtils;
import com.LibraryCT.utilities.ConfigurationReader;
import com.LibraryCT.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class Login_1_StepDefinition {
    BooksPage booksPage=new BooksPage();

    @Given("the user login as a {string}")
    public void the_user_login_as_a(String role) {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        LoginPage loginPage = new LoginPage();
        loginPage.loginAs(role);
    }

    @Then("the user is on {string} page")
    public void the_user_is_on_page(String expectedPage) {
        BrowserUtils.waitUntilURLContains(expectedPage);
        String actualURL = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualURL.contains(expectedPage));
    }
    @Then("the user logout")
    public void the_user_logout() {
        booksPage.userAvatar.click();
        BrowserUtils.sleep(3);
        booksPage.logoutButton.click();
        BrowserUtils.sleep(2);

    }
}
