package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Guru99_Bank_Statement_Page {

	WebDriver driver;

	public Guru99_Bank_Statement_Page(WebDriver driver) {
		this.driver = driver;

	}

	By Account_No = By.xpath("//input[@name='accountno']");
	By From_Date = By.xpath("//input[@name='fdate']");
	By To_Date = By.xpath("//input[@name='tdate']");
	By Minimum_Transaction_Value = By.xpath("//input[@name='amountlowerlimit']");
	By Number_of_Transaction = By.xpath("//input[@name='numtransaction']");
	By Submit = By.xpath("//input[@name='AccSubmit']");

	public WebElement Account_No() {
		return driver.findElement(Account_No);
	}

	public WebElement From_Date() {
		return driver.findElement(From_Date);
	}

	public WebElement To_Date() {
		return driver.findElement(To_Date);
	}

	public WebElement Minimum_Transaction_Value() {
		return driver.findElement(Minimum_Transaction_Value);
	}

	public WebElement Number_of_Transaction() {
		return driver.findElement(Number_of_Transaction);
	}

	public WebElement Submit() {
		return driver.findElement(Submit);
	}

}
