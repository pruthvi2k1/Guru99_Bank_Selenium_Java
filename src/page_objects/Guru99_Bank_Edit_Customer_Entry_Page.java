package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Guru99_Bank_Edit_Customer_Entry_Page {

	WebDriver driver;

	public Guru99_Bank_Edit_Customer_Entry_Page(WebDriver driver) {
		this.driver = driver;
	}

	By Address = By.xpath("//textarea[@name='addr']");
	By Submit = By.xpath("//input[@value='Submit']");

	public WebElement Address() {
		return driver.findElement(Address);
	}

	public WebElement Submit() {
		return driver.findElement(Submit);
	}

}
