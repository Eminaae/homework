package ba.bitcamp.homework07.task01;

public class Main {

	public static void main(String[] args) {
		LinkedListDouble list = new LinkedListDouble();
		
		list.add(2.33);
		list.add(5.0);
		list.add(7.9);
		list.add(88.87);
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		System.out.println(list.size());
		list.remove(3);
	
		list.add(2, 2);	
		System.out.println(list);
	}

}
