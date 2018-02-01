package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.abc.joy23final.R;

/**
 * Created by Abc on 05/05/2017.
 */
public class Friends_Fragment extends Fragment {

    RelativeLayout rlProfile, rlFriends;
    ImageView imgProfileArrow,imgFriendsArrow;
    LinearLayout liProfile,liFriends;
    Boolean ProfileArrow=true;
    Boolean FriendsArrow=true;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.friends_design, container, false);

        rlProfile = (RelativeLayout) view.findViewById(R.id.rlProfileArrow);
        rlFriends = (RelativeLayout) view.findViewById(R.id.rlFriendsArrow);

        imgProfileArrow=(ImageView)view.findViewById(R.id.imgArrowProfile) ;
        imgFriendsArrow=(ImageView)view.findViewById(R.id.imgArrowFriends) ;

        liProfile=(LinearLayout)view.findViewById(R.id.liProfile);
        liFriends=(LinearLayout)view.findViewById(R.id.liFriends);

        liProfile.setVisibility(View.VISIBLE);
        liFriends.setVisibility(View.VISIBLE);

        imgProfileArrow.setImageResource(R.drawable.arrow_up);
        imgFriendsArrow.setImageResource(R.drawable.arrow_up);


        rlProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // ProfileArrow true=up,false=down

                if (ProfileArrow==true) {
                    ProfileArrow=false;
                    imgProfileArrow.setImageResource(R.drawable.arrow_down);
                    liProfile.setVisibility(View.GONE);
                }
                else {
                    ProfileArrow=true;
                    imgProfileArrow.setImageResource(R.drawable.arrow_up);
                    liProfile.setVisibility(View.VISIBLE);
                }
            }
        });

        rlFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgFriendsArrow.setImageResource(R.drawable.arrow_down);

                // FriendsArrow true=up,false=down

                if (FriendsArrow==true) {
                    FriendsArrow=false;
                    imgFriendsArrow.setImageResource(R.drawable.arrow_down);
                    liFriends.setVisibility(View.GONE);
                }
                else {
                    FriendsArrow=true;
                    imgFriendsArrow.setImageResource(R.drawable.arrow_up);
                    liFriends.setVisibility(View.VISIBLE);
                }
            }
        });


        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //  getActivity().setTitle("Friends");


      //  ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowCustomEnabled(true); //show custom title
     //   ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
// getActivity().setTitle("Deal ∨");
        MainActivity2.tvtitle.setText("Friends ");
        MainActivity2.imgarrow.setImageResource(R.drawable.arrow_down);

       // ((DrawerLocker) getActivity()).setDrawerEnabled(false);
    }
}
