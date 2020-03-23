package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NaslovnaObjekti {
	
	
	public WebDriver driver;
	
	private By Prijava =By.linkText("Prijava");
	private By headerTop = By.xpath("//*[@id=\"user-nav\"]");
	private By OdjavaDugme = By.linkText("Odjava");
	
	
	
		


	public NaslovnaObjekti(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}




	public WebElement PrijavaLink ()
	{
		return driver.findElement(Prijava);
		
	}
	
	public WebElement headerTopNav ()
	{
		return driver.findElement(headerTop);
		
	}

	public WebElement OdjavaDugme ()
	{
		return driver.findElement(OdjavaDugme);
		
	}
}

