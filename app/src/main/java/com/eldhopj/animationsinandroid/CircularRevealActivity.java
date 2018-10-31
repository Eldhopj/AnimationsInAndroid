package com.eldhopj.animationsinandroid;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
/**Add the design support library
 * Note : We can give animations to layouts also*/
public class CircularRevealActivity extends AppCompatActivity {

View fabView;
    int cx;
    int cy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circular_reveal);

        fabView = findViewById(R.id.floatingActionButton);


    }

    public void reveal(View view) {
        //Calculating the center of fab
        cx = fabView.getWidth()/2;
        cy = fabView.getHeight()/2;

        float finalRadius = (float) Math.hypot(cx,cy);

        Animator animator = ViewAnimationUtils.createCircularReveal(fabView,cx,cy,0,finalRadius);
        fabView.setVisibility(View.VISIBLE);
        animator.start();
    }

    public void hide(final View view) {
        //Calculating the center of fab
        cx = fabView.getWidth()/2;
        cy = fabView.getHeight()/2;

        float initialRadius = (float) Math.hypot(cx,cy);

        Animator animator = ViewAnimationUtils.createCircularReveal(fabView,cx,cy,initialRadius,0);

        animator.addListener(new AnimatorListenerAdapter() { // This will help to make the fab button invisible after anime
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                fabView.setVisibility(View.INVISIBLE);
            }
        });
        animator.start();
    }

}
