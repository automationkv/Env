package FinalEnv.Env;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class NewTest
{
	public WebDriver driver;
	Logger APP_LOG = Logger.getLogger("devpinoyLogger");
	/*  @Test(dataProvider = "dp")
  public void f(Integer n, String s)
  {
  }

  @DataProvider
  public Object[][] dp()
   {
    return new Object[][]
     {new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
	 */

	@BeforeMethod
	@Parameters ("browser")
	public void setUp(String browser) //throws Exception
	{
		//For Firefox
		if(browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
			APP_LOG.debug("Firefox Browser Opened");
		}

		//For Chrome
		else if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\Automation\\3EnvSetup\\BrowserServers\\chromedriver.exe");
			driver = new ChromeDriver();
			APP_LOG.debug("Chrome Browser Opened");
		}

		//For Internet Explorer
		else if(browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "E:\\Automation\\3EnvSetup\\BrowserServers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			APP_LOG.debug("Internet Explorer Browser Opened");
		}

		/*//For Other Browser
		else
		{
			APP_LOG.debug("Browser is not available");
			throw new Exception("Browser is not available");
		}*/

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.google.co.in");
		APP_LOG.debug("Google Site Launched");
	}

	@Test
	public void checkGoogleTitle() //throws InterruptedException
	{
		String eGoogleTitle = "Google";
		String aGoogleTitle = driver.getTitle();
		APP_LOG.debug("Google Title Captured");

		if (aGoogleTitle.contains(eGoogleTitle))
		{
			System.out.println("checkGoogleTitle Test Passed");
			APP_LOG.debug("checkGoogleTitle Test Passed");
		}
		else
		{
			System.out.println("checkGoogleTitle Test Failed");
			APP_LOG.debug("checkGoogleTitle Test Failed");
		}
	}

	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
