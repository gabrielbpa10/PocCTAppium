package com.ctappium.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\Usuario\\eclipse-workspace\\PocCTAppium\\src\\test\\resources\\features\\Register-form.feature",
		glue = "classpath:com.ctappium.steps",
		tags = "@scenario_register_form_button_generic",
		plugin = {"pretty","json:target/files-json/register-form.json"/*,"html:target/relatorios/cenarios.html"*/}, //Modifica a forma de visão do console sobre os resultados
		monochrome = true, //Tira desenhos especiais no console com os caracteres especiais
		dryRun = false,
		strict = true
		)
public class Runner {

}
