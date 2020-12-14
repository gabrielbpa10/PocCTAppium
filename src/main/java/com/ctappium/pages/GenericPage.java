package com.ctappium.pages;

import com.ctappium.factory.FactoryDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class GenericPage {

	private AndroidDriver<MobileElement> driver;
	private AboutPage about;
	private MenuPage menu;
	private FormPage form;
	
	public void setDriver(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
	public AndroidDriver<MobileElement> getDriver(){
		return this.driver;
	}
	
	public void setAboutPage(AboutPage about) {
		this.about = about;
	}
	
	public AboutPage getAboutPage() {
		return this.about;
	}
	
	public void setMenuPage(MenuPage menu) {
		this.menu = menu;
	}
	
	public MenuPage getMenuPage() {
		return this.menu;
	}
	
	public void setFormPage(FormPage form) {
		this.form = form;
	}
	
	public FormPage getFormPage() {
		return this.form;
	}
}
