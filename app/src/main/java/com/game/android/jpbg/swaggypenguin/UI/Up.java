package com.game.android.jpbg.swaggypenguin.UI;

/**
 * Created by Joy on 1/1/16.
 */
public class Up implements IButtonExecute{
    @Override
    public void execute(GameButton button) {
        if(button!=null){
            button.up();
            button.execute();
        }
    }
}
