
package nb_cl12s10_Test_pkg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {

	
	
	
	
	
	// IQA 1: Have you tested in mutliple countries environment? How would you do it?
		// I need to create a multi dimensional list or array for my string....and save my list. then object where I can ..
			// use @DataProvider annotation to run the testNG before @Test method....we need to also add the parameters in our loginTest based on our list
	
	// IQA 2: What kind of reporting system have you used?
		// For reporting, I have used JUnit....
		// For reporting, I have used TestNG...
		// For reporting, I have also used extent report...
	
	// IQA 3: How to explain framework?
		// 1. Language: Java
		// 2. Project Management Tool: Maven
		// 3. Automation Tool: Selenium
		// 4. Framework Management Tool: Junit or TestNG
		// 5. Data Management: for data driven, talk about excel
		// 6. Reporting: JUnit Vs TestNG Vs Extent Report (use this for TestNG as well)
		// 7. Project Design Pattern: Page Object Model aka POM:  talk about 3 different packages (Page, Util, and Test), what goes in there and how it works
		// 8. IDE: Eclipse
	
	
	// =================================================================================================
	
	

	WebDriver driver;

	By USER_NAME_FIELD = By.xpath("//input[@id='username']");
	By PASSWORD_FIELD = By.xpath("//input[@id='password']");
	By SIGN_IN_BUTTON = By.xpath("//button[@name='login']");
	By DASHBOARD_HEADER_FIELD = By.xpath("//hr[text()=' Dashboard ']");
	By Customer_Menu_Field = By.xpath("//span[contains(text(), 'Customers')]");
	By Add_Customer_Menu_Field = By.xpath("//span[contains(text(), 'Add Customer')]");
	By Full_Name_Field = By.xpath("//*[@id=\"account\"]");
	By Company_Dropdown_Field = By.xpath("//select[@id='cid']");

	@BeforeMethod
	public void init() {

		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // implicit is to slow our execution down every
																			// time we are trying to identify any of our
																			// elements
		// industry standard is 60 seconds
	}

	@DataProvider(name = "loginDataMultiUser")
	public String[][] loginData() {

		String[][] data = new String[][] { 
			{ "demo@techfios.com", "abc123" }, 
			{ "demo@techfios1.com", "abc123" },
			{ "demo@techfios.com", "123abc123" }, 
		};
		return data;

	}

	@Test(dataProvider = "loginDataMultiUser")
	public void loginTest(String userName, String password) {

		driver.findElement(USER_NAME_FIELD).sendKeys(userName);
		driver.findElement(PASSWORD_FIELD).sendKeys(password);
		driver.findElement(SIGN_IN_BUTTON).click();

	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(1500);
		driver.close();
		driver.quit();
	}

}
