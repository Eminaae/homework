package ba.bitcamp.homework02.task02;
/**
 * Describes temperature outside.
 * 
 * @author Emina
 *
 */
public class Temperature {
	double temperature;
	
	/**
	 * Default constructor.
	 * 
	 * @param temperature - temperature in Celsius degreees
	 */
	public Temperature(double temperature) {
		this.temperature = temperature;
	}

	/**
	 * Returns temperature in Celsius degrees.
	 */
	public double getTemperatureInC() {
		return temperature;
	}

	/**
	 * Returns temperature in Kelvin degrees.
	 */
	public double getTemperatureInK() {
		return temperature + 273.15;
	}

	/**
	 * Returns temperature in Fahrenheit degrees.
	 */
	public double getTemperatureInF() {
		return temperature * 1.8 + 32;
	}

	/**
	 * Sets temperature value.
	 * 
	 * @param temp
	 */
	public void setTemperature(int temp) {
		temperature = temp;
	}

}
