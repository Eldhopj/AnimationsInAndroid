package com.eldhopj.animationsinandroid.ActivitySlideAnimation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.eldhopj.animationsinandroid.R;

/**One way of adding transition animation is that adding overridePendingTransition() after startActivity()
 *      and for back press animation override finish() and overridePendingTransition()
 *
 * Second way is that create a **style** and add the theme to activates in **manifest** */

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    public void secondActivity(View view) {
        Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
        startActivity(intent);
       // overridePendingTransition(R.anim.activity_slide_in_right,R.anim.activity_slide_out_left);
    }
}
