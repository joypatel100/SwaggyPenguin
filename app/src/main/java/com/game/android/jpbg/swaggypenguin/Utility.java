package com.game.android.jpbg.swaggypenguin;

import com.game.android.jpbg.framework.Input;

/**
 * Created by Joy on 8/21/15.
 */
public class Utility {

    public static boolean inBounds(Input.TouchEvent event, int x, int y, int width,
                                   int height) {
        return (event.x > x && event.x < x + width - 1 &&
                event.y > y && event.y < y + height - 1);
    }
}
