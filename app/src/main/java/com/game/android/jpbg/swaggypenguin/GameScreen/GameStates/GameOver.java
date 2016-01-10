package com.game.android.jpbg.swaggypenguin.GameScreen.GameStates;

import com.game.android.jpbg.framework.Game;
import com.game.android.jpbg.swaggypenguin.GameResources;
import com.game.android.jpbg.swaggypenguin.GameScreen.IChangeGameStatus;

/**
 * Created by Joy on 1/1/16.
 */
public class GameOver extends AGameState{

    public static final String TYPE = "GAMEOVER";

    public GameOver(Game game, GameResources resources, IChangeGameStatus change) {
        super(game, resources, change);
    }

    @Override
    protected void functionUpdate(float deltaTime) {

    }
}
