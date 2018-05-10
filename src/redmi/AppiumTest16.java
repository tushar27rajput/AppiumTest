package redmi;

import java.net.URL;
import java.util.ArrayList;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class AppiumTest16 
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
		cap.setCapability("udid", "33ac4017d52"); //Give Device ID of your mobile phone
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
		
		if(driver.isAppInstalled("com.cricbuzz.android"))
		{
			Activity a=new Activity("com.cricbuzz.android","com.cricbuzz.android.lithium.app.view.activity.NyitoActivity");
			driver.startActivity(a);
			
		}
		Thread.sleep(5000);
		
		//Get Contexts related to app
		ArrayList<String> a1=new ArrayList<String>(driver.getContextHandles());
		for(int i=0;i<a1.size();i++)
		{
			System.out.println(a1.get(i));
		}
		
		
		//Get Contexts related to app
		String x=driver.getContext();
		System.out.println(x);
		
		
		//Change Context to Native-App when App in WEB_VIEW
		if(driver.isBrowser())
		{
			driver.context("NATIVE_APP");
			
		}
		
		//Close App
		driver.close();
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
		System.out.println("Test End");

	}

}
