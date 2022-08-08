import java.util.Scanner;

public class Game {
	Player player;
	Location location;
	boolean game=false;
	
	Scanner key = new Scanner(System.in);
	
	public Game(Player p) {
		player = p;
	}
	
	public void login() {
		player.selectChar();
		System.out.println(player.toString());
		information();
		start();
	}
	public void information() {
		System.out.println();
		System.out.println("**********************************************************");
		System.out.println();
		System.out.println(player.charName+" "+player.name+", there are so many people in Soror Planet.");
		System.out.println("The most dangerous ones are ENGINEERS, DOCTORS, and ECONOMISTS.");
		System.out.println("You should kill them in their own places.");
		System.out.println("REMEMBER that there are between 1 and 3 people in each places.");
		System.out.println();
		System.out.println("Now, you have 3 battle field, a store, and a safe house:");
		System.out.println("1- Safe House: \tYour health is renewed. You can drop you collected. "
				+ "\n2- Factory: \tThere are 1-3 Engineers.     Gain: Firewood"
				+ "\n3- Hospital: \tThere are 1-3 Doctors.       Gain: Food"
				+ "\n4- Bank: \tThere are 1-3 Diplomats.     Gain: Water"
				+ "\n5- Store: \tYou can buy weapons and armors");
		System.out.println();
		System.out.println("When you kill all people monsters and collect items, YOU'LL WIN."
				+ "\n!!!! REMEMBER that if you run from the locations and people, you will lose 1 point from your health !!!!");
	}
	
	public void start() {
		while(!game) {
			System.out.println();
			System.out.println("-----Locations-----");
			System.out.println("1- Safe House"
					+ "\n2- Factory"
					+ "\n3- Hospital"
					+ "\n4- Bank"
					+ "\n5- Store");
			System.out.println("Please select a valid location.");
			System.out.println();
			int locId = key.nextInt();
			
			while((locId>5 || locId<1) ) {
				System.out.println("!! INVALID INPUT !!");
				System.out.println("1- Safe House"
						+ "\n2- Factory"
						+ "\n3- Hospital"
						+ "\n4- Bank"
						+ "\n5- Store");
				System.out.println("Please select a valid location.");
				System.out.println();
				locId = key.nextInt();
			}
			
			switch(locId) {
			case 1: 
				location = new SafeHouse(player);
				break;
			case 2:
				location = new Factory(player);
				break;	
			case 3:
				location = new Hospital(player);
				break;
			case 4:
				location = new Bank(player);
				break;
			case 5:
				location = new Store(player);
				break;
			}
			if(location.getClass().getName().equalsIgnoreCase("SafeHouse")) {
				
				if(player.inv.isFirewood() && player.inv.isFood() && player.inv.isWater()) {
					location.getLocation();
					System.out.println();
					System.out.println(":)  WELL DONE  :)"
							+ "\n!!! YOU WON !!!");
					game = true;
					break;
				}
				
			}
			if(!location.getLocation()) {
				System.out.println();
				System.out.println(":(  GAME OVER  :(");
				break;
			}
		}
		
	}
}
