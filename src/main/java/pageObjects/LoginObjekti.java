package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginObjekti {

	
	//encapsulation
	//napraviti samo metode public, a varijable private( u ovom slucaju lokatori) i mogu se koristiti samo u klasi
	//private instance variable and public methods
	
	public WebDriver driver;
	private By KorisnickoIme=By.xpath("//*[@id='edit-name']");
	private By Lozinka=By.id("edit-pass");
	private By Prijava=By.id("edit-submit");
	private By NegativnaPoruka = By.xpath("//div[@class='messages error']");
	
	
	
	
	

	public LoginObjekti(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}


	public WebElement KorisnickoImePolje ()
	{
		return driver.findElement(KorisnickoIme);
	}
	
	public WebElement LozinkaPolje ()
	{
		return driver.findElement(Lozinka);
	}
	
	public WebElement PrijavaDugme ()
	{
		return driver.findElement(Prijava);
	}
	
	public WebElement ErrorMessage ()
	{
		return driver.findElement(NegativnaPoruka);
		
		//Sorry, unrecognized username or password
	}
	
	

}
