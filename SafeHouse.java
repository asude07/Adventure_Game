
public class SafeHouse extends NormalLoc{

	public SafeHouse(Player p) {
		super(p, "Safe House");
	}

	public boolean getLocation() {
		super.getLocation();
		player.healhty=player.realHealhty;
		System.out.println("Your healthy is renewed as "+player.healhty+".");
		System.out.println("Items you collected: ");
		if(player.inv.isFirewood()) {
			System.out.println("---> Firewood");
		}
		if(player.inv.isFood()) {
			System.out.println("---> Food");
		}
		if(player.inv.isWater()) {
			System.out.println("---> Water");
		}
		if(!player.inv.isFirewood() && !player.inv.isFood() && !player.inv.isWater()) {
			System.out.println("---> EMPTY <----");
		}
		
		return true;
	}

}
