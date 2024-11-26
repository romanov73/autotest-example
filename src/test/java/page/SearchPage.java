package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage {
    WebDriver driver;

    @FindBy(css = "input.header-search-input")
    private WebElement inputField;

    @FindBy(xpath = "//a[contains(@href, 'users')]")
    private WebElement usersLink;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public SearchPage setSearchString(String text) {
        inputField.sendKeys(text);
        return this;
    }

    public void clickSubmitButton() {
        inputField.sendKeys(Keys.RETURN);
    }

    public void clickUsersLink() {
        usersLink.click();
    }

    public boolean isUserPresent(String userName) {
        return driver.findElement(By.xpath("//*[@id=\"user_search_results\"]//a/em"))
                .getText()
                .contains(userName);
    }
}
