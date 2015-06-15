package capprotectors.saveyourcap;

import java.util.List;

import capprotectors.framework.Game;
import capprotectors.framework.Graphics;
import capprotectors.framework.Input.TouchEvent;
import capprotectors.framework.Screen;

public class MainMenuScreen extends Screen {
    public MainMenuScreen(Game game) {
        super(game);
    }

    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();

        for (TouchEvent event: touchEvents) {
            if (event.type == TouchEvent.TOUCH_UP) {

                if (inBounds(event, 0, g.getHeight()-150, 250, g.getHeight())) {
                    //START GAME
                    Assets.click.play(1f);
                    game.setScreen(new GameScreen(game));
                }

            }
        }
    }

    private boolean inBounds(TouchEvent event, int x, int y, int width,
                             int height) {
        return event.x > x && event.x < x + width - 1 && event.y > y
                && event.y < y + height - 1;
    }

    @Override
    public void paint(float deltaTime) {
        Graphics g = game.getGraphics();
        g.drawScaledImage(Assets.menu, 0, 0, g.getWidth(), g.getHeight(), 0, 0, Assets.menu.getWidth(), Assets.menu.getHeight());
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
        //Display "Exit Game?" Box
    }
}
