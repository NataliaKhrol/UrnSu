package tests;

import org.testng.annotations.Test;

public class ClickTest extends BaseTest{
    @Test
    public void tryClick() {
        classAttributePage.openPage("/click");
        clickPage.tryClick();

    }
}
