package com.game.android.jpbg.swaggypenguin.GameScreen.GamePlay;

import com.game.android.jpbg.swaggypenguin.GameResources;
import com.game.android.jpbg.swaggypenguin.UI.GameImagePosition;
import com.game.android.jpbg.swaggypenguin.UI.IExecute;

import java.util.Random;

/**
 * Created by Joy on 1/7/16.
 */
public class Projectile {

    private GameImageId projectile;
    private float vX, width, height;
    private ParabolaMotion yMotion;
    private IExecute onImpact;

    public Projectile(int id, float x, float y, GameImagePosition pos, int withRespectToId, float width, float height){
        projectile = new GameImageId(id,x,y, pos, withRespectToId);
        vX = 0;
        yMotion = new ParabolaMotion();
        this.width = width;
        this.height = height;
        reset(x, y);
    }

    public void update(float elapsedTime){
        float x = projectile.getX()+vX;
        float y = yMotion.update(elapsedTime);
        if(x <= 0 || x >= width){
            vX = -vX;
            x += vX;
        }
        projectile.setX(x);
        projectile.setY(y);
    }

    public void reset(float startingX, float startingY){
        Random random = new Random();
        projectile.setX(startingX);
        projectile.setY(startingY);
        vX = 1;
        //vX = random.nextFloat()*5f/480f*width;
        //float t = GameResources.oneSecondTime*random.nextFloat()*2f + GameResources.oneSecondTime;
        float t = GameResources.oneSecondTime*10;
        float[] Y = {startingY,0,height};
        float[] T = {0,t/2,t};
        yMotion.resetMotion(Y, T);
    }

    public void setOnImpact(IExecute onImpact){
        this.onImpact = onImpact;
    }

    public void onImpact(){
        onImpact.execute();
    }

    public GameImageId getImageId(){
        return projectile;
    }

}
