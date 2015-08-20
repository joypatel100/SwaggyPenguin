package com.game.android.jpbg.framework;


public interface Audio {

    public Music createMusic(int id);

    public Music createMusic(String file);

    public Sound createSound(int id);

    public Sound createSound(String file);
}
