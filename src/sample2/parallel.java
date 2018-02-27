package sample2;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.lf5.viewer.configure.ConfigurationManager;
import org.openqa.jetty.util.URI;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class parallel
{
	AndroidDriver<MobileElement> driver;
	
	
	
		@Parameters({"deviceName1","platformVersion", "URL1"} )
		@BeforeMethod
		public void beforeMethod(String deviceName1,String platformVersion,String URL1) throws MalformedURLException, InterruptedException
		{
			   
			   DesiredCapabilities capabilities = new DesiredCapabilities();
			   capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
			   capabilities.setCapability("deviceName", deviceName1);
			   //capabilities.setCapability("udid", UDID);
			   capabilities.setCapability("platformVersion", platformVersion);
			   capabilities.setCapability("platformName", "Android");
			   capabilities.setCapability("appPackage", "com.android.calculator2");
			   capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
			   driver = new AndroidDriver<MobileElement>(new URL("http://"+URL1), capabilities);
			   driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
			   Thread.sleep(10000);
	}
		
		@Test
		public void run()
		{
			
		}
		
		@AfterMethod
		public void f()
		{
			driver.quit();
		}
	}

	

