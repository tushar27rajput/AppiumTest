package redmi;



import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class AppiumTest13 
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
		
		//Goto Home Screen Device
		driver.pressKeyCode(AndroidKeyCode.HOME);
		
		String path=driver.getRemoteAddress().getPath();
		System.out.println("Appium Server Path:"+path);
		
		String proto=driver.getRemoteAddress().getProtocol();
		System.out.println("Appium Server Protocol:"+proto);
		
		int port=driver.getRemoteAddress().getPort();
		System.out.println("Appium Server Port:"+port);
		
		String host=driver.getRemoteAddress().getHost();
		System.out.println("Appium Server Host Address:"+host);
		
		
		long dd=driver.getDisplayDensity();
		System.out.println("Andriod Device Display Density:"+dd);
	
		String dte=driver.getDeviceTime();
		System.out.println("Andriod Device Current Time & Date:"+dte);
		
		String plt=driver.getPlatformName();
		System.out.println("Andriod Device Platform:"+plt);

		//Get Andriod Device of Version
		//driver.openNotifications();
		//Thread.sleep(5000);
		
		
		
		if(driver.isAppInstalled("com.android.settings"))
		{
			Activity a=new Activity("com.android.settings","com.android.settings.MiuiSettings");
			driver.startActivity(a);
			
		}
		System.out.println("Andriod Device Platform:"+plt);
		System.out.println("Andriod Device Platform:"+plt);
		
		
		Thread.sleep(5000);
		
		List<MobileElement> l2 = ((AndroidDriver<MobileElement>)driver).findElementsByAndroidUIAutomator("new UiSelector().content-desc(\" Search \")");	
		l2.get(0).sendKeys("Android version");
		Thread.sleep(1000);
		
		//String v=driver.findElement(By.xpath("//*[@bounds='[58,517][329,570]']")).getAttribute("text");
		//System.out.println("Andriod Device Version"+v);
	//	Thread.sleep(5000);
	
		driver.pressKeyCode(AndroidKeyCode.HOME);
		Thread.sleep(5000);
		
		driver.launchApp();
		Thread.sleep(5000);
		driver.closeApp();
		
		
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
		System.out.println("Test End");

		
		
	
	}

}
