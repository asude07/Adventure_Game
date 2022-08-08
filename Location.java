
public abstract class Location {
	protected Player player;
	protected String locName;
	
	public Location(Player p) {
		player = p;
	}
	
	public abstract boolean getLocation();

}
