import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {

		Scanner key = new Scanner(System.in);
		boolean again;
		System.out.println("!! Welcome to Sorror Planet !!");
		System.out.print("Create your name: ");
		String name = key.next();
		Player p1 = new Player(name);
		Game game = new Game(p1);
		game.login();	
		
		Inventory inventory = new Inventory();
		
		System.out.println("\nDO YOU WANT TO PLAY AGAIN?"
				+ "\n1. YES"
				+ "\n2. EXIT");
		int optn = key.nextInt();
		
		if(optn == 1) {
			again = true;
		}
		else {
			System.out.println("\nSorror Planet is waiting you, See you soon!!");
			again=false;
		}
	
		
		while(again) {
			//ClearConsole();
			
			System.out.println(new String(new char[70]).replace("\0", "\r\n"));
			
			System.out.println();
			System.out.println("!! Welcome to Sorror Planet Again!!");
			System.out.print("Create your name: ");
			name = key.next();
			p1 = new Player(name);
			game = new Game(p1);
			game.login();	
			inventory = new Inventory();
			
			System.out.println("\nDO YOU WANT TO PLAY AGAIN?"
					+ "\n1. YES"
					+ "\n2. EXIT");
			optn = key.nextInt();
			
			if(optn == 1) {
				again = true;
			}
			else {
				System.out.println("\nSorror Planet is waiting you, See you soon!!");
				again=false;
				break;
			}
		}
	}
	
	/*public static void ClearConsole(){
        try{
            String operatingSystem = System.getProperty("os.name"); //Check the current operating system
              
            if(operatingSystem.contains("Windows")){        
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } 
        }catch(final Exception e){
            System.out.println(e);
        }
    }*/

}
