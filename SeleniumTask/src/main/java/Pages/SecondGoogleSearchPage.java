package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SecondGoogleSearchPage {


    WebDriver webDriver;
    private By searchResultsElement = By.id("result-stats");
    private By leftSideSuggestedResults = By.xpath("(//div[@class='AJLUJb'])[1]");
    private By rightSideSuggestedResults = By.xpath("(//div[@class='AJLUJb'])[2]");


    public SecondGoogleSearchPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getSearchResultsTextFromSecondPage() {
        //System.out.println(webDriver.findElement(searchResultsElement).getText());
        return webDriver.findElement(searchResultsElement).getText();

    }

    public ArrayList<String> getSuggestedSearchResults() {
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
