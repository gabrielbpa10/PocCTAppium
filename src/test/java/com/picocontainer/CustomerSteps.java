package com.picocontainer;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CustomerSteps {

	private World world;
	
	public CustomerSteps(World world) {
		this.world = world;
	}
	
	@When("she return the {string} to the store")
	public void she_return_the_to_the_store(String itemType) {
		System.out.println(world.customer.getNomeAux());
	   Item returnedItem = new Item(itemType);
	   assertEquals(world.item.getItemType(), returnedItem.getItemType());
	}

	@When("she show her receipt")
	public void she_show_her_receipt() {
		world.customer.refund(world.item.getPrice());
	}

	@Then("she will get ${int} refunded")
	public void she_will_get_$_refunded(Integer expected) {
		int value = world.customer.getRefund();
		System.out.println(value + " = " + expected);
	}
}
