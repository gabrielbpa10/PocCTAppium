package com.ctappium.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AboutPage extends BasePage{

	private String versao = "Versão 1.1";
	private String veja_o_curso_aqui = "Veja o curso aqui";
	
	public AboutPage(AndroidDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public boolean verificarVersão() {
		return super.existeTexto(versao);
	}
	
	public void verificarAcessoTela() {
		 super.existeTexto(veja_o_curso_aqui);
	}
	
}
