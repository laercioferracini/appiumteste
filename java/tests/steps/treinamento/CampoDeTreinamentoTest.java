package tests.steps.treinamento;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.treinamento.CampoDeTreinamentoPO;

public class CampoDeTreinamentoTest {
    WebDriver driver;
    WebElement webElement;
    CampoDeTreinamentoPO c = new CampoDeTreinamentoPO();

    
    @Dado("^que o usuario esteja na pagina inicial \"([^\"]*)\"$")
    public void que_o_usuario_esteja_na_pagina_inicial(String title) throws Throwable {
        driver = c.verificaTitulo();
        Assert.assertEquals(title, driver.getTitle());
    }

    @E("^que o usuario digite \"([^\"]*)\"$")
    public void que_o_usuario_digite(String nome) throws Throwable {
        webElement = c.deveInteragirComTextfield();
        webElement.sendKeys(nome);
    }

    @Entao("^o sistema exibe no campo \"([^\"]*)\"$")
    public void o_sistema_exibe_no_campo(String nome) throws Throwable {
        webElement = c.deveVerificarTextfield();
        Assert.assertEquals(nome, webElement.getAttribute("value"));
    }
}
