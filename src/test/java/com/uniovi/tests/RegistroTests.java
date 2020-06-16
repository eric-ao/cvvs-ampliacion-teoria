package com.uniovi.tests;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.uniovi.tests.pageobjects.PO_HomeView;
import com.uniovi.tests.pageobjects.PO_RegisterView;
import com.uniovi.tests.util.SeleniumUtils;

import org.junit.runners.MethodSorters;

//Ordenamos las pruebas por el nombre del metodo.
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegistroTests {
	
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
	//CP00. Registro de usuario con datos válidos.
	@Test
	public void CP00() {
		PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");
		
		PO_RegisterView.fillForm(driver, "test@mail.com", "TestAcc", "Account", "Pass_123", "Pass_123");
		
		SeleniumUtils.textoPresentePagina(driver, "Bienvenidos a la pagina principal");
	}
	
	// CP01. Registro de usuario con email repetido.
	@Test
	public void CP01() {
		PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");

		PO_RegisterView.fillForm(driver, "test@mail.com", "TestAcc", "Account", "Pass_123", "Pass_123");

		SeleniumUtils.textoNoPresentePagina(driver, "Bienvenidos a la pagina principal");
	}
	
	// CP02. Registro de usuario con email corto.
	@Test
	public void CP02() {
		PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");

		PO_RegisterView.fillForm(driver, "t@m", "TestAcc", "Account", "Pass_123", "Pass_123");

		SeleniumUtils.textoNoPresentePagina(driver, "Bienvenidos a la pagina principal");
	}

	// CP03. Registro de usuario con email largo.
	@Test
	public void CP03() {
		PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");

		PO_RegisterView.fillForm(driver, "emailmuylargotienequetenermasdeveinticuatrocaracteres@mail.com", "TestAcc", "Account", "Pass_123", "Pass_123");

		SeleniumUtils.textoNoPresentePagina(driver, "Bienvenidos a la pagina principal");
	}

	// CP04. Registro de usuario con email mal formateado.
	@Test
	public void CP04() {
		PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");

		PO_RegisterView.fillForm(driver, "emailmalformateado", "TestAcc", "Account", "Pass_123", "Pass_123");

		SeleniumUtils.textoNoPresentePagina(driver, "Bienvenidos a la pagina principal");
	}

	// CP05. Registro de usuario con email vacío.
	@Test
	public void CP05() {
		PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");

		PO_RegisterView.fillForm(driver, " ", "TestAcc", "Account", "Pass_123", "Pass_123");

		SeleniumUtils.textoNoPresentePagina(driver, "Bienvenidos a la pagina principal");
	}

	// CP06. Registro de usuario con nombre corto.
	@Test
	public void CP06() {
		PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");

		PO_RegisterView.fillForm(driver, "CP06@mail.com", "Eric", "Account", "Pass_123", "Pass_123");

		SeleniumUtils.textoNoPresentePagina(driver, "Bienvenidos a la pagina principal");
	}

	// CP07. Registro de usuario con nombre largo.
	@Test
	public void CP07() {
		PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");

		PO_RegisterView.fillForm(driver, "CP07@mail.com", "Este nombre tiene que ser muy largo tiene que contener mas de veinticuatro caracteres", "Account", "Pass_123", "Pass_123");

		SeleniumUtils.textoNoPresentePagina(driver, "Bienvenidos a la pagina principal");
	}

	// CP08. Registro de usuario con nombre mal formateado.
	@Test
	public void CP08() {
		PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");

		PO_RegisterView.fillForm(driver, "CP08@mail.com", "¿Eric?", "Account", "Pass_123", "Pass_123");

		SeleniumUtils.textoNoPresentePagina(driver, "Bienvenidos a la pagina principal");
	}

	// CP09. Registro de usuario con nombre vacío.
	@Test
	public void CP09() {
		PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");

		PO_RegisterView.fillForm(driver, "CP09@mail.com", " ", "Account", "Pass_123", "Pass_123");

		SeleniumUtils.textoNoPresentePagina(driver, "Bienvenidos a la pagina principal");
	}	
	
	// CP10. Registro de usuario con apellido corto.
	@Test
	public void CP10() {
		PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");

		PO_RegisterView.fillForm(driver, "CP10@mail.com", "TestAcc", "apel", "Pass_123", "Pass_123");

		SeleniumUtils.textoNoPresentePagina(driver, "Bienvenidos a la pagina principal");
	}

	// CP11. Registro de usuario con apellido largo.
	@Test
	public void CP11() {
		PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");

		PO_RegisterView.fillForm(driver, "CP11@mail.com", "TestAcc", "Este apellido es demasiado largo tiene que contener al menos veinticuatro caracteres", "Pass_123", "Pass_123");

		SeleniumUtils.textoNoPresentePagina(driver, "Bienvenidos a la pagina principal");
	}

	// CP12. Registro de usuario con apellido mal formateado.
	@Test
	public void CP12() {
		PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");

		PO_RegisterView.fillForm(driver, "CP12@mail.com", "TestAcc", "¿Apellido?", "Pass_123", "Pass_123");

		SeleniumUtils.textoNoPresentePagina(driver, "Bienvenidos a la pagina principal");
	}

	// CP13. Registro de usuario con apellido vacío.
	@Test
	public void CP13() {
		PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");

		PO_RegisterView.fillForm(driver, "CP13@mail.com", "TestAcc", " ", "Pass_123", "Pass_123");

		SeleniumUtils.textoNoPresentePagina(driver, "Bienvenidos a la pagina principal");
	}

	// CP14. Registro de usuario con contraseña corta.
	@Test
	public void CP14() {
		PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");

		PO_RegisterView.fillForm(driver, "CP14@mail.com", "TestAcc", "Account", "123", "123");

		SeleniumUtils.textoNoPresentePagina(driver, "Bienvenidos a la pagina principal");
	}

	// CP15. Registro de usuario con contraseña larga.
	@Test
	public void CP15() {
		PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");

		PO_RegisterView.fillForm(driver, "CP15@mail.com", "TestAcc", "Account", "Esta contraseña es demasiado larga tiene que contener al menos veinticuatro caracteres", "Esta contraseña es demasiado larga tiene que contener al menos veinticuatro caracteres");

		SeleniumUtils.textoNoPresentePagina(driver, "Bienvenidos a la pagina principal");
	}

	// CP16. Registro de usuario con contraseña insegura.
	@Test
	public void CP16() {
		PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");

		PO_RegisterView.fillForm(driver, "CP16@mail.com", "TestAcc", "Account", "12345", "12345");

		SeleniumUtils.textoNoPresentePagina(driver, "Bienvenidos a la pagina principal");
	}

	// CP17. Registro de usuario con contraseña vacía.
	@Test
	public void CP17() {
		PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");

		PO_RegisterView.fillForm(driver, "CP17@mail.com", "TestAcc", "Account", " ", " ");

		SeleniumUtils.textoNoPresentePagina(driver, "Bienvenidos a la pagina principal");
	}

	// CP18. Registro de usuario con contraseña distinta.
	@Test
	public void CP18() {
		PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");

		PO_RegisterView.fillForm(driver, "CP18@mail.com", "TestAcc", "Account", "Pass_123", "Pass_456");

		SeleniumUtils.textoNoPresentePagina(driver, "Bienvenidos a la pagina principal");
	}
}