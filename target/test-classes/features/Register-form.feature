@tela_formulario
Feature: Register form

	@scenario_register_form_button_generic
  Scenario Outline: Register form to save generic button
    Given the acess to Menu
    When to acess the form screen
    And to register all datas: "<Name>" "<Console>" "<Slider>" "<Date>"
    And to click the button to save 
    Then will go to provide the dates, saved
    
    Examples:
    |Name			|Console	 |Slider 	 |Date	|
    |Gabriel	|PS4		 	 |0.38		 |12		|
    |Bruna		|PS4		 	 |0.38		 |12		|
    
  @scenario_register_form_button_long  
	Scenario Outline: Register form to save other button (save time consuming)
		Given the acess to Menu
    When to acess the form screen
    And to register all datas: "<Name>" "<Console>" "<Slider>" "<Date>"
    And to click the long button to save 
    Then will go to provide the dates, saved
    
    Examples:
    |Name			|Console	 |Slider 	 |Date	|
    |Gabriel	|PS4		 	 |0.38		 |12		|