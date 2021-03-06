package com.LibraryCT.pages;


import com.LibraryCT.utilities.ConfigurationReader;
import com.LibraryCT.utilities.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    @FindBy(id = "inputEmail")
    //*[@id="inputEmail"]
    public WebElement emailInput;

    @FindBy(id = "inputPassword")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInButton;


    public void login(String username, String password) {
        emailInput.sendKeys(username);
        passwordInput.sendKeys(password);
        signInButton.click();
    }

    public void loginAs(String role) {
        String username;
        String password;
        if (role.equals("student")) {
            username = ConfigurationReader.getProperty("student_username");
            password = ConfigurationReader.getProperty("student_password");
            login(username,password);
        } else if (role.equals("librarian")) {
            username = ConfigurationReader.getProperty("lib_username");
            password = ConfigurationReader.getProperty("lib_password");
            login(username,password);
        } else {
            throw new RuntimeException("Invalid user type!!!");
        }
    }

}
