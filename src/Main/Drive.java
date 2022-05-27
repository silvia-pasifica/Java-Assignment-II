package Main;
import java.util.*;

public abstract class Drive {
	
	private String type;
	private String manufacture;
	private int size;
	private String ID;

	public Drive(String ID, String type, String manufacture, int size) {
		// TODO Auto-generated constructor stub
		this.ID = ID;
		this.type = type;
		this.manufacture = manufacture;
		this.size = size;
	}
	
	public abstract void print();
	public abstract int calculate();
	
	//encapsulation
	public String getType() {
		return type;
	}

	public String getManufacture() {
		return manufacture;
	}

	public int getSize() {
		return size;
	}
	public Drive() {
		// TODO Auto-generated constructor stub
	}

	public String getID() {
		return ID;
	}
	
	public void print2 () {
		System.out.printf(" %-25s | %-15s | %-10s |\n", manufacture, ID, size);
	}
	

}
