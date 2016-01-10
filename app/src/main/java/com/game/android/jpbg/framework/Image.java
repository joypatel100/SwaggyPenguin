package com.game.android.jpbg.framework;

import android.graphics.Bitmap;

import com.game.android.jpbg.framework.Graphics.ImageFormat;

public interface Image {
    public int getWidth();
    public int getHeight();
    public ImageFormat getFormat();
    public void dispose();
    public Bitmap getBitmap();
    public int getId();
}
