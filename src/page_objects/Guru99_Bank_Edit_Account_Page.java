package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Guru99_Bank_Edit_Account_Page {
	WebDriver driver;

	public Guru99_Bank_Edit_Account_Page(WebDriver driver) {
		this.driver = driver;

	}

	By Account_No = By.xpath("//input[@name='accountno']");
	By Submit = By.xpath("//input[@name='AccSubmit']");

	public WebElement Account_No() {
		return driver.findElement(Account_No);
	}

	public WebElement Submit() {
		return driver.findElement(Submit);
	}

}
