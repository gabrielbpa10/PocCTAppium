package com.ctappium.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class MenuPage extends BasePage {

	private String form = "Formulário";
	private String sobre = "About...";
	
	public MenuPage(AndroidDriver<MobileElement> driver) {
		super(driver);
	}

	public AboutPage clicarOpcaoAbout() {
		super.scrollClick(sobre);
		return new AboutPage(super.driver);
	}

	public FormPage clickForm() {
		super.scrollClick(form);
		return new FormPage(super.driver);
	}
}
