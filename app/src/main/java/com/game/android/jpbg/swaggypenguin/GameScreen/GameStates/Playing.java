package com.game.android.jpbg.swaggypenguin.GameScreen.GameStates;

import com.game.android.jpbg.framework.Game;
import com.game.android.jpbg.swaggypenguin.GameResources;
import com.game.android.jpbg.swaggypenguin.GameScreen.GamePlay.GameImageId;
import com.game.android.jpbg.swaggypenguin.GameScreen.GamePlay.IGameModelObject;
import com.game.android.jpbg.swaggypenguin.GameScreen.GamePlay.SwaggyPenguinGameModel;
import com.game.android.jpbg.swaggypenguin.GameScreen.IChangeGameStatus;
import com.game.android.jpbg.swaggypenguin.R;
import com.game.android.jpbg.swaggypenguin.UI.GameButton;
import com.game.android.jpbg.swaggypenguin.UI.IExecute;
import com.game.android.jpbg.swaggypenguin.Utility;

/**
 * Created by Joy on 1/1/16.
 */
public class Playing extends AGameState {

    public static final String TYPE = "PLAYING";
    private GameButton pause;
    private IGameModelObject model;

    public Playing(Game game, GameResources resources, IChangeGameStatus change) {
        super(game, resources, change);
        pause = Utility.initGameButton(gameResources.getImage(R.drawable.game_screen_pause_button),
                Math.round(20f / 480f * width), Math.round(20f / 800f * height), new Pause());
        images.add(pause);
        buttonHandler.add(pause);
        model = new SwaggyPenguinGameModel(width,height);
    }

    private class Pause implements IExecute{
        @Override
        public void execute() {
            change.changeGameStatus(Paused.TYPE);
        }
    }

    @Override
    protected void functionUpdate(float deltaTime) {
        model.update(deltaTime, game.getInput());
        images.clear();
        for(GameImageId id: model.getImageIds()) {
            images.add(Utility.initGameImage(gameResources, id.getId(), (int) id.getX(), (int) id.getY(), id.getGameImagePosition(),id.getWithRespectToId()));
        }
        images.add(pause);
    }





}
