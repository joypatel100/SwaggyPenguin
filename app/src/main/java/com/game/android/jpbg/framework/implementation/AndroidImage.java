package com.game.android.jpbg.framework.implementation;

import android.graphics.Bitmap;

import com.game.android.jpbg.framework.Graphics.ImageFormat;
import com.game.android.jpbg.framework.Image;

public class AndroidImage implements Image {
    private Bitmap bitmap;
    private ImageFormat format;
    private int id;

    public AndroidImage(Bitmap bitmap, ImageFormat format) {
        this(bitmap,format,-1);
    }

    public AndroidImage(Bitmap bitmap, ImageFormat format, int id){
        this.bitmap = bitmap;
        this.format = format;
        this.id = id;
    }

    @Override
    public int getWidth() {
        return bitmap.getWidth();
    }

    @Override
    public int getHeight() {
        return bitmap.getHeight();
    }

    @Override
    public ImageFormat getFormat() {
        return format;
    }

    @Override
    public void dispose() {
        bitmap.recycle();
    }

    @Override
    public Bitmap getBitmap() {
        return this.bitmap;
    }

    @Override
    public int getId() {
        return id;
    }
}
