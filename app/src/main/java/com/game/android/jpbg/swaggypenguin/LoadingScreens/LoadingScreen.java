package com.game.android.jpbg.swaggypenguin.LoadingScreens;

import android.util.Log;

import com.game.android.jpbg.framework.Game;
import com.game.android.jpbg.framework.Graphics;
import com.game.android.jpbg.framework.Screen;
import com.game.android.jpbg.framework.implementation.Location;
import com.game.android.jpbg.swaggypenguin.GameResources;
import com.game.android.jpbg.swaggypenguin.MainMenuScreen.MainMenuScreen;
import com.game.android.jpbg.swaggypenguin.R;

/**
 * Created by Joy on 8/19/15.
 */
public class LoadingScreen extends Screen {

    private final String LOG_TAG = LoadingScreen.class.getSimpleName();
    GameResources gameResources;

    public LoadingScreen(Game game, GameResources resources) {
        super(game);
        Graphics graphics = this.game.getGraphics();
        gameResources = resources;
        graphics.drawImage(gameResources.getImage(R.drawable.splash_screen),new Location(0,0));
    }

    @Override
    public void update(float deltaTime) {
        Log.v(LOG_TAG,"Update loading screen");
        gameResources.setupValues(game);
        game.setScreen(new MainMenuScreen(game,gameResources));
    }

    @Override
    public void paint(float deltaTime) {
        Graphics g = game.getGraphics();
        g.drawImage(gameResources.getImage(R.drawable.splash_screen),new Location(0,0));
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
