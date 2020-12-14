package com.picocontainer;

import io.cucumber.java.en.Given;

public class GoodSteps {

	private World world;
	
	public GoodSteps(World world) {
		this.world = world;
	}

	@Given("that {string} bought a faulty {string} for ${int}")
	public void that_bought_a_faulty_for_$(String name, String itemType, Integer price) {
	    world.customer = new Customer(name);
	    world.customer.setNome("Gabriel Braga");
	    world.item = new Item(itemType,price);
	}
}
