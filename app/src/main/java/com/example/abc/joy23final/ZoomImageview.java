package com.example.abc.joy23final;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class ZoomImageview extends Activity {//implements GestureDetector.OnGestureListener {
    ImageView img;
    GestureDetector detector;
    TextView textview;
    Animation animIn, animOut;
    public static final String EXTRA_NAME = "cheese_name";
    SwipeRefreshLayout swipeRefreshLayout;
    ScaleGestureDetector scaleGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoom_imageview);

       // img = (ImageView) findViewById(R.id.ImageView);

      //     detector = new GestureDetector(this);

        animIn = AnimationUtils.loadAnimation(this, R.anim.zoom_image);
        animOut = AnimationUtils.loadAnimation(this, R.anim.zoom_out_image);
        Intent intent = getIntent();
        final String cheeseName = intent.getStringExtra(EXTRA_NAME);

        TextView textMsg;
        ImageView myImage;



            textMsg = (TextView)findViewById(R.id.msg);
            myImage = (ImageView)findViewById(R.id.myimage);

            scaleGestureDetector = new ScaleGestureDetector(
                    this, new MySimpleOnScaleGestureListener(textMsg, myImage));
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            scaleGestureDetector.onTouchEvent(event);
            return true;
            //return super.onTouchEvent(event);
        }

        private class MySimpleOnScaleGestureListener
                extends ScaleGestureDetector.SimpleOnScaleGestureListener{

            TextView viewMessage;
            ImageView viewMyImage;

            float factor;

            public MySimpleOnScaleGestureListener(TextView v, ImageView iv) {
                super();
                viewMessage = v;
                viewMyImage = iv;
            }

            @Override
            public boolean onScaleBegin(ScaleGestureDetector detector) {
                factor = 1.0f;
                return true;
                //return super.onScaleBegin(detector);
            }

            @Override
            public boolean onScale(ScaleGestureDetector detector) {

                float scaleFactor = detector.getScaleFactor() - 1;
                factor += scaleFactor;
                viewMessage.setText(String.valueOf(scaleFactor)
                        + "\n" + String.valueOf(factor));
                viewMyImage.setScaleX(factor);
                viewMyImage.setScaleY(factor);
                return true;
                //return super.onScale(detector);
            }
        }
    }

       /* swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_to_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                fetchTimelineAsync(0);
            }
        });
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light, R.color.colorAccent, R.color.colorPrimaryDark);
    }

    public void fetchTimelineAsync(int page) {
        //
    }*/

       /* final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/

       /* CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing);
        collapsingToolbar.setTitle("My Toolbar Tittle");

        collapsingToolbar.setCollapsedTitleTextColor(getResources().getColor(R.color.colorPrimary));
        collapsingToolbar.setExpandedTitleColor(getResources().getColor(R.color.colorAccent));

        collapsingToolbar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {


                int action = event.getAction();
                int x = (int) event.getX();
                int y = (int) event.getY();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        Log.e("down....", x + " : " + y + "");
                        img.startAnimation(animIn);
                        // textSource.setText("ACTION_DOWN- " + x + " : " + y);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        //  textSource.setText("ACTION_MOVE- " + x + " : " + y);
                        break;
                    case MotionEvent.ACTION_UP:
                        //   textSource.setText("ACTION_UP- " + x + " : " + y);
                        img.startAnimation(animOut);
                        Log.e("up....", x + " : " + y + "");
                        break;
                }
                return true;
            }


        });
*/


   /* @Override
    public boolean onTouchEvent(MotionEvent event) {
        return detector.onTouchEvent(event);
    }


    @Override
    public boolean onDown(MotionEvent e) {
        //  Toast.makeText(getApplicationContext(), "OnDown Gesture", Toast.LENGTH_SHORT).show();

      *//* img.clearAnimation();*//*
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        //   Toast.makeText(getApplicationContext(), "Show Press gesture", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        //    Toast.makeText(getApplicationContext(), "Single Tap Gesture", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        //   Toast.makeText(getApplicationContext(), "Scroll Gesture", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        //   Toast.makeText(getApplicationContext(), "Long Press Gesture", Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        switch (getSlope(e1.getX(), e1.getY(), e2.getX(), e2.getY())) {
            case 1:
                Log.e("top.....", "top");
                img.startAnimation(animOut);
                return true;
            case 2:
                Log.e("left.....", "left");
                return true;
            case 3:
                Log.e("down...", "down");
                img.startAnimation(animIn);
                return true;
            case 4:
                Log.e("right...", "right");
                return true;
        }
        return false;
       *//* Toast.makeText(getApplicationContext(), "Fling Gesture", Toast.LENGTH_SHORT).show();
        return true;
*//*
    }

    private int getSlope(float x1, float y1, float x2, float y2) {
        Double angle = Math.toDegrees(Math.atan2(y1 - y2, x2 - x1));
        if (angle > 45 && angle <= 135)
            // top
            return 1;
        if (angle >= 135 && angle < 180 || angle < -135 && angle > -180)
            // left
            return 2;
        if (angle < -45 && angle >= -135)
            // down
            return 3;
        if (angle > -45 && angle <= 45)
            // right
            return 4;
        return 0;
    }*/

