package com.game.android.jpbg.swaggypenguin;

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

    private enum MainMenuLocationPressedType{
        playButton, rankButton, rateButton, notButton;
    }

    public MainMenuScreen(Game game) {
        super(game);
        playButtonLocation = GameValues.mainMenuScreenPlayButtonImgLocationInitial;
        rankButtonLocation = GameValues.mainMenuScreenRankButtonImgLocationInitial;
        rateButtonLocation = GameValues.mainMenuScreenRateButtonImgLocationInitial;
    }

    @Override
    public void update(float deltaTime) {
        //refreshesStats(deltaTime);
        GameValues.mainMenuScreenPenguinAnimation.update(deltaTime);
        List<TouchEvent> events = game.getInput().getTouchEvents();
        for(TouchEvent event: events){
            MainMenuLocationPressedType locationType = mainMenuLocationPressDownType(event);
            switch (event.type) {
                case TouchEvent.TOUCH_DOWN:
                    switch (locationType) {
                        case playButton:
                            playButtonLocation = GameValues.mainMenuScreenPlayButtonImgLocationPushed;
                            break;
                        case rankButton:
                            rankButtonLocation = GameValues.mainMenuScreenRankButtonImgLocationPushed;
                            break;
                        case rateButton:
                            rateButtonLocation = GameValues.mainMenuScreenRateButtonImgLocationPushed;
                            break;
                        default:
                            break;
                    }
                    break;
                case TouchEvent.TOUCH_UP:
                    switch (locationType){
                        case playButton:
                            playButtonLocation = GameValues.mainMenuScreenPlayButtonImgLocationInitial;
                            break;
                        case rankButton:
                            rankButtonLocation = GameValues.mainMenuScreenRankButtonImgLocationInitial;
                            break;
                        case rateButton:
                            rateButtonLocation = GameValues.mainMenuScreenRateButtonImgLocationInitial;
                            break;
                        case notButton:
                            playButtonLocation = GameValues.mainMenuScreenPlayButtonImgLocationInitial;
                            rankButtonLocation = GameValues.mainMenuScreenRankButtonImgLocationInitial;
                            rateButtonLocation = GameValues.mainMenuScreenRateButtonImgLocationInitial;
                            break;
                        default:
                            break;
                    }

            }
        }

    }

    @Override
    public void paint(float deltaTime) {
        Graphics g = game.getGraphics();
        g.drawImage(GameValues.mainMenuScreenBackgroundImg,
                GameValues.mainMenuScreenBackgroundImgLocation);
        g.drawImage(GameValues.mainMenuScreenPenguinAnimation.getImage(),
                GameValues.mainMenuScreenPenguinAnimationLocation);
        g.drawImage(GameValues.mainMenuScreenPlayButtonImg,
                playButtonLocation);
        g.drawImage(GameValues.mainMenuScreenRankButtonImg,
                rankButtonLocation);
        g.drawImage(GameValues.mainMenuScreenRateButtonImg,
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

    }

    @Override
    public void backButton() {

    }

    private MainMenuLocationPressedType mainMenuLocationPressDownType (TouchEvent event){
        if(Utility.inBounds(event,
                GameValues.mainMenuScreenPlayButtonImgLocationInitial.x,
                GameValues.mainMenuScreenPlayButtonImgLocationInitial.y,
                GameValues.mainMenuScreenPlayButtonImgLocationInitial.srcWidth,
                GameValues.mainMenuScreenPlayButtonImgLocationInitial.srcHeight)){
            return MainMenuLocationPressedType.playButton;
        }
        else if(Utility.inBounds(event,
                GameValues.mainMenuScreenRankButtonImgLocationInitial.x,
                GameValues.mainMenuScreenRankButtonImgLocationInitial.y,
                GameValues.mainMenuScreenRankButtonImgLocationInitial.srcWidth,
                GameValues.mainMenuScreenRankButtonImgLocationInitial.srcHeight)) {
            return MainMenuLocationPressedType.rankButton;
        }
        else if(Utility.inBounds(event,
                GameValues.mainMenuScreenRateButtonImgLocationInitial.x,
                GameValues.mainMenuScreenRateButtonImgLocationInitial.y,
                GameValues.mainMenuScreenRateButtonImgLocationInitial.srcWidth,
                GameValues.mainMenuScreenRateButtonImgLocationInitial.srcHeight)){
            return MainMenuLocationPressedType.rateButton;
        }
        return MainMenuLocationPressedType.notButton;
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
            //Log.v(LOG_TAG, Long.toString(statsTotalDTime / statsTotal1SRuns));

            statsTime = System.currentTimeMillis();
            statsCurRuns = 0;
            statsCurDTime = 0;
        }
    }

}
