package adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.abc.joy23final.R;

import java.util.ArrayList;

/**
 * Created by Abc on 18/05/2017.
 */
public class CustomAdpaterCategory extends ArrayAdapter<String> {
    private ArrayList<String> datalist;
    public LayoutInflater inflater;
    Context context;

    public CustomAdpaterCategory(Context context, int resource, ArrayList<String> data) {
        super(context, resource, data);
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.datalist = data;
        this.context = context;
    }
    public class ViewHolder {
        TextView tvcatoryname;
        RelativeLayout rlcategory;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.list_category, null);
            Log.e("position", position + "");

            holder.tvcatoryname = (TextView) convertView.findViewById(R.id.tvcatoryname);
            holder.rlcategory = (RelativeLayout) convertView.findViewById(R.id.rlcategory);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final String tData = datalist.get(position);

        holder.tvcatoryname.setText(tData);

        return convertView;
    }
}