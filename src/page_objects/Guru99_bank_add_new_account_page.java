package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Guru99_bank_add_new_account_page {
	WebDriver driver;

	public Guru99_bank_add_new_account_page(WebDriver driver) {
		this.driver = driver;
	}

	By Customer_id = By.xpath("//input[@name='cusid']");
	By Account_type = By.xpath("//select[@name='selaccount']");
	By Initial_deposit = By.xpath("//input[@name='inideposit']");
	By submit = By.xpath("//input[@value='submit']");

	public WebElement Customer_id() {
		return driver.findElement(Customer_id);
	}

	public WebElement Account_type() {
		return driver.findElement(Account_type);
	}

	public WebElement Initial_deposit() {
		return driver.findElement(Initial_deposit);
	}

	public WebElement submit() {
		return driver.findElement(submit);
	}

}
