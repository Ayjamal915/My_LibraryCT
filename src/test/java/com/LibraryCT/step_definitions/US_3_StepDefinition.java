package com.LibraryCT.step_definitions;

import com.LibraryCT.pages.DashboardPage;
import com.LibraryCT.pages.Librarian_BasePage;
import com.LibraryCT.pages.LoginPage;
import com.LibraryCT.pages.Student_BasePage;
import com.LibraryCT.utilities.BrowserUtils;
import com.LibraryCT.utilities.ConfigurationReader;
import com.LibraryCT.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class US_3_StepDefinition {
    LoginPage loginPage = new LoginPage();
    Student_BasePage studentBasePage = new Student_BasePage();
    Librarian_BasePage librarian_basePage = new Librarian_BasePage();
    DashboardPage dashboardPage = new DashboardPage();
    Select select;

    @Given("the student on the home page")
    public void the_student_on_the_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.loginAs("student");
    }

    @Then("the student should see following modules")
    public void the_student_should_see_following_modules(List Sexpected) {
        List<String> sElems = BrowserUtils.getElementsText(studentBasePage.studentAccess);
        System.out.println("sElems = " + sElems);
        System.out.println("Sexpected = " + Sexpected);
        Assert.assertEquals(sElems,Sexpected);

    }


    @Given("the librarian on the homepage")
    public void the_librarian_on_the_homepage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.loginAs("librarian");
    }

    @Then("the librarian should see following modules")
    public void the_librarian_should_see_following_modules(List Lexpected) {
        System.out.println("Lexpected = " + Lexpected);
        List<String> lElems =BrowserUtils.getElementsText(librarian_basePage.librarianAccess);
        Assert.assertEquals(lElems,Lexpected);
        System.out.println("lElems = " + lElems);


    }


}
