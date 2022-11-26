package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleHomePage {

    private WebDriver webDriver;
    private By searchBoxElement = By.xpath("//input[@title='Search']");
    private By searchButton = By.xpath("(//input[@class='gNO89b'])[2]");

    public GoogleHomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void setSearchText(String searchText) {
        webDriver.findElement(searchBoxElement).sendKeys(searchText);
    }

    public FirstGoogleSearchPage clickSearchButton()
    {
        webDriver.findElement(searchButton).click();
        return new FirstGoogleSearchPage(webDriver);
    }




}
