package pkgmain;

import java.util.Scanner;

public class TestBench {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//instantiate a device
		Device device = new Device("Device 0");
//		device.listOptions();
//		System.out.println(device.getState());
		
		// instantiate the components (ICs and Basics)
		Capacitor c = new Capacitor(15e-12f,50f);
		Diode d = new Diode(1000f,1f);
		Inductor i = new Inductor(150e-6f,0.5f);
		IC ic = new IC("UA741CP","Amp Op");
		Transistor t = new Transistor("TJB","NPN");
//		Basic basic = new Basic();
		Resistor r = new Resistor(1000f,5f,0.25f);
		LED led = new LED(10f,2f,4);
//		System.out.println(led.getColor_name());

	
		// Set state
//		try {
//			device.setState(1);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}

		// Set Basic to the device
		try {
			//int resposta = scan.nextInt();
			device.addBasic(7,led);
			device.addBasic(3,c);
			device.addBasic(5,r);
			device.addBasic(2,i);
			device.addBasic(1,d);
			device.addBasic(6,t);
		} catch (IllegalArgumentException   e) {
			System.out.println(e.getMessage());
		}catch (Exception e2) {
			System.out.println("ERROR!\n");
		}
		
		// Set IC to the device
		try {
			//int resposta = scan.nextInt();
			device.addIC(2,ic);
		} catch (IllegalArgumentException   e) {
			System.out.println(e.getMessage());
		}catch (Exception e2) {
			System.out.println("ERROR!\n");
		}
		
		System.out.println("@"+device.getName()+": ");
//		System.out.println(device.getCircuit());
		System.out.println("Quant. of Components: "+device.getQuant());
		

		
		
		scan.close();
	}
}
