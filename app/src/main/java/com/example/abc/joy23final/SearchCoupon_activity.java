package com.example.abc.joy23final;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SearchCoupon_activity extends Activity {

    ImageView imgCancle,imgBack;
    TextView txtSearch, txtCancel,txtBackSearch;
    RelativeLayout rlSearch;
    EditText edtSearch;
    LinearLayout liFieldSearch,liSearchLabel,liSeachBackCoupons;
    ProgressBar Search_progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_coupon_activity);

        txtSearch = (TextView) findViewById(R.id.tvSearch);
        txtCancel = (TextView) findViewById(R.id.tvCancle);
        txtBackSearch=(TextView)findViewById(R.id.tvBackSearch);

        liSeachBackCoupons = (LinearLayout) findViewById(R.id.liAllSearchBack);
        imgCancle = (ImageView) findViewById(R.id.imgClose);
        imgBack=(ImageView)findViewById(R.id.imgBackSearch);

        edtSearch = (EditText) findViewById(R.id.edtSearch);

        liFieldSearch = (LinearLayout) findViewById(R.id.liFieldSearch);
        liSearchLabel=(LinearLayout)findViewById(R.id.liSearchLabel);
        rlSearch = (RelativeLayout) findViewById(R.id.rlSearch);
        Search_progress = (ProgressBar) findViewById(R.id.Search_progress);

        Search_progress.setVisibility(View.GONE);

        liSearchLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                liSearchLabel.setVisibility(View.GONE);
                rlSearch.setVisibility(View.VISIBLE);
                txtCancel.setVisibility(View.VISIBLE);
                txtBackSearch.setVisibility(View.GONE);

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(edtSearch, InputMethodManager.SHOW_IMPLICIT);

            }
        });

        liSeachBackCoupons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                onBackPressed();
            }
        });

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                onBackPressed();
            }
        });

        liSeachBackCoupons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                onBackPressed();
            }
        });

        imgCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String SearchText = edtSearch.getText().toString();
                Log.e("SearchText....", SearchText + "....");

                edtSearch.setText("");
                Search_progress.setVisibility(View.GONE);

            }
        });

        liFieldSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }
        });

        edtSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {

                    InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    mgr.hideSoftInputFromWindow(edtSearch.getWindowToken(), 0);

                    Search_progress.setVisibility(View.VISIBLE);
                    return true;
                }
                return true;
            }
        });

        txtCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                liSearchLabel.setVisibility(View.VISIBLE);
                rlSearch.setVisibility(View.GONE);
                txtCancel.setVisibility(View.GONE);
                txtBackSearch.setVisibility(View.VISIBLE);

                edtSearch.setText("");
                Search_progress.setVisibility(View.GONE);

                InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(edtSearch.getWindowToken(), 0);
            }
        });
    }
}
