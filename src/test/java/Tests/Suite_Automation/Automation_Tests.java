package Tests.Suite_Automation;

import Baseclass.BaseClass;
import Helpers.RetryAnalyzer;
import Pages.Automation.Page_Comparation;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Automation_Tests extends BaseClass {

    String ClassName = "[" + getClass().getName() + "]: "; //Se usa para ordenar el reporte.


    //Descripcion: Ingresar a la pagina de Gadgetsnow para comparar-laptops
    @Test(groups = {"regression"}, description = "Ingresar a la pagina de Gadgetsnow para comparar-laptops", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test-01 Ingresar a la pagina de Gadgetsnow para comparar-laptops")
    public void test_IngresarHomePage() {
        Page_Comparation page_comparation = new Page_Comparation(driver);
        page_comparation.navigateToPageComparation();
        Assert.assertTrue(page_comparation.ValidatePageObject(), "No se pudo ingresar correctamente a Page Comparation");
    }

    //Descripcion: Comparar los articulos
    @Test(groups = {"regression"}, description = "Comparar los articulos", retryAnalyzer = RetryAnalyzer.class, priority = 1)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test-02 Comparar los articulos")
    public void test_Comparar() {
        Page_Comparation page_comparation = new Page_Comparation(driver);
        page_comparation.navigateToPageComparation();
        Assert.assertTrue(page_comparation.ValidatePageObject(), "No se pudo ingresar correctamente a Page Comparation");

        page_comparation.ingresoBusqueda();
        Assert.assertTrue(page_comparation.busquedaPrimerArticulo(), "No se pudo ingresar correctamente a Page Comparation");

        page_comparation.ingresoComparar();
        page_comparation.busquedaSegundoArticulo();


    }

}
