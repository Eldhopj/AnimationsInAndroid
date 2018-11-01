package com.eldhopj.animationsinandroid;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**Add palette library <a href https://developer.android.com/topic/libraries/support-library/packages#v7-palette/>
 **/
public class PaletteActivity extends AppCompatActivity {

    private ConstraintLayout rootLayout;
    private TextView textViewTitle;
    private TextView textViewBody;
    private ImageView flowerIv;

    Bitmap bitmap;
    //Palette swatches (color profiles)
    private Palette.Swatch vibrantSwatch;
    private Palette.Swatch lightVibrantSwatch;
    private Palette.Swatch darkVibrantSwatch;
    private Palette.Swatch mutedSwatch;
    private Palette.Swatch lightMutedSwatch;
    private Palette.Swatch darkMutedSwatch;

    private int colorSwatches;
    int flowerIndex = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        rootLayout = findViewById(R.id.root_layout);
        textViewTitle = findViewById(R.id.flower);
        textViewBody = findViewById(R.id.text_view_body);
        flowerIv = findViewById(R.id.flowerIv);

        bitmap = ((BitmapDrawable) flowerIv.getDrawable()).getBitmap(); // Getting bitmap from the imageView

        generatingColorPalette(bitmap);

    }

    private void generatingColorPalette(Bitmap bitmap) {
        Palette.from(bitmap)
//              .maximumColorCount(16) // shows maximum number of color to be picked
                .generate(new Palette.PaletteAsyncListener() { // NOTE : if you are running it in background thread no need to use PaletteAsyncListener
                    @Override
                    public void onGenerated(@Nullable Palette palette) {
                        if (palette != null) {
                            vibrantSwatch = palette.getVibrantSwatch();
                            lightVibrantSwatch = palette.getLightVibrantSwatch();
                            darkVibrantSwatch = palette.getDarkVibrantSwatch();
                            mutedSwatch = palette.getMutedSwatch();
                            lightMutedSwatch = palette.getLightMutedSwatch();
                            darkMutedSwatch = palette.getDarkMutedSwatch();
                        }
                    }
                });
    }


    public void nextColor(View view) {

        Palette.Swatch currentSwatch = null;

        switch (colorSwatches) {
            case 0:
                currentSwatch = vibrantSwatch;
                textViewTitle.setText("Vibrant");
                break;
            case 1:
                currentSwatch = lightVibrantSwatch;
                textViewTitle.setText("Light Vibrant");
                break;
            case 2:
                currentSwatch = darkVibrantSwatch;
                textViewTitle.setText("Dark Vibrant");
                break;
            case 3:
                currentSwatch = mutedSwatch;
                textViewTitle.setText("Muted");
                break;
            case 4:
                currentSwatch = lightMutedSwatch;
                textViewTitle.setText("Light Muted");
                break;
            case 5:
                currentSwatch = darkMutedSwatch;
                textViewTitle.setText("Dark Muted");
                break;
        }

        if (currentSwatch != null){ // Prevents crash if one of the pallet is null
            rootLayout.setBackgroundColor(currentSwatch.getRgb()); // gets the color from the picture
            textViewTitle.setTextColor(currentSwatch.getTitleTextColor()); // gets appropriate color for the title
            textViewBody.setTextColor(currentSwatch.getBodyTextColor()); // gets appropriate color for the body
        }
        else { //If swatch is null

            // Give some default color

        }

        if (colorSwatches < 5) { //looping through different color swatches
            colorSwatches ++;
        } else {
            colorSwatches = 0;
        }
    }

    public void nextFlower(View view) {

        switch (flowerIndex){
            case 0:
                flowerIv.setImageDrawable(getResources().getDrawable(R.drawable.flower));
                break;
            case 1:
                flowerIv.setImageDrawable(getResources().getDrawable(R.drawable.flower2));
                break;
            case 2:
                flowerIv.setImageDrawable(getResources().getDrawable(R.drawable.flower3));
                break;
            case 3:
                flowerIv.setImageDrawable(getResources().getDrawable(R.drawable.flower4));
                break;
        }

        bitmap =  ((BitmapDrawable) flowerIv.getDrawable()).getBitmap(); // Getting bitmap from the imageView
        generatingColorPalette(bitmap);

        if (flowerIndex < 3){
            flowerIndex++;
        }else {
            flowerIndex=0;
        }
    }
}
