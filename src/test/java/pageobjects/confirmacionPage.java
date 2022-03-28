package pageobjects;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import support.util;

import javax.sound.midi.Patch;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class confirmacionPage extends util
{
    @FindBy(xpath ="//*[text()='Order ID']//preceding::h2") protected WebElement lvlMensaje;
    @FindBy(xpath  ="//*[text()='Order ID']//following::strong[a]") protected WebElement lvlcodigo;

    public confirmacionPage(){
        PageFactory.initElements(driver, this);
    }
public void validarMensaje(String mensaje){
        wait.until(ExpectedConditions.visibilityOf(lvlMensaje));
        Assert.assertEquals(mensaje,lvlMensaje.getText());
}
public void mostrarCodigo(){
        System.out.println(lvlcodigo.getText());
}
public static void evidencias() throws IOException {
    Date fecha = new Date();
    SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyy_HHmmssSSS");
    String patch = "E:\\intellij proyect\\target";
    String nombre= formato.format(fecha)+"_evidencia.jpg";

    File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(file,new File(patch+nombre));
}
}
