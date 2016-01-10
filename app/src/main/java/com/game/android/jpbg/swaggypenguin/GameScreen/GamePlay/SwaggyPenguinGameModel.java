package com.game.android.jpbg.swaggypenguin.GameScreen.GamePlay;

import com.game.android.jpbg.framework.Input;
import com.game.android.jpbg.swaggypenguin.GameResources;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joy on 1/1/16.
 */
public class SwaggyPenguinGameModel implements IGameModelObject{

    private List<IGameModelObject> objs;
    private GameResources gameResources;

    public SwaggyPenguinGameModel(float width, float height){
        objs = new ArrayList<>();
        //objs.add(new SwaggyPenguin(game.getGraphics().getWidth(),game.getGraphics().getHeight()));
        objs.add(new Background(width,height));
        objs.add(new Cannon(width,height));
    }

    @Override
    public void update(float deltaTime, Input input){
        for(IGameModelObject obj: objs){
            obj.update(deltaTime,input);
        }
    }

    @Override
    public List<GameImageId> getImageIds(){
        List<GameImageId> ids = new ArrayList<>();
        for(IGameModelObject obj: objs){
            ids.addAll(obj.getImageIds());
        }
        return ids;
    }



}
