package com.game.android.jpbg.swaggypenguin;

import com.game.android.jpbg.framework.Game;
import com.game.android.jpbg.framework.Graphics;
import com.game.android.jpbg.framework.Graphics.ImageFormat;
import com.game.android.jpbg.framework.Image;
import com.game.android.jpbg.framework.implementation.Location;

/**
 * Created by Joy on 8/20/15.
 */
public class GameValues {

    private final String LOG_TAG = GameValues.class.getSimpleName();

    public static double oneSecondTime = 68;

    public static Animation
            mainMenuScreenPenguinAnimation;

    public static Image
            splashImg,
            mainMenuScreenBackgroundImg,
            mainMenuScreenPlayButtonImg,
            mainMenuScreenRateButtonImg,
            mainMenuScreenRankButtonImg,
            gameScreenBackgroundImg,
            gameScreenPauseButtonImg,
            gameScreenGetReadyImg,
            gameScreenTapToStartButtonImg,
            gameScreenResumeButtonImg,
            gameScreenMenuButtonImg;

    public static Location
            splashImgLocation = new Location(0,0),
            mainMenuScreenBackgroundImgLocation,
            mainMenuScreenPenguinAnimationLocation,
            mainMenuScreenPlayButtonImgLocation,
            mainMenuScreenRateButtonImgLocation,
            mainMenuScreenRankButtonImgLocation,
            gameScreenBackgroundImgLocation,
            gameScreenPauseButtonImgLocation,
            gameScreenGetReadyImgLocation,
            gameScreenTapToStartButtonImgLocation,
            gameScreenResumeButtonImgLocation,
            gameScreenMenuButtonImgLocation;


    public static void setupValues(Game game){
        Graphics g = game.getGraphics();
        float width = (float) g.getWidth();
        float height = (float) g.getHeight();

        // Load main menu screen images and locations
        mainMenuScreenBackgroundImg = g.newImage(R.drawable.main_menu_screen_background,
                ImageFormat.RGB565);
        mainMenuScreenBackgroundImgLocation = splashImgLocation;

        // Total time of animation to be 1.5 seconds
        mainMenuScreenPenguinAnimation = new Animation();
        mainMenuScreenPenguinAnimation.addFrame(
                g.newImage(R.drawable.main_menu_screen_penguin_animation_1, ImageFormat.RGB565),
                Math.round(1.5*oneSecondTime/3));
        mainMenuScreenPenguinAnimation.addFrame(
                g.newImage(R.drawable.main_menu_screen_penguin_animation_2, ImageFormat.RGB565),
                Math.round(1.5*oneSecondTime/3));
        mainMenuScreenPenguinAnimation.addFrame(
                g.newImage(R.drawable.main_menu_screen_penguin_animation_3, ImageFormat.RGB565),
                Math.round(1.5*oneSecondTime/3));
        mainMenuScreenPenguinAnimationLocation = splashImgLocation;


        mainMenuScreenPlayButtonImg = g.newImage(R.drawable.main_menu_screen_play_button,
                ImageFormat.RGB565);
        mainMenuScreenPlayButtonImgLocation =
                new Location(Math.round(50f/480f*width), Math.round(550f/800f*height),
                        mainMenuScreenPlayButtonImg.getWidth(),
                        mainMenuScreenPlayButtonImg.getHeight());

        mainMenuScreenRateButtonImg = g.newImage(R.drawable.main_menu_screen_rate_button,
                ImageFormat.RGB565);
        mainMenuScreenRateButtonImgLocation =
                new Location(Math.round(190f/480f*width),Math.round(465f/800f*height),
                        mainMenuScreenRateButtonImg.getWidth(),
                        mainMenuScreenRateButtonImg.getHeight());

        mainMenuScreenRankButtonImg = g.newImage(R.drawable.main_menu_screen_rank_button,
                ImageFormat.RGB565);
        mainMenuScreenRankButtonImgLocation =
                new Location(Math.round(260f/480f*width),Math.round(550f/800f*height),
                        mainMenuScreenRankButtonImg.getWidth(),
                        mainMenuScreenRankButtonImg.getHeight());

        // Game Screen Images and Locations
        gameScreenBackgroundImg = g.newImage(R.drawable.game_screen_background_0,ImageFormat.RGB565);
        gameScreenBackgroundImgLocation = splashImgLocation;

        gameScreenPauseButtonImg = g.newImage(R.drawable.game_screen_pause_button,ImageFormat.RGB565);
        gameScreenPauseButtonImgLocation =
                new Location(Math.round(20f/480f*width),Math.round(20f/800f*height),
                        gameScreenPauseButtonImg.getWidth(),
                        gameScreenBackgroundImg.getHeight());


        gameScreenGetReadyImg = g.newImage(R.drawable.game_screen_get_ready,ImageFormat.RGB565);
        gameScreenGetReadyImgLocation =
                new Location(Math.round(80f/480f*width), Math.round(130f/800f*height));

        gameScreenTapToStartButtonImg = g.newImage(R.drawable.game_screen_tap_to_start_button,
                ImageFormat.RGB565);
        gameScreenTapToStartButtonImgLocation =
                new Location(Math.round(170f/480f*width),Math.round(255f/800f*height),
                        gameScreenTapToStartButtonImg.getWidth(),
                        gameScreenTapToStartButtonImg.getHeight());

        gameScreenResumeButtonImg = g.newImage(R.drawable.game_screen_resume_button,
                ImageFormat.RGB565);
        gameScreenResumeButtonImgLocation = new Location(gameScreenPauseButtonImgLocation);

        gameScreenMenuButtonImg = g.newImage(R.drawable.game_screen_menu_button,ImageFormat.RGB565);
        gameScreenMenuButtonImgLocation =
                new Location(Math.round(173f/480f*width),Math.round(375f/800f*height),
                gameScreenMenuButtonImg.getWidth(),
                gameScreenMenuButtonImg.getHeight());
    }



}
