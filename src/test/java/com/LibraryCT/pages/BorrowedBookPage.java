package com.LibraryCT.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BorrowedBookPage extends BasePage{

    @FindBy(xpath = "//tbody//td[2]")
    public List<WebElement> allBorrowedBooksName;
}
