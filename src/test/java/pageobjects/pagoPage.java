package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import support.util;

public class pagoPage extends util {
    @FindBy(id = "card_nmuber") protected WebElement txttarjeta;
    @FindBy(id = "month") protected WebElement cmbmes;
    @FindBy(id = "card_year") protected WebElement cmbanio;
    @FindBy(id = "cvv_code") protected WebElement txtcvv;
    @FindBy(name = "submit") protected WebElement btnpagar;

    public pagoPage() {
        PageFactory.initElements(driver, this);
    }

    public void escribirNroTarjeta(String texto) {
        wait.until(ExpectedConditions.visibilityOf(txttarjeta));
        txttarjeta.sendKeys(texto);
    }

    public void seleccionarMes(String mes) {
        new Select(cmbmes).selectByVisibleText(mes);
    }

    public void seleccionarAnio(String anio) {
        new Select(cmbanio).selectByVisibleText(anio);

    }
    public void escribirCVV(String texto){
        txtcvv.sendKeys(texto);
    }
    public void clickPagar(){
        btnpagar.click();
    }
    }