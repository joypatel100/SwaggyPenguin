package com.game.android.jpbg.swaggypenguin.UI;

import com.game.android.jpbg.framework.Image;
import com.game.android.jpbg.framework.implementation.Location;

/**
 * Created by Joy on 1/9/16.
 */
public enum GameImagePosition {

    TOP_LEFT(new IGameImagePosition() {
        @Override
        public Location getLocationWithRespectTo(float startX, float startY, float width, float height) {
            return new Location(startX,startY,width,height);
        }
    }),
    TOP_RIGHT(new IGameImagePosition(){
        @Override
        public Location getLocationWithRespectTo(float startX, float startY, float width, float height) {
            return new Location(startX-width,startY,width,height);
        }
    }),
    BOTTOM_LEFT(new IGameImagePosition() {
        @Override
        public Location getLocationWithRespectTo(float startX, float startY, float width, float height) {
            return new Location(startX,startY-height,width,height);
        }
    }),
    BOTTOM_RIGHT(new IGameImagePosition() {
        @Override
        public Location getLocationWithRespectTo(float startX, float startY, float width, float height) {
            return new Location(startX-width,startY-height,width,height);
        }
    }),
    CENTER(new IGameImagePosition() {
        @Override
        public Location getLocationWithRespectTo(float startX, float startY, float width, float height) {
            return new Location(startX-width/2,startY-height/2,width,height);
        }
    })
    ;

    private interface IGameImagePosition{
        Location getLocationWithRespectTo(float startX, float startY, float width, float height);
    }

    private IGameImagePosition posFunc;

    GameImagePosition(IGameImagePosition posFunc){
        this.posFunc = posFunc;
    }

    public Location getLocation(Location loc, Image img){
        return posFunc.getLocationWithRespectTo(loc.getX(),loc.getY(),img.getWidth(),img.getHeight());
    }
}
