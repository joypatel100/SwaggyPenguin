package com.game.android.jpbg.framework.implementation;

/**
 * Created by Joy on 8/20/15.
 */
public class Location {

    private final int upDownDeltaY = 5; // Change in y for button presses

    public int x;
    public int y;
    public int srcX;
    public int srcY;
    public int srcWidth;
    public int srcHeight;
    private boolean isDown = false;

    public Location(int x, int y){
        this(x,y,-1,-1,-1,-1);
    }

    public Location(int x, int y, int width, int height){
        this(x,y,-1,-1,width,height);
    }

    public Location(Location location){
        this(location.x,location.y,location.srcX,location.srcY,location.srcWidth,location.srcHeight);
    }

    public Location(int x, int y, int srcX, int srcY, int srcWidth, int srcHeight){
        this.x = x;
        this.y = y;
        this.srcX = srcX;
        this.srcY = srcY;
        this.srcWidth = srcWidth;
        this.srcHeight = srcHeight;
        // Note: if srcX = -1, then srcY = -1
    }

    public void down(){
        down(upDownDeltaY);
    }

    public void up(){
        up(upDownDeltaY);
    }

    public void down(int deltaY){
        if(!isDown) {
            y += deltaY;
            isDown = true;
        }
    }

    public void up(int deltaY){
        if(isDown) {
            y -= deltaY;
            isDown = false;
        }
    }

    public String toString(){
        return "" + x + " " + y;
    }

}