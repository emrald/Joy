package adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.abc.joy23final.ChatMessage;
import com.example.abc.joy23final.R;

import java.util.ArrayList;

/**
 * Created by Abc on 12/05/2017.
 */
public class ChatAdapter extends BaseAdapter {

    private static LayoutInflater inflater = null;
    ArrayList<ChatMessage> chatMessageList;

    public ChatAdapter(Activity activity, ArrayList<ChatMessage> list) {
        chatMessageList = list;
        inflater = (LayoutInflater) activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return chatMessageList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ChatMessage message = (ChatMessage) chatMessageList.get(position);
        View vi = convertView;
        if (convertView == null)
            vi = inflater.inflate(R.layout.design_listview_chat, null);

        TextView msg = (TextView) vi.findViewById(R.id.message_text);
        msg.setText(message.body);
        LinearLayout layout = (LinearLayout) vi.findViewById(R.id.bubble_layout);
        LinearLayout parent_layout = (LinearLayout) vi.findViewById(R.id.bubble_layout_parent);

     //   ImageView img=(ImageView)vi.findViewById(R.id.imgChat);


        // if message is mine then align to right
        if (message.isMine) {
          //  layout.setBackgroundResource(R.drawable.send_message);
            layout.setBackgroundColor(Color.parseColor("#00B900"));
            parent_layout.setGravity(Gravity.RIGHT);
        //    img.setVisibility(View.GONE);
        }
        // If not mine then align to left
        else {
         //  layout.setBackgroundResource(R.drawable.receive_message);
            parent_layout.setGravity(Gravity.LEFT);
            layout.setBackgroundColor(Color.parseColor("#ff000"));
         //  img.setVisibility(View.VISIBLE);
        }
        msg.setTextColor(Color.BLACK);
        return vi;
    }

    public void add(ChatMessage object) {
        chatMessageList.add(object);
    }
}
