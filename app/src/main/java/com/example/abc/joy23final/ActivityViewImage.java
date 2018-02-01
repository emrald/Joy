package com.example.abc.joy23final;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;

import adapter.CustomAdapter;

/**
 * Created by TI A1 on 23-05-2017.
 */
public class ActivityViewImage extends Activity {

    ViewPager viewPager;
   // public static ImageView imgview;
    ArrayList<String> arrayList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_image);

       // imgview = (ImageView)findViewById(R.id.imgview);
        arrayList.add("http://freehotel.staging.wpengine.com/wp-content/uploads/2015/05/Best-Western-Clarksville-TN.jpg");

        arrayList.add("http://freehotel.staging.wpengine.com/wp-content/uploads/2016/01/Motel-6-Townsend-GA.jpg");

        arrayList.add("http://freehotel.staging.wpengine.com/wp-content/uploads/2016/05/Howard-Johnson-Macon-GA.jpg");

        arrayList.add("http://freehotel.staging.wpengine.com/wp-content/uploads/2015/05/Best-Western-Clarksville-TN.jpg");

        viewPager = (ViewPager) findViewById(R.id.viewPager);

        PagerAdapter adapter = new CustomAdapter(ActivityViewImage.this, arrayList);
        viewPager.setAdapter(adapter);
        /*try {
            Picasso.with(ActivityViewImage.this).load(arrayList.get(2)).placeholder(getResources().getDrawable(R.drawable.download)).error(getResources().getDrawable(R.drawable.download)).into(ActivityViewImage.imgview);
        } catch (Exception e) {
            Log.e("Error...", e.getMessage() + "");
        }*/
    }
}
