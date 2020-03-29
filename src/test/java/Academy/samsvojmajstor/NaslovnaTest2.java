package Academy.samsvojmajstor;

import static org.testng.Assert.assertEquals;

import java.io.IOException;import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageObjects.LoginObjekti;
import pageObjects.NaslovnaObjekti;
import resourceTC.BaseTC;
import resources.base;

//extends base = inheritance
public class NaslovnaTest2 extends base {
	//inheritance concept
	//extends base - sve metode koje su u base klasi moci ce da se koriste ovde
	//na primer inicijalizovali smo driver
	//drugi nacin je da se kreira object iz te klase
	
	
	NaslovnaObjekti naslovna = new NaslovnaObjekti(driver);
	LoginObjekti login = new LoginObjekti(driver);
	
	
	BaseTC baseTC = new BaseTC(driver);
	
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	
	
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();
		 log.info("driver is initialized");
	
		 driver.get(prop.getProperty("URL"));
		 log.info("Pokrenuta stranica");
		 

	}
	
	
	@Test
	public void Login() throws IOException
	{	
		
		NaslovnaObjekti naslovna = new NaslovnaObjekti(driver);
		LoginObjekti login = new LoginObjekti(driver);
		
				
		
		naslovna.PrijavaLink().click();
		 log.info("Prijava link je kliknut");
					
		login.KorisnickoImePolje().sendKeys(prop.getProperty("user"));
		log.info("Unet je user");
		login.LozinkaPolje().sendKeys(prop.getProperty("password"));
		log.info("Unet je password");
		login.PrijavaDugme().click();
		log.info("Klik na submit");	
			
		
		//baseTC.LoginSmoke();

	}
	
	@Test
	public void Verifikacija() throws IOException
	{		
		NaslovnaObjekti naslovna = new NaslovnaObjekti(driver);
		
				//verifikacija da se uhvati scrShot na test fail
				Assert.assertEquals(naslovna.OdjavaDugme().getText(), "Odjava");
				log.info("Verifikovano dugme Odjava");

	}
	
	@Test
	public void Odjava()
	{
		
		NaslovnaObjekti naslovna = new NaslovnaObjekti(driver);
		
		naslovna.OdjavaDugme().click();
		log.info("Odjava");	
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		driver=null;
	}
}
