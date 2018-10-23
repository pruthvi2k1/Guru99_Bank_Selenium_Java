package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Guru99_Bank_Delete_Customer_Page {

	WebDriver driver;

	public Guru99_Bank_Delete_Customer_Page(WebDriver driver) {
		this.driver = driver;
	}

	By Customer_ID = By.xpath("//input[@name='cusid']");
	By Submit = By.xpath("//input[@name='AccSubmit']");
	By Reset = By.xpath("//input[@value='Reset']");

	public WebElement Customer_ID() {
		return driver.findElement(Customer_ID);
	}

	public WebElement Submit() {
		return driver.findElement(Submit);
	}

	public WebElement Reset() {
		return driver.findElement(Reset);
	}

}
