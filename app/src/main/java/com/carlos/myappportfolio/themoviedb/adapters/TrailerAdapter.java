package com.carlos.myappportfolio.themoviedb.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.carlos.myappportfolio.R;
import com.carlos.myappportfolio.themoviedb.models.Trailers;

import java.util.List;

/**
 * Created by Carlos on 29/08/2015.
 */
public class TrailerAdapter extends BaseAdapter {
    private List<Trailers.YoutubeEntity> mListTrailers;
    private Context context;

    public TrailerAdapter(Context context, List<Trailers.YoutubeEntity> listTrailers){
        this.mListTrailers=listTrailers;
        this.context=context;

    }
    @Override
    public int getCount() {
        return mListTrailers.size();
    }

    @Override
    public Object getItem(int position) {
        return mListTrailers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tv;
        View row=convertView;
        if (row==null){
            LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row= layoutInflater.inflate(R.layout.row_trailer,parent,false);


        }
        tv= (TextView) row.findViewById(R.id.textViewTrailer);
        tv.setText(mListTrailers.get(position).getName());
        return row;
    }
}
