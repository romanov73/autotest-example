import context.ChromeContext;
import context.Context;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;
import page.SearchPage;


public class GithubUserSearchTest {
    private final static String APP_URL = "https://github.com";

    private static Context context;

    @BeforeAll
    public static void setup() {
        context = new ChromeContext();
        context.start();
        context.getDriver().manage().window().setSize(new Dimension(1600, 900));
    }

    @AfterAll
    public static void quit() {
        context.close();
    }

    @Test
    public void testResultPageHeader() {
        context.getDriver().get(APP_URL);
        String searchString = "romanov73";

        SearchPage page = PageFactory.initElements(context.getDriver(), SearchPage.class);
        page.setSearchString(searchString);
        page.clickSubmitButton();
        page.clickUsersLink();
        Assertions.assertTrue(page.isUserPresent(searchString));
    }
}
