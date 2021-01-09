package com.ctappium.pages;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class FormPage extends BasePage {
	
	private By idName = By.xpath("//*[@content-desc='nome']");
	private By idConsole = By.id("android:id/text1");
	private By idSeekBar = By.xpath("//*[@content-desc='slid']");
	private By idCheck = By.xpath("//*[@content-desc='check']");
	private By idSwitch = By.xpath("//*[@content-desc='switch']");
	private By idButtonOk = By.id("android:id/button1");
	private String textDate = "01/01/2000";
	private String textSave = "SALVAR";
	private String textSaveLong = "SALVAR DEMORADO";
	private By textName = By.xpath("//*[contains(@text,'Nome: ')]");
	
	public FormPage(AndroidDriver<MobileElement> driver) {
		super(driver);
	}

	public void checkFormScreen() {
		super.existeTexto("CT Appium");
	}
	
	public void writeName(String name) {
		super.escreverCampo(idName, name);
	}
	
	public void clickConsole() {
		super.click(idConsole);
	}
	
	public void clickConsoleOption(String console) {
		super.clickForText(console);
	}
	
	public void clickSeekBar(double tamanho) {
		super.clicarSeekBar(idSeekBar, tamanho);
	}
	
	public void clickCheck() {
		super.click(idCheck);
	}
	
	public void clickSwitch() {
		super.click(idSwitch);
	}
	
	public void clickDate() {
		super.clickForText(textDate);
	}
	
	public void clickDateOption(String date) {
		super.clickForText(date);
	}
	
	public void clickButtonOk() {
		super.click(idButtonOk);
	}
	
	public void clickButtonSave() {
		super.clickForText(textSave);
	}
	
	public void clickButtonSaveLong() {
		super.clickForText(textSaveLong);
	}
	
	public void waitLabelNome() {
		try {
			super.encontrarElementoEsperaExplicita(textName, 30);
		} catch (Exception e) {
			System.out.println("Erro: Lengthy request!");
		}
	}
	
	public void screenShot(String nameImage) {
		super.screenShot(nameImage);
	}
}
