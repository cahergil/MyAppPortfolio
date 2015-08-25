package com.carlos.myappportfolio.themoviedb;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.carlos.myappportfolio.R;
import com.carlos.myappportfolio.themoviedb.model.Response;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Carlos on 19/08/2015.
 */
public class MovieAdapter extends BaseAdapter {
    private static final String POSTER_BASE_URL="http://image.tmdb.org/t/p/w185/";
    private List<Response.Movie> movieList;
    private Context context;
    public MovieAdapter(Context context,List<Response.Movie> movieList){
        this.movieList=movieList;
        this.context=context;
    }
    @Override
    public int getCount() {
        return movieList.size();
    }


    @Override
    public Object getItem(int position) {

        return movieList.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }
    class ViewHolder {
        ImageView myPoster;
        ViewHolder(View v){
            myPoster= (ImageView) v.findViewById(R.id.ivPoster);

        }
    }
    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(context);
         //   imageView.setLayoutParams(new GridView.LayoutParams(dpToPx(270), dpToPx(270)));
            Display display=((WindowManager)context.getSystemService(context.WINDOW_SERVICE)).getDefaultDisplay();
            int orientation=display.getRotation();
            switch(orientation) {
                case Surface.ROTATION_0:
                    imageView.setLayoutParams(new GridView.LayoutParams(dpToPx(270), dpToPx(270)));
                    break;
                case Surface.ROTATION_90:
                    case Surface.ROTATION_270:
                    imageView.setLayoutParams(new GridView.LayoutParams(dpToPx(300), dpToPx(300)));
                    break;
                //default:imageView.setLayoutParams(new GridView.LayoutParams(dpToPx(270), dpToPx(270)));
            }



            imageView.setPadding(0, 0, 0, 0);
        } else {
            imageView = (ImageView) convertView;

        }

        String url;
        Response.Movie temp=movieList.get(position);
        url=POSTER_BASE_URL+temp.getPoster_path();
        Picasso.with(context).load(url).into(imageView);
       // imageView.setImageResource(mThumbIds[position]);*/
        return imageView;
    }
    public int dpToPx(int dp) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int px = Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        return px;
    }
    /*@Override
     public View getView(int position, View convertView, ViewGroup parent) {

        View row=convertView;
        ViewHolder viewHolder=null;
        if(row==null) {
           LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           row = layoutInflater.inflate(R.layout.themoviedb_single_row, parent, false);
           viewHolder=new ViewHolder(row);
           row.setTag(viewHolder);
        } else {
           viewHolder= (ViewHolder) row.getTag();

        }
       String url;
        Response.Movie temp=movieList.get(position);
        url=POSTER_BASE_URL+temp.getPoster_path();
        Picasso.with(context).load(url).into(viewHolder.myPoster);
        return row;
    }*/

}
