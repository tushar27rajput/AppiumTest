package redmi;

import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AppiumTest14
{

	public static void main(String[] args) throws Exception
	{
		
		
		System.out.println("Test Start");
		AppiumTest14 obj=new AppiumTest14();
		obj.appiumstart();
		
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723 \" ");
		
		URL u =new URL("http://0.0.0.0:4723/wd/hub");
		
		//Set the Desired Capabilities
		DesiredCapabilities  cap=new DesiredCapabilities();
		cap.setCapability(CapabilityType.BROWSER_NAME,"");
		cap.setCapability(CapabilityType.VERSION, "5.1.1");
		cap.setCapability("deviceName", "Redmi prime 2");
		cap.setCapability("udid", "33ac4017d52"); //Give Device ID of your mobile phone
		cap.setCapability("platformName", "Android");
		cap.setCapability("locationServicesEnabled", true);
		cap.setCapability("locationServicesAuthorized", true);
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
		
		
		//Get Performance Details
		List<String> a1=driver.getSupportedPerformanceDataTypes();
		for(int i=0;i<a1.size();i++)
		{
			System.out.print(a1.get(i)+"\t");
		}
		System.out.println();
		
		//Get Performance Data
		System.out.println("CPU Information");
		List<List<Object>> ci=driver.getPerformanceData("com.google.android.apps.maps", "cpuinfo", 10000);
		for(int i=0;i<ci.size();i++)
		{
			for(int j=0;j<ci.get(i).size();j++)
			{
				try
				{
					System.out.print(ci.get(i).get(j).toString()+"\t");
				}
				catch(Exception ex)
				{
					System.out.println(0);
				}
			}
			System.out.println("");
		}
		
		System.out.println("Memory Information");
		List<List<Object>> ci1=driver.getPerformanceData("com.google.android.apps.maps", "memoryinfo", 10000);
		for(int i=0;i<ci1.size();i++)
		{
			for(int j=0;j<ci1.get(i).size();j++)
			{
				try
				{
					System.out.print(ci1.get(i).get(j).toString()+"\t");
				}
				catch(Exception ex)
				{
					System.out.println(0);
				}
			}
			System.out.println("");
		}
		
		
		System.out.println("Battery Information");
		List<List<Object>> ci2=driver.getPerformanceData("com.google.android.apps.maps", "batteryinfo", 10000);
		for(int i=0;i<ci2.size();i++)
		{
			for(int j=0;j<ci2.get(i).size();j++)
			{
				try
				{
					System.out.print(ci2.get(i).get(j).toString()+"\t");
				}
				catch(Exception ex)
				{
					System.out.println(0);
				}
			}
			System.out.println("");
		}
		
		
		System.out.println("Network Information");
		List<List<Object>> ci3=driver.getPerformanceData("com.google.android.apps.maps", "networkinfo", 10000);
		for(int i=0;i<ci3.size();i++)
		{
			for(int j=0;j<ci3.get(i).size();j++)
			{
				try
				{
					System.out.print(ci3.get(i).get(j).toString()+"\t");
				}
				catch(Exception ex)
				{
					System.out.println(0);
				}
			}
			System.out.println("");
		}
		
		
		
		obj.appiumstop();
		System.out.println("Test End");
		
	}

	
	public static void appiumstart() throws Exception
	{
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723 \" ");
	}
	
	public static void appiumstop() throws Exception 
	{
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}
}
