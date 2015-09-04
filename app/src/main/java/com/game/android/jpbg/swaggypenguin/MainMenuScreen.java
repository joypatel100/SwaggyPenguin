package com.game.android.jpbg.swaggypenguin;

import android.util.Log;

import com.game.android.jpbg.framework.Game;
import com.game.android.jpbg.framework.Graphics;
import com.game.android.jpbg.framework.Input.TouchEvent;
import com.game.android.jpbg.framework.Screen;
import com.game.android.jpbg.framework.implementation.Location;

import java.util.List;

/**
 * Created by Joy on 8/19/15.
 */
public class MainMenuScreen extends Screen {

    private final String LOG_TAG = MainMenuScreen.class.getSimpleName();


    // testing time statistics
    private long statsTime = System.currentTimeMillis(), statsCurRuns = 0, statsTotalRuns = 0,
            statsTotal1SRuns = 0, statsCurDTime = 0, statsTotalDTime = 0;

    private Location
        playButtonLocation, rankButtonLocation, rateButtonLocation;

    private enum MainMenuLocationType {
        playButton, rankButton, rateButton, notButton;
    }

    public MainMenuScreen(Game game) {
        super(game);
        playButtonLocation = GameValues.mainMenuScreenPlayButtonImgLocation;
        rankButtonLocation = GameValues.mainMenuScreenRankButtonImgLocation;
        rateButtonLocation = GameValues.mainMenuScreenRateButtonImgLocation;
    }

    @Override
    public void update(float deltaTime) {
        //refreshesStats(deltaTime);
        GameValues.mainMenuScreenPenguinAnimation.update(deltaTime);
        List<TouchEvent> events = game.getInput().getTouchEvents();
        for(TouchEvent event: events){
            MainMenuLocationType locationType = pressDownLocationType(event);
            switch (event.type) {
                case TouchEvent.TOUCH_DOWN:
                    switch (locationType) {
                        case playButton:
                            playButtonLocation.down();
                            break;
                        case rankButton:
                            rankButtonLocation.down();
                            break;
                        case rateButton:
                            rateButtonLocation.down();
                            break;
                        default:
                            break;
                    }
                    break;
                case TouchEvent.TOUCH_UP:
                    switch (locationType){
                        case playButton:
                            playButtonLocation.up();
                            game.setScreen(new GameScreen(game));
                            break;
                        case rankButton:
                            rankButtonLocation.up();
                            break;
                        case rateButton:
                            rateButtonLocation.up();
                            break;
                        case notButton:
                            playButtonLocation.up();
                            rankButtonLocation.up();
                            rateButtonLocation.up();
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;

            }
        }

    }

    @Override
    public void paint(float deltaTime) {
        Graphics graphics = game.getGraphics();
        graphics.drawImage(GameValues.mainMenuScreenBackgroundImg,
                GameValues.mainMenuScreenBackgroundImgLocation);
        graphics.drawImage(GameValues.mainMenuScreenPenguinAnimation.getImage(),
                GameValues.mainMenuScreenPenguinAnimationLocation);
        graphics.drawImage(GameValues.mainMenuScreenPlayButtonImg,
                playButtonLocation);
        graphics.drawImage(GameValues.mainMenuScreenRankButtonImg,
                rankButtonLocation);
        graphics.drawImage(GameValues.mainMenuScreenRateButtonImg,
                rateButtonLocation);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {
        GameValues.mainMenuScreenPenguinAnimation.setZero();
    }

    @Override
    public void dispose() {
        playButtonLocation = null;
        rankButtonLocation = null;
        rateButtonLocation = null;
    }

    @Override
    public void backButton() {

    }

    private MainMenuLocationType pressDownLocationType(TouchEvent event){
        if(Utility.inBounds(event,
                GameValues.mainMenuScreenPlayButtonImgLocation)){
            return MainMenuLocationType.playButton;
        }
        else if(Utility.inBounds(event,
                GameValues.mainMenuScreenRankButtonImgLocation)) {
            return MainMenuLocationType.rankButton;
        }
        else if(Utility.inBounds(event,
                GameValues.mainMenuScreenRateButtonImgLocation)){
            return MainMenuLocationType.rateButton;
        }
        return MainMenuLocationType.notButton;
    }

    private void refreshesStats(float deltaTime){
        // Avg resfreshes per second: 58
        // Avg delta time totals per second: 68
        statsCurRuns++;
        statsCurDTime += deltaTime;
        //Log.v(LOG_TAG,Float.toString(deltaTime));
        if(System.currentTimeMillis() - statsTime >= 1000){
            statsTotalRuns += statsCurRuns;
            statsTotalDTime += statsCurDTime;
            statsTotal1SRuns++;

            // Avg Number of refreshes
            //Log.v(LOG_TAG, Long.toString(statsTotalRuns/statsTotal1SRuns));

            // Avg Delta Time Total per second
            Log.v(LOG_TAG, Long.toString(statsTotalDTime / statsTotal1SRuns));

            statsTime = System.currentTimeMillis();
            statsCurRuns = 0;
            statsCurDTime = 0;
        }
    }

}
