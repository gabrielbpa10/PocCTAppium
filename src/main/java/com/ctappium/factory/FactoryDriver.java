package com.ctappium.factory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.ctappium.pages.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class FactoryDriver {

	public static AndroidDriver<MobileElement> getDriver(){
		AndroidDriver <MobileElement> driver = null;
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "device");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability("appPackage", "com.ctappium");
		desiredCapabilities.setCapability("appActivity", "com.ctappium.MainActivity");
		//desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Usuario\\eclipse-workspace\\unifor-play\\src\\main\\resources\\unifor-mobile.apk");
		
		try {
			URL remoteUrl = new URL("http://localhost:4723/wd/hub");
			driver = new AndroidDriver<MobileElement>(remoteUrl,desiredCapabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
}
