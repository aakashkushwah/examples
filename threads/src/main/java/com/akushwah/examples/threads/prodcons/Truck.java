package com.akushwah.examples.threads.prodcons;

import java.util.function.Supplier;

public class Truck {
	public enum COLOR {RED, BLACK, BLUE, ORANGE};
	private COLOR color;
	
	private Truck(Supplier<COLOR> supplier) {
		this.color =  supplier.get();
	}
	
	@Override
	public String toString() {
		return super.toString()+" "+color;
	}
	
	public static Truck getTruck(COLOR color) {
		return new Truck(()->color);
	}
}
