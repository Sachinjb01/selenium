package comm.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organization {
	
	
	public Organization(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createorgImg;
	
	@FindBy(name="search_text")
	private WebElement searchtext;
	
	@FindBy(name="search")
	private WebElement search;

	public WebElement getCreateorgImg() {
		return createorgImg;
	}

	public WebElement getSearchtext() {
		return searchtext;
	}


	public WebElement getSearch() {
		return search;
	}
	
	

}
