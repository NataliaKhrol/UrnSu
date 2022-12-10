package tests;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class ClientDelayTest extends BaseTest{
    @Test
    public void trigger() {
        classAttributePage.newPage();
        clientDelayPage.triggerText();
        assertEquals(clientDelayPage.textMessage(), "Data calculated on the client side.");
    }
}
