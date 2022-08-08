
public abstract class NormalLoc extends Location {

	public NormalLoc(Player p, String n) {
		super(p);
		this.locName = n;
		
	}
	
	public boolean getLocation() {
		System.out.println("You are in the "+this.locName);
		return true;
	}

}
