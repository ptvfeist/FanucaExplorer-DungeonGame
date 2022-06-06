package org.academiadecodigo.unbitables.audio;

import javax.sound.sampled.Clip;

public class AudioClip {
    private final Clip clip;

public AudioClip(Clip clip) {
    this.clip = clip;
    clip.start();
    clip.loop(Clip.LOOP_CONTINUOUSLY);
}
}
