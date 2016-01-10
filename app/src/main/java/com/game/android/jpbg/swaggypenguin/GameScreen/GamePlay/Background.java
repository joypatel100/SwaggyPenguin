package com.game.android.jpbg.swaggypenguin.GameScreen.GamePlay;

import com.game.android.jpbg.framework.Input;
import com.game.android.jpbg.swaggypenguin.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by Joy on 1/5/16.
 */
public class Background implements IGameModelObject{

    private final static String LOG_TAG = Background.class.getSimpleName();
    private float width,height;
    private final Map<Integer,Integer> snowType;

    private class Snowflake{
        public final GameImageId snow;
        private float vY = 3, bottomY;

        private Snowflake(){
            Random random = new Random();
            float x = random.nextFloat()*width;
            float y = random.nextFloat()*height*1.5f-0.5f*height;
            int type = random.nextInt(snowType.size());
            snow = new GameImageId(snowType.get(type),x,y);
            bottomY = 750f/800f*height;
        }

        private void update(){
            float y = snow.getY() + vY;
            float x = snow.getX();
            if(y > bottomY){
                Random random = new Random();
                x = random.nextFloat()*width;
                y = -1*random.nextFloat()*height*1.5f;
                int type = random.nextInt(snowType.size());
                snow.setId(snowType.get(type));
            }
            snow.setX(x);
            snow.setY(y);
        }

    }

    private GameImageId background;
    private List<Snowflake> flakes;
    private List<GameImageId> ids;

    public Background(float width, float height){
        snowType = new HashMap<>();
        snowType.put(0,R.drawable.game_screen_snow_flake_0);
        snowType.put(1,R.drawable.game_screen_snow_flake_1);
        snowType.put(2,R.drawable.game_screen_snow_flake_2);
        snowType.put(3,R.drawable.game_screen_snow_flake_3);
        snowType.put(4,R.drawable.game_screen_snow_flake_4);
        snowType.put(5,R.drawable.game_screen_snow_flake_5);
        snowType.put(6,R.drawable.game_screen_snow_flake_6);

        this.width = width;
        this.height = height;
        background = new GameImageId(R.drawable.game_screen_background_0,0,0);
        flakes = new ArrayList<>();
        int numFlakes = 150;
        ids = new ArrayList<>();
        ids.add(background);
        for(int i = 0; i < numFlakes; i++){
            flakes.add(new Snowflake());
            ids.add(flakes.get(i).snow);
        }
    }

    @Override
    public void update(float elapsedTime, Input input) {
        for(Snowflake flake: flakes){
            flake.update();
        }
    }

    @Override
    public List<GameImageId> getImageIds() {
        return ids;
    }
}
