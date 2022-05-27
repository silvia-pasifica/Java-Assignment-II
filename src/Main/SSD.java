package Main;

public class SSD extends Drive{
	
	private int NandType;
	private String cacheCap;

	public SSD(String ID, String type, String manufacture, int size, int NandType, String cacheCap) {
		// TODO Auto-generated constructor stub
		super(ID, type, manufacture, size);
		this.NandType = NandType;
		this.cacheCap = cacheCap;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		if (cacheCap.equals("cache")) {
			System.out.printf(" %-25s | %-15s | %-10s | %-5s | %-12s |\n", super.getManufacture(), super.getID(), super.getSize(), "True", NandType);
		}
		else {
			System.out.printf(" %-25s | %-15s | %-10s | %-5s | %-12s |\n", super.getManufacture(), super.getID(), super.getSize(), "False", NandType);
		}
		
	}

	@Override
	public int calculate() {
		// TODO Auto-generated method stub
		int price = (int)((NandType * 3.75) + (super.getSize() / 2));
		if (cacheCap.equals("cache")) {
			price += 20;
		}
		return price;
	}
	
	

}
