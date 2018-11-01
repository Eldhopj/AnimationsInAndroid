package com.eldhopj.animationsinandroid.ActivitySlideAnimation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.eldhopj.animationsinandroid.R;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

//    @Override
//    public void finish() {
//        super.finish();
//        overridePendingTransition(R.anim.activity_slide_in_left,R.anim.activity_slide_out_right);
//    }

    public void thirdActivity(View view) {
        Intent intent = new Intent(getApplicationContext(),ThirdActivity.class);
        startActivity(intent);
    }


}
