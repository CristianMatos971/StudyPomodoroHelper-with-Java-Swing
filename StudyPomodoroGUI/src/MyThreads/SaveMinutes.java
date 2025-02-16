package MyThreads;

public class SaveMinutes {
	private static int mins;

	SaveMinutes() {

	}

	public static int getMins() {
		return mins;
	}

	public static void setMins(int mins) {
		int x = mins;
		SaveMinutes.mins += x;
	}

}
