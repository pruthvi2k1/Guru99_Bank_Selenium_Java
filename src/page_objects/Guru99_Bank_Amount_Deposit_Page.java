package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Guru99_Bank_Amount_Deposit_Page {

	WebDriver driver;

	public Guru99_Bank_Amount_Deposit_Page(WebDriver driver) {
		this.driver = driver;

	}

	By Account_No = By.xpath("//input[@name='accountno']");
	By Amount = By.xpath("//input[@name='ammount']");
	By Description = By.xpath("//input[@name='desc']");
	By Submit = By.xpath("//input[@name='AccSubmit']");
	By success = By.xpath("//*[@id='deposit']/tbody/tr[1]/td/p");

	public WebElement Account_No() {
		return driver.findElement(Account_No);
	}

	public WebElement Amount() {
		return driver.findElement(Amount);
	}

	public WebElement Description() {
		return driver.findElement(Description);
	}

	public WebElement Submit() {
		return driver.findElement(Submit);
	}

	public WebElement success() {
		return driver.findElement(success);
	}
}
