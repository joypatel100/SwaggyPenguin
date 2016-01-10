package com.game.android.jpbg.swaggypenguin.GameScreen;

import com.game.android.jpbg.framework.Game;
import com.game.android.jpbg.framework.Graphics;
import com.game.android.jpbg.framework.Screen;
import com.game.android.jpbg.swaggypenguin.GameScreen.GameStates.AGameState;
import com.game.android.jpbg.swaggypenguin.GameScreen.GameStates.GameOver;
import com.game.android.jpbg.swaggypenguin.GameScreen.GameStates.Paused;
import com.game.android.jpbg.swaggypenguin.GameScreen.GameStates.Playing;
import com.game.android.jpbg.swaggypenguin.GameScreen.GameStates.Ready;
import com.game.android.jpbg.swaggypenguin.UI.GameImage;
import com.game.android.jpbg.swaggypenguin.GameResources;
import com.game.android.jpbg.swaggypenguin.R;
import com.game.android.jpbg.swaggypenguin.Utility;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Joy on 8/23/15.
 */
public class GameScreen extends Screen implements IChangeGameStatus{

    private final String LOG_TAG = GameScreen.class.getSimpleName();

    private GameResources gameResources;
    private GameImage background;
    private AGameState currentState;
    private Map<String,AGameState> stateMap;


    public GameScreen(Game game, GameResources resources){
        super(game);
        stateMap = new HashMap<>();
        gameResources = resources;
        background = Utility.initGameImage(gameResources.getImage(R.drawable.game_screen_background_0), 0, 0);
        stateMap.put(Ready.TYPE,new Ready(game,gameResources,this));
        stateMap.put(Playing.TYPE, new Playing(game,gameResources,this));
        stateMap.put(Paused.TYPE, new Paused(game,gameResources,this));
        stateMap.put(GameOver.TYPE,new GameOver(game,gameResources,this));
        currentState = stateMap.get(Ready.TYPE);
    }

    @Override
    public void changeGameStatus(String status) {
        currentState = stateMap.get(status);
    }

    @Override
    public void update(float deltaTime) {
        currentState.update(deltaTime);
    }

    @Override
    public void paint(float deltaTime) {
        Graphics graphics = game.getGraphics();
        graphics.drawImage(background.getImage(),background.getLocation());
        for(GameImage image: currentState.getImages()){
            graphics.drawImage(image.getImage(),image.getLocation());
        }
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        // make stuff null
    }

    @Override
    public void backButton() {

    }


}
