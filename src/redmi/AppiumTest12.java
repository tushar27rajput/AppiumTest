package redmi;

import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class AppiumTest12 
{

	public static void main(String[] args) throws Exception
	{
		
		System.out.println("Test Start");
		
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723 \" ");
		
		URL u =new URL("http://0.0.0.0:4723/wd/hub");
		
		//Set the Desired Capabilities
		DesiredCapabilities  cap=new DesiredCapabilities();
		cap.setCapability(CapabilityType.BROWSER_NAME,"");
		cap.setCapability(CapabilityType.VERSION, "5.1.1");
		cap.setCapability("deviceName", "Redmi prime 2");
		cap.setCapability("platformName", "Android");
		cap.setCapability("appPackage", "io.selendroid.testapp");
		cap.setCapability("appActivity","io.selendroid.testapp.HomeScreenActivity");
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
				System.out.println(e.getMessage());
			}
		}
		
		if(driver.isAppInstalled("com.miui.calculator"))
		{
			Activity a=new Activity("com.miui.calculator","com.miui.calculator.cal.CalculatorActivity");
			driver.startActivity(a);
			
		}
		
		
		
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
		System.out.println("Test End");

		

	}

}
