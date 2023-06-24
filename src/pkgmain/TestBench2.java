package pkgmain;

import java.util.Scanner;

public class TestBench2 {
	public static void main(String[] args) {
		try{
			// int state;
			Scanner scan = new Scanner(System.in);
			System.out.println("Device name: ");
			Device device = new Device(scan.nextLine());
			// To build a new device
			device.build();
			// Show the entire circuit
			device.getCircuit();
			
			// System.out.println("Device state:\n"
			// 		+ "0 - Off\n"
			// 		+ "1 - On");
			
			// device.setState(scan.nextInt());

			// Simulate the output with a desired input
			device.simulate();
		}catch (Exception e) {
			System.out.println("Error!");
		}

	}
}
