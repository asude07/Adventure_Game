import java.util.Scanner;

public class Store extends NormalLoc {
	
	Scanner key = new Scanner(System.in);
	public Store(Player p) {
		super(p, "Store");
	}
	
	public boolean getLocation() {
		
		System.out.println("1. Weapon");
		System.out.println("2. Armor");
		System.out.println("3. Exit");
		int option = key.nextInt();
		int selItemID;
		switch (option) {
		case 1:
			selItemID = weaponMenu();
			buyWeapon(selItemID);
			break;
		case 2: 
			selItemID = armorMenu();
			buyArmor(selItemID);
			break;
		default:
			break;
		}
		return true;
	}
	
	public int weaponMenu() {
		System.out.println("---- Your total money is "+player.money+" ----");
		System.out.println("1. Sword ---> damage: 2 \t price: 25");
		System.out.println("2. Gun   ---> damage: 3 \t price: 35");
		System.out.println("3. Rifle ---> damage: 5 \t price: 45");
		System.out.println("For exit, enter another number.");
		System.out.print("Select the ID of Weapon: ");
		int idWeapon = key.nextInt();
		return idWeapon;
		
	}
	
	public void buyWeapon(int itemID) {
		int damage=0, price=0;
		String wname = "";
		if(itemID>0 && itemID<4) {
			switch(itemID) {
			case 1:
				damage=2;
				price=25;
				wname="sword";
				break;
			case 2:
				damage=3;
				price=35;
				wname="gun";
				break;
			case 3:
				damage=4;
				price=45;
				wname="rifle";
				break;
			default:
				System.out.println("Invalid Operation !");				
			}
			
			
			if(player.money>=price) {
				player.inv.setDamage(damage);
				player.inv.setwName(wname);
				player.money -= price;
				System.out.println("You buyed a "+wname+".\nCurrent money: "+player.money);
				System.out.println("Current damage: "+player.getTotalDamage());
			}
			
			
			else System.out.println("Your budget is not enough !");
			
		} else System.out.println("Invalid Operation !");
	}
	
	public int armorMenu() {
		System.out.println("---- Your total money is "+player.money+" ----");
		System.out.println("1. Light   ---> avoid: 1   price: 15");
		System.out.println("2. Medium  ---> avoid: 3   price: 30");
		System.out.println("3. Heavy   ---> avoid: 5   price: 45");
		System.out.println("For exit, enter another number.");
		System.out.print("Select the ID of Armor: ");
		int idArmor = key.nextInt();
		return idArmor;
		
	}
	
	public void buyArmor(int itemID) {
		int armor=0, price=0;
		String aname = "";
		if(itemID>0 && itemID<4) {
			switch(itemID) {
			case 1:
				armor=1;
				price=15;
				aname="lightly armor";
				break;
			case 2:
				armor=3;
				price=30;
				aname="medium armor";
				break;
			case 3:
				armor=4;
				price=45;
				aname="heavyly armor";
				break;
			default:
				System.out.println("Invalid Operation !");		
				
			}
			
			if(player.money>=price) {
				player.inv.setArmor(armor);
				player.inv.setaName(aname);
				player.money -= price;
				System.out.println("You buyed a "+aname+".\nCurrent money: "+player.money);
				System.out.println("Current avoid: "+player.inv.getArmor());
			}
			
			else System.out.println("Your budget is not enough !");
			
		}else System.out.println("Invalid Operation !");
	}


}
