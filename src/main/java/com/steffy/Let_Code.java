package com.steffy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.MarIPT.base.BaseClass;


public class Let_Code extends BaseClass{
@Test(priority=-3)
public void browser_Launch() {
	browserLaunch("Chrome");
}
@Test(priority=-2)
public void Get_Url()
{
launchUrl("https://letcode.in/test");	
}
@Test(priority=-1)
public void signUp()
{
	
driver.findElement(By.xpath("//a[@href='/home']")).click();
driver.findElement(By.xpath("//i[@class='fas fa-user']")).click();
}
@Test
public void Login() throws InterruptedException
{
driver.findElement(By.xpath("//input[@placeholder='Enter Username']")).sendKeys("mor_2314");	
driver.findElement(By.xpath("//input[@type='password']")).sendKeys("83r5^_");
driver.findElement(By.xpath("//button[text()='Login']")).click();
Thread.sleep(1000);
}
@Test(priority=1)
public void mens() throws InterruptedException
{ 
	//driver.navigate().refresh();
	Thread.sleep(1000);
	WebElement cart = driver.findElement(By.xpath("(//button[@class='card-footer-item button is-link is-fullwidth'])[1]"));
	cart.click();
	Thread.sleep(2000);
	WebElement addcart = driver.findElement(By.xpath("//span[text()='Add to Cart']"));
	addcart.click();
	Thread.sleep(1000);
}
@Test(priority=2)
public void bangles()
{
	driver.findElement(By.xpath("(//span[@class='icon'])[2]")).click();
	driver.navigate().refresh();
	
	WebElement cart2=driver.findElement(By.xpath("(//button[@class='card-footer-item button is-link is-fullwidth'])[2]"));
	Wait<WebDriver> wait=new WebDriverWait(driver,Duration.ofMillis(200));
	wait.until(ExpectedConditions.visibilityOf(cart2));

	cart2.click();
	WebElement addcart1 = driver.findElement(By.xpath("//span[text()='Add to Cart']"));
	addcart1.click();
    
}
@Test(priority=3)
public void LogOut()
{
	WebElement signout=driver.findElement(By.xpath("//i[@class='fas fa-sign-out-alt']"));
    signout.click();	
}
@Test(priority=4)
public void title()
{
System.out.println(driver.getTitle());
		
}
/*@Test(priority=5)
public void driverclose()
{
	driver.close();
}
@Test(priority=6)
public void driverquit()
{
driver.quit();	
}*/
}
