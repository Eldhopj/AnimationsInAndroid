package com.eldhopj.animationsinandroid;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class TextSwitcherActivity extends AppCompatActivity {
    private static final String TAG = "TextSwitcherActivity";
    TextSwitcher switcher;
    int stringIndex = 0;
    String stringArray [] = {"One", "Two", "Three", "Four", "Five"};
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_switcher);

        switcher = findViewById(R.id.textSwitcher);

        textSwitcherFactory();
        switcher.setText(stringArray[stringIndex]);

        onClickListenerOnTextView();
    }

    public void next(View view) {
        switcher.setInAnimation(this, android.R.anim.slide_in_left);
        switcher.setOutAnimation(this, android.R.anim.slide_out_right);
        if (stringIndex == stringArray.length-1){ // When the text switcher reaches the last position it reset into first position
            stringIndex = 0;
            switcher.setText(stringArray[stringIndex]);
        }else {
            switcher.setText(stringArray[++stringIndex]); // Shows the next element
        }
    }

    //TODO : Transition is not smooth enough
    public void previous(View view) {
        switcher.setOutAnimation(this,R.anim.text_switcher_prev_slide_out);
        switcher.setInAnimation(this,R.anim.text_switcher_prev_slide_in);
        if (stringIndex == 0){ // When the text switcher reaches the first position it reset into last position
            stringIndex = stringArray.length-1;
            switcher.setText(stringArray[stringIndex]);
        }else {
            switcher.setText(stringArray[--stringIndex]); // Shows the prev element
        }
    }

   private void textSwitcherFactory(){
        switcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                textView = new TextView(getApplicationContext());
                textView.setTextColor(Color.BLUE);
                textView.setGravity(Gravity.CENTER_HORIZONTAL);
                return textView;
            }
        });
    }

    private void onClickListenerOnTextView() {
        switcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (stringIndex){
                    case 0:
                        Log.d(TAG, "onClick: "+"One");
                        return;
                    case 1:
                        Log.d(TAG, "onClick: "+ "two");
                        return;
                    case 2:
                        Log.d(TAG, "onClick: "+ "Three");
                        return;
                }

            }
        });
    }

}
