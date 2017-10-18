package shopingTest;

import java.util.List;

import org.hamcrest.core.SubstringMatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilsShop {
	public static void kliniecielogowania(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));
		element.click();
	}

	public static void logowanie(WebDriver driver) {
		kliniecielogowania(driver);
		WebElement email = driver.findElement(By.xpath("//*[@id=\"email\"]"));
		email.sendKeys("b2bnetworkwarszawa@gmail.com");
		WebElement haslo = driver.findElement(By.xpath("//*[@id=\"passwd\"]"));
		haslo.sendKeys("n3tw0rk2017");
		WebElement submit = driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span"));
		submit.click();
	}

	public static void naWomen(WebDriver driver) {
		WebElement woman = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a"));
		woman.click();
	}

	public static void naCzerwona(WebDriver driver, int nrObrazka) {
		WebElement czerwona = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li["+nrObrazka+"]/div/div[1]/div/a[1]"));
		czerwona.click();
	}

	public static void addToChart(WebDriver driver) {
		WebElement addToChart = driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span"));
		addToChart.click();
	}

	public static void proceed(WebDriver driver) {
		WebElement proceed = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span"));
		proceed.click();
	}
	public static void rozmiarS(WebDriver driver) {
		WebElement rozmiarS = driver.findElement(By.xpath("//*[@id=\"uniform-layered_id_attribute_group_1\"]/span"));
		rozmiarS.click();
	}
	public static double liczkwote(WebDriver driver) {
		WebElement kwota = driver.findElement(By.xpath("//*[@id=\"product_1_1_0_31337\"]/td[4]"));
		String cena = kwota.getText().substring(1);
		
				return Double.parseDouble(cena);
	}
	public static double liczTotalPrice(WebDriver driver) {
		WebElement kwota = driver.findElement(By.xpath("//*[@id=\"total_product\"]"));
		String cena = kwota.getText().substring(1);
		return Double.parseDouble(cena);
	}
	public static double zliczWszystkieKwotySukienek(WebDriver driver) {
		WebElement tabela = driver.findElement(By.xpath("//*[@id=\"cart_summary\"]/tbody"));
		List<WebElement> trki = tabela.findElements(By.tagName("tr"));////*[@id="cart_summary"]/tbody
		double suma = 0;
		for(WebElement tr : trki ) {
			List<WebElement> tede = tr.findElements(By.tagName("td"));
			tede.get(5);
			WebElement cena = tede.get(5);
			String cenaString = cena.getText().substring(1);
			suma = suma + Double.parseDouble(cenaString);
			System.out.println(suma);
		}
			return suma;
			
		}

	public static boolean waitForAjax(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 30);

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {

			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
				} catch (Exception e) {

					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};

		return wait.until(jQueryLoad) && wait.until(jsLoad);
	}
}
