package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Guru99_Bank_Customised_Statement_Page {

	WebDriver driver;

	public Guru99_Bank_Customised_Statement_Page(WebDriver driver) {
		this.driver = driver;

	}

	By success = By.xpath("html/body/table/tbody/tr[1]/td/p");
	By success1 = By.xpath("html/body/table/tbody/tr[1]/td/p");

	public WebElement success() {
		return driver.findElement(success);
	}

	public WebElement success1() {
		return driver.findElement(success1);
	}

}
