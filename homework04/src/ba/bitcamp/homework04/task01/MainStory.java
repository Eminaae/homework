package ba.bitcamp.homework04.task01;

public class MainStory {

	public static void main(String[] args) {
				System.out.println("*The Lion King* \n");
				Character c1 = new Character("Simba", "Male", true, true); 
				Character c2 = new Character("Mufasa", "Male", false, false); 
				Character c3 = new Character("Nala", "Female", true, true); 
				Character c4 = new Character("Scar", "Male", true, true); 
				
				Event e1 = new Event(3); 
				Goal g1 = new Goal("Revenge", 1, e1, c2); 
				
				Protagonist p1 = new Protagonist("Simba", "Male", true, g1); 
				p1.setEnemy(c2); //sets enemy
				p1.setEnemy(c1);
				
				
				System.out.println(c1);
				c1.transmuteCharacter(); //making character capable or incapable;
				System.out.println();
				System.out.println(c1); //printing out same Character with changes
				c1.killCharacter(); //killing Simba
				System.out.println();
				
					
				
				p1.addHelpingCharacter(c1);
				p1.addHelpingCharacter(c2);
				p1.addHelpingCharacter(c4);
				
			
				p1.attainGoal();
			
	}

}
