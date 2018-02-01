package adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abc.joy23final.R;

import java.util.ArrayList;

import dataclass.DataListItem;

/**
 * Created by TI A1 on 23-05-2017.
 */
public class CustomAdapterList extends ArrayAdapter<DataListItem> {
    private ArrayList<DataListItem> datalist;
    public LayoutInflater inflater;
    Context context;

    public CustomAdapterList(Context context, int resource, ArrayList<DataListItem> data) {
        super(context, resource, data);
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.datalist = data;
        this.context = context;
    }
    public class ViewHolder {
        TextView tvcouponname;
        TextView tvdatetime;
        TextView tvcoupondetail;
        ImageView imgcouponlist;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.main_list_item, null);
            Log.e("position", position + "");

            holder.tvcouponname = (TextView) convertView.findViewById(R.id.tvcouponname);
            holder.tvdatetime = (TextView) convertView.findViewById(R.id.tvdatetime);
            holder.tvcoupondetail = (TextView) convertView.findViewById(R.id.tvcoupondetail);
            holder.imgcouponlist = (ImageView) convertView.findViewById(R.id.imgcouponlist);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final DataListItem tData = datalist.get(position);

        holder.tvcouponname.setText("");
        holder.tvdatetime.setText("");
        holder.tvcoupondetail.setText("");

        return convertView;
    }
}