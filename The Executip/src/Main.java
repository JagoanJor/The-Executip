import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.Scanner;

public class Main {
	Scanner s = new Scanner(System.in);

	ArrayList<Data> data = new ArrayList<>();
	
	int choose, fabPrice, discount, stock;
	String name, fabType, id, deleteID;
	
	public Main() {
		Menu();
	}
	
	private void Menu() {
		
		do {
			System.out.println();
			System.out.println("The Executip");
			System.out.println("====================");
			System.out.println("1. Insert new dress");
			System.out.println("2. View all dresses");
			System.out.println("3. Delete a dress");
			System.out.println("4. Exit");
			System.out.print(">> ");
			choose = s.nextInt();
			s.nextLine();
			
			switch(choose) {
				case 1:
					insertNewDress();
					System.out.println("Press enter to Continue...");
					s.nextLine();
					break;
				case 2:
					viewAllDresses();
					System.out.println("Press enter to Continue...");
					s.nextLine();
					break;
				case 3:
					DeleteDress();
					System.out.println("Press enter to Continue...");
					s.nextLine();
					break;
			}
		} while (choose != 4);
	}
	
	private void insertNewDress() {
		
		do {
			System.out.println("Pick which type of dress to insert: ");
			System.out.println("1. Regular dress");
			System.out.println("2. Limited Edition Dress");
			System.out.println("3. Back");
			System.out.print(">> ");
			choose = s.nextInt();
			s.nextLine();
			
		} while (choose != 1 && choose != 2 && choose != 3);
		
		do {
			System.out.print("Input dress name [5 - 20 characters]: ");
			name = s.nextLine();
		} while(name.length() < 5 || name.length() >20);
		
		if(choose == 1) {
			do {
				System.out.print("Input fabric price [Rp. 10000 - Rp. 100000]: Rp. ");
				fabPrice = s.nextInt();
				s.nextLine();
			} while(fabPrice < 10000 || fabPrice > 100000);
			
			do {
				System.out.print("Input fabric type [Cotton | Wool] (case sensitive): ");
				fabType = s.nextLine();
			} while(!fabType.equals("Cotton") && !fabType.equals("Wool"));
			
			do {
				System.out.print("Input discount for this dress [1..100]: ");
				discount = s.nextInt();
				s.nextLine();
			} while(discount < 1 || discount > 100);
			
			System.out.println("Succesfully added a new Regular Dress!");
			
			int price = (fabPrice + 50000) * (100-discount);
			
			Regular r = new Regular(id, name, fabPrice, fabType, 0, discount, price);
			r.generateID();
			data.add(r);
		}
		
		else if(choose == 2) {
			do {
				System.out.print("Input fabric price [Rp. 100000 - Rp. 300000]: Rp. ");
				fabPrice = s.nextInt();
				s.nextLine();
			} while(fabPrice < 100000 || fabPrice > 300000);
			
			do {
				System.out.print("Input fabric type [Satin | Chiffon | Crepe] (case sensitive): ");
				fabType = s.nextLine();
			} while(!fabType.equals("Satin") && !fabType.equals("Chiffon") && !fabType.equals("Crepe"));
			
			do {
				System.out.print("Input stock for this dress [1..10]: ");
				stock = s.nextInt();
				s.nextLine();
			} while(stock < 1 || stock > 10);
			
			System.out.println("Succesfully added a new Limited Edition Dress!");
			
			int price = (fabPrice + 50000) + ((100 - stock) * 10000);
			
			Limited l = new Limited(id, name, fabPrice, fabType, stock, discount, price);
			l.generateID();
			data.add(l);
		}
		
	}
	
	private void viewAllDresses() {
		if(data.isEmpty()) {
			System.out.println("No Dresses available...");
		}
		else {
			System.out.println("=================================================================================================");
			System.out.println("|  ID   |  Name                   | Fabric Price | Fabric Type | Discount | Stock | Total Price |");
			System.out.println("=================================================================================================");
			
			for (int i = 0; i < data.size(); i++) {
				if(data.get(i).getID().startsWith("RE")) {
					System.out.printf("| %-6s| %-24s| %-13d| %-12s| %-7d%% | -     | Rp. %-8d|\n", data.get(i).getID(), data.get(i).getName(), data.get(i).getFabricPrice(), data.get(i).getFabricType(), data.get(i).getDisc(), data.get(i).getPrice());
				} else if(data.get(i).getID().startsWith("LI")) {
					System.out.printf("| %-6s| %-24s| %-13d| %-12s| -        | %-6d| Rp. %-8d|\n", data.get(i).getID(), data.get(i).getName(), data.get(i).getFabricPrice(), data.get(i).getFabricType(), data.get(i).getStock(), data.get(i).getPrice());
				}
			}
			System.out.println("=================================================================================================");
		}
	}
	
	private void DeleteDress() {
		viewAllDresses();
		
		System.out.print("Input dress ID to delete: ");
		deleteID = s.nextLine();
		
		checkExist(deleteID);
		if (checkExist(deleteID) == -1) {
			System.out.println("Dress ID is invalid!");
		}
		else {
			data.remove(checkExist(deleteID));
			System.out.printf("Succesfully removed dress %s!", deleteID);
		}
	}
	
	private int checkExist(String dressID) {
		int exist = -1;
		for (int i = 0; i < data.size(); i++) {
			if(dressID.equals(data.get(i).getID())) {
				exist = i;
				return exist;
			}
		}
		return exist;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
