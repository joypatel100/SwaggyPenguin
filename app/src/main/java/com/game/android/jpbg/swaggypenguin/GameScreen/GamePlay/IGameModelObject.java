package com.game.android.jpbg.swaggypenguin.GameScreen.GamePlay;

import com.game.android.jpbg.framework.Input;

import java.util.List;

/**
 * Created by Joy on 1/2/16.
 */
public interface IGameModelObject {

    public void update(float elapsedTime, Input input);

    public List<GameImageId> getImageIds();
}
