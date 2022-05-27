package Main;
import java.util.*;


public class Main {
	
	Scanner sc = new Scanner(System.in);
	Random rand = new Random();
	
	//menu
	public void menu() {
		System.out.println("AD Drive Store");
		System.out.println("1. Add Drive");
		System.out.println("2. View Drives");
		System.out.println("3. Remove Drive");
		System.out.println("4. Buy");
		System.out.println("5. Exit");
		System.out.print("Choose [1 -5]: ");
	}
	
	
	//add drive
	public void addDrive(Vector<Drive> newDrive) {
		System.out.println("Add Drive");
		System.out.println("==================");
		
		String type = "";
		String manufacture = "";
		int size = 0;
		int rotationSpeed = 0;
		int totalDiskPlate = 0;
		int nandType = 0;
		String cacheCap = "";
		String ID= "";
		
		//type
		do {
			System.out.print("Select drive type [HDD | SSD]: ");
			type = sc.nextLine();
			
		} while (!type.equals("HDD") && !type.equals("SSD"));
		
		//manufacture
		do {
			System.out.print("Input manufacturer name [5..25]: ");
			manufacture = sc.nextLine();
			
		} while (manufacture.length() < 5 || manufacture.length() > 25);
		
		//size
		do {
			System.out.print("Input drive size [256 | 512 | 1024 | 2048] GB: ");
			try {
				size = sc.nextInt();
			} catch (Exception e) {
				// TODO: handle exception
				size = 0;
			}
			sc.nextLine();
			
		} while (size != 256 && size != 512 && size != 1024 && size != 2048 );
		
		if(type.equals("HDD")) {
			do {
				System.out.print("Input drive's rotation speed (RPM) [5200 - 10000]: ");
				try {
					rotationSpeed = sc.nextInt();
				} catch (Exception e) {
					// TODO: handle exception
					rotationSpeed = 0;
				}
				sc.nextLine();
				
			} while (rotationSpeed < 5200 || rotationSpeed > 10000);
			
			//total disk
			do {
				System.out.print("Input no. of disk plate [5 - 12]: ");
				try {
					totalDiskPlate = sc.nextInt();
				} catch (Exception e) {
					// TODO: handle exception
					totalDiskPlate = 0;
				}
				sc.nextLine();
				
			} while (totalDiskPlate < 5 || totalDiskPlate > 12);
			
			//success
			int rand1 = rand.nextInt(100)+1;
			ID = manufacture.substring(0,3).toUpperCase() +  type + rand1 + size;
			
			newDrive.add(new HDD(ID, type, manufacture, size, rotationSpeed, totalDiskPlate));
		}
		else {
			//nand type
			do {
				System.out.print("Input NAND Type [1 - 4]: ");
				try {
					nandType = sc.nextInt();
				} catch (Exception e) {
					// TODO: handle exception
					nandType = 0;
				}
				sc.nextLine();
				
			} while (nandType < 1 || nandType > 4);
			
			//cache cap
			do {
				System.out.print("Input cache type [cache | cacheless]: ");
				cacheCap = sc.nextLine();
				
			} while (!cacheCap.equals("cache") && !cacheCap.equals("cacheless"));
			
			//success
			int rand1 = rand.nextInt(100)+1;
			ID = manufacture.substring(0,3).toUpperCase() +  type + rand1 + size;
			
			newDrive.add(new SSD(ID, type, manufacture, size, nandType, cacheCap));
		}
	}
	
	//view drive
	public void viewDrive (Vector<Drive> ListDrive) {
		System.out.println("List of Drives");
		System.out.println("====================");
		if(ListDrive.isEmpty()) {
			System.out.println("No drive available.");
			sc.nextLine();
		}
		
		//hdd
		int num = 0;
		System.out.println("(HDD)");
		System.out.printf("| %-5s | %-25s | %-15s | %-10s | %-5s | %-12s |\n", "No.", "Manufacture", "Part ID", "Drive Size", "RPM", "Disk Plates");
		for (Drive drives : ListDrive) {
			if (drives instanceof HDD) {
				num++;
				System.out.printf("| %-5d |", num );
				drives.print();
			}
		}
		System.out.println();
		System.out.println();
		//ssd
		num = 0;
		System.out.println("(SSD)");
		System.out.printf("| %-5s | %-25s | %-15s | %-10s | %-5s | %-12s |\n", "No.", "Manufacture", "Part ID", "Drive Size", "Cache", "Disk Plates");
		for (Drive drives : ListDrive) {
			if (drives instanceof SSD) {
				num++;
				System.out.printf("| %-5d |", num );
				drives.print();
			}
		}
		
		System.out.println();
		sc.nextLine();
		
	}
	
	public void printFormat2 (Vector<Drive> ListDrive) {
		System.out.println("List of Drives");
		System.out.println("====================");
		if(ListDrive.isEmpty()) {
			System.out.println("No drive available.");
			sc.nextLine();
		}
		
		//hdd
		int num = 0;
		
		System.out.printf("| %-5s | %-25s | %-15s | %-10s |\n", "No.", "Manufacture", "Part ID", "Drive Size");
		for (Drive drives : ListDrive) {
			num++;
			System.out.printf("| %-5d |", num );
			drives.print2();
		}
		System.out.println();
		System.out.println();
		
	}
	
	//delete
	public void removeDrive (Vector<Drive> ListDrive) {
		System.out.println("Remove Drive");
		System.out.println("====================");
		printFormat2(ListDrive);
		int inp = -1;
		
		do {
			System.out.print("Choose drive No. to be removed: ");
			try {
				inp = sc.nextInt();
			} catch (Exception e) {
				// TODO: handle exception
				inp = -1;
			}
			sc.nextLine();
			
		} while (inp < 1 || inp > ListDrive.size());
		
		ListDrive.remove(inp-1);
		System.out.println("Drive successfully removed!!");
		
		
	}
	
	
	//buy
	public void buyDrive (Vector<Drive> ListDrive) {
		System.out.println("Buy Drive");
		System.out.println("====================");
		System.out.println();
		
		printFormat2(ListDrive);
		
		int inp = -1;
		
		do {
			System.out.print("Select drive No. : ");
			try {
				inp = sc.nextInt();
			} catch (Exception e) {
				// TODO: handle exception
				inp = -1;
			}
			sc.nextLine();
			
		} while (inp < 1 || inp > ListDrive.size());
		
		int drivePrice = ListDrive.get(inp-1).calculate();
		System.out.print("Drive price (USD): ");
		System.out.println(drivePrice);
		System.out.println("Thank you for the pruchase!");
		
	}
	
	

	public Main() {
		// TODO Auto-generated constructor stub
		boolean isRun = true;
		Vector<Drive> drive = new Vector<Drive>();
		int inp = -1;
		
		do {
			do {
				menu();
				try {
					inp = sc.nextInt();
				} catch (Exception e) {
					// TODO: handle exception
					inp = -1;
				}
				sc.nextLine();
				
				//condition
				switch (inp) {
				case 1:
					addDrive(drive);
					System.out.println("Press enter to continue");
					sc.nextLine();
					break;
				case 2:
					viewDrive(drive);
					System.out.println("Press enter to continue");
					sc.nextLine();
					break;
				case 3: 
					removeDrive(drive);
					System.out.println("Press enter to continue");
					sc.nextLine();
					break;
				case 4:
					buyDrive(drive);
					System.out.println("Press enter to continue");
					sc.nextLine();
					break;
				case 5:
					isRun = false;
					break;

				default:
					break;
				}
				
			} while (inp < 1 || inp > 5);
		} while (isRun);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();

	}

}
