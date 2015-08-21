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
            mainMenuScreenRankButtonImg;

    public static Location
            splashImgLocation = new Location(0,0),
            mainMenuScreenBackgroundImgLocation,
            mainMenuScreenPenguinAnimationLocation,
            mainMenuScreenPlayButtonImgLocationInitial,
            mainMenuScreenPlayButtonImgLocationPushed,
            mainMenuScreenRateButtonImgLocationInitial,
            mainMenuScreenRateButtonImgLocationPushed,
            mainMenuScreenRankButtonImgLocationInitial,
            mainMenuScreenRankButtonImgLocationPushed;

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
        mainMenuScreenPlayButtonImgLocationInitial =
                new Location(Math.round(50f/480f*width), Math.round(550f/800f*height),
                        mainMenuScreenPlayButtonImg.getWidth(),
                        mainMenuScreenPlayButtonImg.getHeight());
        mainMenuScreenPlayButtonImgLocationPushed =
                new Location(Math.round(50f/480f*width), Math.round(555f/800f*height));

        mainMenuScreenRateButtonImg = g.newImage(R.drawable.main_menu_screen_rate_button,
                ImageFormat.RGB565);
        mainMenuScreenRateButtonImgLocationInitial =
                new Location(Math.round(190f/480f*width),Math.round(465f/800f*height),
                        mainMenuScreenRateButtonImg.getWidth(),
                        mainMenuScreenRateButtonImg.getHeight());
        mainMenuScreenRateButtonImgLocationPushed =
                new Location(Math.round(190f/480f*width), Math.round(470f/800f*height));

        mainMenuScreenRankButtonImg = g.newImage(R.drawable.main_menu_screen_rank_button,
                ImageFormat.RGB565);
        mainMenuScreenRankButtonImgLocationInitial =
                new Location(Math.round(260f/480f*width),Math.round(550f/800f*height),
                        mainMenuScreenRankButtonImg.getWidth(),
                        mainMenuScreenRankButtonImg.getHeight());
        mainMenuScreenRankButtonImgLocationPushed =
                new Location(Math.round(260f/480f*width), Math.round(555f/800f*height));

    }



}
