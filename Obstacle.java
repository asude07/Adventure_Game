import java.util.Random;
public class Obstacle {
	public String name;
	public int damage, award, health, maxNumber;
	
	public Obstacle(String name, int damage, int award, int health, int maxNumber) {
		
		this.name = name;
		this.damage = damage;
		this.award = award;
		this.health = health;
		this.maxNumber = maxNumber;
	}
	
	public int obstacleCount() {
		Random r = new Random();
		return r.nextInt(this.maxNumber)+1;
		
	}
	
	
}
