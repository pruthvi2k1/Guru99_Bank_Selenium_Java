package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Guru99_Bank_Manager_HomePage {

	WebDriver driver;

	public Guru99_Bank_Manager_HomePage(WebDriver driver) {
		this.driver = driver;

	}

	By log_out_text = By.linkText("Log out");
	By New_Customer = By.linkText("New Customer");
	By Edit_Customer = By.linkText("Edit Customer");
	By Delete_Customer = By.linkText("Delete Customer");
	By New_Account = By.linkText("New Account");
	By Edit_Account = By.linkText("Edit Account");
	By Delete_Account = By.linkText("Delete Account");
	By Deposit = By.linkText("Deposit");
	By Withdrawal = By.linkText("Withdrawal");
	By Fund_Transfer = By.linkText("Fund Transfer");
	By Balance_Inquiry = By.linkText("Balance Enquiry");
	By Mini_Statement = By.linkText("Mini Statement");
	By Change_Password = By.linkText("Change Password");
	By Customised_Statement = By.linkText("Customised Statement");

	public WebElement log_out_text() {
		return driver.findElement(log_out_text);
	}

	public WebElement New_Customer() {
		return driver.findElement(New_Customer);
	}

	public WebElement Edit_Customer() {
		return driver.findElement(Edit_Customer);
	}

	public WebElement Delete_Customer() {
		return driver.findElement(Delete_Customer);
	}

	public WebElement New_Account() {
		return driver.findElement(New_Account);
	}

	public WebElement Edit_Account() {
		return driver.findElement(Edit_Account);
	}

	public WebElement Delete_Account() {
		return driver.findElement(Delete_Account);
	}

	public WebElement Deposit() {
		return driver.findElement(Deposit);
	}

	public WebElement Withdrawal() {
		return driver.findElement(Withdrawal);
	}

	public WebElement Fund_Transfer() {
		return driver.findElement(Fund_Transfer);
	}

	public WebElement Balance_Inquiry() {
		return driver.findElement(Balance_Inquiry);
	}

	public WebElement Mini_Statement() {
		return driver.findElement(Mini_Statement);
	}

	public WebElement Change_Password() {
		return driver.findElement(Change_Password);
	}

	public WebElement Customised_Statement() {
		return driver.findElement(Customised_Statement);
	}
}
