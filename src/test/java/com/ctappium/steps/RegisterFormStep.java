package com.ctappium.steps;

import static org.junit.Assert.assertEquals;
import com.ctappium.pages.GenericPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterFormStep {

	private GenericPage generic;
	private String name;
	
	public RegisterFormStep(GenericPage generic) {
		this.generic = generic;
	}

	@When("to acess the form screen")
	public void to_acess_the_form_screen() {
		generic.setFormPage(generic.getMenuPage().clickForm());
		generic.getFormPage().checkFormScreen();
	}

	@And("to register all datas: {string} {string} {string} {string}")
	public void to_register_all_datas(String name, String console, String slider, String date) {
		this.name = name;
		
		generic.getFormPage().writeName(name);
		generic.getFormPage().clickConsole();
		generic.getFormPage().clickConsoleOption(console);
		generic.getFormPage().clickCheck();
		generic.getFormPage().clickSeekBar(Double.parseDouble(slider));
		generic.getFormPage().clickSwitch();
		generic.getFormPage().clickDate();
		generic.getFormPage().clickDateOption(date);
		generic.getFormPage().clickButtonOk();
		
	}

	@And("to click the button to save")
	public void to_click_the_button_to_save() {
		generic.getFormPage().clickButtonSave();
	}
	
	@And("to click the long button to save")
	public void to_click_the_long_button_to_save() {
		generic.getFormPage().clickButtonSaveLong();
		generic.getFormPage().waitLabelNome();
	}

	@Then("will go to provide the dates, saved")
	public void will_go_to_provide_the_dates_saved() {
		assertEquals("Nome: Gabriel", "Nome: " + name);
	}

	@After (value="@tela_formulario")
	public void quitDriver() {
		generic.getDriver().quit();
	}
}
