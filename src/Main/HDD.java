package Main;

public class HDD extends Drive{
	
	private int rotationSpeed;
	private int totalDiskPlate;

	public HDD(String ID, String type, String manufacture, int size, int rotationSpeed, int totalDiskPlate) {
		// TODO Auto-generated constructor stub
		super(ID, type, manufacture, size);
		this.rotationSpeed = rotationSpeed;
		this.totalDiskPlate = totalDiskPlate;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.printf(" %-25s | %-15s | %-10s | %-5s | %-12s |\n", super.getManufacture(), super.getID(), super.getSize(), rotationSpeed, totalDiskPlate);
	}

	@Override
	public int calculate() {
		// TODO Auto-generated method stub
		int price = (int)((rotationSpeed/10000 * 1.5) + (totalDiskPlate + 25) + (super.getSize() / 4));
		return price;
	}

}
