package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Guru99_Bank_Customer_Registration_Page {

	WebDriver driver;

	public Guru99_Bank_Customer_Registration_Page(WebDriver driver) {
		this.driver = driver;
	}

	By success1 = By.xpath("//*[@id='customer']/tbody/tr[1]/td/p");
	By success2 = By.xpath("//*[@id='customer']/tbody/tr[1]/td/p");
	By success3 = By.xpath("//*[@id='account']/tbody/tr[1]/td/p");
	By success4 = By.xpath("//*[@id='account']/tbody/tr[1]/td/p");
	// Customer details updated Successfully!!!

	public WebElement successmessage1() {
		return driver.findElement(success1);
	}

	public WebElement successmessage2() {
		return driver.findElement(success2);
	}

	public WebElement successmessage3() {
		return driver.findElement(success3);
	}

	public WebElement success4() {
		return driver.findElement(success4);
	}

}
