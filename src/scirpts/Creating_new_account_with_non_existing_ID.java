package scirpts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import page_objects.Guru99_Bank_Manager_HomePage;
import page_objects.Guru99_bank_add_new_account_page;
import page_objects.Guru99_bank_login_page;

public class Creating_new_account_with_non_existing_ID {

	WebDriver driver;

	@BeforeMethod
	public void Open_browser() {
		driver = new FirefoxDriver();
		driver.get("http://www.demo.guru99.com/v4/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void Creating_new_account_with_non_existing_IDs() throws InterruptedException {

		// Guru99_bank_login_page

		Guru99_bank_login_page loginpage = new Guru99_bank_login_page(driver);
		Guru99_Bank_Manager_HomePage ManagerHomePage = loginpage.login("mngr31399", "AbAhUpA");
		// Guru99_Bank_Manager_HomePage

		ManagerHomePage.New_Account().click();
		System.out.println(driver.getTitle());

		// Guru99_bank_add_new_account_page

		Guru99_bank_add_new_account_page addnewaccountpage = new Guru99_bank_add_new_account_page(driver);
		addnewaccountpage.Customer_id().sendKeys("11");
		Select account_type = new Select(addnewaccountpage.Account_type());
		account_type.selectByIndex(1);
		addnewaccountpage.Initial_deposit().sendKeys("500");
		addnewaccountpage.submit().click();
		String message = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println(message);
		Thread.sleep(3000);
		Assert.assertEquals(message, "Customer does not exist!!");

	}

	@AfterMethod
	public void Close_browser() {
		driver.quit();
	}
}
