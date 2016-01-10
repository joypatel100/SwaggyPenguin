package com.game.android.jpbg.swaggypenguin.GameScreen.GamePlay;

import com.game.android.jpbg.swaggypenguin.UI.GameImagePosition;
import com.game.android.jpbg.swaggypenguin.UI.IExecute;

/**
 * Created by Joy on 1/9/16.
 */
public class CannonBall extends Projectile{

    public CannonBall(int id, float x, float y, GameImagePosition pos, int withRespectToId, float width, float height, SwaggyPenguin penguin) {
        super(id, x, y, pos, withRespectToId, width, height);
        this.setOnImpact(new CannonBallImpact(penguin));
    }

    private class CannonBallImpact implements IExecute{
        private SwaggyPenguin penguin;

        private CannonBallImpact(SwaggyPenguin penguin) {
            this.penguin = penguin;
        }

        @Override
        public void execute() {
            penguin.setPenguinState(SwaggyPenguin.PenguinState.DEAD);
        }
    }
}
