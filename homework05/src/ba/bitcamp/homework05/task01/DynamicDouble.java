package ba.bitcamp.homework05.task01;

public class DynamicDouble {

	private double[] array;
	private int count;
	
	public DynamicDouble(int size, double value) {
		super();
		count = size;
		array = new double[size];
		for (int i = 0; i < count; i++) {
			array[i] = value;
		}
	}
	
	public DynamicDouble(int size) {
		this(size, 0.0);
		count = 0;
	}
	
	public DynamicDouble() {
		this(0, 0.0);
	}
	
	public void addElement(double value){
		if(count == array.length){
			double[] tmp = new double[2 * array.length + 1];
			for (int i = 0; i < array.length; i++) {
				tmp[i] = array[i];
			}
			array = tmp;
		}
		array[count] = value;
		count++;
	}
	
	public void addArray(double[] arr){
		for (int i = 0; i < arr.length; i++) {
			addElement(arr[i]);
		}
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	public int getTotalSize() {
		return array.length;
	}
	
	public void removeQuick(int index) throws IllegalArgumentException{
		if(index >= count)
			throw new IllegalArgumentException();
		array[index] = array[count - 1];
		count--;
		if(count <= array.length / 3){
			double[] tmp = new double[array.length / 2];
			for (int i = 0; i < count; i++) {
				tmp[i] = array[i];
			}
			array = tmp;
		}
	}

	public void remove(int index) throws IllegalArgumentException{
		if(index >= count)
			throw new IllegalArgumentException();
		for (int i = index; i < count - 1; i++) {
			array[i] = array[i + 1];
		}
		count--;
		if(count <= array.length / 3){
			double[] tmp = new double[array.length / 2];
			for (int i = 0; i < count; i++) {
				tmp[i] = array[i];
			}
			array = tmp;
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String s = count + "\t[";
		for (int i = 0; i < count; i++) {
			s += array[i];
			if(i != count - 1)
				s += ", ";
		}
		s += "]\n"+ array.length + "\t[";
		for (int i = 0; i < array.length; i++) {
			s += array[i];
			if(i != array.length - 1)
				s += ", ";
		}
		return s + "]";
	}
	
	
	
}
