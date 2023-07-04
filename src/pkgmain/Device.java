package pkgmain;

import java.util.Scanner;

public class Device {

	//Options of the components to compose the Device (class IC and class Basic)
	private String[] options = {"Resistor","Capacitor","Inductor","Diode","LED","Transistor","IC"};
	// private int state=0;
	//The entire circuit string
	private String circuit="";
	//Quantity of components (Basics and ICs)
	private int quant=0;
	//Name of device
	private String name;
	// Amplitude and phase of the device transfer function
	private float amplitude,phase;


	public float getAmplitude() {
		return amplitude;
	}
	public void setAmplitude(float amplitude) {
		this.amplitude = amplitude;
	}
	public float getPhase() {
		return phase;
	}
	public void setPhase(float phase) {
		this.phase = phase;
	}

	//List all the possible components to compose the device
	public void listOptions() {
		for(int i=0;i<options.length;i++) {
			System.out.println((i+1)+" - "+options[i]+"\n");
		}
	}
	public Device(String name) {
		this.name = name;
	}
	// public int getState() {
	// 	return state;
	// }

	// public void setState(int state) {
	// 	System.out.println("Device state:\n"
	// 				+ "0 - Off\n"
	// 				+ "1 - On");
	// 	switch (state){
	// 	case 0:
	// 		this.state=state;
	// 		System.out.println("State changed to off");
	// 		break;
	// 	case 1:
	// 		this.state=state;
	// 		System.out.println("State changed to on");
	// 		break;
	// 	default:
	// 		throw new IllegalArgumentException("Invalid state");
	// 	}
	// }

	//Add a Basic component
	public void addBasic(int quant, Basic basic){
		//Can't put a zero or negative quantity
		if (quant<=0){
			throw new IllegalArgumentException("Invalid quantity (it needs to be bigger than 0).");
		}else {
			this.circuit+=quant +"x -> "+ " "+ basic.getInformation()+"\n";
			this.quant+=quant;
			System.out.println("Added Basic Component(s).");
		}	
	}	

	//Add a IC component
	public void addIC(int quant,IC ic){
		//Can't put a zero or negative quantity
		if (quant<=0){
			throw new IllegalArgumentException("Invalid quantity (it needs to be bigger than 0).");
		}else {
			this.circuit+=quant +"x -> "+ " "+ ic.getInformation()+"\n";	
			this.quant+=quant;
			System.out.println("Added IC(s).");
		}	
	}

	// Show all the components with its specifications and your Transference Function
	public void getCircuit() {
		this.getTransferenceFunction();
		System.out.println("Circuit components: ");
		System.out.println(circuit);

	}

