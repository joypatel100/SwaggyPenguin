package com.game.android.jpbg.swaggypenguin.UI;

import com.game.android.jpbg.framework.Image;
import com.game.android.jpbg.framework.implementation.Location;

/**
 * Created by Joy on 12/31/15.
 */
public class GameButton extends GameImage {

    private boolean isDown = false;
    private IExecute buttonExecute;
    private int push = 5;

    public GameButton(Image img, Location loc, IExecute ibe, GameImagePosition pos){
        super(img,loc,pos);
        this.buttonExecute = ibe;
    }

    public GameButton(Image img, Location loc,IExecute ibe) {
        this(img, loc, ibe, GameImagePosition.TOP_LEFT);
    }

    public void down(){
        if(!isDown) {
            isDown = true;
            location.setY(location.getY() + push);
        }
    }

    public void up(){
        if(isDown) {
            isDown = false;
            location.setY(location.getY() - push);
        }
    }

    public void execute(){
        buttonExecute.execute();
    }


}
