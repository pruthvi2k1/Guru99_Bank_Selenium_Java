package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Guru99_Bank_Fund_Transfer_Entry_Page {

	WebDriver driver;

	public Guru99_Bank_Fund_Transfer_Entry_Page(WebDriver driver) {
		this.driver = driver;
	}

	By Payers_account_no = By.xpath("//input[@name='payersaccount']");
	By Payees_account_no = By.xpath("//input[@name='payeeaccount']");
	By Amount = By.xpath("//input[@name='ammount']");
	By Description = By.xpath("//input[@name='desc']");
	By Submit = By.xpath("//input[@name='AccSubmit']");

	public WebElement Payers_account_no() {
		return driver.findElement(Payers_account_no);
	}

	public WebElement Payees_account_no() {
		return driver.findElement(Payees_account_no);
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

}
