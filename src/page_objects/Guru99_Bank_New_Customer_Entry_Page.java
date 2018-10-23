package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Guru99_Bank_New_Customer_Entry_Page {

	WebDriver driver;

	public Guru99_Bank_New_Customer_Entry_Page(WebDriver driver) {

		this.driver = driver;
	}

	By Customer_Name = By.xpath("//input[@name='name']");
	By Gender = By.xpath("//input[@value='m']");
	By Date_of_Birth = By.xpath("//*[@id='dob']");
	By Address = By.xpath("//textarea[@name='addr']");
	By City = By.xpath("//input[@name='city']");
	By State = By.xpath("//input[@name='state']");
	By PIN = By.xpath("//input[@name='pinno']");
	By Mobile_Number = By.xpath("//input[@name='telephoneno']");
	By E_mail = By.xpath("//input[@name='emailid']");
	By Password = By.xpath("//input[@name='password']");
	By Submit = By.xpath("//input[@value='Submit']");

	public WebElement Customer_Name() {
		return driver.findElement(Customer_Name);
	}

	public WebElement Gender() {
		return driver.findElement(Gender);
	}

	public WebElement Date_of_Birth() {
		return driver.findElement(Date_of_Birth);
	}

	public WebElement Address() {
		return driver.findElement(Address);
	}

	public WebElement City() {
		return driver.findElement(City);
	}

	public WebElement State() {
		return driver.findElement(State);
	}

	public WebElement PIN() {
		return driver.findElement(PIN);
	}

	public WebElement Mobile_Number() {
		return driver.findElement(Mobile_Number);
	}

	public WebElement E_mail() {
		return driver.findElement(E_mail);
	}

	public WebElement Password() {
		return driver.findElement(Password);
	}

	public WebElement Submit() {
		return driver.findElement(Submit);
	}

}
