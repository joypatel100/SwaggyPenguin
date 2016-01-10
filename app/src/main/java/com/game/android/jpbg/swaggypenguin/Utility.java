package com.game.android.jpbg.swaggypenguin;

import com.game.android.jpbg.framework.Image;
import com.game.android.jpbg.framework.Input.TouchEvent;
import com.game.android.jpbg.framework.implementation.Location;
import com.game.android.jpbg.swaggypenguin.UI.GameButton;
import com.game.android.jpbg.swaggypenguin.UI.GameImage;
import com.game.android.jpbg.swaggypenguin.UI.GameImagePosition;
import com.game.android.jpbg.swaggypenguin.UI.IExecute;

/**
 * Created by Joy on 8/21/15.
 */
public class Utility {

    public static boolean inBounds(TouchEvent event, float x, float y, float width,
                                   float height) {
        return (event.getX() > x && event.getX() < x + width - 1 &&
                event.getY() > y && event.getY() < y + height - 1);
    }

    public static boolean inBounds(TouchEvent event, Location location){
        return inBounds(event,location.getX(),location.getY(),location.getSrcWidth(),
                location.getSrcHeight());
    }

    public static GameImage initGameImage(Image image, float x, float y){
        return new GameImage(image,new Location(x,y));
    }

    public static GameImage initGameImage(GameResources resources, int id, float x, float y, GameImagePosition pos, int withRespectToId){
        return new GameImage(resources.getImage(id), new Location(x,y), pos, resources.getImage(withRespectToId));
    }

    public static GameButton initGameButton(Image image, float x, float y, IExecute ibe){
        return new GameButton(image, new Location(x,y),ibe);
    }

}
