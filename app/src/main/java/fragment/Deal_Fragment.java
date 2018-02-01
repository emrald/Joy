package fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.abc.joy23final.ActivityDetails;
import com.example.abc.joy23final.R;

import java.util.ArrayList;

import adapter.CustomAdapterList;
import dataclass.DataListItem;


/**
 * Created by Abc on 05/05/2017.
 */
public class Deal_Fragment extends Fragment {

    static ListView listCoupons;
    CustomAdapterList adt;
    ArrayList<DataListItem> arraylistCoupons;
    static SwipeRefreshLayout mSwipeRefreshLayout;
    DataListItem item;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.deal_design, container, false);

        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swiperefresh);

        listCoupons = (ListView) view.findViewById(R.id.listCoupons);
        arraylistCoupons = new ArrayList<DataListItem>();

        item = new DataListItem();

        item.setCouponname("aaaaaaaaa");
        item.setCoupondetail("234");
        item.setDatetime("11");

        arraylistCoupons.add(item);

        //   Log.e("size....listcoupons...",listCoupons.size()+"..........");

        adt = new CustomAdapterList(getActivity(),R.layout.main_list_item, arraylistCoupons);
        listCoupons.setAdapter(adt);

        listCoupons.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DataListItem data = (DataListItem)parent.getItemAtPosition(position);
                Intent intent = new Intent(getActivity(), ActivityDetails.class);
                intent.putExtra("","");
                startActivity(intent);
            }
        });

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

       /* getActivity().setTitle("Deal");*/
    //    ((FragmentActivity) getActivity()).getSupportActionBar().setDisplayShowCustomEnabled(true); //show custom title
     //   ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
// getActivity().setTitle("Deal ∨");
        MainActivity2.tvtitle.setText("Deal ");
        MainActivity2.imgarrow.setImageResource(R.drawable.arrow_down);

       // ((DrawerLocker) getActivity()).setDrawerEnabled(false);
    }

    private void refresh(){

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(false);
            }
        };
        handler.postDelayed(runnable, 3000);
    }
}
/*
ANDROID_COMPILE_SDK_VERSION = 23
//MIN_SDK = 15
//ANDROID_BUILD_SDK_VERSION = 25
//ANDROID_BUILD_TOOLS_VERSION = 25.0.1
//ANDROID_BUILD_TARGET_SDK_VERSION = 21
//ANDROID_COMPILE_SDK_VERSION = 25*/
