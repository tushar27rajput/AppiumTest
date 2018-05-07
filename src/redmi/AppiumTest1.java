package redmi;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;



public class AppiumTest1 
{

	public static void main(String[] args) throws Exception
	{
		System.out.println("Test Start");
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723 \" ");
		Thread.sleep(1000);
		URL u =new URL("http://0.0.0.0:4723/wd/hub");
		//Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "yuvaweb-5554");
		caps.setCapability(CapabilityType.BROWSER_NAME,"");
		caps.setCapability("udid", "emulator-5554"); //Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "4.2.2");
		//caps.setCapability("appPackage", "com.miui.gallery");
		//caps.setCapability("appPackage","com.miui.player");
		//caps.setCapability("appActivity", "com.miui.gallery.activity.ExternalPhotoPageActivity");
		//caps.setCapability("appActivity", "com.miui.player.ui.MusicBrowserActivity");
		caps.setCapability("appPackage", "com.android.deskclock");
		caps.setCapability("appActivity", "com.android.deskclock.DeskClock");
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
		
		//driver.findElement(By.xpath("//android.widget.TextView[@text='Recents']")).click();
		//driver.findElement(By.className("android.widget.ImageView")).click();
		//driver.pressKeyCode(AndroidKeyCode.HOME);
		//driver.findElementByAccessibilityId("Search").click();
		//driver.findElement(By.xpath("//*[@content-desc = 'Search']")).click();
		//WebElement w=driver.findElement(By.xpath("//*(android.widget.ImageButton[@content-desc='Cities']))"));
		//driver.findElement(By.className("android.widget.ImageButton")).click();
		//driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Cities']")).click();
		driver.findElement(By.xpath("//*[@content-desc='Cities']")).click();
		driver.findElement(By.xpath("(//*[@class='android.widget.CheckBox'])[4]")).click();
		driver.pressKeyCode(AndroidKeyCode.HOME);
		//driver.quit();
		
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
		System.out.println("Test End");

	}

}
