package steps;

import pagefactory.GooglePage;
import pagefactory.YandexPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import runner.TestRunner;

import static org.testng.Assert.assertTrue;

public class Steps extends TestRunner {

    private GooglePage googlePage = new GooglePage(driver);
    private YandexPage yandexPage = new YandexPage(driver);

    @Given("^User is on main google page$")
    public void user_is_on_main_google_page() {
        googlePage.open();
    }

    @Given("^User is on main yandex page$")
    public void user_is_on_main_yandex_page() {
        yandexPage.open();
    }

    @When("^User inputs (.*) and clicks 'Google Search' button$")
    public void user_inputs_search_query_and_clicks_Google_Search_button(String query) {
        googlePage.search(query);
    }

    @When("^User inputs (.*) and clicks 'Find' button$")
    public void user_inputs_search_query_and_clicks_find_button(String query) {
        yandexPage.search(query);
    }

    @Then("^User is redirected on google page with search results$")
    public void user_is_redirected_on_google_page_with_search_results() {
        assertTrue(googlePage.isOnResultPage());
    }

    @Then("^User is redirected on yandex page with search results$")
    public void user_is_redirected_on_yandex_page_with_search_results() throws Exception {
        assertTrue(yandexPage.isOnResultPage());
    }
}
