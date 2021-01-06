package com.picocontainer;

public class Customer {

	private String name;
	private int refund;
	private String nomeAux;
	
	public Customer(String name) {
		this.setName(name);
	}
	
	public void setNome(String nomeAux) {
		this.nomeAux = nomeAux;
	}
	
	public void refund(int price) {
		this.refund = price;
	}
	
	public int getRefund() {
		return this.refund;
	}
	
	public String getNomeAux() {
		return this.nomeAux;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
