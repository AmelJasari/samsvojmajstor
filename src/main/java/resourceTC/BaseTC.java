package resourceTC;

import java.io.IOException;

import pageObjects.LoginObjekti;
import pageObjects.NaslovnaObjekti;
import resources.base;

public class BaseTC extends base{
	
	
	NaslovnaObjekti naslovna = new NaslovnaObjekti(driver);
	LoginObjekti login = new LoginObjekti(driver);
	
	public void LoginSmoke() throws IOException
	{
			
		naslovna.PrijavaLink().click();
		 log.info("Prijava link je kliknut");
					
		login.KorisnickoImePolje().sendKeys(prop.getProperty("user"));
		 log.info("Unet je user");
		login.LozinkaPolje().sendKeys(prop.getProperty("password"));
		log.info("Unet je password");
		login.PrijavaDugme().click();
		log.info("Klik na submit");		

	}
	
	public void LogOUT()
	{
		naslovna.OdjavaDugme().click();
		log.info("Odjava");	
	}

}
