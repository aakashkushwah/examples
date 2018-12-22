package com.akushwah.examples.threads.prodcons;

import java.util.Random;

import com.akushwah.examples.threads.prodcons.Truck.COLOR;

public class TruckClient {
	public static void main(String[] args) {
		TruckGoDown goDown = new TruckGoDown();
		Random random = new Random();

		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					int colorIndex = random.nextInt(4);
					COLOR color = COLOR.values()[colorIndex];
					System.out.println("Client buying truck of color: " + color);
					goDown.buy(color);
				}

			}
		}).start();
	}
}
