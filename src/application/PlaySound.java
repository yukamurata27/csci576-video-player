package application;

import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedInputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.Clip;

/**
 * 
 * <Replace this with a short description of the class.>
 * 
 * @author Giulio
 */
public class PlaySound {

    private InputStream waveStream;
    private AudioInputStream audioInputStream;
    private InputStream bufferedIn;
    private Clip clip;
    private int framePos;

    /**
     * CONSTRUCTOR
     */
    public PlaySound(InputStream waveStream) {
		this.waveStream = waveStream;
    }

    public void initSoundFile () {
    	try {
    		framePos = 0;
			bufferedIn = new BufferedInputStream(this.waveStream);
			AudioInputStream sound = AudioSystem.getAudioInputStream(bufferedIn);

	        clip = AudioSystem.getClip();
	        clip.open(sound);
	    } catch (Exception e) {}
    }

    public void play() {
        clip.setFramePosition(framePos);
        clip.start();
    }

    public void pause() {
        clip.stop();
        framePos = clip.getFramePosition();
    }

    public void stop() {
        clip.stop();
        framePos = 0;
    }
}
