package fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.abc.joy23final.ChatActivity;
import com.example.abc.joy23final.R;

/**
 * Created by Abc on 05/05/2017.
 */
public class Chat_Fragment extends Fragment {
    LinearLayout liProfileChat;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chat_design, container, false);

        liProfileChat = (LinearLayout) view.findViewById(R.id.liProfileChat);

        liProfileChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), ChatActivity.class);
                startActivity(intent);
            }
        });

        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //  getActivity().setTitle("Chat");

       // ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowCustomEnabled(true); //show custom title
      //  ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
// getActivity().setTitle("Deal ∨");
        MainActivity2.tvtitle.setText("Chat ");
        MainActivity2.imgarrow.setImageResource(R.drawable.arrow_down);

       // ((DrawerLocker) getActivity()).setDrawerEnabled(false);
    }

}
