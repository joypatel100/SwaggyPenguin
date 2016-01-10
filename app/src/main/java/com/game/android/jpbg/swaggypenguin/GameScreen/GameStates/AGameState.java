package com.game.android.jpbg.swaggypenguin.GameScreen.GameStates;

import com.game.android.jpbg.framework.Game;
import com.game.android.jpbg.swaggypenguin.GameResources;
import com.game.android.jpbg.swaggypenguin.GameScreen.IChangeGameStatus;
import com.game.android.jpbg.swaggypenguin.UI.GameButtonHandler;
import com.game.android.jpbg.swaggypenguin.UI.GameImage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joy on 1/1/16.
 */
public abstract class AGameState {

    protected GameResources gameResources;
    protected Game game;
    protected float width,height;
    protected List<GameImage> images;
    protected IChangeGameStatus change;
    protected GameButtonHandler buttonHandler;

    public AGameState(Game game, GameResources resources, IChangeGameStatus change){
        this.game = game;
        this.gameResources = resources;
        this.width = game.getGraphics().getWidth();
        this.height = game.getGraphics().getHeight();
        this.images = new ArrayList<>();
        this.change = change;
        this.buttonHandler = new GameButtonHandler();
    }

    public void update(float deltaTime){
        buttonHandler.execute(deltaTime,game.getInput().getTouchEvents());
        functionUpdate(deltaTime);

    }

    protected abstract void functionUpdate(float deltaTime);

    public List<GameImage> getImages(){
        return this.images;
    }

}
