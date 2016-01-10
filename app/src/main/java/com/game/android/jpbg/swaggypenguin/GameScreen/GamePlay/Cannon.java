package com.game.android.jpbg.swaggypenguin.GameScreen.GamePlay;

import com.game.android.jpbg.framework.Input;
import com.game.android.jpbg.swaggypenguin.Animation;
import com.game.android.jpbg.swaggypenguin.GameResources;
import com.game.android.jpbg.swaggypenguin.R;
import com.game.android.jpbg.swaggypenguin.UI.GameImagePosition;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joy on 1/6/16.
 */
public class Cannon implements IGameModelObject{

    public enum ProjectilePosition{
        LEFT(GameImagePosition.TOP_RIGHT),
        RIGHT(GameImagePosition.TOP_LEFT)
        ;

        private GameImagePosition pos;

        ProjectilePosition(GameImagePosition pos){
            this.pos = pos;
        }

        private GameImagePosition getGameImagePosition(){
            return pos;
        }
    }

    private static int DEFAULT_WITH_RESPECT_TO_ID = R.drawable.game_screen_cannon_left_7;

    private static final String LOG_TAG = Cannon.class.getSimpleName();

    private GameImageId leftCannon, rightCannon;
    private Animation leftCannonAnimation, rightCannonAnimation;
    private Projectile leftProjectile, rightProjectile;

    private float width, height;

    public Cannon(float width, float height){
        this.width = width;
        this.height = height;
        leftCannonAnimation = new Animation(new int[]
                {R.drawable.game_screen_cannon_left_0,
                        R.drawable.game_screen_cannon_left_1,
                        R.drawable.game_screen_cannon_left_2,
                        R.drawable.game_screen_cannon_left_3,
                        R.drawable.game_screen_cannon_left_4,
                        R.drawable.game_screen_cannon_left_5,
                        R.drawable.game_screen_cannon_left_6,
                        R.drawable.game_screen_cannon_left_7},
                (float) GameResources.oneSecondTime*2);
        rightCannonAnimation = new Animation(new int[]
                {R.drawable.game_screen_cannon_right_0,
                        R.drawable.game_screen_cannon_right_1,
                        R.drawable.game_screen_cannon_right_2,
                        R.drawable.game_screen_cannon_right_3,
                        R.drawable.game_screen_cannon_right_4,
                        R.drawable.game_screen_cannon_right_5,
                        R.drawable.game_screen_cannon_right_6,
                        R.drawable.game_screen_cannon_right_7},
                (float) GameResources.oneSecondTime*2);
        leftCannon = new GameImageId(leftCannonAnimation.getImageId(),20f/480f*width,157f/800f*height, GameImagePosition.BOTTOM_LEFT);
        rightCannon = new GameImageId(rightCannonAnimation.getImageId(),420f/480f*width,157f/800f*height,GameImagePosition.BOTTOM_LEFT);
        leftProjectile = new Projectile(R.drawable.game_screen_gumball_3,leftCannon.getX(),leftCannon.getY(),
                ProjectilePosition.LEFT.getGameImagePosition(),leftCannon.getId(),width,height);
        rightProjectile = new Projectile(R.drawable.game_screen_gumball_3,rightCannon.getX(),rightCannon.getY(),
                        ProjectilePosition.RIGHT.getGameImagePosition(),rightCannon.getId(),width,height);

    }

    @Override
    public void update(float elapsedTime, Input input) {
        leftCannonAnimation.update(elapsedTime);
        rightCannonAnimation.update(elapsedTime);
        leftProjectile.update(elapsedTime);
        rightProjectile.update(elapsedTime);
    }

    @Override
    public List<GameImageId> getImageIds() {
        leftCannon.setId(leftCannonAnimation.getImageId());
        rightCannon.setId(rightCannonAnimation.getImageId());
        List<GameImageId> ids = new ArrayList<>();
        ids.add(leftCannon);
        ids.add(rightCannon);
        ids.add(leftProjectile.getImageId());
        ids.add(rightProjectile.getImageId());
        return ids;
    }
}
