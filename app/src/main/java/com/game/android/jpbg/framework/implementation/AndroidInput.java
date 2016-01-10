package com.game.android.jpbg.framework.implementation;

import android.content.Context;
import android.view.View;

import com.game.android.jpbg.framework.Input;

import java.util.List;

public class AndroidInput implements Input {


    private TouchHandler touchHandler;
    private AccelerometerHandler accelerometerHandler;

    public AndroidInput(Context context, View view, float scaleX, float scaleY) {
        if(android.os.Build.VERSION.SDK_INT < 5)
            touchHandler = new SingleTouchHandler(view, scaleX, scaleY);
        else
            touchHandler = new MultiTouchHandler(view, scaleX, scaleY);
        accelerometerHandler = new AccelerometerHandler(context);
    }

    @Override
    public boolean isTouchDown(int pointer) {
        return touchHandler.isTouchDown(pointer);
    }

    @Override
    public int getTouchX(int pointer) {
        return touchHandler.getTouchX(pointer);
    }

    @Override
    public int getTouchY(int pointer) {
        return touchHandler.getTouchY(pointer);
    }

    @Override
    public List<TouchEvent> getTouchEvents() {
        return touchHandler.getTouchEvents();
    }

    @Override
    public float getAccelX() {
        return accelerometerHandler.getAccelX();
    }

    @Override
    public float getAccelY() {
        return accelerometerHandler.getAccelY();
    }

    @Override
    public float getAccelZ() {
        return accelerometerHandler.getAccelZ();
    }

}
