package com.example.abc.joy23final;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import adapter.CustomAdpaterCategory;

public class Category_filter_activity extends Activity {

    ListView lstcategory;
    CustomAdpaterCategory adapter_category;
    ArrayList<String> arraylist;
    String[] category_array = {"Active Life","Arts & Entertainment","Automotive","Beauty & Spas",
            "Education","Event Planning & Services","Financial Services","Food","Health & Medical",
            "Home Services","Hotels & Travel","Local Flavor","Local Services","Mass Media","Nightlife",
            "Pets","Professional Services","Public Services & Government","Real Estate","Religious Organizations",
            "Restaurants","Shopping"};
    LinearLayout liAllCategoryBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_filter_activity);



        lstcategory = (ListView)findViewById(R.id.listcategory);
        liAllCategoryBack=(LinearLayout) findViewById(R.id.liAllCategoryBack) ;
        arraylist = new ArrayList<String>(Arrays.asList(category_array));

        liAllCategoryBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        adapter_category = new CustomAdpaterCategory(Category_filter_activity.this, R.layout.list_category, arraylist);
        lstcategory.setAdapter(adapter_category);
    }
}
