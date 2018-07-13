package com.qainfotech.com.Baisc_course;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestFile {
  @Test
  public void f() {
	  
	  String dir = System.getProperty("user.dir");
	  System.out.println(System.getProperty("user.dir"));
	  String chromedriver= "chromedriver";
	 System.setProperty("webdriver.chrome.driver", dir+"/"+chromedriver);
	// System.setProperty("webdriver.chrome.driver", "C:\\path\\to\\chromedriver.exe");
	 ChromeOptions options = new ChromeOptions();
	 options.addArguments("start-maximized"); // open Browser in maximized mode
	 options.addArguments("disable-infobars"); // disabling infobars
	 options.addArguments("--disable-extensions"); // disabling extensions
	 //options.addArguments("--disable-gpu"); // applicable to windows os only
	 options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
	 options.addArguments("--no-sandbox"); // Bypass OS security model
	 WebDriver pointer = new ChromeDriver(options);
	 //driver.get("https://google.com");
	  //WebDriver pointer=new ChromeDriver();
	    pointer.get("http://10.0.1.86/tatoc");
	    pointer.findElement(By.linkText("Basic Course")).click();
	    pointer.findElement(By.className("greenbox")).click();
	    pointer.switchTo().frame(pointer.findElement(By.id("main")));
	    String Colorbox1 = pointer.findElement(By.id("answer")).getAttribute("class");
	    pointer.switchTo().frame(pointer.findElement(By.id("child")));
	    String Colorbox2 = pointer.findElement(By.id("answer")).getAttribute("class");
	    pointer.switchTo().defaultContent();
	    
	    while(Colorbox1.equals(Colorbox2)!=true) {
	    	pointer.switchTo().frame(pointer.findElement(By.id("main")));
	    	pointer.findElement(By.linkText("Repaint Box 2")).click();
	    	pointer.switchTo().frame(pointer.findElement(By.id("child")));
	    	Colorbox2 = pointer.findElement(By.id("answer")).getAttribute("class");
	    	pointer.switchTo().defaultContent();
	    	
	    }
	    pointer.switchTo().defaultContent();
	    pointer.switchTo().frame(pointer.findElement(By.id("main")));
	    pointer.findElement(By.linkText("Proceed")).click();
	    
	    
	    
	    WebElement dragfrom = pointer.findElement(By.id("dragbox"));
	    WebElement To =pointer.findElement(By.id("dropbox"));
	    Actions act=new Actions(pointer);	
	    act.dragAndDrop(dragfrom, To).build().perform();
	    pointer.findElement(By.linkText("Proceed")).click();
	    
	    
	    pointer.findElement(By.linkText("Launch Popup Window")).click();
	    ArrayList windowlist = new ArrayList(pointer.getWindowHandles());
	    String window1=((String)windowlist.get(1));
	    pointer.switchTo().window(window1);
	    pointer.findElement(By.id("name")).sendKeys("KrishnaChauhan");
	    pointer.findElement(By.id("submit")).click();
	    String window2=((String)windowlist.get(0));
	    pointer.switchTo().window(window2);
	    pointer.findElement(By.linkText("Proceed")).click();
	    
	    
	    pointer.findElement(By.linkText("Generate Token")).click();
	    String token = pointer.findElement(By.id("token")).getText();
	    String tokenid= token.substring(7, token.length());
	    Cookie cookie = new Cookie("Token",tokenid);
	    pointer.manage().addCookie(cookie);
	    pointer.findElement(By.linkText("Proceed")).click();
	    
	    
  }
}
