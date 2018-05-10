package redmi;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Connection;

public class AppiumTest15
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
		cap.setCapability("appPackage", "com.miui.calculator");
		cap.setCapability("appActivity","com.miui.calculator.cal.CalculatorActivity");
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
		
		Connection c= driver.getConnection();
		if(c.compareTo(Connection.AIRPLANE)==0)
		{
			System.out.println("AirPlane Mode is ON");
		}
		else
		{
			System.out.println("AirPlane Mode is OFF");
		}
		if(c.compareTo(Connection.DATA)==0)
		{
			System.out.println("DATA is ON");
		}
		else
		{
			System.out.println("DATA is OFF");
		}
		
		if(c.compareTo(Connection.WIFI)==0)
		{
			System.out.println("WIFI is ON");
		}
		else
		{
			System.out.println("WIFI is OFF");
		}
		//driver.setConnection(Connection.ALL);
		//driver.setConnection(Connection.NONE);
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
		System.out.println("Test End");

	}

}
