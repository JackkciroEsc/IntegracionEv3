package LoginFuncionesAlternativas;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.By;
import static org.junit.Assert.*;

public class LoginFunciones {
    private WebDriver driver = new EdgeDriver();

    @Given("el usuario accede a la pagina de inicio de sesion")
    public void el_usuario_accede_a_la_pagina_de_inicio_de_sesion() {
        driver.get("http://localhost:8081/Ev3/");
    }

    @When("ingresa {string} como nombre de usuario y {string} como contraseña")
    public void ingresa_como_nombre_de_usuario_y_como_contraseña(String usuario, String clave) {
        driver.findElement(By.name("usuario")).sendKeys(usuario);
        driver.findElement(By.name("password")).sendKeys(clave);
        driver.findElement(By.name("submit")).click();
    }

    @Then("se muestra un mensaje {string} para el usuario")
    public void se_muestra_un_mensaje_para_el_usuario(String mensajeEsperado) {
        // Esperar un momento para que el mensaje tenga tiempo de aparecer
        esperar(1000);

        // Encuentra el elemento que contiene el mensaje
        WebElement mensaje = driver.findElement(By.tagName("p"));

        // Imprime los mensajes actual y esperado para propósitos de depuración
        System.out.println("Mensaje Esperado: " + mensajeEsperado);
        System.out.println("Mensaje Actual: " + mensaje.getText());

        // Compara el mensaje actual con el esperado
        assertEquals(mensajeEsperado, mensaje.getText());
    }

    // Método de espera para manejar la asincronía
    private void esperar(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        // Cerrar el navegador después de cada escenario
        if (driver != null) {
            driver.quit();
        }
    }
}
