package MyThreads;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class PlayAlarm extends Thread {

	static String filePath = "C:\\Users\\Roger\\git\\StudyPomodoroGUI\\Alarm Sound.aiff";
	static File file = new File(filePath);
	private static boolean shouldPlay = false;
	public static boolean AlarmRunning = false;

	public static boolean getShouldPlay() {
		return shouldPlay;
	}

	public static void setShouldPlay(boolean shouldPlay) {
		PlayAlarm.shouldPlay = shouldPlay;
	}

	public void run() {

		AudioInputStream audioStream = null;
		try {
			audioStream = AudioSystem.getAudioInputStream(file);
		} catch (UnsupportedAudioFileException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Clip clip = null;
		try {
			clip = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			clip.open(audioStream);
		} catch (LineUnavailableException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while (shouldPlay == true) {
			clip.start();
		}

		clip.stop();
		clip.setFramePosition(0);

	}

	public PlayAlarm() {

	}

}
