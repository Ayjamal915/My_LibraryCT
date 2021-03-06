package com.LibraryCT.pages;

import com.LibraryCT.utilities.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Student_BasePage extends BasePage {

    @FindBy(xpath ="//span[@class='title']")
    public List<WebElement> studentAccess;

    @FindBy(xpath = "//a[contains(@href,'#books')]")
    public WebElement booksLink;

    @FindBy(xpath = "//a[contains(@href,'borrowing-books')]")
    public WebElement borrowingBooksLink;

    @FindBy(id = "navbarDropdown")
    public WebElement navBarDropdown;

    @FindBy(css = "a.dropdown-item")
    public WebElement logoutButton;
}
