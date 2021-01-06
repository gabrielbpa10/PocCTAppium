package com.ctappium.steps;

import com.ctappium.factory.FactoryDriver;
import com.ctappium.pages.GenericPage;
import com.ctappium.pages.MenuPage;
import io.cucumber.java.en.Given;

public class AcessMenuStep {

	private GenericPage generic;
	
	public AcessMenuStep(GenericPage generic) {
		this.generic = generic;
	}
	
	@Given("the acess to Menu")
	public void the_acess_to_Menu() {
		generic.setDriver(FactoryDriver.getDriver());
		generic.setMenuPage(new MenuPage(generic.getDriver()));
	}
}
