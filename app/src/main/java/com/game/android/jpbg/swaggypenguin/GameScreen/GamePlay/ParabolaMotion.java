package com.game.android.jpbg.swaggypenguin.GameScreen.GamePlay;

import Jama.Matrix;

/**
 * Created by Joy on 1/9/16.
 */
public class ParabolaMotion {

    private float A, B, C, t, y, tEnd;

    public ParabolaMotion() {
        t = 0;
    }

    /***
     *
     * @param Y : contains 3 y coordinates: starting, peak, and end
     * @param T : contains times corresponding to y
     */

    public void resetMotion(float[] Y, float[] T){
        // check to make sure size of y and t are 3
        float t0 = T[0];
        float t1 = T[1];
        float t2 = T[2];
        float y0 = Y[0];
        float y1 = Y[1];
        float y2 = Y[2];
        double[][] coef = {{t0*t0,t0,1},{t1*t1,t1,1},{t2*t2,t2,1}};
        double[][] val = {{y0},{y1},{y2}};
        Matrix A = new Matrix(coef);
        Matrix b = new Matrix(val);
        Matrix x = A.solve(b);
        this.A = (float) x.get(0,0);
        this.B = (float) x.get(1,0);
        this.C = (float) x.get(2,0);
        this.t = 0;
        this.y = y0;
        this.tEnd = T[2];
    }

    public float update(float elapsedTime){
        t += elapsedTime;
        y = A * t * t + B * t + C;
        return y;
    }

    public boolean isDone(){
        return t >= tEnd;
    }

}
