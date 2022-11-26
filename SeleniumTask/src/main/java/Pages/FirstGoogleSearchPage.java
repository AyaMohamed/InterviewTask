package Pages;

import org.openqa.selenium.*;

import java.util.ArrayList;

public class FirstGoogleSearchPage {

    private WebDriver webDriver;
    private By searchTextElement = By.xpath("//input[@class='gLFyf gsfi']"); //search text box
    private By searchResultsElement = By.id("result-stats"); //search results
    private By entireSearchPageElement = By.id("rcnt"); //the div in which all search results are displayed
    private By secondPageLink = By.xpath("//a[@aria-label='Page 2']"); // "next" button
    //private By searchResultsMainDiv=By.xpath("//div[@class='EIaa9b']");
    private By leftSideSuggestedResults=By.xpath("(//div[@class='AJLUJb'])[1]");
    private By rightSideSuggestedResults=By.xpath("(//div[@class='AJLUJb'])[2]");



    public FirstGoogleSearchPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clearFirstSearchText() {
        webDriver.findElement(searchTextElement).clear();
    }

    public void setSecondSearchText(String searchText) {
        webDriver.findElement(searchTextElement).sendKeys(searchText);
        webDriver.findElement(searchTextElement).sendKeys(Keys.ENTER);
    }

    public Boolean checkIfSearchResultsExists() {
        return webDriver.findElement(searchResultsElement).isDisplayed();
    }

    public void scrollDown() {
        WebElement searchPage = webDriver.findElement(entireSearchPageElement);
        String script = "window.scrollBy(0,document.body.scrollHeight)";
        ((JavascriptExecutor) webDriver).executeScript(script, searchPage);

    }

    public String getSearchResultsTextFromFirstPage()
    {
        //System.out.println(webDriver.findElement(searchResultsElement).getText());
        return webDriver.findElement(searchResultsElement).getText();
    }

    public SecondGoogleSearchPage goToSecondPage() {
        scrollDown();
        webDriver.findElement(secondPageLink).click();
        return new SecondGoogleSearchPage(webDriver);
    }


    public ArrayList<String> getFirstPageSuggestedSearchResults() {
        //1. locate left and right devs children under the main dev element
        //2. get search results from each side, separated by new line
        //3. save all suggested search results into an arraylist
        //4. return this arraylist
        WebElement leftSideDiv = webDriver.findElement(leftSideSuggestedResults);
        String leftSideDivString=leftSideDiv.getText();//text is retrieved separated by \n
        String [] leftSideArray=leftSideDivString.split("\n");
        ArrayList<String> suggestedSearchResults=new ArrayList<>();
        for(int i=0;i<leftSideArray.length;i++)
        {
            suggestedSearchResults.add(leftSideArray[i]);
        }

        WebElement rightSideDiv = webDriver.findElement(rightSideSuggestedResults);
        String rightSideDivString=rightSideDiv.getText();//text is retrieved separated by \n
        String [] rightSideArray=rightSideDivString.split("\n");
        for(int i=0;i<rightSideArray.length;i++)
        {
            suggestedSearchResults.add(rightSideArray[i]);
        }
        return suggestedSearchResults;

    }

}
