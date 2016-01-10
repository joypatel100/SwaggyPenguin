package com.game.android.jpbg.swaggypenguin.GameScreen.GameStates;

import com.game.android.jpbg.framework.Game;
import com.game.android.jpbg.swaggypenguin.GameResources;
import com.game.android.jpbg.swaggypenguin.GameScreen.IChangeGameStatus;
import com.game.android.jpbg.swaggypenguin.R;
import com.game.android.jpbg.swaggypenguin.UI.GameButton;
import com.game.android.jpbg.swaggypenguin.UI.GameImage;
import com.game.android.jpbg.swaggypenguin.UI.IExecute;
import com.game.android.jpbg.swaggypenguin.Utility;

/**
 * Created by Joy on 1/1/16.
 */
public class Ready extends AGameState {

    public static final String TYPE = "READY";
    private GameButton tapToStart;
    private GameImage getReady;

    public Ready(Game g, GameResources resources, IChangeGameStatus change){
        super(g,resources,change);
        tapToStart = Utility.initGameButton(gameResources.getImage(R.drawable.game_screen_tap_to_start_button),
                Math.round(170f / 480f * width), Math.round(255f / 800f * height), new TapToStart());
        getReady = Utility.initGameImage(gameResources.getImage(R.drawable.game_screen_get_ready),
                Math.round(80f / 480f * width), Math.round(130f / 800f * height));
        images.add(tapToStart);
        images.add(getReady);
        buttonHandler.add(tapToStart);
    }

    private class TapToStart implements IExecute{
        @Override
        public void execute() {
            change.changeGameStatus(Playing.TYPE);
        }
    }

    @Override
    protected void functionUpdate(float deltaTime) {

    }



}
