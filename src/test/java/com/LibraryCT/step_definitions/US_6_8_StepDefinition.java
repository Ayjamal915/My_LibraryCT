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
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class US_6_8_StepDefinition {
    UsersPage usersPage = new UsersPage();
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    Select select;

    @Given("user login as a {string}")
    public void user_login_as_a(String string) {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.loginAs(string);
    }

    @Then("the user should see the following book column names")
    public void the_user_should_see_the_following_book_column_names(List<String> expectedBooksTableHeaders) {
        List<String> actualBooksHeaders = BrowserUtils.getElementsText(usersPage.bookTableHeaders);
        Assert.assertEquals(expectedBooksTableHeaders, actualBooksHeaders);
        System.out.println("expectedBooksTableHeaders = " + expectedBooksTableHeaders);
        System.out.println("actualBooksHeaders = " + actualBooksHeaders);
        Assert.assertEquals(expectedBooksTableHeaders, actualBooksHeaders);
    }

    @When("the user click Borrowing Books module")
    public void the_user_click_borrowing_books_module() {
        dashboardPage.borrowingBooksLink.click();
    }

    @Then("the user should see the following borrowed books column names")
    public void the_user_should_see_the_following_borrowed_books_column_names(List<String> expectedBorrowedBooksTitle) {
        List<String> actualBorrowedBooksTitle = BrowserUtils.getElementsText(usersPage.borrowedBooksTableHeaders);
        Assert.assertEquals(expectedBorrowedBooksTitle,actualBorrowedBooksTitle);
        System.out.println("expectedBorrowedBooksTitle = " + expectedBorrowedBooksTitle);
        System.out.println("actualBorrowedBooksTitle = " + actualBorrowedBooksTitle);

    }


}
