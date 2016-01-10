package com.game.android.jpbg.swaggypenguin;

import com.game.android.jpbg.framework.Game;
import com.game.android.jpbg.framework.Graphics;
import com.game.android.jpbg.framework.Image;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Joy on 8/20/15.
 */
public class GameResources {

    private final String LOG_TAG = GameResources.class.getSimpleName();

    private Map<Integer,Image> images;

    // Avg resfreshes per second: 58
    // Avg delta time totals per second: 68
    public static final float oneSecondTime = 68;

    public GameResources(Game game){
        this.images = new HashMap<>();
        addImage(game.getGraphics(),R.drawable.splash_screen);
    }

    public Image getImage(int id){
        return images.get(id);
    }


    public void setupValues(Game game){
        int[] ids = {R.drawable.main_menu_screen_background,
                R.drawable.main_menu_screen_penguin_animation_1,
                R.drawable.main_menu_screen_penguin_animation_2,
                R.drawable.main_menu_screen_penguin_animation_3,
                R.drawable.main_menu_screen_play_button,
                R.drawable.main_menu_screen_rank_button,
                R.drawable.main_menu_screen_rate_button,
                R.drawable.game_screen_background_0,
                R.drawable.game_screen_pause_button,
                R.drawable.game_screen_get_ready,
                R.drawable.game_screen_tap_to_start_button,
                R.drawable.game_screen_resume_button,
                R.drawable.game_screen_menu_button,
                R.drawable.game_screen_snow_flake_0,
                R.drawable.game_screen_snow_flake_1,
                R.drawable.game_screen_snow_flake_2,
                R.drawable.game_screen_snow_flake_3,
                R.drawable.game_screen_snow_flake_4,
                R.drawable.game_screen_snow_flake_5,
                R.drawable.game_screen_snow_flake_6,
                R.drawable.game_screen_cannon_left_0,
                R.drawable.game_screen_cannon_left_1,
                R.drawable.game_screen_cannon_left_2,
                R.drawable.game_screen_cannon_left_3,
                R.drawable.game_screen_cannon_left_4,
                R.drawable.game_screen_cannon_left_5,
                R.drawable.game_screen_cannon_left_6,
                R.drawable.game_screen_cannon_left_7,
                R.drawable.game_screen_cannon_right_0,
                R.drawable.game_screen_cannon_right_1,
                R.drawable.game_screen_cannon_right_2,
                R.drawable.game_screen_cannon_right_3,
                R.drawable.game_screen_cannon_right_4,
                R.drawable.game_screen_cannon_right_5,
                R.drawable.game_screen_cannon_right_6,
                R.drawable.game_screen_cannon_right_7,
                R.drawable.game_screen_gumball_3
        };

        initResources(game.getGraphics(), ids);
    }

    private void addImage(Graphics g,int id){
        images.put(id, g.newImage(id));
    }

    private void initResources(Graphics g, int[] ids){
        for(int id: ids){
            addImage(g,id);
        }
    }
}
