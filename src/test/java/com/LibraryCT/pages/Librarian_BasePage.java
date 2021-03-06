package com.LibraryCT.pages;

import com.LibraryCT.utilities.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Librarian_BasePage extends BasePage{

    @FindBy(xpath ="//*[@id='menu_item']/li")
    public List<WebElement> librarianAccess;

    @FindBy(xpath = "//*[@id='menu_item']/li[1]/a/span[1]")
    public WebElement dashboardLink;

    @FindBy(xpath = "//a[@href='#users']")
    public WebElement usersLink;

    @FindBy(xpath = "//a[contains(@href,'books')]")
    public WebElement booksLink;

    @FindBy(id = "navbarDropdown")
    public WebElement navBarDropdown;

    @FindBy(css="a.dropdown-item")
    public WebElement logoutButton;
}
