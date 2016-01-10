package com.game.android.jpbg.swaggypenguin.UI;

import com.game.android.jpbg.framework.Image;
import com.game.android.jpbg.framework.implementation.Location;

/**
 * Created by Joy on 12/31/15.
 */
public class GameImage {

    private Image image;
    protected Location location;

    public GameImage(Image img, Location loc){
        this(img,loc,GameImagePosition.TOP_LEFT);
    }

    public GameImage(Image img, Location loc, GameImagePosition pos){
        this(img,loc,pos,img);
    }

    public GameImage(Image img, Location loc, GameImagePosition pos, Image withRespectTo){
        this.image = img;
        this.location = pos.getLocation(loc,withRespectTo);
    }

    public Image getImage(){
        return image;
    }

    public Location getLocation(){
        return location;
    }

}
