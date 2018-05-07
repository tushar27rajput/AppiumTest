package redmi;

import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class AppiumTest8 
{

	public static void main(String[] args) throws Exception
	{
		
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
		caps.setCapability("appPackage", "io.selendroid.testapp");
		caps.setCapability("appActivity", "io.selendroid.testapp.HomeScreenActivity");
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
			
			
			List<MobileElement> allTitleElements = ((AndroidDriver<MobileElement>)driver).findElementsByAndroidUIAutomator("new UiSelector().resourceId(\"io.selendroid.testapp:id/my_text_field\")");	
			allTitleElements.get(0).sendKeys("tushar b rajput");
			Thread.sleep(5000);
			
			
			List<MobileElement> l1 = ((AndroidDriver<MobileElement>)driver).findElementsByAndroidUIAutomator("new UiSelector().resourceId(\"io.selendroid.testapp:id/startUserRegistration\")");	
			l1.get(0).click();
			
			
			
			List<MobileElement> l2 = ((AndroidDriver<MobileElement>)driver).findElementsByAndroidUIAutomator("new UiSelector().resourceId(\"io.selendroid.testapp:id/inputUsername\")");	
			l2.get(0).sendKeys("itstushar27");
			Thread.sleep(1000);
			
			List<MobileElement> l3 = ((AndroidDriver<MobileElement>)driver).findElementsByAndroidUIAutomator("new UiSelector().resourceId(\"io.selendroid.testapp:id/inputEmail\")");	
			l3.get(0).sendKeys("tushar.rajput774@gmail.com");
			Thread.sleep(1000);
			
			List<MobileElement> l4 = ((AndroidDriver<MobileElement>)driver).findElementsByAndroidUIAutomator("new UiSelector().resourceId(\"io.selendroid.testapp:id/inputPassword\")");	
			l4.get(0).sendKeys("1ntel@metbkc");
			Thread.sleep(1000);
			
			
			List<MobileElement> l5 = ((AndroidDriver<MobileElement>)driver).findElementsByAndroidUIAutomator("new UiSelector().resourceId(\"io.selendroid.testapp:id/inputName\")");	
			l5.get(0).clear();
			l5.get(0).sendKeys("Tushar B Rajput");
			Thread.sleep(1000);
			while(2>1)
			{
				if(driver.isKeyboardShown())
				{
					driver.hideKeyboard();
					break;
					
				}
				else
				{
					driver.getKeyboard();
				}
			}
			
			//driver.findElement(By.xpath("//*[@text='Programming Languge']"));
			
			
			List<MobileElement> l6 = ((AndroidDriver<MobileElement>)driver).findElementsByAndroidUIAutomator("new UiSelector().resourceId(\"io.selendroid.testapp:id/input_preferedProgrammingLanguage\")");	
			l6.get(0).click();
			Thread.sleep(1000);
			

			List<MobileElement> l7 = ((AndroidDriver<MobileElement>)driver).findElementsByAndroidUIAutomator("new UiSelector().text(\"Java\")");	
			l7.get(0).click();
			Thread.sleep(1000);
			
			List<MobileElement> l8 = ((AndroidDriver<MobileElement>)driver).findElementsByAndroidUIAutomator("new UiSelector().text(\"I accept adds\")");	
			l8.get(0).click();
			Thread.sleep(1000);
			
			List<MobileElement> l9 = ((AndroidDriver<MobileElement>)driver).findElementsByAndroidUIAutomator("new UiSelector().resourceId(\"io.selendroid.testapp:id/btnRegisterUser\")");	
			l9.get(0).click();
			Thread.sleep(1000);
			
			List<MobileElement> l10 = ((AndroidDriver<MobileElement>)driver).findElementsByAndroidUIAutomator("new UiSelector().resourceId(\"io.selendroid.testapp:id/buttonRegisterUser\")");	
			l10.get(0).click();
			Thread.sleep(1000);
			
			List<MobileElement> l11 = ((AndroidDriver<MobileElement>)driver).findElementsByAndroidUIAutomator("new UiSelector().resourceId(\"io.selendroid.testapp:id/touchTest\")");	
			l11.get(0).click();
			Thread.sleep(1000);
			
			MobileElement e1=driver.findElement(By.xpath("//*[@class='android.widget.LinearLayout']"));
			TouchAction t= new TouchAction(driver);
			t.tap(e1).perform();
			
			Thread.sleep(1000);
			t.longPress(e1).perform();
		
			Thread.sleep(1000);
			
			driver.pressKeyCode(AndroidKeyCode.BACK);
			Thread.sleep(1000);
			List<MobileElement> l12 = ((AndroidDriver<MobileElement>)driver).findElementsByAndroidUIAutomator("new UiSelector().resourceId(\"io.selendroid.testapp:id/visibleButtonTest\")");	
			l12.get(0).click();
			String x=l12.get(0).getText();
			System.out.println(x);
			Thread.sleep(1000);
			List<MobileElement> l13 = ((AndroidDriver<MobileElement>)driver).findElementsByAndroidUIAutomator("new UiSelector().resourceId(\"io.selendroid.testapp:id/input_adds_check_box\")");	
			l13.get(0).click();
			
			Thread.sleep(1000);
			List<MobileElement> l14 = ((AndroidDriver<MobileElement>)driver).findElementsByAndroidUIAutomator("new UiSelector().resourceId(\"io.selendroid.testapp:id/buttonTest\")");	
			l14.get(0).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@text='I agree']")).click();
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
