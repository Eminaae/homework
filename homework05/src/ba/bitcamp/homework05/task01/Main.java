package ba.bitcamp.homework05.task01;

public class Main {

	public static void main(String[] args) {
		
		DynamicDouble d = new DynamicDouble(3);
		System.out.println(d);
		d.addElement(4);
		System.out.println(d);
		double[] a = {1,2,3,4,5,6,7,8,9,10};
		d.addArray(a);
		System.out.println(d);
		d.addElement(4);
		System.out.println(d);
		d.addElement(4);
		System.out.println(d);
		d.removeQuick(8);
		System.out.println(d);
		d.remove(5);
		d.remove(5);
		d.remove(5);
		d.remove(5);
		d.remove(5);
		d.remove(5);
		d.remove(5);
		System.out.println(d);
	}
}