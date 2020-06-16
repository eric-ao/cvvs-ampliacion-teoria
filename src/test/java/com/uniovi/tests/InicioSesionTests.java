package com.uniovi.tests;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.uniovi.tests.pageobjects.PO_HomeView;
import com.uniovi.tests.pageobjects.PO_LoginView;
import com.uniovi.tests.util.SeleniumUtils;

import org.junit.runners.MethodSorters;

//Ordenamos las pruebas por el nombre del metodo.
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InicioSesionTests {
	
	//En Windows (Debe ser la versión 65.0.1 y desactivar las actualizacioens automáticas)):
	static String PathFirefox65 = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
	static String Geckdriver024 = "C:\\Users\\Usuario\\Desktop\\SDI Pruebas para CVVS\\cvvs-ampliacion-teoria\\material\\geckodriver024win64.exe";
	//Común a Windows y a MACOSX
	static WebDriver driver = getDriver(PathFirefox65, Geckdriver024);
	static String URL = "http://localhost:8090";
	
	public static WebDriver getDriver(String PathFirefox, String Geckdriver) {
	System.setProperty("webdriver.firefox.bin", PathFirefox);
	System.setProperty("webdriver.gecko.driver", Geckdriver);
	WebDriver driver = new FirefoxDriver();
	return driver;
	}
	
	// Antes de cada prueba se navega al URL home de la aplicaciónn
	@Before
	public void setUp() {
		driver.navigate().to(URL);
	}

	// Después de cada prueba se borran las cookies del navegador
	@After
	public void tearDown() {
		driver.manage().deleteAllCookies();
	}

	// Antes de la primera prueba
	@BeforeClass
	static public void begin() {
	}

	// Al finalizar la última prueba
	@AfterClass
	static public void end() {
		// Cerramos el navegador al finalizar las pruebas
		driver.quit();
	}

	
	
	
	
	
	
	
	
	

	//1. REGISTRARSE COMO USUARIO.
	//CP00. Inicio de sesión correcto.
	@Test
	public void CP00() {
		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
		
		PO_LoginView.fillForm(driver, "test@mail.com", "Pass_123");
		
		SeleniumUtils.textoPresentePagina(driver, "Usuarios");
	}
	
	// CP01. Inicio de sesión. Email no registrado.
	@Test
	public void CP01() {
		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");

		PO_LoginView.fillForm(driver, "emailnoregistrado@mail.com", "Pass_123");

		SeleniumUtils.textoNoPresentePagina(driver, "Usuarios");
	}
	
	// CP02. Inicio de sesión. Email mal formateado.
	@Test
	public void CP02() {
		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");

		PO_LoginView.fillForm(driver, "test@mail,com", "Pass_123");

		SeleniumUtils.textoNoPresentePagina(driver, "Usuarios");
	}

	// CP03. Inicio de sesión. Contraseña incorrecta
	@Test
	public void CP03() {
		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");

		PO_LoginView.fillForm(driver, "test@mail.com", "Pass_456");

		SeleniumUtils.textoNoPresentePagina(driver, "Usuarios");
	}
}