package Academy.samsvojmajstor;

import static org.testng.Assert.assertEquals;

import java.io.IOException;import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginObjekti;
import pageObjects.NaslovnaObjekti;
import resources.base;


public class Naslovna extends base {
	//inheritance concept
	//extends base - sve metode koje su u base klasi moci ce da se koriste ovde
	//na primer inicijalizovali smo driver
	
	//drugi nacin je da se kreira object iz te klase
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();
		 

	}

	
	@Test(dataProvider = "GetData")
	public void LoginNegativni( String KorisnickoImePolje, String LozinkaPolje) throws IOException
	{
		driver.get(prop.getProperty("URL"));	
		NaslovnaObjekti naslovna = new NaslovnaObjekti(driver);
		LoginObjekti login = new LoginObjekti(driver);
			
		naslovna.PrijavaLink().click();
		login.KorisnickoImePolje().sendKeys(KorisnickoImePolje);
		login.LozinkaPolje().sendKeys(LozinkaPolje);
		login.PrijavaDugme().click();
		
			
		//driver.close();

	}
	
	@DataProvider
	public Object[][] GetData() {
		
		//[red][kolona]
		//red je koliko kombinacija imamo
		//kolona je koliko vrednosti unosimo, na primer username i pass su dve vrednosti
				
		
		
				Object[][] data = new Object[2][2];
				//0tf red prazan user
				data[0][0]  = "";
				data[0][1] = "passAmel";
				
				//1st prazan pass
				data[1][0]  = "usrnameMarko";
				data[1][1] = "";
				
			
						
				return data;
		
	}

	@AfterTest
	public void close()
	{
		driver.close();
		driver=null;
	}

}
