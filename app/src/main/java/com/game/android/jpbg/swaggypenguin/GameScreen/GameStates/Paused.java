package com.game.android.jpbg.swaggypenguin.GameScreen.GameStates;

import com.game.android.jpbg.framework.Game;
import com.game.android.jpbg.swaggypenguin.GameResources;
import com.game.android.jpbg.swaggypenguin.GameScreen.IChangeGameStatus;
import com.game.android.jpbg.swaggypenguin.MainMenuScreen.MainMenuScreen;
import com.game.android.jpbg.swaggypenguin.R;
import com.game.android.jpbg.swaggypenguin.UI.GameImage;
import com.game.android.jpbg.swaggypenguin.UI.IExecute;

/**
 * Created by Joy on 1/1/16.
 */
public class Paused extends AGameState {

    public static final String TYPE = "PAUSED";

    public Paused(Game game, GameResources resources, IChangeGameStatus change) {
        super(game, resources, change);
        buttonHandler.add(gameResources.getImage(R.drawable.game_screen_resume_button),
                Math.round(20f / 480f * width), Math.round(20f / 800f * height), new Resume());
        buttonHandler.add(gameResources.getImage(R.drawable.game_screen_menu_button),
                Math.round(173f / 480f * width), Math.round(375f / 800f * height), new Menu());
        for(GameImage image: buttonHandler.getGameButtons()){
            images.add(image);
        }
    }

    private class Resume implements IExecute{
        @Override
        public void execute() {
            change.changeGameStatus(Playing.TYPE);
        }
    }

    private class Menu implements IExecute{
        @Override
        public void execute() {
            game.setScreen(new MainMenuScreen(game,gameResources));
        }
    }

    @Override
    protected void functionUpdate(float deltaTime) {

    }
}
