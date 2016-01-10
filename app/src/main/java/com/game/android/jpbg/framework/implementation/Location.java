package com.game.android.jpbg.framework.implementation;

/**
 * Created by Joy on 8/20/15.
 */
public class Location {

    private final int upDownDeltaY = 5; // Change in y for button presses

    private float x, y, srcX, srcY, srcWidth, srcHeight;

    public Location(float x, float y){
        this(x,y,-1,-1,-1,-1);
    }

    public Location(float x, float y, float width, float height){
        this(x,y,-1,-1,width,height);
    }

    public Location(Location location){
        this(location.x,location.y,location.srcX,location.srcY,location.srcWidth,location.srcHeight);
    }

    public Location(float x, float y, float srcX, float srcY, float srcWidth, float srcHeight){
        this.x = x;
        this.y = y;
        this.srcX = srcX;
        this.srcY = srcY;
        this.srcWidth = srcWidth;
        this.srcHeight = srcHeight;
        // Note: if srcX = -1, then srcY = -1
    }

    public String toString(){
        return "" + x + " " + y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getSrcX() {
        return srcX;
    }

    public float getSrcY() {
        return srcY;
    }

    public float getSrcWidth() {
        return srcWidth;
    }

    public float getSrcHeight() {
        return srcHeight;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }
}