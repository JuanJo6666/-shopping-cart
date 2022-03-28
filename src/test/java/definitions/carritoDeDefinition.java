package definitions;

import io.cucumber.java.es.*;
import pageobjects.*;

import java.io.IOException;

import static pageobjects.confirmacionPage.evidencias;

public class carritoDeDefinition {
    menuPage menu;
    tarjetaPage tarjeta;
    carritoPage carrito;
    pagoPage pago;
    confirmacionPage confirmacion;

    public carritoDeDefinition() {
        menu = new menuPage();
        tarjeta = new tarjetaPage();
        carrito = new carritoPage();
        pago =new pagoPage();
        confirmacion = new confirmacionPage();
    }

    @Dado("que la web esta operativa")
    public void queLaWebEstaOperativa() {
        hooks.driver.get("https://demo.guru99.com/payment-gateway/purchasetoy.php");
    }

    @Cuando("se genera el numero de tarjeta")
    public void seGeneraElNueroDeTarjeta() throws IOException {
        menu.clickGenerarTarjeta();
        menu.ventanaActiva();
        tarjeta.obtenerNroTarjeta();
        tarjeta.obtenerCVV();
        tarjeta.obtenerFecha();
        evidencias();
        tarjeta.ventanaInicial();

    }
    @Y("selecciona la cantidad {string}")
  public void seleccionaLaCantidad(String cant){

        carrito.seleccionarCantidad(cant);
    }
    @Y("realiza la compra del producto")
    public void realizaLaCompraDelProducto() throws IOException {
        carrito.clickComprar();
        evidencias();
    }
    @E("ingresa los datos de la tarjeta")
    public void ingresaLosDatosDeLaTarjeta() throws IOException {
        pago.escribirNroTarjeta(tarjetaPage.nro_tarjeta);
        pago.seleccionarMes(tarjetaPage.mes);
        pago.seleccionarAnio(tarjetaPage.anio);
        pago.escribirCVV(tarjetaPage.cvv);
        evidencias();

    }
    @Y("paga el producto")
    public void pagaElProducto() {
        pago.scrollVertical();
        pago.clickPagar();

    }
    @Entonces("validar el mensaje de pago {string}")
    public void validarElMensajeDePago(String mensaje) throws IOException {
        confirmacion.validarMensaje(mensaje);
        evidencias();
        confirmacion.mostrarCodigo();
    }

}