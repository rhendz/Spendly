package com.example.spendly;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class map extends AppCompatActivity {
    private GestureDetectorCompat mDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        mDetector = new GestureDetectorCompat(this, new map.CustomGestureListener());
    }

    class CustomGestureListener extends GestureDetector.SimpleOnGestureListener {
        private static final int MINV = 1000;

        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2,
                               float velocityX, float velocityY) {
            if (Math.abs(velocityX) > Math.abs(velocityY) && Math.abs(velocityX) >= MINV){
                if (velocityX > 0) finish();
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
