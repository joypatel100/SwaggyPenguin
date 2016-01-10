package com.game.android.jpbg.swaggypenguin;

import java.util.ArrayList;

/**
 * Created by Joy on 8/21/15.
 */
public class Animation {

    public class Frame{
        private int imageId;
        private float endTime;

        public Frame(int image, float endTime){
            this.imageId = image;
            this.endTime = endTime;
        }
    }

    private ArrayList<Frame> frames;
    private int currentFrame;
    private float animTime;
    private float totalDuration;

    public Animation(int[] ids, float maxDuration){
        this();
        float frameDuration = maxDuration/ids.length;
        for(Integer id: ids){
            addFrame(id,frameDuration);
        }

    }

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

    public synchronized void addFrame(int image, float duration) {
        totalDuration += duration;
        frames.add(new Frame(image, totalDuration));
    }

    private Frame getFrame(int i) {
        return frames.get(i);
    }

    public synchronized int getImageId() {
        if (frames.size() == 0) {
            return -1;
        } else {
            return getFrame(currentFrame).imageId;
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
