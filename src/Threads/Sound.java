package Threads;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import Sounds.AudioStorage;

public class Sound extends Thread {
	
	private static Clip soundClip;
	private AudioInputStream audioStream;

	public Sound() {
		try {
			audioStream = AudioSystem.getAudioInputStream(getClass().getResource(AudioStorage.getAudioTable().get("mainTheme")));
		} catch (IOException | UnsupportedAudioFileException e) {
			e.printStackTrace();
		}
	}
	
	public static Clip getSoundClip() {
		return soundClip;
	}
	
	public void updateSound(String soundName) {
		try {
			audioStream = AudioSystem.getAudioInputStream(getClass().getResource(AudioStorage.getAudioTable().get(soundName)));
		} catch (IOException | UnsupportedAudioFileException e) {
			e.printStackTrace();
		}
	}
	
	public void startSound(float volume, int loop) {
		try {
			soundClip = AudioSystem.getClip();
			soundClip.open(audioStream);
		} catch (LineUnavailableException | IOException e) {
			e.printStackTrace();
		}
		FloatControl gainControl = (FloatControl) soundClip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(volume);
		soundClip.start();
		soundClip.loop(loop);
	}

	public void run() {
		startSound(-20f, MAX_PRIORITY);
	}
}
