package com.game.android.jpbg.framework.implementation;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.SoundPool;

import com.game.android.jpbg.framework.Audio;
import com.game.android.jpbg.framework.Music;
import com.game.android.jpbg.framework.Sound;

import java.io.IOException;

public class AndroidAudio implements Audio {
    AssetManager assets;
    SoundPool soundPool;
    Resources resources;

    public AndroidAudio(Activity activity) {
        activity.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        this.assets = activity.getAssets();
        this.soundPool = new SoundPool(20, AudioManager.STREAM_MUSIC, 0);
        this.resources = activity.getResources();
    }

    @Override
    public Music createMusic(int id){
        return createMusic(resources.getString(id),true,id);
    }

    @Override
    public Music createMusic(String filename) {
        return createMusic(filename,false,0);
    }

    private Music createMusic(String filename, boolean isId, int id){
        AssetFileDescriptor assetDescriptor = null;
        try {
            if (isId){
                assetDescriptor = resources.openRawResourceFd(id);
            }
            else {
                assetDescriptor = assets.openFd(filename);
            }
            return new AndroidMusic(assetDescriptor);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't load music '" + filename + "'");
        }
    }

    @Override
    public Sound createSound(int id){
        return createSound(resources.getString(id));
    }

    @Override
    public Sound createSound(String filename) {
        try {
            AssetFileDescriptor assetDescriptor = assets.openFd(filename);
            int soundId = soundPool.load(assetDescriptor, 0);
            return new AndroidSound(soundPool, soundId);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't load sound '" + filename + "'");
        }
    }

    private Sound createSound(String filename, boolean isId, int id){
        AssetFileDescriptor assetDescriptor = null;
        try {
            if(isId){
                assetDescriptor = resources.openRawResourceFd(id);
            }
            else{
                assetDescriptor = assets.openFd(filename);
            }
            int soundId = soundPool.load(assetDescriptor, 0);
            return new AndroidSound(soundPool, soundId);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't load sound '" + filename + "'");
        }
    }
}
