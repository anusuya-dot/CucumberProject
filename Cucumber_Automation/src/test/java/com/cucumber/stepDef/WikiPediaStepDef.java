package com.cucumber.stepDef;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import com.cucumber.Base;
import com.page.*;

public class WikiPediaStepDef {


	public static WebDriver driver;
	WikipediaMainPage WikiMainPage= new WikipediaMainPage();
	String wikiTitle="Wikipedia, the free encyclopedia";
	@Given("^User opens wikipedia website$")
	public void user_opens_wikipedia_website() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Base.initializeBrowser();
		
		WikiMainPage.verifyTitle(wikiTitle);
	}



	@When("^User enters search phrase as \"([^\"]*)\"$")
	public void user_enters_Search_phrase_as(String SearchItem) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		WikiMainPage.enterSearchItem(SearchItem);

	}

	

	@Then("^Page title should contain \\\"([^\\\"]*)\\\"$")
	public void page_title_should_contain(String title) throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		WikiMainPage.verifyTitle(title);

	}
	@Then("^Result is shown for \"([^\"]*)\"$")
	public void result_is_shown_for(String item) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String SearchText =WikiMainPage.verifyInvalidSearchEntity();
		Assert.assertTrue(SearchText.toLowerCase().contains(item.toLowerCase() + " may refer to:"));
		
	}

	

	@Then("^I verify \"([^\"]*)\" search entity in the searched page$")
	public void i_verify_search_entity_in_the_searched_page(String item) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String SearchText =WikiMainPage.verifySearchEntity();
		Assert.assertEquals(SearchText, item);
	}

	@Then("^Application is closed$")
	public void close_Browser() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		WikiMainPage.closebrowser();
	}


}




