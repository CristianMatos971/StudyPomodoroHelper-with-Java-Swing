package MyThreads;

public class RestingTime {

	private static int FinalRT = 0;
	private static int RT;
	private static PlayAlarm a1;

	RestingTime() {

	}

	public static void decreaseRT(int Rdc) throws InterruptedException {

		PlayAlarm.setShouldPlay(false);

		MyThread1.running = true;

		int x = Rdc;
		RestingTime.RT -= x;

		if (RestingTime.RT <= 0) {

			WorkingTime.isWTRunning = true;

			WorkingTime.setWT(WorkingTime.getFinalWT());
			RestingTime.setRT(RestingTime.getFinalRT());

			MyThread1.running = false;

			if (RestingTime.getRT() == RestingTime.getFinalRT()) {
				PlayAlarm.setShouldPlay(true);
				a1 = new PlayAlarm();
				a1.setPriority(4);
				a1.start();
			} else {
				a1.interrupt();
			}

			System.out.println("one resting session finished!");

		}
	}

	public static int getFinalRT() {
		return FinalRT;
	}

	public static void setFinalRT(int FRT) {
		int x = FRT;
		RestingTime.FinalRT = x;
	}

	public static int getRT() {
		return RT;
	}

	public static void setRT(int RT) {
		RestingTime.RT = RT;
	}

}
