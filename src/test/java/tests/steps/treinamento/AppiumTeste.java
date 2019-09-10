package tests.steps.treinamento;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumTeste {

	// Create instance for Appium Driver
	static AppiumDriver<WebElement> driver;

	@BeforeClass
	public static void Setup() throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 5X");
//		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "ASUS_X00DD");
//		cap.setCapability(MobileCapabilityType.UDID, "H4AXB601B016DZZ");
		cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		cap.setCapability(MobileCapabilityType.APP, "C:\\Users\\lsilferr\\AndroidStudioProjects\\SimpleText\\app\\build\\outputs\\apk\\debug\\app-debug.apk");
//		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator");
		cap.setCapability("platformName", "Android");
		cap.setCapability("appPackage", "com.teste.simpletext");
		cap.setCapability("avd", "Nexus_5X_API_29_x86");

		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);

	}

	@Test
	public void SimpleTest() {
		Assert.assertNotNull(driver.getContext());
	}
	@Test
	public void checkingNameApp() {
		WebElement e= driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView");
//		System.out.println(e.getText() );
		Assert.assertEquals(e.getText(), "SimpleText");
		
	}
	@Test
	public void checkingText() {
		WebElement e= driver.findElementById("tfHello");
//		System.out.println(e.getText() );
		Assert.assertEquals(e.getText(), "Hello World!");
	}
}
