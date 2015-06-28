package capprotectors.saveyourcap;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

import com.swarmconnect.Swarm;

import java.util.List;

import capprotectors.framework.Game;
import capprotectors.framework.Graphics;
import capprotectors.framework.Input.TouchEvent;
import capprotectors.framework.Screen;
import capprotectors.implementation.AndroidGame;

public class MainMenuScreen extends Screen {
    public MainMenuScreen(Game game) {
        super(game);
    }

    @Override
    public void update(float deltaTime) {
        //Graphics g = game.getGraphics();
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();

        for (TouchEvent event : touchEvents) {
            if (event.type == TouchEvent.TOUCH_UP) {

                if (inBounds(event, 50, 300, 550, 300)) {
                    //START GAME
                    Assets.click.play(1f);
                    game.setScreen(new GameScreen(game));
                }

                if (inBounds(event, 50, 620, 550, 750 - 620)) {
                    Assets.click.play(1f);
                    Swarm.showDashboard();
                }

                if (inBounds(event, 620, 295, 1235 - 620, 365 - 295)) {
                    Assets.click.play(1f);
                    toggleMusic();
                }

                if (inBounds(event, 620, 380, 1235 - 620, 440 - 380)) {
                    Assets.click.play(1f);
                    Swarm.showAchievements();
                }

                if (inBounds(event, 620, 460, 1230 - 620, 530 - 460)) {
                    Assets.click.play(1f);
                    Swarm.showLeaderboards();
                }

                if (inBounds(event, 620, 555, 1235 - 620, 620 - 555)) {
                    Assets.click.play(1f);
                    Swarm.showStore();
                }

                if (inBounds(event, 650, 640, 1230 - 620, 110)) {
                    confirmExit();
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
        g.drawScaledImage(Assets.mainmenu, 0, 0, g.getWidth(), g.getHeight(), 0, 0, Assets.mainmenu.getWidth(), Assets.mainmenu.getHeight());
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
        Assets.theme.play();
    }

    @Override
    public void dispose() {

    }

    @Override
    public void backButton() {
        //Display "Exit Game?" Box
        confirmExit();
    }

    public void toggleMusic() {
        ((AndroidGame) game).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                AlertDialog.Builder builder = new AlertDialog.Builder((AndroidGame) game);
                builder.setCancelable(true);
                builder.setMessage("The only setting: Toggle Music :D");
                builder.setPositiveButton("Music on!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Assets.theme.setVolume(0.85f);
                        dialog.cancel();
                    }
                });
                builder.setNegativeButton("No music plz", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Assets.theme.setVolume(0);
                        dialog.cancel();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }

    public void confirmExit() {
        ((AndroidGame) game).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                AlertDialog.Builder builder = new AlertDialog.Builder((AndroidGame) game);
                builder.setCancelable(false);
                builder.setMessage("Do you want to Exit?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //if user pressed "yes", then he is allowed to exit from application
                        ((AndroidGame) MainMenuScreen.this.game).finish();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //if user select "No", just cancel this dialog and continue with app
                        dialog.cancel();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }

}