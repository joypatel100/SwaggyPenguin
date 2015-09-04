package com.game.android.jpbg.swaggypenguin;

import com.game.android.jpbg.framework.Game;
import com.game.android.jpbg.framework.Graphics;
import com.game.android.jpbg.framework.Graphics.ImageFormat;
import com.game.android.jpbg.framework.Screen;

/**
 * Created by Joy on 8/19/15.
 */
public class SplashLoadingScreen extends Screen {

    private final String LOG_TAG = SplashLoadingScreen.class.getSimpleName();

    public SplashLoadingScreen(Game game) {
        super(game);
    }

    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        GameValues.splashImg = g.newImage(R.drawable.splash_screen, ImageFormat.RGB565);

        game.setScreen(new LoadingScreen(game));
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
