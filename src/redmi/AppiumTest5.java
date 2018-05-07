package redmi;

import java.net.URL;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AppiumTest5 {

	public static void main(String[] args) throws Exception 
	{
		System.out.println("Test Start");
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the 1st value:");
		String value1=sc.nextLine();
		System.out.println("Enter the 2nd value");
		String value2=sc.nextLine();

		
		
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
		caps.setCapability("appPackage", "com.miui.calculator");
		caps.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
		
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
		try
		{
			//Automated Application Elements
			driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
			
			//Enter 1st value
			for(int i=0;i<value1.length();i++)
			{
				char z=value1.charAt(i);
				MobileElement e=(MobileElement) driver.findElement(By.xpath("//*[@text='"+z+"']"));
				
				e.click();
				
			}
			
			//Click (+)  
			driver.findElement(By.xpath("//*[@content-desc='plus']")).click();
			
			//Enter 2nd value
			for(int i=0;i<value2.length();i++)
			{
				char z=value2.charAt(i);
				driver.findElement(By.xpath("//*[@text='"+z+"']")).click();
			}
			
			//Click (=)
			driver.findElement(By.xpath("//*[@content-desc='equals']")).click();
			
			//Output
			String str=driver.findElement(By.xpath("//*[@class='android.widget.TextView']")).getAttribute("text");
			
			int i1=Integer.parseInt(value1);
			int i2=Integer.parseInt(value2);
			int o=Integer.parseInt(str);
			
			if(o==i1+i2)
			{
				System.out.println("Automation Test Passed");
			}
			else
			{
				System.out.println("Automation Test Failed");
			}
			
			//Close the Application
			driver.closeApp();
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
			//Stop Server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
		System.out.println("Test End");

	}

}
