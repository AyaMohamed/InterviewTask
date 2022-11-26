import Pages.FirstGoogleSearchPage;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FirstGooglePageTests extends BaseTests {

    public static FirstGoogleSearchPage firstGoogleSearchPage;

    @Test
    @Order(1)
    //@DisplayName("Check if number of search results exist on UI")
    public void validateNumberOfSearchResultsExist() {

        firstGoogleSearchPage=homePage.clickSearchButton();
        searchForFirstKeyword("test automation");
        firstGoogleSearchPage.clearFirstSearchText();
        firstGoogleSearchPage.setSecondSearchText("automation testing");
        Assertions.assertTrue(firstGoogleSearchPage.checkIfSearchResultsExists());
    }


}
