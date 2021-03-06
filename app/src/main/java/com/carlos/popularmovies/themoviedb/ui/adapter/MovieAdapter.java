package com.carlos.popularmovies.themoviedb.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.carlos.popularmovies.R;
import com.carlos.popularmovies.themoviedb.api.model.Response;
import com.carlos.popularmovies.utils.AppConstants;
import com.carlos.popularmovies.utils.Utilities;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Carlos on 11/11/2015.
 */
public class MovieAdapter extends BaseAdapter {

    private List<Response.Movie> movieList;
    private Context context;

    public MovieAdapter(Context context, List<Response.Movie> movieList) {
        this.movieList = movieList;
        this.context = context;
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
        TextView myTitle;

        ViewHolder(View v) {
            myPoster = (ImageView) v.findViewById(R.id.imgPoster);
            myTitle=(TextView) v.findViewById(R.id.txtTitle);
        }
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View row=convertView;
        ViewHolder holder=null;
        if (row==null) {

            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(R.layout.row_movie,parent,false);
            holder=new ViewHolder(row);
            row.setTag(holder);

        } else  {
            holder=(ViewHolder)row.getTag();


        }
        String url;
        Response.Movie temp=movieList.get(position);
        url= AppConstants.POSTER_BASE_URL+temp.getPoster_path();
        Picasso.with(context)
                .load(url)
                .centerCrop()
                .resize((int)Utilities.convertDpToPixel((float)170,context),(int)Utilities.convertDpToPixel((float)260,context))
                .into(holder.myPoster);
        if(temp.getTitle()!=null)
            holder.myTitle.setText(Utilities.setTypeface(context,temp.getTitle()));
        return row;
    }
}