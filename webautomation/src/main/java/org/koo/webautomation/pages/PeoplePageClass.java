package org.koo.webautomation.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PeoplePageClass {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//div[@id='all_verified']//following-sibling::*//descendant::a")
	List<WebElement> profileList;

	@FindBy(xpath = "//span[normalize-space()='People you can follow']")
	WebElement categoryName;

	@FindBy(xpath = "//img[@alt='share']")
	WebElement shareSymbol;

	// Initializing the Page Objects:
	@SuppressWarnings("deprecation")
	public PeoplePageClass(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this);
	}

	public void navigateToUrl(String url) {
		driver.get(url);
	}

	public void getProfileUrl() {

		for (int x = 1; x < profileList.size(); x++) {
			try {
				// wait for page load
				wait.until(ExpectedConditions.visibilityOf(categoryName));

				// iterate web elements
				WebElement profile = profileList.get(x);

				// get profile name
				String[] dataList = (profile.getText().split("\n"));

				// click profile
				profile.click();

				// wait for profile page open
				wait.until(ExpectedConditions.visibilityOf(shareSymbol));

				// print profile url
				System.out.println(dataList[0] + "==>" + driver.getCurrentUrl());

				// navigate back
				driver.navigate().back();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

}
