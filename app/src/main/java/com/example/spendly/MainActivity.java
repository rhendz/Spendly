package com.example.spendly;

import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private GestureDetectorCompat mDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDetector = new GestureDetectorCompat(this, new CustomGestureListener());
        ImageView myImageView = (ImageView) findViewById(R.id.imageView2);
        myImageView.setImageResource(R.drawable.spendlylogo);
    }

    class CustomGestureListener extends GestureDetector.SimpleOnGestureListener {
        private static final int MINV = 1000;

        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2,
                               float velocityX, float velocityY) {
            if (Math.abs(velocityX) >= Math.abs(velocityY) && Math.abs(velocityX) >= MINV) {
                if (velocityX > 0) startActivity(new Intent(MainActivity.this, receipt.class));
                else startActivity(new Intent(MainActivity.this, map.class));
            } else if (Math.abs(velocityY) > Math.abs(velocityX) && Math.abs(velocityY) >= MINV){
                if (velocityY < 0)
                    startActivity(new Intent(MainActivity.this, camera.class));
            }

            return true;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.mDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
