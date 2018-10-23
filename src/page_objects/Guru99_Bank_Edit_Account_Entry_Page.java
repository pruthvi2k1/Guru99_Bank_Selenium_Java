package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Guru99_Bank_Edit_Account_Entry_Page {

	WebDriver driver;

	public Guru99_Bank_Edit_Account_Entry_Page(WebDriver driver) {
		this.driver = driver;

	}

	By Type_of_Account = By.xpath("//select[@name='a_type']");
	By Submit = By.xpath("//input[@name='AccSubmit']");

	public WebElement Type_of_Account() {
		return driver.findElement(Type_of_Account);
	}

	public WebElement Submit() {
		return driver.findElement(Submit);
	}

}
