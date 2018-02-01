package com.example.abc.joy23final;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FilterActivity extends Activity implements View.OnClickListener {

    RelativeLayout rlDistanceHeader,rlCategoryFilter;
    LinearLayout liExpandDistance,liFilterBack;
    TextView txtMile1, txtMile5, txtMile25, txtMile50, txtDistance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        rlDistanceHeader = (RelativeLayout) findViewById(R.id.rldistance);
        rlCategoryFilter=(RelativeLayout)findViewById(R.id.rlCategoryFilter);
        liExpandDistance = (LinearLayout) findViewById(R.id.lldistance);
        liFilterBack=(LinearLayout)findViewById(R.id.liFilterBack);

        txtDistance = (TextView) findViewById(R.id.tvDistance);

        txtMile1 = (TextView) findViewById(R.id.tvMile1);
        txtMile5 = (TextView) findViewById(R.id.tvMile5);
        txtMile25 = (TextView) findViewById(R.id.tvMile25);
        txtMile50 = (TextView) findViewById(R.id.tvMile50);

        txtMile1.setOnClickListener(this);
        txtMile5.setOnClickListener(this);
        txtMile25.setOnClickListener(this);
        txtMile50.setOnClickListener(this);

        liExpandDistance.setVisibility(View.GONE);

        liFilterBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        rlCategoryFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(FilterActivity.this,Category_filter_activity.class);
                startActivity(i);
            }
        });

        rlDistanceHeader.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (liExpandDistance.getVisibility() == View.GONE) {
                    expand();
                } else {
                    collapse();
                }
            }
        });

    }

    private void expand() {

        liExpandDistance.setVisibility(View.VISIBLE);

        final int widthSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        final int heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        liExpandDistance.measure(widthSpec, heightSpec);

        ValueAnimator mAnimator = slideAnimator(0, liExpandDistance.getMeasuredHeight());
        mAnimator.start();
    }


    private void collapse() {
        int finalHeight = liExpandDistance.getHeight();

        ValueAnimator mAnimator = slideAnimator(finalHeight, 0);

        mAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                //Height=0, but it set visibility to GONE
                liExpandDistance.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        mAnimator.start();
    }

    private ValueAnimator slideAnimator(int start, int end) {

        ValueAnimator animator = ValueAnimator.ofInt(start, end);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                //Update Height
                int value = (Integer) valueAnimator.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = liExpandDistance.getLayoutParams();
                layoutParams.height = value;
                liExpandDistance.setLayoutParams(layoutParams);
            }
        });
        return animator;
    }


    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.tvMile1:
                collapse();
                txtDistance.setText("1 Mile");

                txtMile1.setTextSize(25);
                txtMile5.setTextSize(18);
                txtMile25.setTextSize(18);
                txtMile50.setTextSize(18);

                break;

            case R.id.tvMile5:
                collapse();
                txtDistance.setText("5 Miles");

                txtMile5.setTextSize(25);
                txtMile1.setTextSize(18);
                txtMile25.setTextSize(18);
                txtMile50.setTextSize(18);

                break;

            case R.id.tvMile25:
                collapse();
                txtDistance.setText("25 Miles");

                txtMile25.setTextSize(25);
                txtMile5.setTextSize(18);
                txtMile1.setTextSize(18);
                txtMile50.setTextSize(18);

                break;

            case R.id.tvMile50:
                collapse();
                txtDistance.setText("50 Miles");

                txtMile50.setTextSize(25);
                txtMile5.setTextSize(18);
                txtMile25.setTextSize(18);
                txtMile1.setTextSize(18);

                break;
        }
    }
}
