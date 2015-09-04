package com.game.android.jpbg.swaggypenguin;

import com.game.android.jpbg.framework.Game;
import com.game.android.jpbg.framework.Graphics;
import com.game.android.jpbg.framework.Input.TouchEvent;
import com.game.android.jpbg.framework.Screen;
import com.game.android.jpbg.framework.implementation.Location;

import java.util.List;

/**
 * Created by Joy on 8/23/15.
 */
public class GameScreen extends Screen {

    private final String LOG_TAG = GameScreen.class.getSimpleName();

    private enum GameState{
        ready, running, paused, gameOver;
    }

    private GameState gameState;
    private Location tapToStartButtonLocation, pauseButtonLocation, resumeButtonLocation,
            menuButtonLocation;

    private enum GameLocationType{
        tapToStartButton, pauseButton, menuButton, resumeButton, notButton;
    }

    public GameScreen(Game game){
        super(game);
        gameState = GameState.ready;
        tapToStartButtonLocation = GameValues.gameScreenTapToStartButtonImgLocation;
        pauseButtonLocation = GameValues.gameScreenPauseButtonImgLocation;
        resumeButtonLocation = GameValues.gameScreenResumeButtonImgLocation;
        menuButtonLocation = GameValues.gameScreenMenuButtonImgLocation;

    }

    @Override
    public void update(float deltaTime) {
        switch (gameState){
            case ready:
                updateReady(deltaTime);
                break;
            case running:
                updateRunning(deltaTime);
                break;
            case paused:
                updatePaused(deltaTime);
                break;
            case gameOver:
                break;
            default:
                break;
        }


    }

    @Override
    public void paint(float deltaTime) {
        Graphics graphics = game.getGraphics();
        graphics.drawImage(GameValues.gameScreenBackgroundImg,GameValues.gameScreenBackgroundImgLocation);
        switch (gameState){
            case ready:
                paintReady(graphics);
                break;
            case running:
                paintRunning(graphics);
                break;
            case paused:
                paintPaused(graphics);
                break;
            case gameOver:
                break;
            default:
                break;
        }

    }

    private void tapToStart(){
        if(gameState == GameState.ready) {
            gameState = GameState.running;
        }
    }

    @Override
    public void pause() {
        if(gameState == GameState.running){
            gameState = GameState.paused;
        }

    }

    @Override
    public void resume() {
        if(gameState == GameState.paused){
            gameState = GameState.running;
        }

    }

    @Override
    public void dispose() {
        tapToStartButtonLocation = null;
        pauseButtonLocation = null;
        resumeButtonLocation = null;
        menuButtonLocation = null;
    }

    @Override
    public void backButton() {

    }

    private GameLocationType pressDownLocationType(TouchEvent event){
        switch (gameState) {
            case ready:
                if(Utility.inBounds(event,tapToStartButtonLocation)){
                    return GameLocationType.tapToStartButton;
                }
                break;
            case running:
                if (Utility.inBounds(event, pauseButtonLocation)) {
                    return GameLocationType.pauseButton;
                }
                break;
            case paused:
                if(Utility.inBounds(event,resumeButtonLocation)){
                    return GameLocationType.resumeButton;
                }
                else if(Utility.inBounds(event,menuButtonLocation)){
                    return GameLocationType.menuButton;
                }
                break;
            case gameOver:
                break;
            default:
                break;
        }
        return GameLocationType.notButton;
    }

    private void onPressDown(GameLocationType locationType){
        switch (locationType){
            case tapToStartButton:
                tapToStartButtonLocation.down();
                break;
            case pauseButton:
                pauseButtonLocation.down();
                break;
            case resumeButton:
                resumeButtonLocation.down();
                break;
            case menuButton:
                menuButtonLocation.down();
                break;
            default:
                break;
        }
    }

    private void onPressUp(GameLocationType locationType){
        switch (locationType){
            case tapToStartButton:
                tapToStartButtonLocation.up();
                tapToStart();
                break;
            case pauseButton:
                pauseButtonLocation.up();
                pause();
                break;
            case resumeButton:
                resumeButtonLocation.up();
                resume();
                break;
            case menuButton:
                menuButtonLocation.up();
                game.setScreen(new MainMenuScreen(game));
                break;
            case notButton:
                tapToStartButtonLocation.up();
                pauseButtonLocation.up();
                resumeButtonLocation.up();
                menuButtonLocation.up();
                break;
            default:
                break;
        }
    }

    private void onTouchEvent(){
        List<TouchEvent> events = game.getInput().getTouchEvents();
        for(TouchEvent event: events){
            GameLocationType locationType = pressDownLocationType(event);
            switch (event.type){
                case TouchEvent.TOUCH_DOWN:
                    onPressDown(locationType);
                    break;
                case TouchEvent.TOUCH_UP:
                    onPressUp(locationType);
                    break;
                default:
                    break;
            }
        }
    }

    private void updateReady(float deltaTime){
        onTouchEvent();
    }

    private void paintReady(Graphics graphics){
        graphics.drawImage(GameValues.gameScreenGetReadyImg,GameValues.gameScreenGetReadyImgLocation);
        graphics.drawImage(GameValues.gameScreenTapToStartButtonImg, tapToStartButtonLocation);

    }

    private void updateRunning(float deltaTime){
        onTouchEvent();
    }

    private void paintRunning(Graphics graphics){
        graphics.drawImage(GameValues.gameScreenPauseButtonImg, pauseButtonLocation);
    }

    private void updatePaused(float deltaTime){
        onTouchEvent();
    }

    private void paintPaused(Graphics graphics){
        graphics.drawImage(GameValues.gameScreenResumeButtonImg,resumeButtonLocation);
        graphics.drawImage(GameValues.gameScreenMenuButtonImg,menuButtonLocation);
    }
}
