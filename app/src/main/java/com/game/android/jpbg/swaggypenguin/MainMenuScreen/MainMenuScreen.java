package com.game.android.jpbg.swaggypenguin.MainMenuScreen;

import com.game.android.jpbg.framework.Game;
import com.game.android.jpbg.framework.Graphics;
import com.game.android.jpbg.framework.Screen;
import com.game.android.jpbg.swaggypenguin.Animation;
import com.game.android.jpbg.swaggypenguin.GameResources;
import com.game.android.jpbg.swaggypenguin.GameScreen.GameScreen;
import com.game.android.jpbg.swaggypenguin.R;
import com.game.android.jpbg.swaggypenguin.UI.EventHandlerMap;
import com.game.android.jpbg.swaggypenguin.UI.GameButton;
import com.game.android.jpbg.swaggypenguin.UI.GameButtonHandler;
import com.game.android.jpbg.swaggypenguin.UI.GameImage;
import com.game.android.jpbg.swaggypenguin.UI.IExecute;
import com.game.android.jpbg.swaggypenguin.Utility;

/**
 * Created by Joy on 8/19/15.
 */
public class MainMenuScreen extends Screen {

    private final String LOG_TAG = MainMenuScreen.class.getSimpleName();

    private GameImage background;
    private Animation penguinAnimation;
    private EventHandlerMap eventHandlerMap;
    private GameResources gameResources;
    private GameButtonHandler buttonHandler;

    public MainMenuScreen(Game game, GameResources resources) {
        super(game);
        gameResources = resources;
        float width = game.getGraphics().getWidth();
        float height = game.getGraphics().getHeight();
        buttonHandler = new GameButtonHandler();
        background = Utility.initGameImage(gameResources.getImage(R.drawable.main_menu_screen_background), 0, 0);
        buttonHandler.add(gameResources.getImage(R.drawable.main_menu_screen_play_button),
                Math.round(50f / 480f * width), Math.round(550f / 800f * height), new PlayGame());
        buttonHandler.add(gameResources.getImage(R.drawable.main_menu_screen_rate_button),
                Math.round(190f / 480f * width), Math.round(465f / 800f * height), null);
        buttonHandler.add(gameResources.getImage(R.drawable.main_menu_screen_rank_button),
                Math.round(260f / 480f * width), Math.round(550f / 800f * height), null);
        penguinAnimation = new Animation();
        long animT = Math.round(1.5 * GameResources.oneSecondTime / 3);
        penguinAnimation.addFrame(R.drawable.main_menu_screen_penguin_animation_1, animT);
        penguinAnimation.addFrame(R.drawable.main_menu_screen_penguin_animation_2, animT);
        penguinAnimation.addFrame(R.drawable.main_menu_screen_penguin_animation_3, animT);
        eventHandlerMap = new EventHandlerMap();
    }

    private class PlayGame implements IExecute {
        @Override
        public void execute() {
            game.setScreen(new GameScreen(game,gameResources));
        }
    }

    @Override
    public void update(float deltaTime) {
        //refreshesStats(deltaTime);
        penguinAnimation.update(deltaTime);
        buttonHandler.execute(deltaTime,game.getInput().getTouchEvents());
    }

    @Override
    public void paint(float deltaTime) {
        Graphics graphics = game.getGraphics();
        graphics.drawImage(background.getImage(),background.getLocation());
        graphics.drawImage(gameResources.getImage(penguinAnimation.getImageId()),0,0);
        for(GameButton button: buttonHandler.getGameButtons()){
            graphics.drawImage(button.getImage(),button.getLocation());
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

    }

    @Override
    public void backButton() {

    }

}