package ba.bitcamp.homework01.task01;

public class MainFootballerTeam {

		public static void main(String[] args) {
			
			Footballer f1 = new Footballer("Miralem Pjanic,", 1990, ", Midfielder");
			Footballer f2 = new Footballer("Vedad Ibisevic", 1984,"Striker");
			Footballer f3 = new Footballer("Emir Spahic", 1980, "Centre back");
			Footballer f4 = new Footballer("Muhamed Besic", 1992, "Defensive midfielder");
			Footballer f5 = new Footballer("Avdija Vrsajevic", 1986, "Right back");
			Footballer f6 = new Footballer("Edin Dzeko", 1986, "Forward");
			
			System.out.println(f1.name + " " +  f1.yob + " " + f1.position);
			System.out.println(f2.name + " " +  f2.yob + " " + f2.position);
			System.out.println(f3.name + " " +  f3.yob + " " + f3.position);
			System.out.println(f4.name + " " +  f4.yob + " " + f4.position);
			System.out.println(f5.name + " " +  f5.yob + " " + f5.position);
			System.out.println(f6.name + " " +  f6.yob + " " + f6.position);
			
			Footballer [] footballers = new Footballer []{f1, f2, f3, f4, f5, f6};
			Team t = new Team("Reprezentacija BiH", footballers);
			
			System.out.println(countPlayers(t, 1980));
			System.out.println(countPlayers(t, "Striker"));
			System.out.println(getYoungestPlayer(t));
		}
		
		public static int countPlayers(Team t, int year){
			int counter = 0;
			for(int i = 0; i < t.footballers.length; i++){
				if(t.footballers[i].yob == year){
					counter++;
				}
			}
			return counter;	
		}
		
		public static int countPlayers(Team t, String position){
			int counter = 0;
			for(int i = 0; i < t.footballers.length; i++){
				if(t.footballers[i].position == position){
					counter ++;
				}
			}
			return counter;	
		}
		
		public static Footballer getYoungestPlayer(Team t){
			Footballer youngestPlayer = t.footballers[0];
			for(int i = 0; i < t.footballers.length; i++){
				if(youngestPlayer.yob < t.footballers[i].yob){
						youngestPlayer = t.footballers[i];
				}
			}
			return youngestPlayer;
		}
}


