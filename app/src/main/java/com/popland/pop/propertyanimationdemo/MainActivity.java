package com.popland.pop.propertyanimationdemo;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Rectangle1 rect1;
Rectangle2 rect2;
//ImageView iv1, iv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rect1 = (Rectangle1)findViewById(R.id.rect1);
        rect2 = (Rectangle2)findViewById(R.id.rect2);
//        final ImageView iv1 = (ImageView)findViewById(R.id.iv1);
//        final ImageView iv2 = (ImageView)findViewById(R.id.iv2);

        final ValueAnimator animator = ValueAnimator.ofFloat(0.0f,1.0f);//animator loop through the array
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());//frame refreshed evenly in the period of duration
        animator.setDuration(5000L);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                //constantly moving background
                final float progress = (float)valueAnimator.getAnimatedValue();
                final float width = rect1.getWidth();
                final float translationX = width * progress;
                rect1.setTranslationX(translationX);
                rect2.setTranslationX(translationX - width);
            }
        });
        animator.start();

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(rect1,"translationX",500f);//object, property name, ending value
        //objectAnimator.setRepeatCount(ObjectAnimator.INFINITE);
        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                Toast.makeText(MainActivity.this,"done",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        objectAnimator.setDuration(3000L);
        //objectAnimator.start();

        ValueAnimator alphaAnim = ObjectAnimator.ofFloat(rect1,"alpha",1f,0f);
        //alphaAnim.setRepeatCount(ValueAnimator.INFINITE);
        alphaAnim.setDuration(3000L);

        AnimatorSet animSet = new AnimatorSet();
        animSet.play(objectAnimator).before(alphaAnim);
        animSet.start();
    }
}
