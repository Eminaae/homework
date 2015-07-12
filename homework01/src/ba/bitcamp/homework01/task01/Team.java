package ba.bitcamp.homework01.task01;

public class Team {

		public String name;
		public Footballer [] footballers; // String represents 

		public Team(String name, Footballer[] footballers) {
			super();
			this.name = name;
			this.footballers = footballers;
		}

		@Override
		public String toString() {
			String s = "";
			s += "Name: " + name + "\n";
			return s;
		}
		
		public String toString1(){
			String s = "Team name: " + name + "\n";
			s += "*************************";
			for (int i = 0; i < footballers.length; i++) {
			s += "\n" + footballers[i] + "\n";
			}
			s += "*************************\n";
			return s;
		}
	}




