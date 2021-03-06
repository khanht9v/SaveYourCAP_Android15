package capprotectors.saveyourcap;

import capprotectors.framework.Image;
import capprotectors.framework.Music;
import capprotectors.framework.Sound;

public class Assets {
    public static Image menu, splash, background, button;
    public static Image student, professor;
    public static Sound click;
    public static Music theme;

    public static void load(MainGame mainGame) {
        theme = mainGame.getAudio().createMusic("menutheme.mp3");
        theme.setLooping(true);
        theme.setVolume(0.85f);
        theme.play();
    }
}
