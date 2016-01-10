package com.game.android.jpbg.swaggypenguin.UI;

import com.game.android.jpbg.framework.Image;
import com.game.android.jpbg.framework.Input;
import com.game.android.jpbg.framework.implementation.Location;
import com.game.android.jpbg.swaggypenguin.Utility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joy on 1/5/16.
 */
public class GameButtonHandler {

    private List<GameButton> buttonList;
    private EventHandlerMap eventHandlerMap;

    public GameButtonHandler(){
        buttonList = new ArrayList<>();
        eventHandlerMap = new EventHandlerMap();
    }

    public List<GameButton> getGameButtons(){
        return buttonList;
    }

    public void add(GameButton button){
        buttonList.add(button);
    }

    public void add(Image image, int x, int y, IExecute ibe){
        buttonList.add(new GameButton(image,new Location(x,y), ibe));
    }

    public void execute(float deltaTime, List<Input.TouchEvent> events){
        for(Input.TouchEvent event: events){
            GameButton button = getButtonPressed(event);
            if(nullUp(event, button)){
                continue;
            }
            eventHandlerMap.get(event.getType()).execute(button);
        }
    }

    private GameButton getButtonPressed(Input.TouchEvent event){
        for(GameButton button: buttonList){
            if(Utility.inBounds(event, button.getLocation())){
                return button;
            }
        }
        return null;
    }

    private boolean nullUp(Input.TouchEvent event, GameButton currentButton){
        if(currentButton==null && event.getType()== Input.TouchEvent.TOUCH_UP){
            for(GameButton button: buttonList){
                button.up();
                return true;
            }
        }
        return false;
    }

}
