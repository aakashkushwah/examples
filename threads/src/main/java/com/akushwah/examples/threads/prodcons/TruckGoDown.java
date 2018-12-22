package com.akushwah.examples.threads.prodcons;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.akushwah.examples.threads.prodcons.Truck.COLOR;

public class TruckGoDown {
	private final int MAX = 5;
	private ArrayBlockingQueue<Truck> blackTrucks = new ArrayBlockingQueue<>(MAX);
	private ArrayBlockingQueue<Truck> redTrucks = new ArrayBlockingQueue<>(MAX);
	private ArrayBlockingQueue<Truck> blueTrucks = new ArrayBlockingQueue<>(MAX);
	private ArrayBlockingQueue<Truck> orangeTrucks = new ArrayBlockingQueue<>(MAX);

	public TruckGoDown() {
		new Thread(new TruckProducer(COLOR.BLACK, blackTrucks)).start();
		new Thread(new TruckProducer(COLOR.RED, redTrucks)).start();
		new Thread(new TruckProducer(COLOR.BLUE, blueTrucks)).start();
		new Thread(new TruckProducer(COLOR.ORANGE, orangeTrucks)).start();
	}

	public Truck buy(COLOR color) {
		
		Truck result = null;
		switch (color) {
		case BLACK:
			try {
				result = blackTrucks.take();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case BLUE:
			try {
				result = blueTrucks.take();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case RED:
			try {
				result = redTrucks.take();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case ORANGE:
			try {
				result = orangeTrucks.take();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		default:
			break;
		}
		return result;
	}

}

class TruckProducer implements Runnable {
	private COLOR color;
	private BlockingQueue<Truck> trucks;

	public TruckProducer(COLOR color, BlockingQueue<Truck> trucks) {
		this.color = color;
		this.trucks = trucks;
	}

	@Override
	public void run() {
		while (true) {
			Truck truck = Truck.getTruck(color);
			try {
				trucks.put(truck);
				System.out.println("Truck Producer produced a new truck of color: "+color);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
