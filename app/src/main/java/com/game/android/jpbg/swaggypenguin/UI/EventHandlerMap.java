package com.game.android.jpbg.swaggypenguin.UI;

import com.game.android.jpbg.framework.Input;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Joy on 1/1/16.
 */
public class EventHandlerMap {

    private Map<Integer,IButtonExecute> eventHandlerMap;

    public EventHandlerMap(){
        eventHandlerMap = new HashMap<>();
        eventHandlerMap.put(Input.TouchEvent.TOUCH_DOWN, new Down());
        eventHandlerMap.put(Input.TouchEvent.TOUCH_UP,new Up());
    }

    public IButtonExecute get(int eventType){
        return (eventHandlerMap.containsKey(eventType)) ? eventHandlerMap.get(eventType):new EmptyButtonExecute();
    }
}
