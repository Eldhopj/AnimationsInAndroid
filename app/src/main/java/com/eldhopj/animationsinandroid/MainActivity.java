package com.eldhopj.animationsinandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.eldhopj.animationsinandroid.SharedElementTransition.SharedAnimeTransation;

public class MainActivity extends AppCompatActivity {
TextView fadeInTv,fadeOutTv,crossInTv,crossOutTv,blinkTv, zoomInTv,zoomOutTv, rotateTv, moveTv, slideUpTv, slideDownTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fadeInTv = findViewById(R.id.fadeInTv);
        fadeOutTv = findViewById(R.id.fadeOutTv);
        crossInTv = findViewById(R.id.crossFadeIn);
        crossOutTv = findViewById(R.id.crossFadeOut);
        blinkTv = findViewById(R.id.blinkTv);
        zoomInTv = findViewById(R.id.zoomInTv);
        zoomOutTv = findViewById(R.id.zoomOutTv);
        rotateTv = findViewById(R.id.rotateTv);
        moveTv = findViewById(R.id.moveTv);
        slideUpTv = findViewById(R.id.slideUpTv);
        slideDownTv = findViewById(R.id.slideDownTv);
    }

    public void fadeIn(View view) {
       Animation fadeInAnimation =  animationUtils(R.anim.fade_in);
        fadeInTv.setVisibility(View.VISIBLE);
        fadeInTv.startAnimation(fadeInAnimation);//Starting the animation
    }

    public void fadeOut(View view) {
        Animation fadeOutAnimation =  animationUtils(R.anim.fade_out);
        fadeOutTv.setVisibility(View.INVISIBLE);
        fadeOutTv.startAnimation(fadeOutAnimation);
    }

    public void crossFade(View view) {
        Animation crossFadeIn = animationUtils(R.anim.fade_in);
        Animation crossFadeOut = animationUtils(R.anim.fade_out);

        crossOutTv.setVisibility(View.VISIBLE);
        crossOutTv.startAnimation(crossFadeIn);

        crossInTv.startAnimation(crossFadeOut);
    }

    public void blink(View view) {
        Animation blinkAnimation =  animationUtils(R.anim.blink);
        blinkTv.setVisibility(View.VISIBLE);
        blinkTv.startAnimation(blinkAnimation);
    }

    public void zoomIn(View view) {
        Animation zoomInAnimation = animationUtils(R.anim.zoom_in);
        zoomInTv.startAnimation(zoomInAnimation);
    }

    public void zoomOut(View view) {
        Animation zoomOutAnimation = animationUtils(R.anim.zoom_out);
        zoomOutTv.startAnimation(zoomOutAnimation);
    }

    public void rotate(View view) {
        Animation rotateAnimation = animationUtils(R.anim.rotate);
        rotateTv.startAnimation(rotateAnimation);
    }

    public void move(View view) {
        Animation moveAnimation = animationUtils(R.anim.move);
        moveTv.startAnimation(moveAnimation);
    }

    public void slideUp(View view) {
        Animation slideUpAnimation = animationUtils(R.anim.slide_up);
        slideUpTv.startAnimation(slideUpAnimation);
    }

    public void slideDown(View view) {
        Animation slideDownAnimation = animationUtils(R.anim.slide_down);
        slideDownTv.startAnimation(slideDownAnimation);
    }

    private Animation animationUtils(int id){
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),id); //AnimationUtils : Loading animation logic
        return animation;
    }



    public void startSharedTransActivity(View view) {
        Intent intent = new Intent(getApplicationContext(),SharedAnimeTransation.class);
        startActivity(intent);
    }

    public void textSwitcher(View view) {
        Intent intent = new Intent(getApplicationContext(),TextSwitcherActivity.class);
        startActivity(intent);
    }

    public void circularReveal(View view) {
        Intent intent = new Intent(getApplicationContext(),CircularRevealActivity.class);
        startActivity(intent);
    }

    public void gradientAnimation(View view) {
        Intent intent = new Intent(getApplicationContext(),GradientAnimationActivity.class);
        startActivity(intent);
    }
}
