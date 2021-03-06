package com.LibraryCT.pages;

import com.LibraryCT.utilities.Driver;

import org.junit.experimental.categories.Categories;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BooksPage extends BasePage{

    @FindBy(xpath = "(//a[@class='nav-link'])[1]")
    public WebElement booksTab;

    @FindBy(xpath = "//a[@class='navbar-brand']")
    public WebElement libraryTab;

    @FindBy(xpath = "//img[@id='user_avatar']")
    public WebElement userAvatar;

    @FindBy(css="a.dropdown-item")
    public WebElement logoutButton;

    @FindBy(id="book_categories")
    public WebElement dropDownBookCategories;

    @FindBy(xpath="//*[@id='tbl_books']/tbody/tr[1]/td[5]")
    public WebElement categoryColumnFirstElement;

}

