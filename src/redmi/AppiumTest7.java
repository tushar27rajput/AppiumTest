package redmi;


import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AppiumTest7 
{

	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		System.out.println("Test Start");
		
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723 \" ");
		
		URL u =new URL("http://0.0.0.0:4723/wd/hub");
		
		//Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Redmi prime 2 ");
		caps.setCapability(CapabilityType.BROWSER_NAME,"");
		caps.setCapability("udid", "33ac4017d52"); //Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "5.1.1");
		caps.setCapability("appPackage", "com.vegantaram.android.inventory_tracker_paid");
		caps.setCapability("appActivity", "com.vegantaram.android.inventory_tracker_paid.InventoryMainActivity");
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
			
			MobileElement e=driver.findElement(By.xpath("//*[@text='Transaction']"));
			e.click();
			Thread.sleep(5000);
			List<MobileElement> allTitleElements = ((AndroidDriver<MobileElement>)driver).findElementsByAndroidUIAutomator("new UiSelector().resourceId(\"com.vegantaram.android.inventory_tracker_paid:id/btn_main_transaction\")");	
			allTitleElements.get(0).click();
			
			List<MobileElement> l=((AndroidDriver<MobileElement>)driver).findElementsByAndroidUIAutomator("new UiSelector().resourceId(\"com.vegantaram.android.inventory_tracker_paid:id/btn_add_trans\")");
			l.get(0).click();
			
			List<MobileElement> l1=((AndroidDriver<MobileElement>)driver).findElementsByAndroidUIAutomator("new UiSelector().resourceId(\"com.vegantaram.android.inventory_tracker_paid:id/autoComplete_trans_product_code\")");
			
			l1.get(0).sendKeys("101");
			
			//Reset(Refresh) Application 
			driver.resetApp();
			
			List<MobileElement> l2 = ((AndroidDriver<MobileElement>)driver).findElementsByAndroidUIAutomator("new UiSelector().resourceId(\"com.vegantaram.android.inventory_tracker_paid:id/btn_main_clients\")");	
			l2.get(0).click();
			Thread.sleep(5000);
			List<MobileElement> l3=((AndroidDriver<MobileElement>)driver).findElementsByAndroidUIAutomator("new UiSelector().resourceId(\"com.vegantaram.android.inventory_tracker_paid:id/btn_Add_client\")");
			l3.get(0).click();
			Thread.sleep(5000);
			List<MobileElement> l4=((AndroidDriver<MobileElement>)driver).findElementsByAndroidUIAutomator("new UiSelector().resourceId(\"com.vegantaram.android.inventory_tracker_paid:id/txt_client_name\")");
			l4.get(0).sendKeys("Tushar Rajput");
			Thread.sleep(5000);
			List<MobileElement> l5=((AndroidDriver<MobileElement>)driver).findElementsByAndroidUIAutomator("new UiSelector().text(\"Street 1\")");
			l5.get(0).sendKeys("238 shivaji nagar");
			Thread.sleep(5000);
			List<MobileElement> l6=((AndroidDriver<MobileElement>)driver).findElementsByAndroidUIAutomator("new UiSelector().text(\"Street 2\")");
			l6.get(0).sendKeys("salunkhe chowk");
			Thread.sleep(5000);
			
			driver.hideKeyboard();
			
			List<MobileElement> l7=((AndroidDriver<MobileElement>)driver).findElementsByAndroidUIAutomator("new UiSelector().text(\"City\")");
			l7.get(0).sendKeys("Jalgaon");
			Thread.sleep(5000);
			List<MobileElement> l8=((AndroidDriver<MobileElement>)driver).findElementsByAndroidUIAutomator("new UiSelector().text(\"State\")");
			l8.get(0).sendKeys("Maharashtra");
			Thread.sleep(5000);
			List<MobileElement> l9=((AndroidDriver<MobileElement>)driver).findElementsByAndroidUIAutomator("new UiSelector().text(\"ZipCode\")");
			l9.get(0).sendKeys("425001");
			Thread.sleep(5000);
			List<MobileElement> l10=((AndroidDriver<MobileElement>)driver).findElementsByAndroidUIAutomator("new UiSelector().resourceId(\"com.vegantaram.android.inventory_tracker_paid:id/txt_client_contact_num\")");
			l10.get(0).sendKeys("9579778909");
			Thread.sleep(5000);
			List<MobileElement> l11=((AndroidDriver<MobileElement>)driver).findElementsByAndroidUIAutomator("new UiSelector().resourceId(\"com.vegantaram.android.inventory_tracker_paid:id/txt_client_ref\")");
			l11.get(0).sendKeys("akshay pol");
			Thread.sleep(5000);
			List<MobileElement> l12=((AndroidDriver<MobileElement>)driver).findElementsByAndroidUIAutomator("new UiSelector().resourceId(\"com.vegantaram.android.inventory_tracker_paid:id/button1\")");
			l12.get(0).click();
			Thread.sleep(5000);
			//driver.closeApp();
			
			
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
