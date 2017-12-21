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

public class Rectangle2 extends View {
    Paint paint;
    public Rectangle2(Context c, AttributeSet attrs){
        super(c,attrs);
        paint = new Paint();
        paint.setColor(Color.CYAN);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(0,0,canvas.getWidth(),canvas.getHeight(),paint);
    }
}
