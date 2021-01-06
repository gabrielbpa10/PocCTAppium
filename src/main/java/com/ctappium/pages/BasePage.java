package com.ctappium.pages;


import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class BasePage {

	protected AndroidDriver<MobileElement> driver;

	public BasePage(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
	}

	protected MobileElement encontrarElemento(By by) {
		return this.driver.findElement(by);
	}

	protected MobileElement encontrarElementoEsperaExplicita(By by, int segundos) {
		WebDriverWait espera = new WebDriverWait(this.driver,segundos);
		espera.until(ExpectedConditions.presenceOfElementLocated(by));
		return this.driver.findElement(by);
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	protected boolean verificarElementoDesativado(By by,int segundos, int milisegundos) {
		try {
			@SuppressWarnings("rawtypes")
			Wait espera = new FluentWait(this.driver)
					.withTimeout(segundos, TimeUnit.SECONDS)
					.pollingEvery(milisegundos, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class)
					.ignoring(TimeoutException.class);
		
		return  Boolean.parseBoolean((String) espera.until(ExpectedConditions.invisibilityOf(this.encontrarElemento(by))));
		} catch (Exception e) {
			return true;
		}
		
	}
	
	protected void click(By by) {
		encontrarElemento(by).click();
	}

	protected void clickForText(String texto) {
		encontrarElementoPorTexto(texto).click();
	}

	protected void escreverCampo(By by, String texto) {
		encontrarElemento(by).sendKeys(texto);
	}

	protected List<MobileElement> encontrarElementos(By by) {
		return this.driver.findElements(by);
	}

	protected MobileElement encontrarElementoPorTexto(String texto) {
		return this.encontrarElemento(By.xpath("//*[@text = '" + texto + "']"));
	}

	protected String retornarAtributoAndroid(By by, String atributo) {
		return this.encontrarElemento(by).getAttribute(atributo);
	}
	
	protected Boolean existeTexto(String texto) {
		return this.encontrarElementoPorTexto(texto).getText() != null ? Boolean.TRUE : Boolean.FALSE;
	}

	protected String retornarTexto(By by) {
		return this.encontrarElemento(by).getText();
	}

	protected void esperar(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("rawtypes")
	protected void scroll(double inicio, double fim) {
		Dimension size = this.driver.manage().window().getSize();
		int x =  size.width/2;
		int y_inicio = (int) (size.height * inicio);
		int y_fim = (int) (size.height * fim);
		
		new TouchAction(this.driver)
		.press(PointOption.point(x, y_inicio))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
		.moveTo(PointOption.point(x, y_fim))
		.release()
		.perform();
		
	}
	
	protected String scrollText(String texto) {
		return driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
				+ "new UiSelector().text(\""+texto+"\"));")).getText();
	}
	
	protected String scrollTextNoScrollable(String texto) {
		return driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView("
				+ "new UiSelector().text(\""+texto+"\"));")).getText();
	}
	
	protected String scrollIdView(String texto, String id) {
		return driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)" +
				".resourceId(\""+ id +"\"))"+
				".scrollIntoView("+
				 "new UiSelector().text(\""+texto+"\"));")).getText();
	}
	
	protected void scrollClick(String texto) {
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
				+ "new UiSelector().text(\""+texto+"\"));")).click();
	}
	
	protected boolean verificarElementoAtivado(By by) {
		return this.encontrarElemento(by).isEnabled();
	}
	
	protected boolean verificarElementoAtividadoEsperaExplicita(By by, int segundos) {
		return this.encontrarElementoEsperaExplicita(by,segundos).isEnabled();
	}
	
	protected void clicarSeekBar(By by, double tamanho) {
		MobileElement seek = this.encontrarElemento(by);
		int y = seek.getLocation().y + (seek.getSize().height/2);
		int x = (int) (seek.getLocation().x + seek.getSize().width * tamanho);
		
		System.out.println("Posição Inicial do X: " + seek.getLocation().x);
		System.out.println("Comprimento da barra: " + seek.getSize().width);
		
		this.tap(x,y);
	}

	@SuppressWarnings("rawtypes")
	private void tap(int x, int y) {
		 new TouchAction (this.driver).tap(PointOption.point(x, y)).perform();
	}
}
