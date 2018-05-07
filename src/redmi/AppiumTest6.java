package redmi;

import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class AppiumTest6 
{

	public static void main(String[] args) throws Exception
	{
		
		System.out.println("Test Start");
		
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723 \" ");
		
		URL u =new URL("http://0.0.0.0:4723/wd/hub");
		
		//Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Redmi prime 2 ");
		caps.setCapability(CapabilityType.BROWSER_NAME,"Chrome");
		caps.setCapability("udid", "33ac4017d52"); //Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "5.1.1");
		//caps.setCapability("appPackage", "com.miui.calculator");
		//caps.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
		AndroidDriver<MobileElement> driver;
		
		while(2>1)
		{
			try
			{
				driver=new AndroidDriver<MobileElement>(u,caps);
				break;
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		
		try
		{
			
			driver.get("https://m.youtube.com");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@title='Search YouTube']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@name='q']")).sendKeys("jannat");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id='koya_elem_1_2']")).click();
			String x=driver.getCurrentPackage();
			System.out.println(x);
			
			String y=driver.currentActivity();
			System.out.println(y);
			
			Duration d=Duration.of(10, ChronoUnit.SECONDS);
			driver.runAppInBackground(d);
			Thread.sleep(5000);
			
			driver.pressKeyCode(AndroidKeyCode.HOME);
			Thread.sleep(5000);
			
			driver.launchApp();
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//*[@text='9']")).click();
			Thread.sleep(5000);
			
			driver.resetApp();
			Thread.sleep(5000);
			
			driver.closeApp();
			
			
		}
	
	
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
		System.out.println("Test End");
		
	}

}
