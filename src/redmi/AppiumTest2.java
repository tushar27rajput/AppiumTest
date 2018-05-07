package redmi;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class AppiumTest2
{

	public static void main(String[] args) throws Exception 
	{
		System.out.println("Test Start");
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723 \" ");
		Thread.sleep(1000);
		URL u =new URL("http://0.0.0.0:4723/wd/hub");
		//Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Redmi prime 2");
		caps.setCapability(CapabilityType.BROWSER_NAME,"");
		caps.setCapability("udid", "33ac4017d52"); //Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "5.1.1");
		caps.setCapability("appPackage", "com.android.contacts");
		caps.setCapability("appActivity", "com.android.contacts.activities.TwelveKeyDialer");
		
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
				 
			}
		}
		
	try
	{
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		String mob="9579778909";
		for(int i=0;i<mob.length();i++)
		{
			char y=mob.charAt(i);
			String z="";
			
			switch(y)
			{
				case '0':
					z="zero";
					break;
				
				case '1':
					z="one";
					break;
					
				case '2':
					z="two";
					break;
				
				case '3':
					z="three";
					break;
			
				case '4':
					z="four";
					break;
			
				case '5':
					z="five";
					break;
				
				case '6':
					z="six";
					break;
					
				case '7':
					z="seven";
					break;
			
				case '8':
					z="eight";
					break;
			
				case '9':
					z="nine";
					break;
					
				default:
					System.out.println("Wrong digit");
					break;
				
			}
			MobileElement e=driver.findElement(By.xpath("//*[@content-desc='"+z+"']"));
			System.out.println(z);
			TouchAction t=new TouchAction(driver);
			t.tap(e).perform();
			
			Thread.sleep(5000);
			
		}
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


