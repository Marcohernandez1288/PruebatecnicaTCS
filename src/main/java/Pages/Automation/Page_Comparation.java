package Pages.Automation;

import Helpers.Helpers;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Page_Comparation {

    public WebDriver driver; //Declaro Objeto Driver.
    public Helpers helpers;

    public Page_Comparation(WebDriver driver) {  //Metodo Constructor de la Clase.
        this.driver = driver;
        helpers = new Helpers(driver);
    }

    /**
     * ---------------------------------------------------------------------------------------------------------
     * WebElements // WebElements // WebElements // WebElements // WebElements // WebElements // WebElements //
     * ---------------------------------------------------------------------------------------------------------
     */
    //Elements Locators
    public By tagCompareLaptop = By.xpath("//h1[@class='_24YRq'][contains(.,'Compare Laptops')]");
    public By imputBuscar = By.xpath("//input[contains(@id,'search_input')]");
    public By btnBuscar = By.xpath("//li[contains(.,'lenovo E41-80 (80QAA01FIH) Laptop (Pentium Dual Core/2 GB/500 GB/DOS)')]");
    public By tagLenovoE41 = By.xpath("//h1[@class='_24YRq _1zr71'][contains(.,'lenovo E41-80 Laptop (Pentium Dual Core/2 GB/500 GB/DOS) - 80QAA01FIH')]");
    public By btnComparar = By.xpath("//span[contains(.,'Compare')]");
    public By ingresoCompararPrimeraLaoptop = By.xpath("//h6[contains(.,'lenovo E41-80 (80QAA01FIH) Laptop (Pentium Dual Core/2 GB/500 GB/DOS)')]");
    public By btnBuscarPortatiles = By.xpath("(//span[@class='_1WJ4c'][contains(.,'Select Laptops')])[1]");
    public By imputBuscarPortatiles = By.xpath("//input[contains(@placeholder,'Search Laptops')]");
    public By listBuscar = By.xpath("(//span[contains(.,'Lenovo B40-80 (80LS0018US) Laptop (Core i3 5th Gen/4 GB/500 GB/Windows 10)')])[2]");
    public By tagLenovoB40 = By.xpath("//h2[@class='_24YRq aBeyq'][contains(.,'Specifications')]");


    /**
     * -----------------------------------------------------------------------------------------------------------
     * Funciones // Funciones //  Funciones //  Funciones //  Funciones //  Funciones //  Funciones //  Funciones
     * -----------------------------------------------------------------------------------------------------------
     */

    @Step("Page_Comparation: Go to Url")
    public void navigateToPageComparation() {
        helpers.navigateTOUrl(helpers.GetSelectedenvironment());
        helpers.TakeScreenshot2("IngresoCorrectoPage_Comparation");
    }


    @Step("Page_Comparation: Validate getting the correct page")
    public boolean ValidatePageObject() {
        System.out.println("Page_Comparation: El objeto de la pagina es valido");
        return helpers.explicitWait_PresenceOfElementDisplayed(tagCompareLaptop);

    }

   @Step("Page_Comparation: Search the first article to compare")
   public void ingresoBusqueda(){
        helpers.sendText(imputBuscar,"LENOVO E41-80");
        helpers.ClickForJS(btnBuscar);

  }
   @Step("Page_Comparation: Validate search the first article to compare")
  public boolean busquedaPrimerArticulo (){
    try{
          helpers.explicitWait_visibilityOfElementLocated(tagLenovoE41);
          helpers.TakeScreenshot2("lenovo e41-80");
        return true;
        } catch (Exception e){
            System.err.println(e);
            return false;
        }
    }

    @Step("Page_Wikipedia: Ingresar a Comparar")
    public void ingresoComparar (){
       helpers.scrollDownToElement(driver.findElement(btnComparar));
       helpers.TakeScreenshot2("Comparar primer Articulo");
       helpers.ClickForJS(btnComparar);
       helpers.explicitWait_PresenceOfElementDisplayed(ingresoCompararPrimeraLaoptop);

    }

    @Step("Page_Comparation: Busqueda de segundo articulo a comparar")
    public void busquedaSegundoArticulo(){
        helpers.scrollDownToElement(driver.findElement(btnBuscarPortatiles));
        helpers.ClickForJS(btnBuscarPortatiles);
        helpers.sendText(imputBuscarPortatiles,"Lenovo B40-80");
        helpers.explicitWait_PresenceOfElementDisplayed(listBuscar);
        helpers.ClickForJS(listBuscar);
        helpers.scrollDownToElement(driver.findElement(tagLenovoB40));
        helpers.SleepSeconds(5);

    }

}
