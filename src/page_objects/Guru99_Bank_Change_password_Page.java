package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Guru99_Bank_Change_password_Page {

	WebDriver driver;

	public Guru99_Bank_Change_password_Page(WebDriver driver) {
		this.driver = driver;

	}

	By Old_Password = By.xpath("//input[@name='oldpassword']");
	By New_Password = By.xpath("//input[@name='newpassword']");
	By Confirm_Password = By.xpath("//input[@name='confirmpassword']");
	By Submit = By.xpath("//input[@value='Submit']");

	public WebElement Old_Password() {
		return driver.findElement(Old_Password);
	}

	public WebElement New_Password() {
		return driver.findElement(New_Password);
	}

	public WebElement Confirm_Password() {
		return driver.findElement(Confirm_Password);
	}

	public WebElement Submit() {
		return driver.findElement(Submit);
	}
}
