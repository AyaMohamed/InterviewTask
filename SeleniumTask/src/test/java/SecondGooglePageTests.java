import Pages.FirstGoogleSearchPage;
import Pages.GoogleHomePage;
import Pages.SecondGoogleSearchPage;
import org.junit.jupiter.api.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SecondGooglePageTests extends FirstGooglePageTests {
    private static SecondGoogleSearchPage secondPage;

    @Order(1)
    @Test
    @DisplayName("Validate that the number of results on page 2 not equal to page 3")
    public void validateThatNumberOfSearchResultsNotEqual()
    {
        //firstGoogleSearchPage.scrollDown();
        secondPage=firstGoogleSearchPage.goToSecondPage();
        String firstPageSearchResult=firstGoogleSearchPage.getSearchResultsTextFromFirstPage();
        String secondPageSearchResult=secondPage.getSearchResultsTextFromSecondPage();
        boolean result=true;
        if(firstPageSearchResult!=secondPageSearchResult)
        {
            result=false;
        }
        Assertions.assertFalse(result);
    }

    @Order(2)
    @Test
    @DisplayName("Validate there are different search suggestions displayed at the end of the page")
    public void validateSuggestedSearchResults()
    {
        ArrayList<String> firstPageSuggestedSearch=firstGoogleSearchPage.getFirstPageSuggestedSearchResults();
        ArrayList<String> searchPageSuggestedSearchResults=secondPage.getSuggestedSearchResults();

    }



}
