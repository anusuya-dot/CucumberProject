package com.page;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.testng.Assert;

import com.cucumber.Base;



public class WikipediaMainPage extends Base {
		
	/** 
	 * Description : Enter search Items
	 */
	
	
	public void enterSearchItem(String SearchItem)

	{
		WebElement searchInput= driver.findElement(By.xpath("//input[@id='searchInput']"));
		// Enter something to search for
		searchInput.sendKeys(SearchItem);
		// Now submit the form. WebDriver will find the form for us from the element
		searchInput.submit();

	}

	/** 
	 * Description : Verify Page title
	 */
	

	public void verifyTitle(String title)
	{
		
		Assert.assertTrue(driver.getTitle().contains(title));

	}

	/** 
	 * Description : Verify search entity
	 */
	
	public String verifySearchEntity()
	{
		WebElement SearchHeading=driver.findElement(By.xpath("//h1[@id='firstHeading']"));
		return SearchHeading.getText();

	}
	
	/** 
	 * Description : Verify Invalid search entity
	 */
	
	public String verifyInvalidSearchEntity()
	{
		WebElement SearchResult=driver.findElement(By.cssSelector("div#mw-content-text.mw-content-ltr p"));
		return SearchResult.getText();

	}



	/** 
	 * Description : To close the browser
	 */
	public void closebrowser()
	{
		driver.quit();
	}

}
