package com.game.android.jpbg.swaggypenguin;

import android.util.Log;

import com.game.android.jpbg.framework.Game;
import com.game.android.jpbg.framework.Graphics;
import com.game.android.jpbg.framework.Screen;

/**
 * Created by Joy on 8/19/15.
 */
public class LoadingScreen extends Screen {

    private final String LOG_TAG = LoadingScreen.class.getSimpleName();

    public LoadingScreen(Game game) {
        super(game);
    }

    @Override
    public void update(float deltaTime) {
        Log.v(LOG_TAG,"Update loading screen");
        Graphics g = game.getGraphics();
        GameValues.setupValues(game);

        game.setScreen(new MainMenuScreen(game));
    }

    @Override
    public void paint(float deltaTime) {
        Graphics g = game.getGraphics();
        g.drawImage(GameValues.splashImg, GameValues.splashImgLocation);
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
