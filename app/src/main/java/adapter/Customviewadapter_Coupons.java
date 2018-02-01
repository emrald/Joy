package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abc.joy23final.R;
import dataclass.RowItemCoupons;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Abc on 06/05/2017.
 */
public class Customviewadapter_Coupons extends ArrayAdapter<RowItemCoupons> {
    private ArrayList<RowItemCoupons> datalist;
    public LayoutInflater inflater;
    Context context;

    public Customviewadapter_Coupons(Context context, int resource, ArrayList<RowItemCoupons> data) {
        super(context, resource, data);
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.datalist = data;
        this.context = context;
    }


    public class ViewHolder {
        TextView txtCouponName, txtCouponRate, txtCouponDays;
        ImageView imgCoupons, imgStars;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.design_coupon_list, null);
         //   Log.e("position", position + "");

            holder.txtCouponName = (TextView) convertView.findViewById(R.id.tvNameCoupons);
            holder.txtCouponRate = (TextView) convertView.findViewById(R.id.tvRatesCoupons);
            holder.txtCouponDays = (TextView) convertView.findViewById(R.id.tvDaysCoupons);
            holder.imgCoupons = (ImageView) convertView.findViewById(R.id.imgCoupons);
            holder.imgStars = (ImageView) convertView.findViewById(R.id.imgStarCoupons);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final RowItemCoupons tData = datalist.get(position);

        holder.txtCouponName.setText(tData.getCouponName());
      //  Log.e("CouponName......", tData.getCouponName() + "...CouponName");

        holder.txtCouponRate.setText("(" + tData.getCouponRate() + " rates)");
     //   Log.e("CouponRate......", tData.getCouponRate() + "...CouponRate");

        holder.txtCouponDays.setText(tData.getCouponDays() + " Days");
     //   Log.e("CouponDays......", tData.getCouponDays() + "...CouponDays");


        Picasso.with(context)
                .load(R.drawable.four_star)
                .placeholder(R.drawable.five_star)
                .into(holder.imgStars);

        Picasso.with(context)
                .load(R.drawable.freiend_selected)
                .placeholder(R.drawable.friend_default)
                .into(holder.imgCoupons);

        return convertView;
    }
}
