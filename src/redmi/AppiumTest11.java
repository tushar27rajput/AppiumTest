package redmi;

import java.net.URL;

import org.openqa.selenium.html5.Location;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AppiumTest11
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
		cap.setCapability("locationServicesEnabled", "True");
		cap.setCapability("locationServicesAuthorized", "True");
		cap.setCapability("appPackage", "com.google.android.apps.maps");
		cap.setCapability("appActivity","com.google.android.maps.MapsActivity");
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
		
		
		//Jalgaon(HomeTown longitude,latitude & Altitude )
		Location l1=new Location(21.0076578,75.5626039,2000);
		driver.setLocation(l1);
		Thread.sleep(5000);
		
		//HYD( longitude,latitude & Altitude )
		Location l2=new Location(17.385044,78.486671,2000);
		driver.setLocation(l2);
		Thread.sleep(5000);
		
		//TajMahal( longitude,latitude & Altitude )
		Location l3=new Location(27.1750,78.0422,2000);
		driver.setLocation(l3);
		Thread.sleep(5000);
		
		
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
		System.out.println("Test End");

	}

}
