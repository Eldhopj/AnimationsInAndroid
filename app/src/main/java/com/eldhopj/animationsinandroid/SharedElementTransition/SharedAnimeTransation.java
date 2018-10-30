package com.eldhopj.animationsinandroid.SharedElementTransition;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.view.View;
import android.widget.ImageView;

import com.eldhopj.animationsinandroid.R;

/**Add windowContentTransitions in styles*/

public class SharedAnimeTransation extends AppCompatActivity {

    ImageView androidImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_anime_transation);

        androidImage = findViewById(R.id.androidImage);

        setTitle("Element transition");//Optional

        //Excluding animations from the following items , we can change and customise according
        Fade fade = new Fade();
        View decor = getWindow().getDecorView();
        fade.excludeTarget(decor.findViewById(R.id.action_bar_container),true);
        fade.excludeTarget(android.R.id.statusBarBackground,true);
        fade.excludeTarget(android.R.id.navigationBarBackground,true);

        getWindow().setEnterTransition(fade);
        getWindow().setExitTransition(fade);
    }

    public void openDetailedActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), DetailedActivity.class);

        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(SharedAnimeTransation.this,
                androidImage,
                "androidHistory"); // The shared element name of the second activity

        startActivity(intent,options.toBundle());
    }
}
