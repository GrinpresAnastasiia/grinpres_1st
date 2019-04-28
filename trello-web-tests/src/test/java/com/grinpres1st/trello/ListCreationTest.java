package com.grinpres1st.trello;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ListCreationTest extends TestBase {
    @Test
    public void addNewListOnBoard(){
        clickOnBoard(By.xpath("//a[@href='/b/xJwJL0Iw/english']//div[@class='board-tile-details is-badged']"));
        createNewList();
        typeListName("Lesson2");
        clickOnSubmitButton();
    }


}
