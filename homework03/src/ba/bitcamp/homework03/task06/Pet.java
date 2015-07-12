package ba.bitcamp.homework03.task06;

public abstract class Pet {
	protected static final int DOG = 0;
	protected static final int CAT = 1;
	
	private String name;
	private int year;
	private int type;
	
	public Pet(String name, int year, int type) {
		super();
		this.name = name;
		this.year = year;
		this.type = type;
	}
	@Override
	public String toString(){
		String s = "";
		if(this.type==Pet.DOG){
			s="Av Av";
		} else {
			s = "Go away human";
		}
		return s;
	}
}
