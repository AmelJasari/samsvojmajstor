package stepDefinitions;


import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LoginObjekti;
import pageObjects.NaslovnaObjekti;
import resources.base;

public class stepDefinitions extends base{
	
	
	
	
	@Given("^Inicijalizovan je driver$")
	public void inicijalizovan_je_driver() throws Throwable 
	{
	    
		driver =initializeDriver();
		 log.info("driver is initialized");
		
	    
	}

	@Given("^User je na pocetnoj strani \"([^\"]*)\"$")
	public void user_je_na_pocetnoj_strani(String arg1) throws Throwable 
	{
	    
		driver.get(arg1);
		 log.info("Pokrenuta stranica");
		
	}

	@Given("^Odabran je link za logovanje$")
	public void odabran_je_link_za_logovanje() throws Throwable
	{
		NaslovnaObjekti naslovna = new NaslovnaObjekti(driver);
		naslovna.PrijavaLink().click();
		 log.info("Prijava link je kliknut");
		
	}

	@When("^User se loguje na aplikaciju koristeci user \"([^\"]*)\" i password \"([^\"]*)\"$")
	public void user_se_loguje_na_aplikaciju_koristeci_user_i_password(String arg1, String arg2) throws Throwable
	{
		LoginObjekti login = new LoginObjekti(driver);
		login.KorisnickoImePolje().sendKeys(arg1);
		log.info("Unet je user");
		login.LozinkaPolje().sendKeys(arg2);
		log.info("Unet je password");
		login.PrijavaDugme().click();
		log.info("Klik na submit");	
		
	}

	@Then("^Verifikujemo da se pojavilo dugme Odjava$")
	public void verifikujemo_da_se_pojavilo_dugme_Odjava() throws Throwable
	{
		NaslovnaObjekti naslovna = new NaslovnaObjekti(driver);
		Assert.assertEquals(naslovna.OdjavaDugme().getText(), "Odjava");
		log.info("Verifikovano dugme Odjava");
		
	}

	@Then("^Odjavljujemo se sa stranice$")
	public void Odjavljujemo_se_sa_stranice() throws Throwable
	{
		NaslovnaObjekti naslovna = new NaslovnaObjekti(driver);
		naslovna.OdjavaDugme().click();
		log.info("Odjava");	

	}
	
	 @Then("^Prikazuje se poruka za neispravan login$")
	    public void prikazuje_se_poruka_za_neispravan_login() throws Throwable {
	       
		 LoginObjekti login = new LoginObjekti(driver);
		 login.ErrorMessage().getText();
		 
		 Assert.assertEquals(login.ErrorMessage().getText(), "Sorry, unrecognized username or password. Have you forgotten your password?");
		 
		 
	    }
	 
	 @When("^Negativni user se loguje na aplikaciju koristeci user (.+) i password (.+)$")
	    public void negativni_user_se_loguje_na_aplikaciju_koristeci_user_i_password(String username, String password) throws Throwable {
		 LoginObjekti login = new LoginObjekti(driver);
			login.KorisnickoImePolje().sendKeys(username);
			log.info("Unet je user");
			login.LozinkaPolje().sendKeys(password);
			log.info("Unet je password");
			login.PrijavaDugme().click();
			log.info("Klik na submit");	
	    }

	 @And("^Zatvaranje explorera$")
	    public void zatvaranje_explorera() throws Throwable {
		 driver.close();
	    }
}
