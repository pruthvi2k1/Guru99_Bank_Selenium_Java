package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Guru99_bank_login_page {

	WebDriver driver;

	public Guru99_bank_login_page(WebDriver driver) {
		this.driver = driver;
	}

	By username = By.xpath("//input[@name='uid']");
	By password = By.xpath("//input[@name='password']");
	By login_button = By.xpath("//input[@name='btnLogin']");

	public WebElement username() {
		return driver.findElement(username);
	}

	public WebElement password() {
		return driver.findElement(password);
	}

	public WebElement login_button() {
		return driver.findElement(login_button);
	}

	public Guru99_Bank_Manager_HomePage login(String username1, String password1) {
		driver.findElement(username).sendKeys(username1);
		driver.findElement(password).sendKeys(password1);
		driver.findElement(login_button).click();
		Guru99_Bank_Manager_HomePage ManagerHomePage = new Guru99_Bank_Manager_HomePage(driver);
		return ManagerHomePage;

	}
}
