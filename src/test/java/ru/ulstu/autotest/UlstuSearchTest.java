package ru.ulstu.autotest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import ru.ulstu.autotest.context.Context;
import ru.ulstu.autotest.context.FirefoxContext;
import ru.ulstu.autotest.page.SearchPage;


public class UlstuSearchTest {
    private final static String APP_URL = "https://ulstu.ru/";

    private static Context context;

    @BeforeAll
    public static void setup() {
        context = new FirefoxContext();
        context.start();
    }

    @AfterAll
    public static void quit() {
        context.close();
    }

    @Test
    public void testResultPageHeader() {
        context.getDriver().get(APP_URL);
        String searchString = "Факультет информационных систем и технологий";

        SearchPage page = PageFactory.initElements(context.getDriver(), SearchPage.class);
        page.sendSearchString(searchString);
        page.clickSearch();
        Assertions.assertTrue(page.isResultPresent(searchString));
    }
}
