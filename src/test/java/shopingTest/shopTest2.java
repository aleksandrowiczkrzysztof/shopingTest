package shopingTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class shopTest2 {
	private WebDriver driver;

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
	}

/*	@Test
	public void test() {
		UtilsShop.logowanie(driver);
		UtilsShop.naWomen(driver);
		UtilsShop.rozmiarS(driver);
		UtilsShop.waitForAjax(driver);
		UtilsShop.naCzerwona(driver);
		UtilsShop.addToChart(driver);
		UtilsShop.waitForAjax(driver);
		UtilsShop.proceed(driver);
		UtilsShop.liczkwote(driver);
		UtilsShop.liczkwote2(driver);
		UtilsShop.liczkwote(driver);
		UtilsShop.liczkwote2(driver);
		
		assertEquals(UtilsShop.liczkwote(driver), UtilsShop.liczkwote2(driver),2);
	}*/
	@Test

	public void test() {
		UtilsShop.logowanie(driver);
		for (int i = 1; i <3; i++) {
		UtilsShop.naWomen(driver);
		UtilsShop.rozmiarS(driver);
		UtilsShop.waitForAjax(driver);
		UtilsShop.naCzerwona(driver, i);
		UtilsShop.addToChart(driver);
		UtilsShop.waitForAjax(driver);
		UtilsShop.proceed(driver);
		UtilsShop.liczkwote(driver);
		UtilsShop.liczTotalPrice(driver);
		}
	
		
		assertEquals(UtilsShop.zliczWszystkieKwotySukienek(driver), UtilsShop.liczTotalPrice(driver),2);
/*		double cenaProduktu = zakupyUtil.cenaPierwszegoProduktu(driver);
		double total = zakupyUtil.totalsum(driver);
		assertEquals(total, cenaProduktu,2);*/
}
}
