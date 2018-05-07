package redmi;

import java.net.URL;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AppiumTest9  
{

	public static void main(String[] args) throws Exception 
	{
		
		System.out.println("Test Start");
		
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723 \" ");
		
		URL u =new URL("http://0.0.0.0:4723/wd/hub");
		
		//Set the Desired Capabilities
		DesiredCapabilities  cap=new DesiredCapabilities();
		cap.setCapability(CapabilityType.BROWSER_NAME,"");
		cap.setCapability(CapabilityType.VERSION, "4.2.2");
		cap.setCapability("deviceName", "yuvaweb:5554");
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
				System.out.println(e.getMessage());
			}
		}
		
		String x=driver.getOrientation().name();
		System.out.println(x);
		if(x.equals("LANDSCAPE"))
		{
			driver.rotate(ScreenOrientation.PORTRAIT);
			Thread.sleep(5000);
		}
		driver.lockDevice();
		Thread.sleep(2000);
		if(driver.isLocked())
		{
			System.out.println("Locked Phone");
			driver.unlockDevice();
		}
		
		
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
		System.out.println("Test End");
		

	}

}
