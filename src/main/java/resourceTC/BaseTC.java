package resourceTC;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.LoginObjekti;
import pageObjects.NaslovnaObjekti;
import resources.base;

public class BaseTC extends base{
	
	
	public WebDriver driver;
	
	public BaseTC(WebDriver driver) {
		
		
		this.driver=driver;
	}
	
	
	public void LoginSmoke() throws IOException
	{
			
		NaslovnaObjekti naslovna = new NaslovnaObjekti(driver);
		
		
		naslovna.PrijavaLink().click();
		 log.info("Prijava link je kliknut");
				
		 LoginObjekti login = new LoginObjekti(driver); 
		
		login.KorisnickoImePolje().sendKeys(prop.getProperty("user"));
		log.info("Unet je user");
		login.LozinkaPolje().sendKeys(prop.getProperty("password"));
		log.info("Unet je password");
		login.PrijavaDugme().click();
		log.info("Klik na submit");		

	}
	
	public void LogOUT()
	{
		NaslovnaObjekti naslovna = new NaslovnaObjekti(driver);
		
		naslovna.OdjavaDugme().click();
		log.info("Odjava");	
	}

}
