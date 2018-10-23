package scirpts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import page_objects.Guru99_Bank_Balance_Enquiry_Page;
import page_objects.Guru99_Bank_Manager_HomePage;
import page_objects.Guru99_bank_login_page;

public class Balance_Inquiry_with_non_existing_account_no {

	WebDriver driver;

	@BeforeMethod
	public void Open_browser() {
		driver = new FirefoxDriver();
		driver.get("http://www.demo.guru99.com/v4/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void Balance_Inquiry_with_non_existing_account_nos() throws InterruptedException {

		// Guru99_bank_login_page

		Guru99_bank_login_page loginpage = new Guru99_bank_login_page(driver);
		Guru99_Bank_Manager_HomePage ManagerHomePage = loginpage.login("mngr31399", "AbAhUpA");
		// Guru99_Bank_Manager_HomePage

		ManagerHomePage.Balance_Inquiry().click();
		System.out.println(driver.getTitle());

		// Guru99_Bank_Balance_Enquiry_Page

		Guru99_Bank_Balance_Enquiry_Page BalanceEnquiryPage = new Guru99_Bank_Balance_Enquiry_Page(driver);
		BalanceEnquiryPage.Account_No().sendKeys("11");
		BalanceEnquiryPage.Submit().click();
		String message = driver.switchTo().alert().getText();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		System.out.println(message);
		Assert.assertEquals(message, "Account does not exist");

	}

	@AfterMethod
	public void Close_browser() {
		driver.quit();
	}

}
