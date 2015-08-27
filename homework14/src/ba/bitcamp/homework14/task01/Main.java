package ba.bitcamp.homework14.task01;

public class Main {
	
	public static void main(String[] args) {
		try {
			ConnectToDatabase.connect();
		} catch (ClassNotFoundException e) {
			System.err.println("JDBC library is not loaded.");
			System.err.println("Msg: " + e.getMessage());
			System.exit(1);
		}
		new GuiSendCompaint();
		new GuiViewComplaint();
	}
}
