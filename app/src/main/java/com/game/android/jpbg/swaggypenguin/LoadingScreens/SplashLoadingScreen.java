package com.game.android.jpbg.swaggypenguin.LoadingScreens;

import com.game.android.jpbg.framework.Game;
import com.game.android.jpbg.framework.Screen;
import com.game.android.jpbg.swaggypenguin.GameResources;

/**
 * Created by Joy on 8/19/15.
 */
public class SplashLoadingScreen extends Screen {

    private final String LOG_TAG = SplashLoadingScreen.class.getSimpleName();
    GameResources gameResources;

    public SplashLoadingScreen(Game game) {
        super(game);
        gameResources = new GameResources(game);
    }

    @Override
    public void update(float deltaTime) {
        game.setScreen(new LoadingScreen(game,gameResources));
    }

    @Override
    public void paint(float deltaTime) {

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
