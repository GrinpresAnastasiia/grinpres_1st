package com.grinpres1st.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class TestBase {

    WebDriver driver;
//beforeSuite позволяет открыть брайзер 1 раз в самом начале тестов
    @BeforeClass
    public void setUp() {
       /* String browser = null;
        if (browser.equals(BrowserType.CHROME)){
            driver = new ChromeDriver();
        }else if (browser.equals(BrowserType.FIREFOX)){
            driver= new FirefoxDriver();
        }else if (browser.equals(BrowserType.EDGE)){
            driver = new EdgeDriver();
        }*/
        driver = new ChromeDriver();
        driver.get("https://trello.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        clickLogInButton(By.xpath("//a[@href='/login']"));
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

    public void clickOnSubmitButton() {
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    public void typeListName(String nameOfList) {
        driver.findElement(By.xpath("//input[@class='list-name-input']")).sendKeys(nameOfList);
    }

    public void createNewList() {
        driver.findElement(By.xpath("//div[@class='js-add-list list-wrapper mod-add is-idle']")).click();
    }

    public void clickOnBoard(By boardLocator) {
        driver.findElement(boardLocator).click();
    }

    public void submitNewCard() {
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    public void typeCardName(String cardName) {
        driver.findElement(By.xpath("//textarea[@class='list-card-composer-textarea js-card-title']")).sendKeys(cardName);
    }

    public void addNewCard() {
        driver.findElement(By.xpath("//span[@class='js-add-a-card']")).click();
    }
}
