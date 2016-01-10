package com.game.android.jpbg.swaggypenguin.GameScreen.GamePlay;

import com.game.android.jpbg.swaggypenguin.UI.GameImagePosition;

/**
 * Created by Joy on 1/2/16.
 */
public class GameImageId {

    private int id, withRespectToId;
    private float x,y;
    private GameImagePosition pos;

    public GameImageId(int id, float x, float y){
        this(id,x,y,GameImagePosition.TOP_LEFT,id);
    }

    public GameImageId(int id, float x, float y, GameImagePosition pos){
        this(id,x,y,pos,id);
    }

    public GameImageId(int id, float x, float y, int withRespectToId){
        this(id,x,y,GameImagePosition.TOP_LEFT,withRespectToId);
    }

    public GameImageId(int id, float x, float y, GameImagePosition pos, int withRespectToId){
        this.id = id;
        this.x = x;
        this.y = y;
        this.pos = pos;
        this.withRespectToId = withRespectToId;
    }

    public int getId(){
        return id;
    }

    public int getWithRespectToId(){
        return withRespectToId;
    }

    public float getX(){
        return x;
    }

    public float getY(){
        return y;
    }

    public GameImagePosition getGameImagePosition(){
        return pos;
    }

    public void setX(float x){
        this.x = x;
    }

    public void setY(float y){
        this.y = y;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setWithRespectToId(int withRespectToId) {
        this.withRespectToId = withRespectToId;
    }

    public void setGameImagePosition(GameImagePosition pos) {
        this.pos = pos;
    }
}
