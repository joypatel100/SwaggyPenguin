package com.game.android.jpbg.framework.implementation;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;

import com.game.android.jpbg.framework.Graphics;
import com.game.android.jpbg.framework.Image;

import java.io.IOException;
import java.io.InputStream;

public class AndroidGraphics implements Graphics {
    private AssetManager assets;
    private Resources resources;
    private Bitmap frameBuffer;
    private Canvas canvas;
    private Paint paint;
    private Rect srcRect = new Rect();
    private Rect dstRect = new Rect();

    private static final String LOG_TAG = AndroidGraphics.class.getSimpleName();

    public AndroidGraphics(AssetManager assets, Bitmap frameBuffer, Resources resources) {
        this.assets = assets;
        this.frameBuffer = frameBuffer;
        this.canvas = new Canvas(frameBuffer);
        this.paint = new Paint();
        this.resources = resources;
    }

    @Override
    public Image newImage(String fileName) {
        return newImage(fileName, ImageFormat.RGB565);
    }

    @Override
    public Image newImage(int id) {
        return newImage(id,ImageFormat.RGB565);
    }

    @Override
    public Image newImage(int id, ImageFormat format){
        //Log.v(LOG_TAG,resources.getString(id));
        return newImage(resources.getString(id),format,true,id);
    }

    @Override
    public Image newImage(String fileName, ImageFormat format) {
        //Log.v(LOG_TAG,fileName);
        return newImage(fileName,format,false,-1);
    }

    private Image newImage(String fileName, ImageFormat format, boolean isId, int id){
        Config config = null;
        if (format == ImageFormat.RGB565)
            config = Config.RGB_565;
        else if (format == ImageFormat.ARGB4444)
            config = Config.ARGB_4444;
        else
            config = Config.ARGB_8888;

        Options options = new Options();
        options.inPreferredConfig = config;


        InputStream in = null;
        Bitmap bitmap = null;
        try {
            if(isId){
                in = resources.openRawResource(id);
            }
            else{
                in = assets.open(fileName);
            }
            bitmap = BitmapFactory.decodeStream(in, null, options);
            if (bitmap == null)
                throw new RuntimeException("Couldn't load bitmap from asset '"
                        + fileName + "'");
        } catch (IOException e) {
            throw new RuntimeException("Couldn't load bitmap from asset '"
                    + fileName + "'");
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
        }

        if (bitmap.getConfig() == Config.RGB_565)
            format = ImageFormat.RGB565;
        else if (bitmap.getConfig() == Config.ARGB_4444)
            format = ImageFormat.ARGB4444;
        else
            format = ImageFormat.ARGB8888;

        return new AndroidImage(bitmap, format, id);
    }

    @Override
    public void clearScreen(int color) {
        canvas.drawRGB((color & 0xff0000) >> 16, (color & 0xff00) >> 8,
                (color & 0xff));
    }


    @Override
    public void drawLine(int x, int y, int x2, int y2, int color) {
        paint.setColor(color);
        canvas.drawLine(x, y, x2, y2, paint);
    }

    @Override
    public void drawRect(int x, int y, int width, int height, int color) {
        paint.setColor(color);
        paint.setStyle(Style.FILL);
        canvas.drawRect(x, y, x + width - 1, y + height - 1, paint);
    }

    @Override
    public void drawARGB(int a, int r, int g, int b) {
        paint.setStyle(Style.FILL);
       canvas.drawARGB(a, r, g, b);
    }

    @Override
    public void drawString(String text, int x, int y, Paint paint){
    	canvas.drawText(text, x, y, paint);
    }

    public void drawImage(Image image, int x, int y, int srcX, int srcY,
            int srcWidth, int srcHeight) {
        srcRect.left = srcX;
        srcRect.top = srcY;
        srcRect.right = srcX + srcWidth;
        srcRect.bottom = srcY + srcHeight;

        dstRect.left = x;
        dstRect.top = y;
        dstRect.right = x + srcWidth;
        dstRect.bottom = y + srcHeight;

        canvas.drawBitmap(((AndroidImage) image).getBitmap(), srcRect, dstRect,
                null);
    }

    @Override
    public void drawImage(Image Image, int x, int y) {
        canvas.drawBitmap(((AndroidImage)Image).getBitmap(), x, y, null);
    }

    @Override
    public void drawImage(Image image, Location location){
        if(location.getSrcX() == -1){
            drawImage(image, (int) location.getX(), (int) location.getY());
        }
        else{
            drawImage(image, (int) location.getX(), (int) location.getY(),
                    (int) location.getSrcX(),(int) location.getSrcY(),
                    (int) location.getSrcWidth(), (int) location.getSrcHeight());
        }
    }

    public void drawScaledImage(Image image, int x, int y, int width, int height, int srcX, int srcY, int srcWidth, int srcHeight){

   	    srcRect.left = srcX;
        srcRect.top = srcY;
        srcRect.right = srcX + srcWidth;
        srcRect.bottom = srcY + srcHeight;

        dstRect.left = x;
        dstRect.top = y;
        dstRect.right = x + width;
        dstRect.bottom = y + height;

        canvas.drawBitmap(((AndroidImage) image).getBitmap(), srcRect, dstRect, null);

    }

    @Override
    public int getWidth() {
        return frameBuffer.getWidth();
    }

    @Override
    public int getHeight() {
        return frameBuffer.getHeight();
    }
}
