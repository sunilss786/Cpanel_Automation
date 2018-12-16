package com.sunil.demo2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.UUID;
import java.util.Random;



import okio.Timeout;


public class createorder {

	public static void main(String[] args) throws Exception
	
	{
		System.out.println("sunil");

		// TODO Auto-generated method stub
		//firefox
		 //System.setProperty("webdriver.gecko.driver", "D:\\seleniumJar\\geckodriver.exe");
         //WebDriver driver = new FirefoxDriver();
		
		// Chrome
		System.setProperty("webdriver.chrome.driver", "D:\\seleniumJar\\chromedriver.exe");
         WebDriver driver=new ChromeDriver();
         
		 //Launch the Online Store Website
		 driver.get("https://admin.grab.in/");
		 
		 //Maximize window
		 driver.manage().window().maximize();
		// Enter UserName
		 driver.findElement(By.id("username")).sendKeys("suniltest");
		 // Enter Password
		 driver.findElement(By.id("password")).sendKeys("Grab@789");  //Grab@789
		// Wait For Page To Load
		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		// Click on 'Sign In' button
 		driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[3]/div[1]/button")).click();
		
 		for(int i=1;i<=2;i++)
 		{
 		   driver.findElement(By.id("areaId")).sendKeys("Andheri West");
 		
 		   Select dropnew=new Select(driver.findElement(By.id("restaurantId")));
 		
 		   dropnew.selectByVisibleText("Suniltest");
 		//dropnew.selectByIndex(1);
 		
 		   Random rand = new Random();
 	       int num = rand.nextInt(9000000) + 1000000;
 		
 		   //String uuid = UUID.randomUUID().toString();
 	
		    driver.findElement(By.id("billNo")).sendKeys(""+num);
		    driver.findElement(By.id("orderAmount")).sendKeys("55");
		    driver.findElement(By.id("customerPhone")).sendKeys("8286682623");
		    
		    Thread.sleep(1000);

		     //delivery years
	 		
	       Select dropndelivery=new Select(driver.findElement(By.id("deliveryArea")));
	 		
	        dropndelivery.selectByVisibleText("4 Bunglows");
	 	    //dropndelivery.selectByIndex(1);
		 
		    driver.findElement(By.id("customerName")).sendKeys("Sunil Yadav");
		    driver.findElement(By.id("customerAddress")).sendKeys("Laxmi Plaza new link road goregaon west");
		 
		    //if dynamic option yes
		    // driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[2]/form/div[1]/div[2]/label/i")).click();

		 
		    // Add order
		 
	 	    driver.findElement(By.xpath("//*[@id=\"placeordrBtn\"]")).click();
	 	    
	 	   Thread.sleep(10000);
 		}

		driver.close();

	}

}
