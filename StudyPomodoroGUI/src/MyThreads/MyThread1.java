package MyThreads;

public class MyThread1 extends Thread {

	public MyThread1() {

	}

	public static boolean running = true;
	public int i = 0;
	public static int secsArm;
	private int minsArm;

	@Override
	public void run() {

		secsArm = SaveSeconds.getSecs();
		minsArm = SaveMinutes.getMins();

		System.out.println("Started running!");
		for (i = secsArm; i < 61; i++) {
			if (i == 60) {
				SaveMinutes.setMins(1);
				WorkingTime.setWT(WorkingTime.getWTime());

				if (WorkingTime.isWTRunning == true) {

					try {
						WorkingTime.decreaseWT(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else if (WorkingTime.isWTRunning == false) {

					try {
						RestingTime.decreaseRT(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					if (RestingTime.getRT() == 1) {
						PlayAlarm.setShouldPlay(true);

					}

				}

				MyFrame.startChangingMins();
				i = 0;
			}
			System.out.println(SaveSeconds.getSecs() + ", WT left: " + WorkingTime.getWTime() + ", RT LEFT:"
					+ RestingTime.getRT());
			SaveSeconds.setSecs(i);
			MyFrame.startChanging();
			try {
				Thread.sleep(1000);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (i == 61) {
				SaveSeconds.setSecs(0);

			}
			if (running == false) {
				try {
					SaveSeconds.setSecs(i);
					stopRunning();
					break;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

	}

	public static int getSecsLeft() {
		return secsArm;
	}

	public void stopRunning() throws InterruptedException {
		this.interrupt();
	}
}
