package redmi;

import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AppiumTest4
{

	public static void main(String[] args) throws Exception
	{
		
		
		
		
		
		System.out.println("Test Start");
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723 \" ");
		Thread.sleep(1000);
		URL u =new URL("http://0.0.0.0:4723/wd/hub");
		//Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Redmi prime 2");
		caps.setCapability(CapabilityType.BROWSER_NAME,"");
		caps.setCapability("udid", "33ac4017d52"); //Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "5.1.1");
		caps.setCapability("appPackage", "com.miui.player");
		caps.setCapability("appActivity", "com.miui.player.ui.MusicBrowserActivity");
		
		AndroidDriver driver;
		
		while(2>1)
		{
			try
			{
				driver=new AndroidDriver(u,caps);
				break;
			}
			catch(Exception e)
			{
				 
			}
		}
		
		try 
		{
			Thread.sleep(5000);
		//driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		/*driver.findElement(By.xpath("//*[@text='2']")).click();
		driver.findElement(By.xpath("//*[@content-desc='plus']")).click();
		driver.findElement(By.xpath("//*[@text='9']")).click();
		driver.findElement(By.xpath("//*[@content-desc='equals']")).click();
		*/
			
		driver.findElement(By.xpath("//*[@content-desc='Search']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//*[@class='android.widget.EditText'])[1]")).sendKeys("jannat");
		Thread.sleep(5000);
		driver.findElement(By.id("search_button")).click();
		Thread.sleep(5000);
			
			//driver.findElement(By.xpath("(//*[@content-desc='New chat'])[2]")).click();
			//Thread.sleep(5000);
			//driver.findElement(By.xpath("//*[@class='android.widget.TextView']")).sendKeys("@chikuu");
			
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
