package shopingTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.AssertionFailedError;

public class napisyTest {

	@Test
	public void czyCiagZnakowMaDlugoscCztery() {
		String nazwa = "lawa";
		nazwa.length();

		assertEquals(4, nazwa.length());
	}

	@Test
	public void CzyWyrazZaczynaSieOdLiteryT() {
		String nazwa2 = "trawa";
		String zmienna = nazwa2.substring(0, 1);
		assertEquals("t", zmienna);

	}

	@Test
	public void czyOstatnieDwieLiteryWnapisieToNa() {
		String nazwa3 = "maniana";
		String zmienna = nazwa3.substring(5);
		assertEquals("na", zmienna);
	}

	@Test
	public void czySlowoZawieraLitereK() {
		String slowo = "ksiazka";
		assertEquals(true, slowo.contains("k"));
	}

	@Test
	public void czySlowoZawieraLitereMa() {
		String slowo = "mama";
		assertEquals(true, slowo.contains("ma"));
	}

	@Test
	public void czSlowoRozpoczynaSieNaLitereMak() {
		String slowo = "makaron";
		String zmienna = slowo.substring(0, 3);
		assertEquals(true, zmienna.contains("mak"));
	}

	@Test
	public void zliczIleRazyWystepujeLiteraA() {
		String slowo = "kaszka";
		int licznik = 0;
		for (Character znak : slowo.toCharArray()) {
			if (znak.charValue() == 'a') {
				licznik++;
			}
		}
		assertEquals(2, licznik);
	}

	@Test
	public void czyPodanyNapisZawieraLiczbe21() {
		String cena = "$21";
		String liczbaString = cena.substring(1);
		int liczba = Integer.parseInt(liczbaString);
		assertEquals(21, liczba);
	}

	@Test
	public void czyPodanyNapisZawieraLiczbe13() {
		String cena = "cena: 13.12 zl";
		String liczbaString = cena.substring(6, 11);
		double liczba = Double.parseDouble(liczbaString);
		assertEquals(13.12, liczba, 2);
	}
	@Test
	public void czyPodanyNapisZawieraLiczbe13v2() {
		String cena = "cena: 113.12zl";
		int indexDwukropek = cena.indexOf(":");
		int indexZ = cena.indexOf("z");
		String liczbaString = cena.substring(indexDwukropek+2, indexZ);
		double liczba = Double.parseDouble(liczbaString);
		assertEquals(13.12, liczba, 2);
	
}
}