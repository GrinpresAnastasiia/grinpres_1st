package com.grinpres1st.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://trello.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        clickLogInButton(By.xpath("//a[@href=\"/login\"]"));
        login("agrinpres@gmail.com", "Bently2502");

    }

    public void login(String userName, String password) {
        type(By.id("user"), userName);
        type(By.id("password"), password);
        click(By.id("login"));
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By user, String text) {
        click(user);
        driver.findElement(user).clear();
        driver.findElement(user).sendKeys(text);
    }

    public void clickLogInButton(By locator) {
        click(locator);
    }

    public void submitBoardCreation() {
        click(By.xpath("//button[@type='submit']"));
    }

    public void typeBoardName(String boardName) {
        driver.findElement(By.className("subtle-input")).sendKeys(boardName);
    }

    public void initBoardCreationFromDesk() {
        clickOnNewDesk();
        click(By.className("subtle-input"));
    }

    public void clickOnNewDesk() {
        click(By.xpath("//div[@class='board-tile mod-add']"));
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
