package com.leaf.test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TC001 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://acme-test.uipath.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("kumar.testleaf@gmail.com",Keys.TAB);
		driver.findElement(By.name("password")).sendKeys("leaf@12",Keys.TAB);
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		WebElement element=driver.findElement(By.xpath("(//div[@class='dropdown'])[6]"));
		Actions builder=new Actions(driver);
		builder.moveToElement(element).build().perform();
		driver.findElement(By.xpath("//a[contains(text(),'Search for Invoice')]")).click();
		driver.findElement(By.id("invoiceNumber")).sendKeys("785201");
		driver.findElement(By.xpath("//*[text()='Search']")).click();
		String text = driver.findElement(By.xpath("(//table[@class='table']//tr/td)[1]")).getText();
		
		if(text.equals("785201")) {
			WebElement invoice_item = driver.findElement(By.xpath("(//table[@class='table']//tr/td)[3]"));
			
			System.out.println(invoice_item.getText());
		}
		driver.findElement(By.xpath("//a[text()='Log Out']")).sendKeys(Keys.RETURN);;
		
	}


}
