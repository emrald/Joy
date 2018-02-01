package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.abc.joy23final.R;

/**
 * Created by Abc on 05/05/2017.
 */
public class More_Fragment extends Fragment {

    ImageView imgdealscreated,imgneedscreated,imgreview,imgdealsresponded,imgneedsresponded,
            imgfavorites,imgmyprofile,imgsettings,imgmypayment,imgmypage,imginvitepeople;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.more_design, container, false);

        imgdealscreated = (ImageView)view.findViewById(R.id.imgdealscreated);
        imgneedscreated = (ImageView)view.findViewById(R.id.imgneedscreated);
        imgreview = (ImageView)view.findViewById(R.id.imgreview);
        imgdealsresponded = (ImageView)view.findViewById(R.id.imgdealsresponded);
        imgneedsresponded = (ImageView)view.findViewById(R.id.imgneedsresponded);
        imgfavorites = (ImageView)view.findViewById(R.id.imgfavorites);
        imgmyprofile = (ImageView)view.findViewById(R.id.imgmyprofile);
        imgsettings = (ImageView)view.findViewById(R.id.imgsettings);
        imgmypayment = (ImageView)view.findViewById(R.id.imgmypayment);
        imgmypage = (ImageView)view.findViewById(R.id.imgmypage);
        imginvitepeople = (ImageView)view.findViewById(R.id.imginvitepeople);

        imgdealscreated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        imgneedscreated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        imgreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        imgdealsresponded.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        imgneedsresponded.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        imgfavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        imgmyprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        imgsettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        imgmypayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        imgmypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        imginvitepeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MainActivity2.tvtitle.setText("More ");
        MainActivity2.imgarrow.setImageResource(R.drawable.arrow_down);

    }
}
