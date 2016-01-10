package com.game.android.jpbg.swaggypenguin.GameScreen.GamePlay;

import com.game.android.jpbg.framework.Input;
import com.game.android.jpbg.swaggypenguin.Animation;
import com.game.android.jpbg.swaggypenguin.GameResources;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joy on 1/1/16.
 */
public class SwaggyPenguin implements IGameModelObject{

    private GameImageId penguin;

    private float vX, score, startingY;
    private PenguinState state;
    private ParabolaMotion yMotion;

    public static enum PenguinState{
        GROUND,AIR,DEAD;
    }

    private Animation flight;

    public SwaggyPenguin(float width, float height){
        this.score = 0;
        this.state = PenguinState.GROUND;
        startingY = 600f/800f * height;
        penguin = new GameImageId(0,0.4f * width,startingY);
        vX = 0;

        // y direction values
        float[] Y = {startingY,100f/800f * height,startingY};
        float[] T = {0,GameResources.oneSecondTime/2,GameResources.oneSecondTime};

        yMotion = new ParabolaMotion();
        yMotion.resetMotion(Y,T);


    }

    @Override
    public void update(float elapsedTime, Input input){
        updateVelocity(input.getAccelX(),input.getAccelZ());
        updateX(elapsedTime);
        updateY(elapsedTime);
    }

    private void updateVelocity(float accelX, float accelZ){
        if (Math.abs(accelZ) < 9.7){
            float speed = Math.abs(accelX)/9.8f*50f;
            if (accelX < .001){
                vX = speed;
            }else if (accelX > -.25){
                vX = -speed;
            }else {
                vX = 0;
            }
        }
    }

    private void updateX(float elapsedTime){
        if(state!=PenguinState.AIR) {
            penguin.setX(penguin.getX() + vX);
        }
    }

    private void updateY(float elapsedTime){
        penguin.setY(yMotion.update(elapsedTime));
        state = (penguin.getY() <= startingY) ? PenguinState.AIR : PenguinState.GROUND;
    }

    @Override
    public List<GameImageId> getImageIds() {
        List<GameImageId> ids = new ArrayList<>();
        ids.add(penguin);
        return ids;
    }

    public void setPenguinState(PenguinState state){
        this.state = state;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
