package com.game.android.jpbg.framework.implementation;

/**
 * Created by Joy on 8/20/15.
 */
public class Location {
    public int x;
    public int y;
    public int srcX;
    public int srcY;
    public int srcWidth;
    public int srcHeight;
    public boolean onlyXY = false;

    public Location(int x, int y){
        this(x,y,-1,-1,-1,-1);
        onlyXY = true;
    }

    public Location(int x, int y, int srcX, int srcY, int srcWidth, int srcHeight){
        this.x = x;
        this.y = y;
        this.srcX = srcX;
        this.srcY = srcY;
        this.srcWidth = srcWidth;
        this.srcHeight = srcHeight;
    }
}