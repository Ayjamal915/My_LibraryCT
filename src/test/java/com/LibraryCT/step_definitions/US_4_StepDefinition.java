package com.LibraryCT.step_definitions;

import com.LibraryCT.pages.DashboardPage;
import com.LibraryCT.pages.UsersPage;
import com.LibraryCT.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class US_4_StepDefinition {
    DashboardPage dashboardPage = new DashboardPage();
    UsersPage usersPage = new UsersPage();

    Select select;
    Actions actions = new Actions(Driver.getDriver());

    @When("I click on {string} tab.")
    public void i_click_on_tab(String string) {
        dashboardPage.usersTab.click();
    }

    @Then("I should be able add users with valid information.")
    public void i_should_be_able_add_users_with_valid_information() {
        usersPage.userAdd.click();
        usersPage.addUser();
        usersPage.addUserSave.click();
    }

    @Then("I able to close the add user window by clicking on close button.")
    public void i_able_to_close_the_add_user_window_by_clicking_on_close_button() {
        usersPage.userAdd.click();
        usersPage.addUserClose.click();
    }


}
