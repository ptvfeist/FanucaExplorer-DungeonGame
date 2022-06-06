package org.academiadecodigo.unbitables.audio;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AudioPlayer {
    private List<AudioClip> audioClips;

    public AudioPlayer() {
        audioClips = new ArrayList<>();
    }

    // Musicas de fundo
    public void playMusic (String filename) {
        final Clip clip = getClip(filename);
        audioClips.add(new AudioClip(clip));
    }

    // Efeitos Especiais

    /* public void playSound (String filename) {
        final Clip clip = getClip(filename);
        audioClips.add(new SoundClip(clip));

    } */

    private Clip getClip(String filename) {
        final URL soundFile = AudioPlayer.class.getResource("/sounds/" + filename);
        try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile)) {
            final Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.setMicrosecondPosition(0);
            return clip;

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);

        }
    }
}


