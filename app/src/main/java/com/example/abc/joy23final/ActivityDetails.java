package com.example.abc.joy23final;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import fragment.WorkaroundMapFragment;

/**
 * Created by TI A1 on 23-05-2017.
 */
public class ActivityDetails extends FragmentActivity implements OnMapReadyCallback {

    WorkaroundMapFragment mapFragment;
    Activity context;
    GoogleMap mMap;
    ScrollView scrollmain, scrollmap;
    int status;
    double latitude=0.0,longitude=0.0;
    Marker marker;
    FrameLayout framelayout;
    //RatingBar ratingBar1;
    RelativeLayout rlmapaddress,rldirection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        scrollmap = (ScrollView) findViewById(R.id.scrollmap);
        scrollmain = (ScrollView) findViewById(R.id.scrollmain);
        framelayout = (FrameLayout)findViewById(R.id.framelayout);
        rlmapaddress = (RelativeLayout)findViewById(R.id.rlmapaddress);
        rldirection = (RelativeLayout)findViewById(R.id.rldirection);
       // ratingBar1 = (RatingBar)findViewById(R.id.ratingBar1);

        context = ActivityDetails.this;
        mapFragment = ((WorkaroundMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_details));
      /* googleMap = mapFragment.getMap();*/
     //   SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_details);
        mapFragment.getMapAsync(this);
       /* mapFragment = ((WorkaroundMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_details));
        googleMap = mapFragment.getMap();
*/
        ((WorkaroundMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_details)).setListener(new WorkaroundMapFragment.OnTouchListener() {
            @Override
            public void onTouch() {
                scrollmap.requestDisallowInterceptTouchEvent(true);
            }
        });

        status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getBaseContext());
       /* ((WorkaroundMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_details)).setListener(new WorkaroundMapFragment.OnTouchListener() {
            @Override
            public void onTouch() {
                scrollmap.requestDisallowInterceptTouchEvent(true);
            }
        });*/
        if (ContextCompat.checkSelfPermission(ActivityDetails.this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(ActivityDetails.this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(ActivityDetails.this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 1);

        } else {
            GPSTracker gps = new GPSTracker(ActivityDetails.this);

            // Check if GPS enabled
            if (gps.getIsGPSTrackingEnabled()) {

                latitude = gps.getLatitude();
                longitude = gps.getLongitude();
                Log.e("latitude", latitude+"");

            } else {
                // Can't get location.
                // GPS or network is not enabled.
                // Ask user to enable GPS/network in settings.
                gps.showSettingsAlert();
            }
        }
        scrollmain.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                Log.v("TAG", "PARENT TOUCH");
                findViewById(R.id.scrollmap).getParent().requestDisallowInterceptTouchEvent(false);
                //       findViewById(R.id.scrolltextdetail).getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            }

        });

        scrollmap.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                Log.v("TAG", "CHILD TOUCH");
                // Disallow the touch request for parent scroll on touch of child view
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
   //     status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getBaseContext());
        framelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityDetails.this,ActivityViewImage.class);
                startActivity(intent);
            }
        });
        //ratingBar1.setStarsSeparation(20, Dimension.DP);
       /* LayerDrawable stars = (LayerDrawable) ratingBar1.getProgressDrawable();
        stars.getDrawable(2).setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);*/
   //     stars.getDrawable(0).setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
    //    stars.getDrawable(1).setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_ATOP);

       /* LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
        // Filled stars
        setRatingStarColor(stars.getDrawable(2), ContextCompat.getColor(ActivityDetails.this, R.color.colorAccent));
        // Half filled stars
        setRatingStarColor(stars.getDrawable(1), ContextCompat.getColor(ActivityDetails.this, R.color.colorPrimaryDark));
        // Empty stars
        setRatingStarColor(stars.getDrawable(0), ContextCompat.getColor(ActivityDetails.this, R.color.dgts__purple));
*/
       /* LayerDrawable layerDrawable = (LayerDrawable) ratingBar.getProgressDrawable();
        DrawableCompat.setTint(DrawableCompat.wrap(layerDrawable.getDrawable(0)), Color.RED);   // Empty star
        DrawableCompat.setTint(DrawableCompat.wrap(layerDrawable.getDrawable(1)), Color.GREEN); // Partial star
        DrawableCompat.setTint(DrawableCompat.wrap(layerDrawable.getDrawable(2)), Color.BLUE);*/

        rlmapaddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityDetails.this,MapsActivity.class);
                startActivity(intent);
            }
        });
        rldirection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://maps.google.com/maps?saddr="+latitude+","+longitude+"&daddr=20.5666,45.345"));
                startActivity(intent);
            }
        });
    }
   /* @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }*/
   private void setRatingStarColor(Drawable drawable, @ColorInt int color)
   {
       if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
       {
           DrawableCompat.setTint(drawable, color);
       }
       else
       {
           drawable.setColorFilter(color, PorterDuff.Mode.SRC_IN);
       }
   }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(ActivityDetails.this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                LatLng sydney = new LatLng(-34, 151);
                mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
              //  mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-34, 151), 12.0f));
            }
        }else {
                LatLng sydney = new LatLng(-34, 151);
                mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
             //   mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-34, 151), 12.0f));
            }
         //   mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-34, 151), 14.0f));

    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

   /* @Override
    public void onLocationChanged(Location location) {
        marker = googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(-34,151))
                .title("Sydney")
                .snippet("City"));//.icon(BitmapDescriptorFactory.fromBitmap(myBitmap)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-34, 151), 10));
    }*/
}
