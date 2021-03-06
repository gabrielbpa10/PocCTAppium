package com.ctappium.steps;

import static org.junit.Assert.assertTrue;

import com.ctappium.pages.GenericPage;

import io.cucumber.java.After;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Ent�o;
import io.cucumber.java.pt.Quando;

public class InformacoesSobreSteps {

	private GenericPage generic;
	
	public InformacoesSobreSteps(GenericPage generic) {
		this.generic = generic;
	}
	
	@E("clicar na op��o about...")
	public void clicar_na_opcao() {
		generic.setAboutPage(generic.getMenuPage().clicarOpcaoAbout());
	}
	
	@Quando("acessar a tela sobre, o usu�rio ler os dados")
	public void acessar_a_tela_sobre_o_usuario_ler_os_dados() {
		  generic.getAboutPage().checkAboutScreen();
	}

	@Ent�o("verificar� todos os dados da tela sobre")
	public void verificara_todos_os_dados_da_tela_sobre() {
		assertTrue(generic.getAboutPage().checkVersion());
	}
	
	@After (value="@tela_sobre")
	public void finalizarDriver() {
		generic.getDriver().quit();
	}

}
