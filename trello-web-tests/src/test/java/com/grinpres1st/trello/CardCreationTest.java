package com.grinpres1st.trello;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CardCreationTest extends TestBase {
    @Test
    public void cardCreationTest(){
        clickOnBoard(By.xpath("//a[@href='/b/xJwJL0Iw/english']//div[@class='board-tile-details is-badged']"));

        addNewCard();
        typeCardName("New card");
        submitNewCard();
    }
}
