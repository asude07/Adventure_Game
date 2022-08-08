import java.util.Scanner;

public class Player {
	
	Scanner key = new Scanner(System.in);
	
	String name, charName;
	int damage, healhty, money, realHealhty;
	Inventory inv;
	
	public Player(String n) {
		this.name = n;
		this.inv = new Inventory();
	}
	
	public int getTotalDamage() {
		return this.damage + this.inv.getDamage();
	}
	
	public void selectChar() {
		System.out.println("------- Hi "+ this.name + " -------");
		System.out.println("There are 3 characters you can choose:");
		System.out.println("1- Orangutan \t ----> Damage=6 \t Healthy=19 \t Money=23$");
		System.out.println("2- Gorilla \t ----> Damage=8 \t Healthy=15 \t Money=19$");
		System.out.println("3- Chimpanzee \t ----> Damage=4 \t Healthy=25 \t Money=11$");
		System.out.println("Select the ID of your character:");
		int charId = key.nextInt();
		
		while(charId>3 || charId<1) {
			System.out.println("!! INVALID INPUT !!");
			System.out.println("There are 3 characters you can choose:");
			System.out.println("1- Orangutan \t ----> Damage=6 \t Healthy=19 \t Money=23$");
			System.out.println("2- Gorilla \t ----> Damage=8 \t Healthy=15 \t Money=19$");
			System.out.println("3- Chimpanzee \t ----> Damage=4 \t Healthy=25 \t Money=11$");
			System.out.println("Select the ID of your character:");
			charId = key.nextInt();
		}
		
		if(charId == 1) {
			this.charName = "Orangutan";
			this.damage=6;
			this.healhty=19;
			this.realHealhty=19;
			this.money=23;
		}
		
		if(charId == 2) {
			this.charName = "Gorilla";
			this.damage=8;
			this.healhty=15;
			this.realHealhty=15;
			this.money=19;
		}
		
		if(charId == 3) {
			this.charName = "Chimpanzee";
			this.damage=4;
			this.healhty=25;
			this.realHealhty=25;
			this.money=15;
		}
				
	}
	
	public String toString() {

		System.out.println("You choose "+charName+".");
		String str="Your damage power is "+damage+", healthy score is "+healhty
				+" and you have $"+money+".";
		return str;
	}
	
	
}
