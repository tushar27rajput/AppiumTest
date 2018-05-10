package myand;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Demo {

	public static void main(String[] args) throws Exception 
	{
		System.out.println("Test Start");
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723 \" ");
		Thread.sleep(1000);
		URL u =new URL("http://0.0.0.0:4723/wd/hub");
	
		
		DesiredCapabilities  cap=new DesiredCapabilities();
		
		cap.setCapability("deviceName", "yuvaweb:5554");
		cap.setCapability(CapabilityType.BROWSER_NAME,"Android");
		//cap.setCapability("newCommandTimeout", 100000);
		cap.setCapability(CapabilityType.VERSION, "4.2.2");
		cap.setCapability("platformName", "Android");
		cap.setCapability("appPackage", "com.android.calculator2");
		cap.setCapability("appActivity","com.android.calculator2.Calculator");
		
		AndroidDriver<MobileElement> driver;
		
		while(2>1)
		{
			try
			{
				driver=new AndroidDriver<MobileElement>(u,cap);
				break;
			}
			catch(Exception e)
			{
				 
			}
		}
		//driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		TouchAction t=new TouchAction((PerformsTouchActions) driver);
		MobileElement two=driver.findElement(By.name("2"));
		   t.tap(two).perform();
		   MobileElement plus=driver.findElement(By.name("+"));
		   t.tap(plus).perform();
		   MobileElement four=driver.findElement(By.name("4"));
		   t.tap(four).perform();
		   MobileElement equalTo=driver.findElement(By.name("="));
		   t.tap(equalTo).perform();
		   //locate the edit box of the calculator by using By.tagName()
		   MobileElement results=driver.findElement(By.tagName("EditText"));
			//Check the calculated value on the edit box
		assert results.getText().equals("6"):"Actual value is : "+results.getText()+" did not match with expected value: 6";
		
		//driver.quit();

		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
		System.out.println("Test End");

		

	}

}
