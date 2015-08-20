package com.game.android.jpbg.swaggypenguin;

import com.game.android.jpbg.framework.Screen;
import com.game.android.jpbg.framework.implementation.AndroidGame;

/**
 * Created by Joy on 8/19/15.
 */
public class SwaggyPenguinGame extends AndroidGame {

    private final String LOG_TAG = SwaggyPenguinGame.class.getSimpleName();

    boolean firstTimeCreate = true;

    @Override
    public Screen getInitScreen() {
        if(firstTimeCreate){
            firstTimeCreate = false;
        }

        return new SplashLoadingScreen(this);
    }
}
