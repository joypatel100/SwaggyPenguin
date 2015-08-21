package com.game.android.jpbg.swaggypenguin;

import com.game.android.jpbg.framework.Image;

import java.util.ArrayList;

/**
 * Created by Joy on 8/21/15.
 */
public class Animation {

    public class Frame{
        Image image;
        long endTime;

        public Frame(Image image, long endtime){
            this.image = image;
            this.endTime = endtime;
        }
    }

    public ArrayList<Frame> frames;
    public int currentFrame;
    public long animTime;
    public long totalDuration;

    public Animation(){
        this.frames = new ArrayList<>();
        this.totalDuration = 0;

        synchronized (this){
            this.animTime = 0;
            this.currentFrame = 0;
        }
    }

    public synchronized void setZero(){
        synchronized(this){
            animTime = 0;
            currentFrame = 0;
        }
    }

    public boolean isZero(){
        return animTime == 0;
    }

    public synchronized void addFrame(Image image, long duration) {
        totalDuration += duration;
        frames.add(new Frame(image, totalDuration));
    }

    private Frame getFrame(int i) {
        return frames.get(i);
    }

    public synchronized Image getImage() {
        if (frames.size() == 0) {
            return null;
        } else {
            return getFrame(currentFrame).image;
        }
    }

    public synchronized void update(float elapsedTime){
        if(frames.size() > 1){
            animTime += elapsedTime;
            if(animTime >= totalDuration){
                animTime = animTime % totalDuration;
                currentFrame = 0;
            }
            while (animTime > getFrame(currentFrame).endTime) {
                currentFrame++;
            }
        }

    }



}
