package com.popland.pop.propertyanimationdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;



/**
 * Created by hai on 21/12/2017.
 */

public class Rectangle1 extends View {
Paint paint;
    public Rectangle1(Context c, AttributeSet attrs){
        super(c,attrs);
        paint = new Paint();
        paint.setColor(Color.MAGENTA);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(0,0,canvas.getWidth(),canvas.getHeight(),paint);
    }
}
