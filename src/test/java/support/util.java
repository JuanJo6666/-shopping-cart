package support;

import definitions.hooks;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class util extends hooks {
    public static WebDriverWait wait;
    public static JavascriptExecutor js;

    public util() {
        wait = new WebDriverWait(driver,30);
        js= (JavascriptExecutor) driver;
    }
    public void ventanaActiva(){
        Set<String> identificadores =driver.getWindowHandles();
        for (String identificador : identificadores){
            driver.switchTo().window(identificador);
        }
    }
    public void ventanaInicial(){
        driver.close();
        driver.switchTo().window("");
    }
    public void scrollVertical(){
    js.executeScript("window.scrollBy(0,1000)");
        }
}