	// Concatenate a component with your specification and quantity
	public void setCircuit(String circuit) {
		this.circuit = circuit;
	}
	public int getQuant() {
		return quant;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	// Show the Transference Function
	public void getTransferenceFunction(){
		System.out.println("Transference Function: "+this.getAmplitude()+"<"+this.getPhase()+"°.");
	}

	// run the simulation by applying a Transference Function on input
	public float[] run(float abs_in,float angle_in){
		float[] out = {0,0};
		// if (this.getState()==1){
			out[0] = this.getAmplitude()*abs_in;
			out[1]=sumAngles(this.getPhase(),angle_in);
			System.out.println("Output: "+out[0]+"<"+out[1]+"°");
		// }else{
		// 	System.out.println("Circuit is off, run failed. Try to change the state to 'on'.");
		// }
		return out;
	}

	// Build a new device
	public void build() {
		Scanner scan = new Scanner(System.in);
		int op;
		boolean control=true;
		int quant;
		int loop=1;
		System.out.println("----> Adding components to the device. <----");
		while (true) {
			
			// loop to get the quantity of a component
			while (true) {
				
				System.out.println("Quantity: ");
				quant=scan.nextInt();
				
				if (quant<=0) {
					System.out.println("Invalid quantity (it needs to be bigger than 0).");
				}else {
					break;
				}
			}
			listOptions();

			//loop to select a specific component get your specification to instantiate an object of Basic (subclasses) or IC  
			while (control) {
				System.out.println("Select a option: ");
				op=scan.nextInt();
				
				switch (op) {
					case 1:
						float R, tolerance_percent, W;
						System.out.println("R (ohms): ");
						R=scan.nextFloat();
						System.out.println("Tolerance (%): ");
						tolerance_percent=scan.nextFloat();
						System.out.println("Potency (W): ");
						W=scan.nextFloat();
						Resistor r = new Resistor(R,tolerance_percent,W);
						control=false;
						this.addBasic(quant, r);
						break;
						
					case 2:
						float C, Vmax;
						System.out.println("C (F): ");
						C=scan.nextFloat();
						System.out.println("Vmax (V): ");
						Vmax=scan.nextFloat();
						Capacitor c = new Capacitor(C,Vmax);
						control=false;
						this.addBasic(quant, c);
						break;
					case 3:
						float L;
						System.out.println("L (H): ");
						L=scan.nextFloat();
						System.out.println("Potency (W): ");
						W=scan.nextFloat();
						Inductor i = new Inductor(L,W);
						control=false;
						this.addBasic(quant, i);
						break;
					case 4:
						float Vmax_reverse, Idirect;
						System.out.println("Vmax_reverse (V): ");
						Vmax_reverse=scan.nextFloat();
						System.out.println("Idirect (A): ");
						Idirect=scan.nextFloat();
						Diode d = new Diode(Vmax_reverse, Idirect);
						control=false;
						this.addBasic(quant, d);
						break;
					case 5:
						int color_code;
						String color_name;
						System.out.println("Vmax_reverse (V): ");
						Vmax_reverse=scan.nextFloat();
						System.out.println("Idirect (A): ");
						Idirect=scan.nextFloat();
						LED led = new LED(Vmax_reverse,Idirect,1);
						led.listColorCode();
						System.out.println("Select a color code: ");
						color_code=scan.nextInt();
						led.setColor_code(color_code);
						control=false;
						this.addBasic(quant, led);
						break;
					case 6:
						String category, polarity;
						System.out.println("Category: ");
						category=scan.next();
						System.out.println("Polarity: ");
						polarity=scan.next();
						Transistor t =  new Transistor(category,polarity);
						control=false;
						this.addBasic(quant, t);
						break;
					case 7:
						String series_name;
						System.out.println("Series name: ");
						series_name=scan.next();
						System.out.println("Category: ");
						category=scan.next();
						IC ic =  new IC(series_name,category);
						control=false;
						this.addIC(quant, ic);
						break;
					default:
						System.out.println("Invalid option!");
				}
				
	
					
				}
			control=true;
			//User chooses to continue adding components or not
			System.out.println("Do you want to continue adding? (0 to no)");
			loop=scan.nextInt();
			if (loop==0) {break;}
		}

		//Set a Transference Function
		System.out.println("Transference Function: Amplitude<phase°");
		System.out.println("A: ");
		this.setAmplitude(scan.nextFloat());
		System.out.println("Phase (in degree): ");
		this.setPhase(scan.nextFloat());
		System.out.println("----> Ending Device Builder. <----");
		}

		// Simulation to get the input values and generate the output
		public void simulate(){
			Scanner scan = new Scanner(System.in);
			float in_abs;
			float in_phase;
			System.out.println("---->Simulation<----");
			System.out.println("Input amplitude: ");
			in_abs=scan.nextFloat();
			System.out.println("Input phase: ");
			in_phase=scan.nextFloat();
			System.out.println("Input: "+in_abs+"<"+in_phase+"°.");
			this.getTransferenceFunction();
			this.run(in_abs, in_phase);
		}

		// Operate with the sum and sub of angles in degrees
		public static float sumAngles(float angle1, float angle2) {
        	float sum = angle1 + angle2;
        
       		while (sum >= 360.0 || sum < -360.0) {
            	if (sum >= 360.0) {
                	sum -= 360.0;
            	} else if (sum < -360.0) {
                	sum += 360.0;
            	}
        	}
        
        return sum;
    }
}

