package adapter;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.abc.joy23final.R;
import com.example.abc.joy23final.ZoomableImageView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by TI A1 on 17-05-2016.
 */
public class CustomAdapter extends PagerAdapter {

    Context context;
    ArrayList<String> arrayList;
    //int[] imageId = {R.drawable.icon_back, R.drawable.icon_condos, R.drawable.icon_cabins, R.drawable.icon_handicap, R.drawable.icon_game_room};
    //ImageLoader imageLoader = AppController.getInstance().getImageLoader();
    ProgressDialog pd;

    public CustomAdapter(Context context, ArrayList<String> arrayList) {
        this.arrayList = arrayList;
        this.context = context;

    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // TODO Auto-generated method stub

        LayoutInflater inflater = ((Activity) context).getLayoutInflater();

        View viewItem = inflater.inflate(R.layout.image_item, container, false);
       final ZoomableImageView imageView = (ZoomableImageView) viewItem.findViewById(R.id.imageView);
       ImageView imageviewbackground = (ImageView)viewItem.findViewById(R.id.imageviewbackground);
      /*  if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();*/
        try {
            Picasso.with(context).load(arrayList.get(position)).placeholder(context.getResources().getDrawable(R.drawable.download)).error(context.getResources().getDrawable(R.drawable.download)).into(imageviewbackground);
            Log.e("URL...",arrayList.get(position)+"");
        } catch (Exception e) {
            Log.e("Error...", e.getMessage() + "");
        }
        try {
          /*  Picasso.with(context).load(arrayList.get(position)).placeholder(context.getResources().getDrawable(R.drawable.download)).error(context.getResources().getDrawable(R.drawable.download)).into(imageView);
            Log.e("URL...",arrayList.get(position)+"");*/

            Picasso.with(context).load (arrayList.get(position)).into(new Target() {
                @Override
                public void onBitmapLoaded (final Bitmap bitmap,
                                            final Picasso.LoadedFrom loadedFrom) {
                    imageView.setImageBitmap (bitmap);
                }

                @Override
                public void onBitmapFailed (final Drawable drawable) {
                    Log.d("TAG", "Failed");
                }

                @Override
                public void onPrepareLoad (final Drawable drawable) {
                    imageView.setImageDrawable (drawable);
                }
            });
        } catch (Exception e) {
            Log.e("Error...", e.getMessage() + "");
        }
        /*DownloadImageTask exe = new DownloadImageTask(imageView);
        exe.execute(arrayList.get(position));*/
      /*  Uri uri =  Uri.parse(arrayList.get(position));
        imageView.setImageURI(uri);
        Log.e("URI...", uri + "");
        Log.e("URL...", arrayList.get(position)+ "");*/

        ((ViewPager) container).addView(viewItem);

        return viewItem;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return arrayList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        // TODO Auto-generated method stub

        return view == ((View) object);
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // TODO Auto-generated method stub
        ((ViewPager) container).removeView((View) object);
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        @Override
        protected void onPreExecute() {
               //  pd = ProgressDialog.show(context, "", "Loading..");
            super.onPreExecute();
            pd = new ProgressDialog(context);
            // Create a progressdialog
            pd = new ProgressDialog(context);
            // Set progressdialog title
            pd.setTitle("Please wait a moment...");
            // Set progressdialog message
            pd.setMessage("Loading...");
            pd.setIndeterminate(false);
            // Show progressdialog
            pd.show();
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage() + "");
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
          //     	pd.dismiss();
            bmImage.setImageBitmap(result);
            pd.dismiss();
            super.onPreExecute();
        }
    }
}
