package stable;

import java.util.List;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class stableBuild {

	public static void main(String[] args) throws InterruptedException
	{
		// TODO Auto-generated me
	
		
		// Chrome
		System.setProperty("webdriver.chrome.driver", "D:\\seleniumJar\\chromedriver.exe");
         WebDriver driver=new ChromeDriver();
         
		 //Launch the Online Store Websiteeee
		 driver.get("https://cpanel.grab.in/");
		 //Maximize window
		 driver.manage().window().maximize();
		// Enter UserName
		 driver.findElement(By.name("username")).sendKeys("sunil");
		 
		 // Enter Password
		 driver.findElement(By.name("password")).sendKeys("Victory@7777");   //Victory@7777
		 driver.findElement(By.xpath(".//*[@id='m_login_signin_submit']")).click();
		 Thread.sleep(8000);
		 //JavascriptExecutor js = (JavascriptExecutor)driver;
		 //arrow
		 driver.findElement(By.xpath(".//*[@id='btn-nav-sidebar-minified' or @id='m_aside_left_minimize_toggle']")).click();
		// count of GrabDasboard
		 List<WebElement> grabList=driver.findElements(By.xpath((".//*[@id='m_ver_menu' or @id='main-nav']/ul/li")));
		 //System.out.println("Count"+grabList.size());

		
		 for(int i=1;i<=grabList.size();i++)
		 {
			 driver.findElement(By.xpath((".//*[@id='main-nav' or @id='m_ver_menu']/ul/li["+i+"]"))).click();
			 System.out.println("helloo"+i);
			 
			 Thread.sleep(2000);
			 //List<WebElement> subContent=driver.findElements(By.xpath(".//*[ @id='m_ver_menu' or @id='main-nav']/ul/li["+i+"]/div/ul/li"));
			 
			 List<WebElement> subContent=driver.findElements(By.xpath(".//*[@id='m_ver_menu']/ul/li["+i+"]/div/ul/li | .//*[@id='main-nav']/ul/li["+i+"]/ul/li"));

			 
			 int dd=subContent.size();
			 int ddd=dd-1;
			 System.out.println("count2"+ddd);

			 
			 for(int j=1;j<=ddd;j++)
			 {
				 
				 driver.findElement(By.xpath(".//*[@id='m_ver_menu']/ul/li["+i+"]/div/ul/li["+(j+1)+"]/a | .//*[@id='main-nav']/ul/li["+i+"]/ul/li["+j+"]/a")).click();
				 
				 
				 Thread.sleep(2000);
				 List<WebElement> innerSub=driver.findElements(By.xpath(".//*[@id='main-nav']/ul/li["+i+"]/ul/li["+j+"]/ul/li | .//*[@id='m_ver_menu']/ul/li["+i+"]/div/ul/li["+(j+1)+"]/div/ul/li"));
				// System.out.println("innerSub Count="+innerSub.size());
				 if(innerSub.size()>=1)
				 {
                       int add=innerSub.size();
                       
                       int cd=add-1;
					 for(int k=1;k<=cd;k++)
					 {
						 System.out.println("helloo"+i +j +k);
						 driver.findElement(By.xpath(".//*[@id='main-nav']/ul/li["+i+"]/ul/li["+j+"]/ul/li["+k+"]/a")).click();
						 Thread.sleep(3000);
						 
						 //driver.findElement(By.xpath(".//*[@id='btn-nav-sidebar-minified']/i")).click();
						 //Thread.sleep(2000);
						 
						//*[@id='Email' or @name='Email']
						 
						 driver.findElement(By.xpath(".//*[@id='btn-nav-sidebar-minified' or @id='m_aside_left_minimize_toggle']")).click();
						 Thread.sleep(2000);
						 

						 System.out.println("suuu2");
						 driver.findElement(By.xpath((".//*[@id='main-nav' or @id='m_ver_menu']/ul/li["+i+"]/a"))).click(); 
						 Thread.sleep(2000);
						 System.out.println("suuu3");
						 
						 //driver.findElement(By.xpath(".//*[@id='main-nav']/ul/li["+i+"]/ul/li["+j+"]")).click();
						 driver.findElement(By.xpath(".//*[@id='m_ver_menu']/ul/li["+i+"]/div/ul/li["+(j+1)+"]/a | .//*[@id='main-nav']/ul/li["+i+"]/ul/li["+j+"]/a")).click();

						 Thread.sleep(2000);
						 
						 //driver.findElement(By.xpath(".//div[nav[@id='main-nav']/ul/li["+i+"]/ul/li["+j+"]/a/span or div[@id='m_ver_menu']/ul/li["+i+"]/div/ul/li["+j+"]/a/span]")).click();
						 //System.out.println("Text : " + ele1.getText());
						 //ele1.submit();;	
					 }
				 }
				 
				 
				 
				 WebElement eleText = null;
				 try
				 {
					 eleText=driver.findElement(By.xpath(".//*[text()='Click here to refresh'] | /html/body"));
				 }
				 catch (Exception e) 
				 {
					// TODO: handle exception
				 }
				 
				 if(eleText != null)
				 {
					 //System.out.println("inside if");
					 driver.navigate().back();
					 Thread.sleep(2000);
				 }
				 driver.findElement(By.xpath(".//*[@id='btn-nav-sidebar-minified' or @id='m_aside_left_minimize_toggle']")).click();
				 Thread.sleep(2000);
				 System.out.println("suuu2");

				 driver.findElement(By.xpath((".//*[@id='main-nav' or @id='m_ver_menu']/ul/li["+i+"]/a"))).click(); 
				 Thread.sleep(2000);
				 System.out.println("suuu3");

				 
			 }
		 }
	}

}
