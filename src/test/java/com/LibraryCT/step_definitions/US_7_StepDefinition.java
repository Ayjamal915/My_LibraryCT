package com.LibraryCT.step_definitions;

import com.LibraryCT.pages.BooksPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class US_7_StepDefinition {
    BooksPage booksPage = new BooksPage();

    @Then("user can search books with different categories")
    public void user_can_search_books_with_different_categories(List<String> expectedBooksCategoryText) {
        Select categoryDropdown = new Select(booksPage.dropDownBookCategories);
        List<WebElement> categoryAsWebElement = categoryDropdown.getOptions();
        // List<String> categoryAsString = BrowserUtils.getElementsText(categoryAsWebElement);
        List<String> categoryAsString =new ArrayList<>();

        for (int i = 0; i < categoryAsWebElement.size(); i++) {
            categoryAsString.add(categoryAsWebElement.get(i).getText());
            categoryAsWebElement.get(i).click();
        }
        Assert.assertEquals(categoryAsString,expectedBooksCategoryText);
        System.out.println(categoryAsString);
        System.out.println(expectedBooksCategoryText);
    }

}
