package MyThreads;

public class WorkingTime {

	private static int worktime;
	private static int FinalWT;
	public static boolean isWTRunning = true;
	private static PlayAlarm a1;

	WorkingTime() {

	}

	public static int getWTime() {
		return worktime;
	}

	public static void setWT(int WT) {
		int x = WT;
		WorkingTime.worktime = x;
	}

	public static int getFinalWT() {
		return FinalWT;
	}

	public static void setFinalWT(int FWT) {
		int x = FWT;
		WorkingTime.FinalWT = x;
	}

	public static void decreaseWT(int dc) throws InterruptedException {

		PlayAlarm.setShouldPlay(false);

		MyThread1.running = true;

		int x = dc;
		WorkingTime.worktime -= dc;

		if (WorkingTime.worktime <= 0) {

			WorkingTime.isWTRunning = false;
			WorkingTime.setWT(WorkingTime.getFinalWT());

			MyThread1.running = false;

			if (WorkingTime.getWTime() == WorkingTime.getFinalWT()) {
				PlayAlarm.setShouldPlay(true);
				a1 = new PlayAlarm();
				a1.setPriority(10);
				a1.start();
			} else {
				a1.interrupt();
			}

			System.out.println("one session finished!");

		}

	}

}
