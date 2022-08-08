import java.util.Scanner;

public abstract class BattleLoc extends Location{
	
	Obstacle obstacle;
	String award;
	
	Scanner key = new Scanner(System.in);
	
	public BattleLoc(Player p, String n, Obstacle o, String a) {
		super(p);
		this.locName=n;
		obstacle = o;
		this.award=a;
	}
	
	public boolean getLocation() {
		int obsCount = obstacle.obstacleCount();
		System.out.println("You are here now: "+this.locName);
		System.out.println("!! Be carefull !! There are "+obsCount+" "+obstacle.name);
		System.out.println("<W>ar or <R>un");
		String selCase = key.next();
		System.out.println();
		
		if(selCase.equalsIgnoreCase("w")) {
			if(combat(obsCount)) {
				System.out.println();
				System.out.println("You killed all enemies in the "+ this.locName);
				
				if(this.award.equals("food") && player.inv.isFood() == false) {
					System.out.println("You win: "+this.award);
					player.inv.setFood(true);
				}
				
				else if(this.award.equals("firewood") && player.inv.isFirewood() == false) {
					System.out.println("You win: "+this.award);
					player.inv.setFirewood(true);
				}
				
				else if(this.award.equals("water") && player.inv.isWater() == false) {
					System.out.println("You win: "+this.award);
					player.inv.setWater(true);
				}
				return true;
			}
			
			if(player.healhty <= 0) {
				System.out.println();
				System.out.println("!! YOU DIED !!");
				return false;
			} return true;
		}
		else {
			player.healhty -= 1;
			System.out.println("You lost 1 point from your health.");
			System.out.println("Your new health: "+player.healhty);
		}
		
		return true;
		
	}
	public boolean combat(int obsCount) {
		for(int x=0; x<obsCount; x++) {
			int defObsHealth = obstacle.health;
			playerStats();
			enemiesStats();
			while(player.healhty>0 && obstacle.health>0) {
				System.out.println();
				System.out.println("<H>it or <R>un :");
				String selCase = key.next();
				selCase = selCase.toUpperCase();
				
				if(selCase.equals("H")) {
					System.out.println();
					System.out.println("You kicked it!");
					obstacle.health -= (player.getTotalDamage());
					afterHit();
					if(obstacle.health>0) {
						System.out.println(obstacle.name+" kicked you!");
						player.healhty = (player.healhty + player.inv.getArmor()) - obstacle.damage;
						afterHit();
					}
				} 
				
				else {
					player.healhty -= 1;
					System.out.println("You lost 1 point from your health because you run.");
					System.out.println("Your new health: "+player.healhty);
					break;
				}
			
			}
			
			
			if(obstacle.health<=0 && player.healhty>0) {
				System.out.println();
				System.out.println("You killed one enemy!!");
				player.money += obstacle.award;
				System.out.println("Current money: "+player.money);
				obstacle.health=defObsHealth;
				
			} else return false;
		}
		
		return true;
	}
	
	public void playerStats() {
		System.out.println("Player "+player.charName+" "+player.name+" informations: \n---------");
		System.out.println("Health: "+player.healhty);
		System.out.println("Damage: "+player.getTotalDamage());
		System.out.println("Money:  "+player.money);
		if(player.inv.getDamage()>0) {
			System.out.println("Weapon: "+player.inv.getwName());
		}
		if(player.inv.getArmor()>0) {
			System.out.println("Armor:  "+player.inv.getaName());
		}
	}
	
	public void enemiesStats() {
		System.out.println();
		System.out.println("Enemy "+obstacle.name+" information: \n---------");
		System.out.println("Name:   "+obstacle.name);
		System.out.println("Health: "+obstacle.health);
		System.out.println("Damage: "+obstacle.damage);
		System.out.println("Award:  "+obstacle.award);
	}
	
	public void afterHit() {
		System.out.println("Player health: "+player.healhty);
		System.out.println(obstacle.name + " health: "+obstacle.health);
		System.out.println();
	}

}























