

package nb_cl12s10_Test_pkg;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Parallel_Test {

	
	

	// Executable jar files: right click on 
		// .bat jar --> is for java
		//.dotnet --> for C#
	
	
	
	// IQA 1: Can we conduct parallel execution using Selenium Webdriver?
		// Yes, we can run using the convert to TestNG option to generate the testNG.xml... 
				// to do this, right click on the project name, and down below click on TestNG then convert to TestNG option....
			// we need to modify the parallel mode to methods, and mention the # of thread counts based on how many browsers we are using 
	
	// IQA 2: Why do we conduct parallel execution?
		// so that we can run different browsers to test whether our codes are performing as per our expectations and without any timeout issues since different browsers run different time 
	
	
	
	
	
	// ======== ============= =========== =========== ============== ============= ===================
	
	public WebDriver driver; 

	@Test 
	public void FirefoxTest() { 

	System.out.println("The thread ID for Firefox is "+ Thread.currentThread().getId()); 
	System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver"); 
	driver = new FirefoxDriver(); 
	driver.get("https://www.yahoo.com/"); 

	} 

	@Test 
	public void ChromeTest(){ 

	System.out.println("The thread ID for Chrome is "+ Thread.currentThread().getId()); 
	System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver"); 
	driver = new ChromeDriver(); 
	driver.get("https://www.yahoo.com/"); 
	}
	
	
}
