package org.academiadecodigo.unbitables.audio;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class Sound {

    Clip clip;
    URL soundURL[] = new URL[20];

    public Sound() {

        soundURL[0] = getClass().getResource("/sounds/Title.wav");
        soundURL[1] = getClass().getResource("/sounds/SE1.wav");
        soundURL[2] = getClass().getResource("/sounds/SE2.wav");
        soundURL[3] = getClass().getResource("/sounds/start1.wav");
        soundURL[4] = getClass().getResource("/sounds/ .wav");


    }

    public void setFile(int i) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (Exception e) {
        }
    }

    public void playMusic(int i) {

        setFile(i);
        play(i);
        loop();
    }

    public void playSE(int i) {

        setFile(i);
        play(i);
    }

    public void stopMusic() {

        stop();
    }


    public void play(int i) {
        clip.start();
    }

    public void stop() {
        clip.stop();
    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}
