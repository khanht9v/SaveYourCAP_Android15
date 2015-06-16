package capprotectors.saveyourcap;

import capprotectors.framework.Game;
import capprotectors.framework.Graphics;
import capprotectors.framework.Graphics.ImageFormat;
import capprotectors.framework.Screen;

public class LoadingScreen extends Screen {
    public LoadingScreen(Game game) {
        super(game);
    }

    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();

        Assets.menu = g.newImage("menu.png", ImageFormat.RGB565);
        Assets.background = g.newImage("background.png", ImageFormat.RGB565);
//        Assets.button = g.newImage("button.jpg", ImageFormat.RGB565);
        Assets.student = g.newImage("student.jpg", ImageFormat.ARGB4444);
        Assets.professor = g.newImage("professor.jpg", ImageFormat.ARGB4444);

        Assets.click = game.getAudio().createSound("click.ogg");

        game.getAudio().createSound("fuse.ogg").play(1f);
        try {
            Thread.sleep(2408);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        game.setScreen(new MainMenuScreen(game));
    }

    @Override
    public void paint(float deltaTime) {
        Graphics g = game.getGraphics();
        g.drawScaledImage(Assets.splash, 0, 0, g.getWidth(), g.getHeight(), 0, 0, Assets.splash.getWidth(), Assets.splash.getHeight());
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void backButton() {

    }
}