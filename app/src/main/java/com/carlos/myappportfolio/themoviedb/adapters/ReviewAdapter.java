package com.carlos.myappportfolio.themoviedb.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.carlos.myappportfolio.R;
import com.carlos.myappportfolio.themoviedb.models.Reviews;

import java.util.List;

/**
 * Created by Carlos on 29/08/2015.
 */
public class ReviewAdapter extends BaseAdapter {
    private List<Reviews.ResultsEntity> mListReviews;
    private Context mContext;
    public ReviewAdapter(Context context, List<Reviews.ResultsEntity> listReviews){
        this.mListReviews=listReviews;
        mContext=context;
    }
    @Override
    public int getCount() {
        return mListReviews.size();
    }

    @Override
    public Object getItem(int position) {
       return  mListReviews.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textAuthor,textContent;
        View row=convertView;
        if(row==null){
            LayoutInflater layoutInflater= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row= layoutInflater.inflate(R.layout.row_review,parent,false);
        }
        textAuthor= (TextView) row.findViewById(R.id.tvAutor);
        textAuthor.setText("Author:"+mListReviews.get(position).getAuthor());
        textContent=(TextView) row.findViewById(R.id.tvContent);
        textContent.setText(mListReviews.get(position).getContent());
        return row;
    }
}
